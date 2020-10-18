package FileWriting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class addObjectsIntoArray {

    public static void addNewProductToStorage(){
ArrayList arrayList = new ArrayList();
        String line;



        try {
            BufferedReader input = new BufferedReader(new FileReader("chinese.txt"));
            if (!input.ready()){
                throw new IOException();
            }
            while ((line = input.readLine()) != null){
                arrayList.add(line);
            }
            input.close();
        }
        catch (IOException e){
            System.err.print(e);
        }
    }
}
