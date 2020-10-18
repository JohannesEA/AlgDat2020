package Forelesning;

import java.util.*;

public interface Stakk <T> {

    public void leggInn(T verdi); //Eng: push. Skal legge inn en verdi øverst i stakken
    public T kikk(); //Eng: peek. Skal returnere en referanse til det øverste objektet
    public T taUt(); //Eng: pop. Skal ta ut (fjerne) den øverste ferdien
    public int antall(); //Eng: size. Skal vise antall verdier i stabelen
    public boolean tom(); //Eng: isEmpty. Skal sjekke om stabelen er tom
    public void nullStill(); //Eng: clear. Skal tømme stabelen slik at den kan brukes på nytt
} //Interface stakk

//Oppg 1 --> tallet 3 ligger øverst i stabelen
//Oppg 2 --> tallet 5 ligger øverst i stabelen

class TabellStakk <T> implements Stakk<T> {

    private T[] a; //En T-tabell
    private int antall; //antall verdier på stakken

    public TabellStakk() { //Konstruktør -tabellengde 8.
        this(8);
    }

    @SuppressWarnings("Unchecked")
    public TabellStakk(int lengde) {
        if (lengde < 0) {
            throw new IllegalArgumentException("Negativ tabellengde");
        }

        a = (T[]) new Object[lengde]; //Oppretter tabellen
        antall = 0; //Stakken er tom

    }


    @Override
    public void leggInn(T verdi) {
        if (antall == a.length) {
            a = Arrays.copyOf(a, antall == 0 ? 1 : 2 * antall); //Dobler
            a[antall++] = verdi;
        }
    }

    @Override
    public T kikk() {
        if (antall == 0) {
            throw new NoSuchElementException("Stakken er tom!");
        }
        return a[antall - 1];
    }

    @Override
    public T taUt() {
        if (antall == 0) {
            throw new NoSuchElementException("Stakken er tom!");
        }
        antall--;  //Reduserer antallet

        T temp = a[antall]; //Tar vare på det øverste objektet
        a[antall] = null; //Tilrettelegger for resirkulering

        return temp; //returnerer den øverste verdien
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean tom() {
        return antall == 0;
    }

    @Override
    public void nullStill() {
        if (a.length == 0) {
            throw new NoSuchElementException("Stabelen er tom");
        }
        for (int i = 0; i < antall; i++) {
            a[i] = null;
        }
        antall = 0;

    }
@Override
    public String toString(){

        StringJoiner stringJoiner = new StringJoiner(",","[","]"  );

      for (int i = 0; i < a.length; i++){
          stringJoiner.add((CharSequence) a[i]);
      }

      return stringJoiner.toString();
    }


    //Metode for å snu stabelen
    public static  <T> void snu(Stakk<T> A){

        Stakk<T> temporaryStackOne = null;

        while (!A.tom()){
            temporaryStackOne.leggInn((T) A);
        }

    }


    public static void main(String[] agrs) {


        Stack<Character> s = new Stack<>(); //Oppretter en stakk

        //Legger inn verdier
        s.push('A');
        s.push('B');
        s.push('C');

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }



        Stack<Integer> integerStack = new Stack<>();

        integerStack.add(1);
        integerStack.add(2);
        integerStack.add(3);
        integerStack.add(4);

      System.out.println(integerStack.toString());

      Stack<String> stringStack = new Stack<>();
      stringStack.push("Bottom");
      printStack(stringStack);
      stringStack.push("Second");
      printStack(stringStack);
      stringStack.push("Third");
      printStack(stringStack);

      stringStack.pop();
      printStack(stringStack);
      stringStack.pop();
      printStack(stringStack);
      stringStack.pop();
      printStack(stringStack);

        PriorityQueue<String> queue = new PriorityQueue<>();

        queue.offer("First");
        queue.offer("Second");
        queue.offer("Third");

        System.out.printf("%s ",queue);
        System.out.println();

       //Skriver ut verdien med "høyes" prioritet
        System.out.printf("%s ", queue.peek());
        System.out.println();

        //Fjerne verdien med høyes prioritet
        queue.poll();
        System.out.printf("%s ", queue);
        System.out.println();


    }

    private static void printStack(Stack<String> s){
        if (s.isEmpty()){
            System.out.println("Stack is emty");
        }
        else{
            System.out.printf("%s, TOP\n", s);
        }

    }
}


