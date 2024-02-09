package csc241.xml;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Node> nodes;
    private List<Edge> edges;
    private String id;
    private String edgeDefault;

    public Graph(String id, String edgeDefault) {
        this.id = id;
        this.edgeDefault = edgeDefault;
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public String toString() {
        String ret = ("Graph " + id + " (" + edgeDefault + ")");
        for (Node n : nodes){
            ret += "\nNode: " + n;
        }
        for (Edge e : edges){
            ret += "\nEdge: " + e;
        }
        return ret;
    }
}
