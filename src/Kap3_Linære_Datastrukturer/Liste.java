package Kap3_Linære_Datastrukturer;

import java.util.Iterator;

public interface Liste<T> extends Beholder<T>
{
    @Override                                  // fra Beholder
    public boolean leggInn(T verdi);           // Nytt element bakerst

    public void leggInn(int indeks,T verdi);   // Nytt element på plass indeks

    @Override                                  // fra Beholder
    public boolean inneholder(T verdi);        // Er verdi i listen?

    public T hent(int indeks);                 // Hent element på plass indeks

    public int indeksTil(T verdi);             // Hvor ligger verdi?

    public T oppdater(int indeks,T verdi);     // Oppdater på plass indeks

    @Override                                  // fra Beholder
    public boolean fjern(T verdi);             // Fjern objektet verdi

    public T fjern(int indeks);                // Fjern elementet på plass indeks

    @Override                                  // fra Beholder
    public int antall();                       // Antallet i listen

    @Override                                  // fra Beholder
    public boolean tom();                      // Er listen tom?

    @Override                                  // fra Beholder
    public void nullstill();                   // Listen nullstilles (og tømmes)

    @Override                                  // fra Beholder
    public Iterator<T> iterator();             // En iterator

    public default String melding(int indeks)  // Unntaksmelding
    {
        return "Indeks: " + indeks + ", Antall: " + antall();
    }

    /* Metode som tester indeksen. Hvis parameter leggInn er true, vil
    0 <= indeks <= antall() være tillatt. Hvis leggInn er false,
    vil kun 0 <= indeks < antall() være tillatt. */
    public default void indeksKontroll(int indeks, boolean leggInn)
    {
        if (indeks < 0 ? true : (leggInn ? indeks > antall() : indeks >= antall()))
            throw new IndexOutOfBoundsException(melding(indeks));
    }

}  // grensesnittet Liste