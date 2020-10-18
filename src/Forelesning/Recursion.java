package Forelesning;

import javax.print.DocFlavor;
import java.util.Arrays;

public class Recursion {

   public static void main(String [] args) {
     /*  int value = 6;
       int return_value = recursiveFunction(value);

       System.out.println("Main: " + return_value);

       int faculty_value = 6;
       System.out.println(faculty_value + "! = " + recursice_nFaculty(faculty_value));

       int[] values = {1, 2, 3};
       recursive_permutartion(values, 0);

       int[] values_b = {1, 2, 4, 8, 17, 19, 22};
       for (int i = 0; i < 25; i++) {
           System.out.println(i+ " = " + recursive_binarySeach(i, values_b, 0, values_b.length - 1));
       }*/

       System.out.println(sum(5));
   }

   static int recursiveFunction(int value) {
       System.out.println("Recursive function: "+value);

       if (value <= 5) {
           return -1;
       } else {
           return recursiveFunction(value-1);
       }
   }

   //Regne ut n! (n fakultet)
   static int recursice_nFaculty(int n){
       if (n == 1){
           return 1;
       }
       else
       {
       return n*recursice_nFaculty(n-1);
   }
   }

   //Metode for binære søk
    //Søker fra og med venstre til og med høyre
   public static int recursive_binarySeach(int searchValue,int [] a, int left, int right){
       int middleValue = (left+right)/2; //Finner midtpunktet

       if (right-left == 0){
           if (a[middleValue] == searchValue){
               return middleValue;
           }
           else
           return -middleValue;
       }

       if (a[middleValue] <= searchValue){
           if (a[middleValue] == searchValue){
               return middleValue;
           }
         return recursive_binarySeach(searchValue, a, middleValue+1, right);
       }
       else {
           return recursive_binarySeach(searchValue, a, left, middleValue-1);
       }

   }



   //Generere en neste-permutasjonstype
    //skal vise alle måtene n antall tall kan stokkes om (1,2,3 -> 1,3,2 -> 2,1,3 osv.-
  public static void recursive_permutartion(int [] a, int k){
       if (k == a.length-1){
           System.out.println(Arrays.toString(a));
       }
       for (int i = k; i < a.length; i++){
           bytt(a, i ,k);
           recursive_permutartion(a, k+1);
           bytt(a, i ,k);
       }
   }

   public static void bytt(int [] a, int m, int n){
       int temp = a[m];
       a[m] = a[n];
       a[n] = temp;
   }

   //Tverrsummen av et heltall er lik summen av tallets sifre. dvs n = 72417 => tverrsum(n) = 7+2+4+1+7 = 20
   //Lag en rekursiv metode som utfører dette

   public static int tverrsum(int n){
       if (n < 10) return n; // hvis n bare er ett tal, returner tallet
       else return tverrsum(n/10)+(n%10);
   }

   //Ekuilids formel er en formel som finner "største felles divisor". Dvs største tallet begge gitte tall (ikke 0) går opp i

    public static int ekuilid(int a, int b){
       if (a == 0 && b == 0){
           return -1; //Hvis begge tallene er 0, er det ingen felles divisor
       }
       if (a == 0) return a;
       int r = a%b;    //r er resten
       return ekuilid(b, r); //rekursivt kall
    }

    //Summen av tallene fra 1 til n er gitt ved formelen n(n+1)/2

    public static int sum (int n){ //Summen av tallene fra 1 til n
       if (n == 1) return 1; //Summen av tallet 1 = 1
       return sum(n-1)+n; //Summen av de n-1 første +n
    }


    // summen av de n første verdiene i en tabell (for eksempel et array)
    public static int tableSum(int [] a, int n){ // Summen av de n første verdiene i tabellen
       if (n == 1) return a[0]; //Returnerer den første verdien i tabellen
       else return tableSum(a, n-1)+ a[n-1]; //Summen av de n-1 første + a[n-1]
    }

    //summen av venstre og høyre side i en tabell
    public static int splitSum(int [] a, int left, int right){
       if (left == right) return a[left];
       int middleOfTable = (left + right)/2;
       return splitSum(a, left, right) + splitSum(a, middleOfTable+1, right);
    }

    //Det n-te Fibonacci-tallet fib(n) er definert som summen av de to foregående fib-tallene. dvd fin(n) = fin(n-1) +fin(n-2)
    //fib(0) = 0 og fib(1) = 1, fib(2) = fib(0) + fib(1) = 1 osv...

    public static int fib(int n){ //det n-te fibonacci tallet
       if (n <= 1) return  n; //startverdiene
       else return fib(n-1) + fib(n-2); //summen av de 2 forrige fib tallene
    }




}
