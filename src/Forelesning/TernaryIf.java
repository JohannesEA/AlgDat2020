package Forelesning;

public class TernaryIf {
    public static void main(String [] args){
        for (int i = 0; i <10; i++){
            int a = i;
            int b = myTernaryIf(a);
            System.out.print(b);
        }
        int a = 17;

        int b = (a<5) ? 13:17;
    }

    public static int myTernaryIf(int value){
        /*if (value < 5)
        {
            return 0;
        } else return  90;*/

        return (value < 5) ? 0 : 98; //Samme kode som over, bare mye mer effektivt.
    }


}


