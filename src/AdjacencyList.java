import java.util.ArrayList;


public class AdjacencyList extends Graph {

    public AdjacencyList() {
        this.vertices = new ArrayList<Vertex>();
    }

    @Override
    public Vertex addVertex(String s) {

        Vertex nVertex = null;

        if (isAVertex(s)) {
            nVertex = getVertexByName(s);
        }
        else {
            nVertex = new Vertex(s);
            vertices.add(nVertex);
        }

        return nVertex;
    }

    @Override
    public void addEdge(String from, String to, double weight) {


        Vertex source = addVertex(from);
        Vertex destination = addVertex(to);

        Edge nEdge = new Edge(source,destination,weight);

        source.getEdges().add(nEdge);
        destination.getEdges().add(nEdge);
    }

    @Override
    public void printGraph() {
        for (Vertex v : vertices) {
            System.out.println("-- Vertex " + v.getName() + " --");
            for (Edge e : v.getEdges()) {
                System.out.println("\tVertex ID" + e.toString());
                System.out.println("\tVertex from: " + e.getFrom().getName());
                System.out.println("\tVertex to: " + e.getTo().getName());
                System.out.println("\tVertex weight: " + e.getWeight());
            }
        }
    }

    @Override
    public boolean isAVertex(String s) {
        for (Vertex v : vertices) {
            if (v.getName().equals(s)) {
                return true;
            }
        }
        return false;
    }

    public Vertex getVertexByName(String s) {
        for (Vertex v: vertices) {
            if (v.getName().equals(s)) {
                return v;
            }
        }
        return null;
    }
}
