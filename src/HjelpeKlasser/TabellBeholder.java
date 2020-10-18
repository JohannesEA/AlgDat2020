package HjelpeKlasser;

import java.util.*;

public class TabellBeholder<T> extends AbstraktBeholder<T>
{
    private T[] a;
    private int antall;

    public TabellBeholder()    // konstruktør
    {
        this(10);     // bruker 10 som startdimensjon
    }

    public TabellBeholder(int størrelse)  // konstruktør
    {
        a = (T[])new Object[størrelse];
        antall = 0;
    }

    public TabellBeholder(Iterable<T> itererbar)  // konstruktør
    {
        for (T verdi : itererbar) leggInn(verdi);
    }

    @Override
    public boolean leggInn(T t)
    {
        // En full tabell utvides med 50%
        if (antall == a.length) a = Arrays.copyOf(a,(3*antall)/2 + 1);
        a[antall++] = t;
        return true;  // vellykket innlegging
    }

    private class TabellBeholderIterator implements Iterator<T>
    {
        private int denne = 0;              // instansvariabel
        private boolean removeOK = false;   // instansvariabel

        @Override
        public boolean hasNext()     // sjekker om det er flere igjen
        {
            return denne < antall;     // sjekker verdien til denne
        }

        @Override
        public T next()
        {
            if (!hasNext())
                throw new NoSuchElementException("Tomt eller ingen verdier igjen!");

            T temp = a[denne];         // henter aktuell verdi
            denne++;                   // flytter indeksen
            removeOK = true;           // nå kan remove() kalles
            return temp;               // returnerer verdien
        }

        @Override
        public void remove()
        {
            if (!removeOK) throw
                    new IllegalStateException("Ulovlig tilstand!");

            removeOK = false;          // remove() kan ikke kalles på nytt

            // verdien i posisjon denne - 1 skal fjernes siden den ble returnert
            // i det siste kallet på next(), verdiene fra og med denne flyttes
            // derfor en enhet mot venstre

            antall--;           // en verdi vil bli fjernet
            denne--;            // denne må flyttes til venstre

            for (int i = denne; i < antall; i++)
            {
                a[i] = a[i+1];    // verdiene flyttes
            }

            a[antall] = null;   // verdien som lå lengst til høyre nulles
        }

    }  // class TabellBeholderIterator

    @Override
    public Iterator<T> iterator()
    {
        return new TabellBeholderIterator();
    }

    public static void main(String [] args){
        Beholder<Integer> beholder = new TabellBeholder<Integer>();

        for (int i = 1; i <= 10; i++) beholder.leggInn(i);

        System.out.println("Antall verdier: " + beholder.antall());
        System.out.println(beholder);  // bruker metoden toString

        System.out.println("Fjerner oddetallene: ");
        for (int i = 1; i <= 10; i++)
            if (i % 2 != 0) beholder.fjern(i);  // fjerner odddetallene

        System.out.println(beholder);  // bruker metoden toString
    }

}  // class TabellBeholder
