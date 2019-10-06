package travel.data;

import java.io.*;

public class FileSerializer<T> {

    public static final String filename = "order.xml";

    public  void saveFile(T serObj) throws IOException {
        File newFile = new File(filename);
        if (newFile.exists()) {

            if(!newFile.delete()){
                throw new IOException("Could not delete file");
            }

        }

        if(!newFile.createNewFile()){
            throw new IOException("Could not create file: " + newFile.getName());
        }

            try {
                FileOutputStream fileOut = new FileOutputStream(newFile);
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                objectOut.writeObject(serObj);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
    }
    public T loadFromFile() throws ClassNotFoundException, IOException {
        File newFile = new File(filename);
        if (!newFile.exists()) {
            throw new ClassNotFoundException ("Could not find file: " + newFile.getName());
        }

        try(FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn)){
            Object obj = objectIn.readObject();
            return (T) obj;
        }
    }

}
