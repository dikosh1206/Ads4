import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraSearch<V> extends Search<V> {
    private Map<V, Double> distTo;

    public DijkstraSearch(WeightedGraph<V> graph, V start) {
        super(start);
        distTo = new HashMap<>();
        dijkstra(graph, start);
    }

    private void dijkstra(WeightedGraph<V> graph, V start) {
        PriorityQueue<Vertex<V>> queue = new PriorityQueue<>(Comparator.comparingDouble(v -> distTo.get(v.getData())));
        for (Vertex<V> vertex : graph.getAllVertices()) {
            distTo.put(vertex.getData(), Double.POSITIVE_INFINITY);
        }
        distTo.put(start, 0.0);
        queue.add(graph.getVertex(start));
        marked.put(start, true);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                V neighbor = entry.getKey().getData();
                double weight = entry.getValue();
                double newDist = distTo.get(current.getData()) + weight;
                if (newDist < distTo.get(neighbor)) {
                    distTo.put(neighbor, newDist);
                    edgeTo.put(neighbor, current.getData());
                    queue.add(entry.getKey());
                    marked.put(neighbor, true);
                }
            }
        }
    }

    public double distTo(V vertex) {
        return distTo.getOrDefault(vertex, Double.POSITIVE_INFINITY);
    }
}
