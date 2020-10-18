package Ukesoppgaver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Uke2 {

       public static void main(String[] args){
            int tabelA[] = {6, 2, 3, 9, 5, 4, 12};
            int tabelB[] = {22, 3,43, 9, 6};

       

            //Metoden for nest høyeste verdi i tabellen
        int d[] = Uke2.randPerm(15);
        int c = findSecondLargestNumberInArray(d, d.length);
        System.out.println(c);
            //slutt



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
            //slutt


            //Finne index og elle posisjon til minimum og maksimumverdi i en tabell/array
            System.out.println(min1(tabelA, 2,6));
            System.out.println(min2(tabelB, 0,4));
            System.out.println(max1(tabelA, 2,6));
            System.out.println( max2(tabelB, 0,4));
            System.out.println("Tredje minste tallet i A er "+ findThirdSmallestNumberInArray(tabelA));
            //slutt


            //Random unique arratgeneratod
            System.out.println(randomArrayGenerator(10));
            //slutt

            //Metode som skriver ut tallene i intervallet fra x til y
            skriv(tabelB, 1, 4);


            //Reversere ett array

           reverseArrayClass rac = new reverseArrayClass();
           rac.reverseArray(tabelA, tabelA.length);
        }



        //Oppgave 1.5 til seksjon 1.2.1 uke 34
        public static String min1(int [] inputArray, int from, int to) { //fra venstre grense til høyre grense
            Tabell.fromToControl(inputArray.length, from, to);  //kontroll

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
            Tabell.fromToControl(inputArray.length, left, right); //kontroll

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
            Tabell.fromToControl(inputArray.length, from, to);  //kontroll

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
            Tabell.fromToControl(inputArray.length, left, right); //kontroll

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
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
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

        public static void skriv(int [] a, int from, int to){ // 1.2.2 4:Metode som skriver ut tallene i intervallet fra til
            Tabell.fromToControl(a.length, from, to);

System.out.print("Tallene i arrayet fra index "+from+" til "+to+" er: ");

for (int i = from; i <= to; i++) {
    System.out.print(a[i] + " ");
}
        }

        public static void skrivln(int [] a, int from, int to){
           for (int i = from; i <= to; i++){
               System.out.println(a[i]);
           }
        }  //1.2.2 5: Skal også skrive ut verdiene i arrayet fra til, med linjeskift

   public static int findSecondLargestNumberInArray(int [] inputArray, int total){
      int temp;

      for (int i = 0; i < total; i++){
         for (int j = i+1; j <total; j++){
             if (inputArray[i] > inputArray[j]){
                 temp= inputArray[i];
                 inputArray[i] = inputArray[j];
                 inputArray[j] = temp;
             }
         }
      }
      return inputArray[total-2];


    }

    public static int findThirdSmallestNumberInArray(int[] a){
        int n = a.length;
        int min = 0;
        int secondSmallest = 0;
        int thirdSmallest = 0;
        for(int i=1;i<n;i++){
            if(a[i] < a[min]){
                min = i;
            }else if(a[i] < a[secondSmallest]){
                secondSmallest = i;
            }else if(a[i]< a[thirdSmallest]){
                thirdSmallest = i;
            }
        }

        return a[thirdSmallest];
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

    public static class reverseArrayClass {

        void reverseArray(int[] a, int n) {
            int[] b = new int[n];
            int j = n;
            for (int i = 0; i < n; i++) {
                b[j - 1] = a[i];
                j = j - 1;
            }

            System.out.print("\nReversed array is: ");
            for (int k = 0; k < n; k++){
                System.out.print(b[k]+" ");
            }
        }
    }

    }//Uke2

