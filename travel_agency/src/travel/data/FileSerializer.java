package travel.data;


import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class FileSerializer<T> {

    public  void saveFile(T serObj, String filename) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();

        xmlMapper.writeValue(new File(filename), serObj);
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
