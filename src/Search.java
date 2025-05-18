import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class Search<V> {
    protected Map<V, Boolean> marked;
    protected Map<V, V> edgeTo;
    protected final V start;

    public Search(V start) {
        this.start = start;
        this.marked = new HashMap<>();
        this.edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(V v) {
        return marked.getOrDefault(v, false);
    }

    public List<V> pathTo(V v) {
        if (!hasPathTo(v)) return null;
        LinkedList<V> path = new LinkedList<>();
        for (V x = v; !x.equals(start); x = edgeTo.get(x)) {
            path.addFirst(x);
        }
        path.addFirst(start);
        return path;
    }
}
