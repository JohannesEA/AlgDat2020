package Eksempler;

import javax.swing.*;
import javax.swing.plaf.synth.SynthUI;
import java.util.ArrayList;

public class IDTest {

    public static boolean testIfIntegerIDAlreadyExistInArray(int[] a, int id){
        if (a == null){
            return false;
        }
        boolean erLik = false;

        for (int i = 0; i < a.length; i++){
            if (a[i] == id){
                erLik = true;
                //Kan kaste et mer passende avvik
            }
        }
        if (erLik == true){
            System.out.println("Iden du har skrevet inn eksisterer allerede i lageret");
        }
        else System.out.println("Din id er unik og er: "+id);
        return true;
    }

    public static boolean testIfStringIDAlreadyExistsInArray(String [] a, String id){
        if (a == null){
            System.out.println("Arrayet er tomt"); //Kast avvik her - Exception
        }
        boolean erLik = false;

        for (int i = 0; i < a.length; i++){
            if (a[i] == id){
                erLik = true;
                break;
            }
            else erLik = false;
        }
       if (erLik == false){
           System.out.println("Din nye unike id er "+id );

       } else System.out.println("Id: '"+id+ "' eksisterer allerede i lageret. Du må ha et unikt id. ");
        return false;
    }

    public static void finnNestStorsteNummerIArrayU(int [] a){
        int largest_number = 0;

        for (int i = 0; i <a.length; i++){
            for (int j = 0; j<a.length; j++){
                if (a[i] < a[j] ){
                    largest_number = a[i];
                    a[i] = a[j];
                    a[j] =largest_number;
                }
            }

        }

        System.out.println("Nest største nummer i array er: " +largest_number);

    }

    static String testStringId(String [] strings, String id){
        for (int i = 0; i < strings.length; i++){
               if ( id == strings [i]  ){
                   return "Feil! Iden du skrev inn er allerede brukt";
           }
        }
        return "Din id er: "+id;
    }
    
    public static void main(String [] args){

        int [] a = {1,2,3,9,22,10,5,6};
        testIfIntegerIDAlreadyExistInArray(a, 9);
        finnNestStorsteNummerIArrayU(a);

        String [] sArray ={"s123", "s234", "s345"};
        testIfStringIDAlreadyExistsInArray(sArray, "s123");
        System.out.println(testStringId(sArray, "s1253"));



        ArrayList<Person> myStorage = new ArrayList<>();
        Person person = new Person();
       /* person.setId(id);
        person.setName("Johannes");
        myStorage.add(person);*/

        int personId = 0;
        for (int i = 0; i < 5; i++){
            if (myStorage.contains(personId)){
              throw new IllegalArgumentException("Iden eksisterer allerede");
            }
            Person newPerson = new Person();
            newPerson.setId(i);
            newPerson.setName("Name " +i);
            myStorage.add(newPerson);
            personId++;
        }

        System.out.println(myStorage);




    }
}
