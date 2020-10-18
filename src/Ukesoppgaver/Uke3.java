package Ukesoppgaver;

public class Uke3 {
    public static void main(String [] args){
int [] a_unsorted = {2,5,4,5,26,12,21,3,2,32,22,7,8,5};
int [] a_sorted ={2, 3, 4, 5, 6, 7, 8, 9};


BubbleSort bs = new BubbleSort();
bs.bubbleSort(a_unsorted);
System.out.println("Sortert array med bubbleSort metoden: ");
bs.printArray(a_unsorted);
System.out.print("\nTallet 5 er på index "+(sortetSearchInArray2(a_sorted, 5)));


    }

   public static int unsortedSearchInArray(int [] a, int value){ //søke etter element i array

        for (int i = 0; i<a.length; i++){
            if (a[i] == value){ //Sjekker tellet
                return i; //returnerer indexen til tllet
            }
        }
        return -1;
    }

    public static int sortetSearchInArray2(int [] a, int value){ //søke etter element i array
        int step_length = 2;
        for (int i = 0; i <a.length; i+=step_length){
            if (a[i] >= value){
                int begin = i-step_length;
                int end = i+1;
                for (int j = begin; j <end; j++) {
                    if (a[j] == value){
                        return j;
                    }
                }
                return -1;
            }
        }
        return -1;
    }

    int binarySearch (int [] a, int left, int right){
        //midten = (v+h)/2

        return -1;
    }


    void quickSort(int[] a, int begin, int end){ //sorterer array, ett og ett tall. Velger ett tall og sier "dette tallet skal jeg sortere"
      //Tallet man velger skal være i "midten" mens mindre verdier blir satt til venstre, og større verdier blir satt til høyre
if (begin < end){
    int partitionIndex  = parition(a, begin, end);

    quickSort(a, begin,partitionIndex-1);
    quickSort(a, partitionIndex+1, end);
}


    }

    int parition (int [] a, int begin, int end){  //tar det siste elementet i arrayet som pivot(skillevegg), så
        //sjekker det, og endrer rekkefølgen slik at arrayet blir sortert.
        int pivot = a[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++){
            if (a[j] <= pivot){
                i++;

                int swapTemp = a[i];
                a[i] = a[j];
                a[j] = swapTemp;
            }
        }

        int swapTemp = a[i+1];
        a[i+1] = a[end];
        a[end] = swapTemp;

        return i+1;
    }

    public static class BubbleSort {

        public void bubbleSort(int[] a) {
            int n = a.length;

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (a[j] > a[j + 1]) {
                        int temp = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = temp;
                    }
                }
            }
        } //bubbleSort

        public void printArray(int[] a) {
            int n = a.length;
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
        }
    }


    //Oppgaver 1.3.1 permutasjoner

    //Oppgave 1

    public static boolean nextPermutation(int [] a){
        int i = a.length-2;
        while (i >= 0 && a[i] > a[i+1]) i--;
        if (i < 0) return false;

        int j = a.length-1;
        while (a[j] < a[i]) j--;
        Uke2.bytt(a, i, j);

        return true;
    }

    public static void snu(int[] a, int v, int h){
        while (v < h ) Uke2.bytt(a, v++, h--);
    }

    public static void snu(int [] a, int v){
        snu(a, v, a.length-1);
    }
    public static void snu(int [] a){
        snu(a, 0, a.length-1);
    }




}
