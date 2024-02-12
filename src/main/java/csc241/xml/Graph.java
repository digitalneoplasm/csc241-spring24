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

    public void addNode(Node n){
        nodes.add(n);
    }

    public void addEdge(Edge e){
        edges.add(e);
    }

    public Node getNodeByID(String id){
        for (Node n : nodes){
            if (n.getID().equals(id)){
                return n;
            }
        }
        return null;
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
