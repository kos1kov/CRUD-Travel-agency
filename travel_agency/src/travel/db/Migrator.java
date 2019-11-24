package travel.db;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import static java.util.logging.Level.ALL;
import static java.util.logging.Level.SEVERE;

public class Migrator {
    private final Logger logger = Logger.getLogger(Migrator.class.getName());
    public void validate(String XMLFile, String XSDFile) {
        try {

            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(XSDFile));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(XMLFile)));
            System.out.println("Validated");
            logger.info("Validated");
        } catch (SAXException | IOException e) {
            logger.log(SEVERE, "IOException occured");
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public Migrator(){
        try {
            FileHandler fileHandler =
                    new FileHandler("log.txt");
            fileHandler.setLevel(ALL);
            logger.addHandler(fileHandler);
        }catch(IOException e){
            logger.addHandler(new ConsoleHandler());
        }
        logger.setLevel(ALL);
    }
}
