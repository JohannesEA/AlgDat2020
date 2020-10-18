package FileWriting;
import javax.swing.*;
import java.io.*;
import java.lang.*;
import java.util.*;

public class createFile {

    private Formatter x;

    public void openFile() {
        try {
            x = new Formatter("chinese.txt");
        } catch (Exception e) {
            System.out.println("You have an error in 'openFile'!");
        }
    }

    public void addRecords(String a, String firstName, String lastName) {

        //float = %f, Integer = %d, String = %s

        //if (!String a contains etc.... ), må lage exceptions

        try {
            x.format("%s %s %s\n", a, firstName, lastName);
            x.close();

        } catch (Exception e) {
            System.err.print(e.getMessage());
        }


    }
    public void closeFile() {
        x.close();
    }

    public void addNewObjectsToFile(String id, String productName, String price) throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter("chinese.txt", true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            PrintWriter newPErson = pw.printf("%s %s %s\n", id, productName, price);
            System.out.println("Data Successfully appended into file"+ newPErson);
            pw.flush();
        } finally {
            try {
                pw.close();
                bw.close();
                fw.close();
            } catch (IOException io) {// can't do anything } } }

            }
        }
    }




    public static void main(String[] argd) throws IOException {
        String id = "";
        String productName = "";
        String price = "";

        createFile cf = new createFile();


        ArrayList<Products> arrayList = new ArrayList<>();


        for (int i = 0; i < 3; i++) {
            id = JOptionPane.showInputDialog("Skriv inn din alder: ");
            productName = JOptionPane.showInputDialog("Skriv inn ditt fornavn: ");
            price = JOptionPane.showInputDialog("Skriv inn ditt etternavn: ");
            if (id.isEmpty() || productName.isEmpty()||price.isEmpty()){
                System.exit(0);
            }
//Legger til nytt objekt i gitt fil
            cf.addNewObjectsToFile(id, productName, price);

//Legge til et objekt i en arraylist
            Products newProduct = new Products(id, productName, price);
            arrayList.add(newProduct);




           /* createFile newFile = new createFile();
            newFile.openFile();
            newFile.addRecords(id, productName, price);
            newFile.closeFile();*/
            //addObjectsIntoArray.addNewProductToStorage();

        }
        System.out.println(arrayList.toString());



    }
}
