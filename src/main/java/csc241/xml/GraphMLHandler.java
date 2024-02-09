package csc241.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GraphMLHandler extends DefaultHandler {
    // Store our data.
    private Graph g;
    public void startDocument() throws SAXException {
        System.out.println("Document Start");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start: " + qName);
        if (qName.equals("graph")) {
            System.out.println("ID : " + attributes.getValue("id"));
            System.out.println("Edge Default : " + attributes.getValue("edgedefault"));
            g = new Graph(attributes.getValue("id"),
                    attributes.getValue("edgedefault"));
        }
        if (qName.equals("node")) {
            System.out.println("ID : " + attributes.getValue("id"));
        }
        if (qName.equals("edge")) {
            System.out.println("source : " + attributes.getValue("source"));
            System.out.println("target : " + attributes.getValue("target"));
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End: " + qName);
    }

    public void endDocument() throws SAXException {
        System.out.println("Document End");
        System.out.println("What we learned...");
        System.out.println(g);
    }
}
