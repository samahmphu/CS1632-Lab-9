import java.util.*;

public abstract class Graph {
    protected ArrayList<Vertex> vertices;


    public abstract Vertex addVertex(String s);

    public abstract void addEdge(String from, String to, double weight);

    public abstract void printGraph();

    public abstract boolean isAVertex(String s);

    public abstract Vertex getVertexByName(String s);


    public void dAlgo(Vertex source) {
        HashMap<Vertex, Double> dis = new HashMap<>();
        HashMap<Vertex, Vertex> prev = new HashMap<>();

        PriorityQueue<Vertex> queue = new PriorityQueue<>(
                Comparator.comparingDouble(n -> dis.get(n))
        );

        // distances
        for (Vertex v : vertices) {
            dis.put(v,Double.POSITIVE_INFINITY);
            prev.put(v,null);
        }

        dis.put(source,0.0);
        queue.addAll(vertices);

        // algorithm
        while (!queue.isEmpty()) {
            Vertex ver = queue.poll();

            if (Double.isInfinite(dis.get(ver))) {
                break;
            }

            for (Edge edge : ver.getEdges()) {
                Vertex v;
                if (edge.getFrom() == ver) {
                    v = edge.getTo();
                }
                else if (edge.getTo() == ver) {
                    v = edge.getFrom();
                }
                else {
                    continue;
                }

                // avoid repeating
                if (!queue.contains(v)) {
                    continue;
                }

                double alt = (dis.get(ver) + edge.getWeight());

                if (alt < dis.get(v)) {
                    queue.remove(v);

                    dis.put(v, alt);
                    prev.put(v, ver);

                    queue.add(v);
                }
            }
        }

        // print shortest paths
        for (Vertex v : vertices) {
            if (Double.isInfinite(dis.get(v))) {
                System.out.println(v.getName() + " is not reachable");
                continue;
            }
            LinkedList<Vertex> path = new LinkedList<>();

            Vertex current = v;

            while (current != null) {
                path.addFirst(current);
                current = prev.get(current);
            }

            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i).getName());

                if (i < path.size() - 1) {
                    System.out.print("-> ");
                }
            }
            System.out.printf(" dist: %.1f%n", dis.get(v));
        }
    }
}
