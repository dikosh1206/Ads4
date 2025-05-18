public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 2);
        graph.addEdge("B", "D", 5);
        graph.addEdge("C", "D", 1);
        graph.addEdge("D", "E", 3);

        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph, "A");
        System.out.println("Path from A to E: " + dijkstra.pathTo("E"));
        System.out.println("Distance from A to E: " + dijkstra.distTo("E"));

        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph, "A");
        System.out.println("BFS Path from A to E: " + bfs.pathTo("E"));
    }
}
