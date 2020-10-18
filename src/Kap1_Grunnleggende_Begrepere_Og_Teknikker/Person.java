package Kap1_Grunnleggende_Begrepere_Og_Teknikker;

import java.util.*;

public class Person implements Comparable<Person>
{
    private final String fornavn;         // personens fornavn
    private final String etternavn;       // personens etternavn

    public Person(String fornavn, String etternavn)    // konstruktør
    {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
    }

    public String fornavn() { return fornavn; }       // aksessor
    public String etternavn() { return etternavn; }   // aksessor

    @Override
    public int compareTo(Person p)    // pga. Comparable<Person>
    {
        int cmp = etternavn.compareTo(p.etternavn);     // etternavn
        if (cmp != 0) return cmp;           // er etternavnene ulike?

        return fornavn.compareTo(p.fornavn);   // sammenligner fornavn
    }

    @Override
    public boolean equals(Object o)      // vår versjon av equals
    {
        if (o == this) return true;
        if (!(o instanceof Person)) return false;
        return compareTo((Person)o) == 0;
    }

    @Override
    public int hashCode() { return Objects.hash(fornavn,etternavn); }

    @Override
    public String toString() { return fornavn + " " + etternavn; }

} // class Person