import java.util.Scanner;
/**
 * Class for di graph.
 */
class DiGraph {
    /**
     * num of vertices.
     */
    private int v;
    /**
     * num of edges.
     */
    private int e;
    /**
     * bag type array.
     */
    private Bag<Integer>[] adj;

    /**
     * Constructs the object.
     */
    DiGraph() {

    }

    /**
     * Constructs the object.
     *
     * @param      v1    The v 1
     */
    DiGraph(final int v1) {
        this.v = v1;
        this.e = 0;
        adj = (Bag<Integer>[]) new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] =  new Bag<Integer>();
        }
    }

    /**
     * No.of vertices.
     *
     * @return     { description_of_the_return_value }
     */
    public int ver() {
        return v;
    }

    /**
     * No.of edges.
     *
     * @return     { description_of_the_return_value }
     */
    public int edg() {
        return e;
    }

    /**
     * Adds an edge.
     *
     * @param      ve     { parameter_description }
     * @param      w     { parameter_description }
     */
    public void addEdge(final int ve, final int w) {
        // if (ve == w) {
        //     return;
        // }
        if (!hasEdge(ve, w)) {
            e++;
            adj[ve].add(w);
        }
    }

    /**
     * Determines if it has edge.
     *
     * @param      ve     { parameter_description }
     * @param      w     { parameter_description }
     *
     * @return     True if has edge, False otherwise.
     */
    public boolean hasEdge(final int ve, final int w) {
        for (int each: adj[ve]) {
                if (each == w) {
                    return true;
                }
        }
        return false;
    }

    /**
     * Iterable bag elements.
     *
     * @param      ve     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<Integer> adj(final int ve) {
        return adj[ve];
    }
}
/**
 * Class for DFS.
 */
class DFs {
    /**
     * Boolean array for the vertices.
     */
    private boolean[] marked;
    /**
     * gives bool whether element is present or not in stack.
     */
    private boolean[] onStack;
    /**
     * Give the previous edge of the given vertex.
     */
    private int[] edgeTo;
    /**
     * Cycle is a stack to add cycle forming vertices.
     */
    private Stack<Integer> cycle;
    /**
     * Constructs the object.
     */
    DFs() {

    }

    /**
     * Constructs the object for DFS.
     *
     * @param      gr     { parameter_description }
     * @param      s     { parameter_description }
     */
    DFs(final DiGraph gr, final int s) {
        marked = new boolean[gr.ver()];
        onStack = new boolean[gr.ver()];
        edgeTo = new int[gr.ver()];
        validateVertex(s);
        // hasCycle =false;
        dfs(gr, s);
    }
    /**
     * performs DFS.
     *
     * @param      gr    { parameter_description }
     * @param      v     { parameter_description }
     */
    private void dfs(final DiGraph gr, final int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : gr.adj(v)) {

            // short circuit if directed cycle found
            if (cycle != null) {
                return;
            // found new vertex, so recur
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(gr, w);
            } else if (onStack[w]) {

            // trace back directed cycle
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
                // assert check();
            }
        }
        onStack[v] = false;
    }
    /**
     * Determines if it has cycle.
     *
     * @return     True if has cycle, False otherwise.
     */
    public boolean hasCycle() {
        return cycle != null;
    }
    /**
     * to validate given vertex is in rangeor not.
     *
     * @param      v     { parameter_description }
     */
    private void validateVertex(final int v) {
        int v1 = marked.length;
        if (v < 0 || v >= v1) {
            throw new IllegalArgumentException("vertex "
                + v + " is not between 0 and " + (v1 - 1));
        }
    }
}
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * MAin method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = Integer.parseInt(sc.nextLine());
        int b = Integer.parseInt(sc.nextLine());
        DiGraph g = new DiGraph(a);
        while (sc.hasNext()) {
            String num = sc.nextLine();
            String[] numbers = num.split(" ");
            g.addEdge(Integer.parseInt(numbers[0]),
                Integer.parseInt(numbers[1]));
        }
        DFs cc = new DFs(g, 0);
        if (cc.hasCycle()) {
            System.out.println("Cycle exists.");
        } else {
            System.out.println("Cycle doesn't exists.");

        }
    }
}

