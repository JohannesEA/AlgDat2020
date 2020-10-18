package Ukesoppgaver;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class Tabell {

    //Oppgave 1.5 til seksjon 1.2.1 uke 34
    public static String min1(int[] inputArray, int from, int to) { //fra venstre grense til høyre grense
        fromToControl(inputArray.length, from, to);  //kontroll

        int m = from; //indeks til minste verdi i a [from: to>
        int min_value = inputArray[m]; //minste verdien i a[from: to>

        for (int i = from + 1; i < to; i++) {

            if (inputArray[i] < min_value) {
                m = i; //indeks til minste verdi oppdateres
                min_value = inputArray[m]; //minste verdi oppdateres
            }
        }
        return "indeksen til laveste verdi er " + m + " med verdien " + min_value; //posisjonen til største verdi
    }


    public static String min2(int[] inputArray, int left, int right) { //fra og med venstre grenst til og med høyre grense
        fromToControl(inputArray.length, left, right); //kontroll

        /*if (left < 0 || right > inputArray.length || left >= right) { //kontroll
            throw new IllegalArgumentException("Illegal value");
        }*/ //Kan også skrive kontrollen slik

        int m = left;
        int min_value = inputArray[m];

        for (int i = left; i <= right; i++) {
            if (inputArray[i] < min_value) {
                m = i;
                min_value = inputArray[m];
            }
        }
        return "indexen til laveste verdi fra index " + left + " til index " + right + " er: " + m;
    }

    public static int maks(int[] a) {
        if (a == null || a.length < 1) {
            throw new NoSuchElementException();
        }

        for (int i = 1; i < a.length; i++) {

            if (a[i - 1] > a[i]) {  //Sjekker om tallet til venstre er større enn tallet til høyre
                int temp = a[i - 1];  //bytter plass på verdiene
                a[i - 1] = a[i];
                a[i] = temp; //oppdaterer tallet
            }
        }
        return a[a.length - 1]; //Returnerer størtste tall/tall som er helt til høyre i arrayet
    }


    public static String max1(int[] inputArray, int from, int to) { //fra venstre grense til høyre grense
        fromToControl(inputArray.length, from, to);  //kontroll

        int m = from; //indeks til minste verdi i a [from: to>
        int max_value = inputArray[m]; //minste verdien i a[from: to>

        for (int i = from + 1; i < to; i++) {

            if (inputArray[i] > max_value) {
                m = i; //indeks til minste verdi oppdateres
                max_value = inputArray[m]; //minste verdi oppdateres
            }
        }
        return "indeksen til høysete verdi er " + m + " med verdien " + max_value; //posisjonen til største verdi
    }


    public static String max2(int[] inputArray, int left, int right) { //fra og med venstre grenst til og med høyre grense
        fromToControl(inputArray.length, left, right); //kontroll

        int m = left;
        int max_value = inputArray[m];

        for (int i = left; i <= right; i++) {
            if (inputArray[i] > max_value) {
                m = i;
                max_value = inputArray[m];
            }
        }
        return "indeksen til høyeste verdi fra index " + left + " til index " + right + " er: " + m;
    }


    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int[] randPerm(int n) { //Metode for å generere en unik liste med n tall
        Random r = new Random();  //Lager ny randomgenerator
        int[] a = new int[n]; //en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1); //Legger inn tallene 1, 2.. n

        for (int k = n - 1; k > 0; k--) {  //løkke som går n-1 ganger
            int i = r.nextInt(k + 1);  //et tilfeldig tall fra 0 til k
            bytt(a, k, i); //bytter om
        }
        return a; //permutasjonen returneres
    }

    public static void skriv(int[] a, int from, int to) { // 1.2.2 4:Metode som skriver ut tallene i intervallet fra til
        fromToControl(a.length, from, to);

        System.out.print("Tallene i arrayet fra index " + from + " til " + to + ", skrevet ut med skriv-metoden er: ");

        for (int i =from; i <= to; i++) {
                System.out.print(a[i] + " ");
        }
    }

    public static void skriv2(int [] a){
        System.out.print("\nTallene i arrayet, skrevet ut med skriv2-metoden er: ");
        int index = 0;
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i]+" ");
            index++;
        }
        System.out.print("\nArrayet har en størrelse på "+index+" tall");
    }

    public static void skrivln(int [] a, int from, int to){
       System.out.println("\nTallene i arrayet, skrevet ut med skrivln-metoden er: ");
        for (int i = from; i <= to; i++){
            System.out.println(a[i]);
        }
    }

    public static void naturligeTall(int n){

        System.out.print("\nNaturlige tal til og med "+n+" er: ");
        for (int i = 1; i <= n; i++){
            if (n < 1){
                throw new IllegalArgumentException("Det må være naturlige tall dvs n >= 1");
            }
            System.out.print(i+" ");
        }
    }

    public static void heltall(int fra, int til){
        if (fra == til) {
            throw new NoSuchElementException
                    ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");
        }
        if (fra < 1 || til <= fra){
            throw new IllegalArgumentException("Fra må være større enn 0, til må være større enn fra");
        }
        System.out.print("\nHeltall fra "+ fra+ " til "+til+ " er: ");
        for (int i = fra; i <= til; i++){
            System.out.print(i+" ");
        }
    }

    public static void fromToControl(int tablengde, int fra, int til){
        if (fra < 0)                                  // fra er negativ
            throw new ArrayIndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > tablengde)                          // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + tablengde + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }

    public static void vhKontroll(int tabellLengde, int v,int h){
        if (v < 0){
            throw new ArrayIndexOutOfBoundsException("v("+v+")<0");
        }
        if (h >= tabellLengde){
            throw new ArrayIndexOutOfBoundsException("h("+h+")>= tablengde( "+tabellLengde+")");
        }
        if (v >h+1){
            throw new IllegalArgumentException("v = "+v+",h = "+h);
        }
    }




    public static void main(String [] args){
        int [] a ={1,2,3,4,5,6,7,8,9,10};

        skriv(a, 1, 6);
       skriv2(a);
       skrivln(a, 0, 5);
       naturligeTall(5);
       heltall(5, 10);
       
    }


}
