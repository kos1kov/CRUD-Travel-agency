package travel.data;

import java.io.*;

public class FileSerializer {

    private String filename = "order.txt";

    public void SaveFile(Object serObj) {
        File newFile = new File(filename);
        if(newFile.exists())
            try {
                FileOutputStream fileOut = new FileOutputStream("./" + filename);
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                objectOut.writeObject(serObj);
                objectOut.close();
                System.out.println("The Object  was successfully written to a file");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            else
        try
        {
            boolean created = newFile.createNewFile();
            if(created)
                System.out.println("File has been created");
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    public void LoadFromFile(){
        try {

            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();

            System.out.println("The Object has been read from the file");
            objectIn.close();


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
