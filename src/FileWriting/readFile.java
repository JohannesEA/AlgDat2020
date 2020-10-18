package FileWriting;


import java.io.*;
import java.lang.*;
import java.util.*;

public class readFile {

    private Scanner x;

    public void openFile(){
        try {
            x = new Scanner(new File("chinese.txt"));
        }
        catch (Exception e){
            System.out.println("Could not find file");
        }
    }

    public void readFileData(){
        while (x.hasNext()){ //Så lenge filen x har noe i seg
            String a = x.next(); //alder
            String b = x.next(); //fornavn
            String c = x.next(); //etternavn


            System.out.printf("%s %s %s\n",a,b,c);
        }
    }

    public void closeFile(){
        x.close();
    }

    public static void main(String[] argd) {
        readFile r = new readFile();
        r.openFile();
        r.readFileData();
        r.closeFile();
    }
}
