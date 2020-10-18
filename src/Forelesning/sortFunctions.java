package Forelesning;

import java.util.Arrays;

public class sortFunctions {

    //sorterer array, ett og ett tall. Velger ett tall og sier "dette tallet skal jeg sortere"
    //Tallet man velger skal være i "midten" mens mindre verdier blir satt til venstre, og større verdier blir satt til høyre
    void quickSort(int[] a, int begin, int end) {

        if (begin < end) {
            int partitionIndex = parition(a, begin, end);

            quickSort(a, begin, partitionIndex - 1);
            quickSort(a, partitionIndex + 1, end);
        }
    }

    //tar det siste elementet i arrayet som pivot(skillevegg), så
    //sjekker det, og endrer rekkefølgen slik at arrayet blir sortert.
    int parition (int [] a, int begin, int end){

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



        //boblesortering er en av de enkleste sorteringsalgoritmene som fungerer ved å sammenligne
       // to og to naboverdier og bytte plass for å få rekken i en stigende rekkefølge.
        public static void bubbleSort(int[] a) {
        boolean isSorted = false;
        while (!isSorted){
            isSorted = true;
            for (int i = 0; i < a.length-1; i++){ //a.length-1 fordi den tester a[i+1]. dvs at hvis man bare har a.length, vil man få en exception
                if (a[i] > a[i+1]){
                    swap(a, i, i+1);
                    isSorted = false;
                }
            }
        }

    } //bubbleSort


    //Metode for å bytte gitte verdier i et array
    public static void swap(int [] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }



    //Deler arrayet i 2, sammenligner tallene og sorterer tallene i stigende rekkefølge
    //Lager et nytt "temporary" array der de sorterte verdiene blir skrevet inn
    public static void mergeSort(int [] a){
        mergeSort(a, new int[a.length],0 ,a.length-1); //fra venstre til høyre side
    }
    public static void mergeSort(int [] a, int [] temp ,int leftStart, int rightEnd){
        if (leftStart >= rightEnd){
            return;
        }
        //deler arrayet i 2
        int middle = (leftStart+rightEnd)/2;
        //Sorterer venstre siden
        mergeSort(a,temp ,leftStart, middle);
        //Sorterer høyre siden
        mergeSort(a, temp,middle+1, rightEnd);
        //Sett sammen sidene
        mergeHalves(a,temp ,leftStart, rightEnd);
    }

    public static void mergeHalves(int [] a,int [] temp ,int leftStart, int rightEnd){
int leftEnd = (rightEnd+leftStart)/2;
    int rightStart = leftEnd+1;
    int size = rightEnd -leftStart+1;

    int left = leftStart;
    int right = rightStart;
    int index = leftStart;

    while ( left <= leftEnd && right <= rightEnd){
        if (a[left] <= a[right]){
            temp[index] = a[left];
            left++;
        } else{
            temp[index] = a[right];
            right++;
        }
        index++;
    }
    System.arraycopy(a, left, temp, index, leftEnd-left+1);
    System.arraycopy(a, right, temp, index, rightEnd-right+1);
    System.arraycopy(temp, leftStart, a, leftStart, size);
    }


    //Insertion sort
    //Sjekker om tallet til venstre for det gitte tallet er mindre enn det gitte tallet
    //Hvis tallet til venstre er mindre, bytter de plass
    static void insertionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }



    //Selection sort
    //Definerer a[0] som det minste tallet.
    //Looper gjennom arrayet, og sjekker om a[i] < a[0];
    //Sorterer deretter arrayet
    public static int[] selectionSort(int [] a){
        int temp;
     for (int i = 0; i < a.length; i++){
               int minValue = a[0];
               int minIndex = i;
    for (int j = 0; j < a.length; j++){
        if (a[j] < minValue){
            minValue = a [j];
            minIndex = j;
        }
    }

    if (minValue < a[i]){
              temp =a[i];
              a[i] = a[minIndex];
              a[minIndex] = temp;
    }
     }
     return a;
    }

    //Shell sort
    //Er en annen variant av insertion sort
    //ideen med shell sort er å kunne slytte elementer langt frem.¨
    public static int shellSort(int arr[])
    {
        int n = arr.length;

        // Start with a big gap, then reduce the gap
        for (int gap = n/2; gap > 0; gap /= 2)
        {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            for (int i = gap; i < n; i += 1)
            {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                int temp = arr[i];

                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];

                // put temp (the original a[i]) in its correct
                // location
                arr[j] = temp;
            }
        }
        return 0;
    }



    //Heapsort
    public static void heapSort(int arr[])
    {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i=n-1; i>0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    static void heapify(int arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2*i + 1; // left = 2*i + 1
        int r = 2*i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    public static void main(String [] args){

    //Bubble sort
    int [] a = {1, 3, 2, 5, 3, 2, 10, 43, 23,  9, 8};
    bubbleSort(a);
    System.out.println("Bubble sort: "+Arrays.toString(a));

    //Merge sort
    int [] b = {69, 3, 5, 4, 3, 7, 10, 43, 23,  9, 8};
    mergeSort(b);
    System.out.println("Merge sort: "+Arrays.toString(b));

    //Insertion sort
        int [] c = {9, 6, 4, 2, 4, 7, 2, 1};
        insertionSort(c);
    System.out.println("Insertion sort: "+Arrays.toString(c));

    //Selection sort
        int [] d = {5, 3, 4, 2, 7, 3, 7, 5, 9, 10};
    System.out.println("Selection sort: "+Arrays.toString(selectionSort(d)));

    //Shell sort
        int [] e = {5, 3, 5, 7, 3, 1, 3, 10};
    shellSort(e);
    System.out.println("Shell sort: "+Arrays.toString(e));


    //heap sort
        int [] f = {5, 3, 4, 2, 10, 99, 29, 23, 4, 3, 2, 1};
        heapSort(f);
        System.out.println("Heap sort: "+Arrays.toString(f));

}

}
