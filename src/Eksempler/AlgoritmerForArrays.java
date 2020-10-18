package Eksempler;

public class AlgoritmerForArrays {

    public static void main(String [] args ){
        int [] array = {1, 32, 44, 2, 32, 69, 4};
        System.out.print(AlgoritmerForArrays.findmax(array));
    }

    public static int findmax(int [] a){
        int max = a[0];


        for (int i = 0; i < a.length; i++){
            if (max < a[i]){
                max = a[i];
               
            }
        }
        return max;
    }
}
