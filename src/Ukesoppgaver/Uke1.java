package Ukesoppgaver;

import java.util.Arrays;
import java.util.Random;

public class Uke1 {

        public static void main(String [] args){
            int tabelA[] = {9, 2, 3, 4, 1, 55, 6};
            int tabelB[] = {22, 3,43, 9, 6};
            int faktorialNumber = 5;

            System.out.println("Smallest number in tabelA: "+getSmallestNumberInArray(tabelA));
            System.out.println("Smallest number in tabelA: "+getSmallestNumberInArray(tabelB));
            System.out.println("Lowest number in tabelA: "+getLowestNumberInArray(tabelA));
            System.out.println("Largest number in array tabelA: "+getLargestNumberInArray(tabelA));
            System.out.println("Largest number in array tabelB: "+getLargestNumberInArray(tabelB));
            System.out.println("Position to smallest number in tabelA: "+ getPositionToSmallestNumberInArrray(tabelA));
            System.out.println("Position to smallest number in tabelB: "+ getPositionToSmallestNumberInArrray(tabelB));
            System.out.println("Position to smallest number in tabelA: "+getPositionToAndTheLowestNumberInArray(tabelA));
            System.out.println("Position to smallest number in tabelB: "+ getPositionToAndTheLowestNumberInArray(tabelB));
            System.out.println("Value to smallest number in tabelA: "+tabelA[getPositionToAndTheLowestNumberInArray(tabelA)]);
            System.out.println("Value to smallest number in tabelB: "+ tabelB[getPositionToAndTheLowestNumberInArray(tabelB)]);
            System.out.println("Position to largest number in tabelA: "+ getPositionToLargestNumberInArray(tabelA) );
            System.out.println("Position to largest number in tabelB: "+ getPositionToLargestNumberInArray(tabelB));
            //eksempel på fakultetregning 5! = 5*4*3*2*1 = 120
            System.out.println("Fakultetet for "+faktorialNumber+ " er "+nFakultetUtregning(faktorialNumber));
            System.out.println("Random number-array generator "+ Arrays.toString(randomNumberInArrayGenerator(10)));
            System.out.println("Random unique number-array generator"+ Arrays.toString(uniqueRandomNumberInArrayGenerator(20)));



            //Eksempel på for each løkke
            int [] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};

            for (int k: a){
                System.out.print(k+" "); //printer ut 1 2 3 4 5 6 7 8 9
            }
        } //main

        public static int getSmallestNumberInArray(int [] inputArray){
            int maxValue = inputArray[0];
            for (int i = 1; i < inputArray.length; i++){
                if (inputArray[i] < maxValue){
                    maxValue = inputArray[i];
                }
            }
            return maxValue;
        }

        public static int getLowestNumberInArray(int [] inputArray){ //Annen metode med samme utfall som getSmallestNumberinArray
            int minValue = inputArray[0];
            for (int i = 0; i < inputArray.length; i++){
                int value = inputArray[i];
                if (value < minValue){
                    minValue = value;
                }
            }
            return minValue;
        }

        public static int getPositionToAndTheLowestNumberInArray(int [] array ){
            //Initialiserer med første element
            int min_value = array[0];
            int min_index = 0;

            //Loop over alle resterende elementer og sjekk om vi finner et mindre tall.
            for (int i = 1; i < array.length; i++){
                int value = array[i];
                int index = i;
                //Sjekk om verdien er mindre enn vi har sett tidligere
                if (value < min_value) {
                    min_value = value;
                    min_index = index;
                }
            }

            //Returnerer minste verdi
            return min_index;
        }


        public static int getLargestNumberInArray(int [] inputArray){
            int maxValue = inputArray[0];
            for (int i = 1; i < inputArray.length; i++){
                if (inputArray[i] > maxValue){
                    maxValue = inputArray[i];
                }
            }
            return maxValue;
        }

  /*  public static int getNextMaxNumberInArray(int [] inputArray){  //Metode for å finne nest største verdi i array
        int next_max = min(inputArray[0], inputArray[1]);
        int max_value = max(inputArray[0], inputArray[1]);

        for (int i = 2; i <inputArray.length ;i++){
            if (inputArray[i] > next_max){
                if (inputArray[i] > max_value){
                    next_max = max_value;
                    max_value = inputArray[i];
                }
            } else {
                next_max = inputArray[i];
            }
        }


        return next_max;


        //Dette skal stå i main
           int n = 100_000, antall = 2_000;
        long tid;
        int c[] = uniqueRandomNumberInArrayGenerator(n);

        tid = System.currentTimeMillis();
        for (int i = 0; i < antall; i++){
            kostnader(c);
            tid = System.currentTimeMillis()-tid;
            //System.out.println("Flere kostnader: "+tid+" millisek");
        } //
    }*/



        public static int getPositionToSmallestNumberInArrray(int [] array){
            if(array.length < 1){
                throw new java.util.NoSuchElementException("Tabellen er tom!");
            }
            int smallest = 0; //indeks til forløpig største verdi

            for (int i = 1; i < array.length; i++){
                if (array[i] < array[smallest]) {
                    smallest = i;
                }
            }
            return smallest;
        }

        public static int getPositionToLargestNumberInArray(int [] array){
            if (array.length < 1){
                throw new java.util.NoSuchElementException("Tabellen er tom!");
            }

            int largest = 0;


            for (int i = 1; i < array.length; i++){
                if (array[i] > array[largest]){
                    largest = i;
                }
            }
            return largest;
        }

        public static int kostnader(int[] a){
            int m = 0;
            for (int i =1; i < a.length; i++){}
            return m;
        }

        public static int[] randomNumberInArrayGenerator(int n){  //generering av tilfeldige tall. alle ulike fra 1 til n
            Random r = new Random();  //Random number generator
            int[] a = new int[n];  //Tabell med plass til n tall

            for (int i = 0; i < n; i++){
                a[i] = r.nextInt(n)+1;  //tabellen fylles med tall
            }

            return a; //tabellen returneres
        }

        public static int[] uniqueRandomNumberInArrayGenerator(int n){
            Random r = new Random();  //Randomgenerator
            int [] a = new int[n];  //En tabell med plass til n tall

            Arrays.setAll(a, i ->i+1);  //legger inn tallene 1, 2... n

            for (int k = n-1; k>0; k--){  //løkke som går n-1 ganger
                int i = r.nextInt(k+1); //tilfeldig tall fra 0 til k
                Uke2.bytt(a, k, i); //bytter om
            }
            return a;
        }


        public static int nFakultetUtregning(int n){
            if (n == 1){
                return 1;
            }
            if (n == 0){
                return 0;
            }
            else {
                return (n* nFakultetUtregning(n-1));
            }
        }



        public static void fromToControl(int tableLength, int from, int to){  //Kontroll på input i min og max index metodene
            if (from < 0){
                throw new ArrayIndexOutOfBoundsException("from("+from+") is negative!");
            }
            if (to > tableLength){
                throw new ArrayIndexOutOfBoundsException("to ("+to+")>table length ("+tableLength+")");
            }
            if (from > to){
                throw new IllegalArgumentException("from ("+from+") > to ("+to+")- Illegal intervall");
            }
        }


        //Fortsette på oppgave 1.2.1


} //Uke1
