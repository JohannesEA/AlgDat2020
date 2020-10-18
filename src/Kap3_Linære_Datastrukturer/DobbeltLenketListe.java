package Kap3_Linære_Datastrukturer;

import java.util.*;

public class DobbeltLenketListe<T> implements Liste<T>
{
    private static final class Node<T>   // en indre nodeklasse
    {
        // instansvariabler
        private T verdi;
        private Node<T> forrige, neste;

        // konstruktør
        private Node(T verdi, Node<T> forrige, Node<T> neste)
        {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }
    }

    // instansvariabler
    private Node<T> hode;    // peker til den første i listen
    private Node<T> hale;    // peker til den siste i listen
    private int antall;      // antall noder i listen
    private int modAntall;   // antall endringer i listen

    // hjelpemetode
    private void indeksKontroll(int indeks)
    {
        if (indeks < 0)
        {
            throw new IndexOutOfBoundsException("Indeks " +
                    indeks + " er negativ!");
        }
        else if (indeks >= antall)
        {
            throw new IndexOutOfBoundsException("Indeks " +
                    indeks + " >= antall(" + antall + ") noder!");
        }
    }

    // hjelpemetode
    private static <T> void nullSjekk(T verdi)
    {
        if (verdi == null) throw
                new NullPointerException("Ikke tillatt med null-verdier!");
    }

    // hjelpemetode
    private Node<T> finnNode(int indeks)
    {
        Node<T> p;

        if (indeks <= antall / 2)
        {
            p = hode;
            for (int i = 0; i < indeks; i++)
            {
                p = p.neste;
            }
        }
        else
        {
            p = hale;
            for (int i = antall - 1; i > indeks; i--)
            {
                p = p.forrige;
            }
        }
        return p;
    }

    // konstruktør
    public DobbeltLenketListe()
    {
        hode = hale = null;
        antall = 0;
        modAntall = 0;
    }

    public boolean tom()
    {
        return antall == 0;
    }

    public int antall()
    {
        return antall;
    }

    public void nullstill()
    {
        Node<T> p = hode;

        while (p != null)
        {
            Node<T> q = p.neste;

            p.neste = null;     // for resirkulering
            p.forrige = null;   // for resirkulering
            p.verdi = null;     // for resirkulering

            p = q;
        }
        antall = 0;
        modAntall++;
        hode = hale = null;
    }

    public boolean inneholder(T verdi)
    {
        return indeksTil(verdi) != -1;
    }

    public void leggInn(int indeks, T verdi)
    {
        nullSjekk(verdi);

        if (indeks < 0)
        {
            throw new IndexOutOfBoundsException("Indeks " +
                    indeks + " er negativ!");
        }
        else if (indeks > antall)
        {
            throw new IndexOutOfBoundsException("Indeks " +
                    indeks + " > antall(" + antall + ") noder!");
        }
        else if (antall == 0)  // tom liste
        {
            hode = hale = new Node<>(verdi, null, null);
        }
        else if (indeks == 0)  // ny verdi forrest
        {
            hode = hode.forrige = new Node<>(verdi, null, hode);
        }
        else if (indeks == antall)  // ny verdi bakerst
        {
            hale = hale.neste = new Node<>(verdi, hale, null);
        }
        else
        {
            Node<T> p = finnNode(indeks);  // ny verdi til venstre for p
            p.forrige = p.forrige.neste = new Node<>(verdi, p.forrige, p);
        }

        antall++;      // ny verdi i listen
        modAntall++;   // en endring i listen
    }

    public boolean leggInn(T verdi)
    {
        nullSjekk(verdi);

        if (antall == 0)  // tom liste
        {
            hode = hale = new Node<>(verdi, null, null);
        }
        else  // ny verdi bakerst
        {
            hale = hale.neste = new Node<>(verdi, hale, null);
        }

        antall++;      // ny verdi i listen
        modAntall++;   // en endring i listen

        return true;
    }

    public T hent(int indeks)
    {
        indeksKontroll(indeks);

        return finnNode(indeks).verdi;
    }

    public int indeksTil(T verdi)
    {
        if (verdi == null) return -1;

        Node<T> p = hode;

        for (int i = 0; i < antall; i++, p = p.neste)
        {
            if (p.verdi.equals(verdi))
            {
                return i;
            }
        }
        return -1;
    }

    public T oppdater(int indeks, T nyverdi)
    {
        indeksKontroll(indeks);
        nullSjekk(nyverdi);

        Node<T> p = finnNode(indeks);

        T gammelverdi = p.verdi;
        p.verdi = nyverdi;

        modAntall++;   // en endring i listen
        return gammelverdi;
    }

