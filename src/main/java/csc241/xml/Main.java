package csc241.xml;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        SAXParserFactory spf = SAXParserFactory.newInstance();

        try {
            InputStream input = new FileInputStream("/Users/danielschlegel/Library/CloudStorage/Dropbox/Teaching/CSC241/24S/Class Code/CS2/src/main/resources/graphml1.xml");
            SAXParser saxParser = spf.newSAXParser();
            GraphMLHandler gmh = new GraphMLHandler();
            saxParser.parse(input,gmh);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }
}
