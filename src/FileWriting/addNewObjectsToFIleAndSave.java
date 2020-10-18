package FileWriting;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class addNewObjectsToFIleAndSave {


        private static final String filepath="chinese.txt";

        public static void main(String args[]) {

            addNewObjectsToFIleAndSave objectIO = new addNewObjectsToFIleAndSave();

            Student student = new Student("Johannes","Andresen",23);
            objectIO.WriteObjectToFile(student);
        }

    public void WriteObjectToFile(Object serObj) {

        try {

            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
