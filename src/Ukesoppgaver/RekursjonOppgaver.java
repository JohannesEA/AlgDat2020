package Ukesoppgaver;

public class RekursjonOppgaver {



    //Oppgave 1
    // Lag en iterativ metode av an  =  2a(n−1)  +  3a(n−2)  , n ≥ 2     a0 = 1 ,  a1 = 2

    //Rekursiv metode
    public static int aRecursive(int n){
        if (n == 0) return 1;
        else if (n == 1) return 2;
        else return 2* aRecursive(n-1)+3* aRecursive(n-2);
    }

    //Iterativ metode

    // an = 2a(n-1) + 3a(n-2) n>= 2, a0 = 1, a1 = 2
    public static int aIterativ(int n){
        int [] result = new int[n+1];
       result[0] = 1;
       result[1] = 2;

       for (int i = 2; i <= n; i++){
           result[i] = 2*result[i-1] + 3*result[i-2];
       }
       return result[n];
    }

    //Oppgave 2: Finn en formel for for an:
    //an = 2a(n-1) + 3a(n-2) n>= 2, a0 = 1, a1 = 2

    //Oppgave 3: Lag en iterativ metode av den rekursive metoden under

    public static int tverrsum(int n)              // n må være >= 0
    {
        if (n < 10) return n;// kun ett siffer
        else return tverrsum(n / 10) + (n % 10);     // metoden kalles
    }

    public static int tverrSumIterAtiv(int n){
        int sum = 0;
        if (n < 10) return  n;

        while (n > 0){
            sum += n%10;
            n = n/10;
        }
        return sum;
    }

    //Oppgave 4: Lag en metode for gjentatt tverrsum. Feks tverrsum(956847) = 39, tverrsum(39) = 12, tverrsum(12) = 3


    //Rekursiv metode
    public static int sifferrot(int n){
        if (n < 10) return n;
        n = n%10 + sifferrot(n/10);
        return tverrsum(n);
    }

    //iterativ metode
    public static int sifferrotIterativ(int n){
        int root = 0;
        while (n > 0 || root > 9){
            if ( n == 0){
                n = root;
                root = 0;
            }
            root += n %10;
            n /= 10;
        }
        return root;
    }


    //Oppgave 7: Lag en rekursiv metode som funner summen av kvadrattallene fra 1 til n.
    //dvs finner summen 1^2+ 2^2 +3^2.. +n^2;

    //rekursiv metode
    public static int kvadratTall(int n){
        if (n == 0) return 0;
        return kvadratTall(n-1)+(n*n);

    }

    //interativ metode
    public static int kvadratTallIterativ(int n){
        int sum = 0;

        for (int i = 1; i <= n; i++){
            sum+= (i*i);
        }
        return sum;
    }

    //Oppgave 8: Summen av heltallene fra 1 til n er et spesialtilfelle av det å finne summen av heltallene fra k til n
    //Der k <= n. Lag en metode sum(int k, int n) som finner denne sommen, og gjør det ved å bruke "splitt og hersk"


    //Recursive method
    public static int DigitSumFromKtoN(int k, int n){
        if (k == n) return k;
       int middle = (k+n)/2;
       return DigitSumFromKtoN(k, middle) + DigitSumFromKtoN(middle+1, n);
    }


    //iterativ metode
    public static int DigitSumFromKtoNIterativ(int k, int n){
        int sum = 0;

        for (int i = k; i <= n; i++){
            sum += i;
        }
        return sum;
    }

    //Oppgave 9: Rekursiv metode fom returnerer posisjonen til det største tallet blandt de n første verdiene i en
    //helttalls-tabell


    //recurtion method
    public static int largestNun(int [] a, int n){
    if (n > 0){
        return Math.max(a[n], largestNun(a, n-1));
    }
    else return a[0];
    }

    //iterativ method
    public static int largestNumIterativ(int [] a, int n){
        int tempLargest = a[0];

        for (int i = 0; i <= n; i++){
            if (a[i] > tempLargest){
                tempLargest = a[i];
            }
        }
        return tempLargest;
    }

    //Oppgave 10: lag en rekursiv metode for å finne n!


   //Recursive method
    public static int nFaculty(int n){
        if (n <= 2) return n;
        return nFaculty(n-1)*n;
    }

    //itiativ method
    public static int nFacultyItiativ(int n){
        int sum =1;

        for (int i = 1; i <= n; i++){
            sum *= i;
        }
        return sum;
    }

    //Oppgave 11: lag en metode som finner det n-te favonacci tallet.
    //bruk long som datatype istedenfor int. finn tall nr 50


    //Recursive method
    public static int fib(int n){ //det n-te fibonacci tallet
        if (n <= 1) return  n; //startverdiene
        return fib(n-1) + fib(n-2); //summen av de 2 forrige fib tallene
    }

    //iterativ method
    public static int fibItiativ(int n){
  int [] result = new int[n+2];
  result[0] = 0;
  result[1] = 1;

  for (int i = 2; i <= n; i++){
    result[i] = result[i-1] + result[i-2];
  }
  return result[n];

    }

    public static void main(String [] args){
        System.out.println(aIterativ(10));
        System.out.println(aRecursive(10));
        System.out.println(tverrsum(1234));
        System.out.println(tverrSumIterAtiv(1234));
        System.out.println(sifferrot(956847));
        System.out.println(sifferrotIterativ(956847));
        System.out.println(kvadratTall(10));
        System.out.println(kvadratTallIterativ(10));
        System.out.println(DigitSumFromKtoNIterativ(1, 10));
        System.out.println(DigitSumFromKtoN(1, 10));
        int [] a = {1, 2, 3, 44,5, 6, 7, 100, 9};
        System.out.println(largestNun(a, 6));
        System.out.println(largestNumIterativ(a, 8));
        System.out.println(nFacultyItiativ(10)); //5*4*3*2*1
        System.out.println(nFaculty(10));
        System.out.println(fib(9));
        System.out.println(fibItiativ(9));
    }


}
