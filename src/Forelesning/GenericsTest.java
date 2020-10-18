package Forelesning;

public class GenericsTest {
    public static void main(String [] args){
       // int [] a = {1, 3, 6, 29, 69, 8};
   // char [] b = {'A', 'Z', 'K', 'L', 'E', 'Y', 'N'};

        Integer [] a = {1, 3, 6, 29, 69, 8};
        Character [] b = {'A', 'Z', 'K', 'L', 'E', 'Y', 'N'};
        String [] c = {"Johannes", "Peter", "Elias", "David"};
        Person [] d = {new Person("Petter", "Pettersen"), new Person("Johannes", "zendium"), new Person("Kari", "Muhammed")};

         System.out.println("Index til største tall i tabell");
         System.out.println(maks(a));

         System.out.println("Maks av char-array");
         System.out.println(maks(b));

         System.out.println("Generisk metode for å finne maks: ");
         System.out.println(genericaks(a));
         System.out.println(genericaks(b));
         System.out.println(genericaks(c));
         System.out.println(genericaks(d));

         Integer [] integerArray = {2, 3, 4, 5, 6};
         Character [] charArray = {'J', 'O', 'S'};
         printMe(integerArray);
         printMe(charArray);

    }

    public static class Person implements Comparable<Person> {

        String firstName;
        String lastName;

        Person(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public int compareTo(Person other){
            /*
            if(this.last_Name < other.lastName{
            return -1;
            }
            else if(this.last_name == other.lastName){
            return 0;
            }
            else{ return 1;
            }
            */
            int last_compare = this.lastName.compareTo(other.lastName);
            if (last_compare == 0){
                return this.firstName.compareTo(other.firstName);
            }
            else return last_compare;
        }
    }



   //Vanlig metode for å finne indeksen til maks int verdi
    static int maks(Integer[] values){
        int currentMaks = values[0];
        int currentIndex = 0;

        for (int i = 0; i < values.length; i++){
            if (currentMaks < values[i]){
                currentMaks = values[i];
                currentIndex = i;
            }
        }
        return currentIndex;
    }


    //Vanlig metode for å finne indeksen til største karakterverdi
    static int maks(Character [] values){

        char currentMaks = values[0];
        int currentIndex = 0;

        for (int i = 0; i < values.length; i++){
            if (currentMaks < values[i]){
                currentMaks = values[i];
                currentIndex = i;
            }
        }
        return currentIndex;
    }


    //Generisk metode som finner indekxen til input liste (uavhengig om type)
    static <T extends Comparable<? super T>>
  int genericaks(T [] values){
        T currentMaks = values[0];
        int currentIndex = 0;

        for (int i = 0; i < values.length; i++){
            if (values[i].compareTo(currentMaks) > 0){
                currentMaks = values[i];
                currentIndex = i;
            }
        }
        return currentIndex;
    }


    //Generisk metode
    public static <T> void printMe(T[] x){
        for (T t: x){
            System.out.printf("%s ", t);

        }
        System.out.println();
    }

}