    public T fjern(int indeks)
    {
        indeksKontroll(indeks);

        Node<T> p = hode;

        if (antall == 1)  // bare en node i listen
        {
            hode = hale = null;
        }
        else if (indeks == 0)  // den første skal fjernes
        {
            hode = hode.neste;
            hode.forrige = null;
        }
        else if (indeks == antall - 1)  // den siste skal fjernes
        {
            p = hale;
            hale = hale.forrige;
            hale.neste = null;
        }
        else
        {
            p = finnNode(indeks);  // bruker hjelpemetode
            p.forrige.neste = p.neste;
            p.neste.forrige = p.forrige;
        }

        T verdi = p.verdi;           // skal returneres
        p.verdi = null;              // for resirkulering
        p.forrige = p.neste = null;  // for resirkulering

        antall--;      // en verdi mindre i listen
        modAntall++;   // ny endring i listen

        return verdi;
    }

    public boolean fjern(T verdi)
    {
        if (verdi == null) return false;

        Node<T> p = hode;

        while (p != null)  // leter etter verdien
        {
            if (p.verdi.equals(verdi)) break;
            p = p.neste;
        }

        if (p == null)
        {
            return false;        // verdi er ikke i listen
        }
        else if (antall == 1)  // bare en node i listen
        {
            hode = hale = null;
        }
        else if (p == hode)    // den første skal fjernes
        {
            hode = hode.neste;
            hode.forrige = null;
        }
        else if (p == hale)    // siste skal fjernes
        {
            hale = hale.forrige;
            hale.neste = null;
        }
        else
        {
            p.forrige.neste = p.neste;
            p.neste.forrige = p.forrige;
        }

        p.verdi = null;              // for resirkulering
        p.forrige = p.neste = null;  // for resirkulering

        antall--;      // en verdi mindre i listen
        modAntall++;   // ny endring i listen

        return true;   // vellykket fjerning
    }

    private class DobbeltLenketListeIterator implements Iterator<T>
    {
        private Node<T> p;
        private boolean fjernOK;
        private int iteratorModAntall;

        private DobbeltLenketListeIterator()
        {
            p = hode;           // p starter på den første i listen
            fjernOK = false;    // blir sann når next() kalles
            iteratorModAntall = modAntall;    // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks)
        {
            indeksKontroll(indeks);
            p = finnNode(indeks);
            fjernOK = false;    // blir sann når next() kalles
            iteratorModAntall = modAntall;    // teller endringer
        }

        public boolean hasNext()
        {
            return p != null;  // har vi kommet til den siste i listen?
        }

        public T next()
        {
            if (p == null) throw
                    new NoSuchElementException("Ingen flere verdier i listen!");

            if (iteratorModAntall != modAntall) throw
                    new ConcurrentModificationException("Listen har blitt endret!");

            fjernOK = true;

            T verdi = p.verdi;       // tar vare på verdien i p
            p = p.neste;             // flytter p til neste

            return verdi;
        }

        public void remove()
        {
            if (!fjernOK) throw
                    new IllegalStateException("Kan ikke fjerne en verdi nå!");

            if (iteratorModAntall != modAntall) throw
                    new ConcurrentModificationException("Listen har blitt endret!");

            fjernOK = false;
            Node<T> q = hode;

            if (antall == 1)    // bare en node i listen
            {
                hode = hale = null;
            }
            else if (p == null)  // den siste skal fjernes
            {
                q = hale;
                hale = hale.forrige;
                hale.neste = null;
            }
            else if (p.forrige == hode)  // den første skal fjernes
            {
                hode = hode.neste;
                hode.forrige = null;
            }
            else
            {
                q = p.forrige;  // q skal fjernes
                q.forrige.neste = q.neste;
                q.neste.forrige = q.forrige;
            }

            q.verdi = null;              // for resirkulering
            q.forrige = q.neste = null;  // for resirkulering

            antall--;             // en node mindre i listen
            modAntall++;          // en endring i listen
            iteratorModAntall++;  // en endring i iteratoren
        }

    } // class DobbeltLenketListeIterator

    public Iterator<T> iterator()
    {
        return new DobbeltLenketListeIterator();
    }

    public Iterator<T> iterator(int indeks)
    {
        indeksKontroll(indeks);
        return new DobbeltLenketListeIterator(indeks);
    }

    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append('[');

        if (!tom())
        {
            s.append(hode.verdi);

            for (Node<T> p = hode.neste; p != null; p = p.neste)
            {
                s.append(',').append(' ').append(p.verdi);
            }
        }

        s.append(']');
        return s.toString();
    }

    public String omvendtString()
    {
        StringBuilder s = new StringBuilder();
        s.append('[');

        if (!tom())
        {
            s.append(hale.verdi);

            for (Node<T> p = hale.forrige; p != null; p = p.forrige)
            {
                s.append(',').append(' ').append(p.verdi);
            }
        }

        s.append(']');
        return s.toString();
    }

} // class DobbeltLenketListe