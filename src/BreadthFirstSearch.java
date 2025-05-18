import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BreadthFirstSearch<V> extends Search<V> {

    public BreadthFirstSearch(WeightedGraph<V> graph, V start) {
        super(start);
        bfs(graph, start);
    }

    private void bfs(WeightedGraph<V> graph, V start) {
        Queue<V> queue = new LinkedList<>();
        queue.add(start);
        marked.put(start, true);

        while (!queue.isEmpty()) {
            V current = queue.poll();
            for (Map.Entry<Vertex<V>, Double> entry : graph.getVertex(current).getAdjacentVertices().entrySet()) {
                V neighbor = entry.getKey().getData();
                if (!marked.containsKey(neighbor)) {
                    marked.put(neighbor, true);
                    edgeTo.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
    }
}

