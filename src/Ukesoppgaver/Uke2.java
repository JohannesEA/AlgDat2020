package Ukesoppgaver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Uke2 {

       public static void main(String [] args){
            int tabelA[] = {9, 2, 3, 4, 1, 55, 6};
            int tabelB[] = {22, 3,43, 9, 6};

            //Metoden for nest høyeste verdi i tabellen
        /*int d[] = Table.randPerm(15);
        int[] c = getNextMaxNumberInArrayWithTurnementTree(d);
        System.out.println(c);*/
            //slutt

            //Metode for å finne nest største nr{
            // }



            //randPerm og maksverdi
            int a[] = Uke2.randPerm(15);
            for (int k: a) System.out.print(k+" ");
            System.out.println("");

            int m = Uke1.getLargestNumberInArray(a);
            System.out.println("Største verdi i tabellen over er "+m);
            int posM = Uke1.getPositionToLargestNumberInArray(a);
            System.out.println("positjonen til den største verdien i tabellen over er "+posM);
            //slutt

            //bytter om verdiene i array
            System.out.println(Arrays.toString(tabelB));
            Uke2 b = new Uke2();
            b.bytt(tabelB, 1, 2);
            System.out.println(Arrays.toString(tabelB));
            //alutt






            //Finne index og elle posisjon til minimum og maksimumverdi i en tabell/array
            System.out.println(min1(tabelA, 2,6));
            System.out.println(min2(tabelB, 0,4));
            System.out.println(max1(tabelA, 2,6));
            System.out.println( max2(tabelB, 0,4));
            //slutt


            //Random unique arratgeneratod
            System.out.println(randomArrayGenerator(10));
            //slutt

            //Metode som skriver ut tallene i intervallet fra x til y
            System.out.println(skriv(tabelA, 0, 5));
        }



        //Oppgave 1.5 til seksjon 1.2.1 uke 34
        public static String min1(int [] inputArray, int from, int to) { //fra venstre grense til høyre grense
            Uke1.fromToControl(inputArray.length, from, to);  //kontroll

            int m = from; //indeks til minste verdi i a [from: to>
            int min_value= inputArray[m]; //minste verdien i a[from: to>

            for (int i = from + 1; i < to; i++) {

                if (inputArray[i] < min_value){
                    m = i; //indeks til minste verdi oppdateres
                    min_value = inputArray[m]; //minste verdi oppdateres
                }
            }
            return "indeksen til laveste verdi er "+m+" med verdien "+min_value; //posisjonen til største verdi
        }


        public static String min2(int [] inputArray, int left, int right){ //fra og med venstre grenst til og med høyre grense
            Uke1.fromToControl(inputArray.length, left, right); //kontroll

        /*if (left < 0 || right > inputArray.length || left >= right) { //kontroll
            throw new IllegalArgumentException("Illegal value");
        }*/ //Kan også skrive kontrollen slik

            int m = left;
            int min_value = inputArray[m];

            for (int i = left; i <= right; i++){
                if (inputArray[i] < min_value){
                    m = i;
                    min_value = inputArray[m];
                }
            }
            return "indexen til laveste verdi fra index "+left+" til index "+right+" er: "+m;
        }

        public static String max1(int [] inputArray, int from, int to) { //fra venstre grense til høyre grense
            Uke1.fromToControl(inputArray.length, from, to);  //kontroll

            int m = from; //indeks til minste verdi i a [from: to>
            int max_value= inputArray[m]; //minste verdien i a[from: to>

            for (int i = from + 1; i < to; i++) {

                if (inputArray[i] > max_value){
                    m = i; //indeks til minste verdi oppdateres
                    max_value = inputArray[m]; //minste verdi oppdateres
                }
            }
            return "indeksen til høysete verdi er "+m+" med verdien "+max_value; //posisjonen til største verdi
        }


        public static String max2(int [] inputArray, int left, int right){ //fra og med venstre grenst til og med høyre grense
            Uke1.fromToControl(inputArray.length, left, right); //kontroll

            int m = left;
            int max_value = inputArray[m];

            for (int i = left; i <= right; i++){
                if (inputArray[i] > max_value){
                    m = i;
                    max_value = inputArray[m];
                }
            }
            return "indeksen til høyeste verdi fra index "+left+" til index "+right+" er: "+m;
        }


        public static void bytt(int [] a, int i, int j){
            int temp = a[i]; a[i] = a[j]; a[j] = temp;
        }

        public static int[] randPerm(int n){ //Metode for å generere en unik liste med n tall
            Random r = new Random();  //Lager ny randomgenerator
            int [] a = new int[n]; //en tabell med plass til n tall

            Arrays.setAll(a, i -> i+1); //Legger inn tallene 1, 2.. n

            for (int k = n-1; k >0; k--){  //løkke som går n-1 ganger
                int i = r.nextInt(k+1);  //et tilfeldig tall fra 0 til k
                bytt(a, k, i); //bytter om
            }
            return a; //permutasjonen returneres
        }

        public static ArrayList<Integer> randomArrayGenerator(int n){ //Genererer en liste med n tall. (ikke unik)

            ArrayList<Integer> list = new ArrayList<>(n);
            for (int i = 0; i < n; i++){
                list.add(i);
            }
            Collections.shuffle(list);
            return list;
        }

        public static int skriv(int [] a, int from, int to){ // 1.2.2 4:Metode som skriver ut tallene i intervallet fra til
            Uke1.fromToControl(a.length, from, to);

            int f = from;

            for (int i = from; i <= to; i++) {
                f = a[i];
            }
            return f;
        } //ikke fungerende, skriver ut høyste verdi i arrayet fra



        public static int skrivln(int [] a, int from, int to){ return 0;}  //1.2.2 5: Skal også skrive ut verdiene i arrayet fra til, med linjeskift

   /* public static int[] getNextMaxNumberInArrayWithTurnementTree(int [] inputArray){
        int n = inputArray.length; //tabellens lengde

        if (n < 2){
            throw new java.util.NoSuchElementException("inputArray.length("+n+")<2!");
        }

        int m = AlgoritmerOgDataStrukturer.getLargestNumberInArray(inputArray);
        String nm;

        if (m == 0){
            nm = max1(inputArray, 1, n);
        }
        else if (m == n-1){
            nm = max1(inputArray, 0, n-1);
        }
        else {
            String mv = max1(inputArray, 0, m);
            String mh = max1(inputArray, m+1, n);
            nm = inputArray[Integer.parseInt(mh)] > inputArray[Integer.parseInt(mv)]? mh:mv;
        }
        return new int[]{m, Integer.parseInt(nm)};
    }*/
    }//Uke2

