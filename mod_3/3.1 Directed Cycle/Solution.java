import java.util.Scanner;
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
        if (ve == w) {
            return;
        }
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
class DFs {
	boolean[] marked;
	int[] edgeTo;
	int count;
	DFs() {

	}

    public DFs(DiGraph G, int s) {
        marked = new boolean[G.ver()];
        edgeTo = new int[G.ver()];
        validateVertex(s);
        dfs(G, s);
    }
    private void dfs(DiGraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
            else {
            	System.out.println("Cycle exists.");
            }
        }
        System.out.println("Cycle doesn't exists.");
    }
    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
}
class Solution {
	Solution() {

	}
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
    }
}