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
        ret += "\nNodes:";
        for (Node n : nodes){
            ret += "\n" + n;
        }
        ret += "\nEdges:";
        for (Edge e : edges){
            ret += "\n" + e;
        }
        return ret;
    }
}
