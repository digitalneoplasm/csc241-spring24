package csc241.xml;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private final String id;
    private final List<Edge> connectedEdges;

    public Node(String id) {
        this.id = id;
        this.connectedEdges = new ArrayList<>();
    }

    public void addEdge(Edge e) {
        connectedEdges.add(e);
    }

    public String getID() {
        return id;
    }

    public String toString() {
        String result = "Node id=" + id;
        for (Edge e : connectedEdges) {
            result += "\n\t --- " + e.getOtherNode(this).getID();
        }
        return result;
    }
}
