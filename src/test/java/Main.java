import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {

            File schemaFile = new File("TOSCA-v1.0.xsd");
            File xmlFile = new File("test.xml");
            Schema schema = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(schemaFile);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new FileInputStream(xmlFile)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//        URL schemaURL = new URL("http://docs.oasis-open.org/tosca/TOSCA/v1.0/os/schemas/TOSCA-v1.0.xsd");// The URL to your XML Schema;
            File xsdFile = new File("TOSCA-v1.0.xsd");
            // parse an XML document into a DOM tree
            DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = parser.parse(new File("test.xml"));

            // create a SchemaFactory capable of understanding WXS schemas
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            // load a WXS schema, represented by a Schema instance
            Source schemaFile = new StreamSource(new File("TOSCA-v1.0.xsd"));
            Schema schema = factory.newSchema(schemaFile);

            System.out.println(document.getDocumentElement().getTagName());

            // create a Validator instance, which can be used to validate an instance document
            Validator validator = schema.newValidator();
            // validate the DOM tree
            try {
                validator.validate(new DOMSource(document));
            } catch (SAXException e) {
                // instance document is invalid!
                System.err.println("instance document is invalid!");
                System.err.println(e.getMessage());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }


        Process p;
        try {

/*
            p = Runtime.getRuntime().exec("ls");

            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
*/
            Main main = new Main();

//            main.byCommonsExec();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void byCommonsExec(String[] command)
            throws IOException, InterruptedException {
        DefaultExecutor executor = new DefaultExecutor();
        CommandLine cmdLine = CommandLine.parse(command[0]);
        for (int i = 1, n = command.length; i < n; i++) {
            cmdLine.addArgument(command[i]);
        }
        executor.execute(cmdLine);
    }
}