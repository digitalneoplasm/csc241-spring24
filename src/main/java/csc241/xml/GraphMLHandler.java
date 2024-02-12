package csc241.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GraphMLHandler extends DefaultHandler {
    // Store our data.
    private Graph graph;
    public void startDocument() throws SAXException {
        System.out.println("Document Start");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start: " + qName);
        if (qName.equals("graph")) {
            System.out.println("ID : " + attributes.getValue("id"));
            System.out.println("Edge Default : " + attributes.getValue("edgedefault"));
            graph = new Graph(attributes.getValue("id"),
                            attributes.getValue("edgedefault"));
        }
        if (qName.equals("node")) {
            System.out.println("ID : " + attributes.getValue("id"));
            Node n = new Node(attributes.getValue("id"));
            graph.addNode(n);
        }
        if (qName.equals("edge")) {
            String sourceID = attributes.getValue("source");
            String targetID = attributes.getValue("target");
            System.out.println("source : " + sourceID);
            System.out.println("target : " + targetID);
            Node n1 = graph.getNodeByID(sourceID);
            Node n2 = graph.getNodeByID(targetID);
            if (n1 == null){
                throw new RuntimeException("Malformed XML file: Missing node with id " + sourceID);
            }
            if (n2 == null){
                throw new RuntimeException("Malformed XML file: Missing node with id " + targetID);
            }
            Edge e = new Edge(n1, n2);
            graph.addEdge(e);
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End: " + qName);
    }

    public void endDocument() throws SAXException {
        System.out.println("Document End");
        System.out.println("What we learned...");
        System.out.println(graph);
    }

    public Graph getGraph() {
        return graph;
    }
}
