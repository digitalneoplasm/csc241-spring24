package csc241.xml;

public class Edge {
    private final Node source;
    private final Node target;

    public Edge(Node source, Node target) {
        this.source = source;
        this.target = target;
        source.addEdge(this);
        target.addEdge(this);
    }

    public Node getOtherNode(Node n) {
        if (source == n) return target;
        return source;
    }

    public String toString(){
        return source.getID() + " --- " + target.getID();
    }
}
