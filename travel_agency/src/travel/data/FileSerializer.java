package travel.data;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.List;

public class FileSerializer<T> {

    public  void saveFile(T serObj, String filename) throws IOException {
        XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream(filename));
        xmlEncoder.writeObject(serObj);
        xmlEncoder.close();
    }
    public T loadFromFile(String filename) throws ClassNotFoundException, IOException {
        XMLDecoder decoder =
                new XMLDecoder(
                        new BufferedInputStream(
                                new FileInputStream(filename)));
        List<T> array = (List<T>)decoder.readObject();
        decoder.close();
        return (T) array;
    }

}
