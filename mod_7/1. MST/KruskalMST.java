/**
 * Class for kruskal mst.
 */
public class KruskalMST {
    /**
     * Floating point.
     */
    private static final double FLOATING_POINT_EPSILON = 1E-12;
    /**
     * weight of MST.
     */
    private double weight;
    /**
     * edges in MST.
     */
    private Queue<Edge> mst = new Queue<Edge>();

    /**
     * Compute a minimum spanning tree (or forest)
     * of an edge-weighted graph.
     * @param G the edge-weighted graph
     */
    public KruskalMST(final EdgeWeightedGraph G) {
        // more efficient to build heap by passing array of edges
        MinPQ<Edge> pq = new MinPQ<Edge>();
        for (Edge e : G.edges()) {
            pq.insert(e);
        }

        // run greedy algorithm
        UF uf = new UF(G.V());
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            // v-w does not create a cycle.
            if (!uf.connected(v, w)) {
                // merge v and w components.
                uf.union(v, w);
                // add edge e to mst.
                mst.enqueue(e);
                weight += e.weight();
            }
        }

        // check optimality conditions
        assert check(G);
    }

    /**
     * Returns the edges in a minimum spanning
     * tree (or forest).
     * @return the edges in a minimum spanning
     * tree (or forest) as
     * an iterable of edges
     *
     * Complexity is 1.
     */
    public Iterable<Edge> edges() {
        return mst;
    }

    /**
     * Returns the sum of the edge weights
     * in a minimum spanning tree (or forest).
     * @return the sum of the edge weights
     * in a minimum spanning tree (or forest)
     *
     * Complexity is 1.
     */
    public double weight() {
        return weight;
    }


    /**
     * Checks the optimality conditions.
     *
     * Complexity is E V lg* V.
     *
     * @param      grp     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private boolean check(final EdgeWeightedGraph grp) {

        // check total weight
        double total = 0.0;
        for (Edge e : edges()) {
            total += e.weight();
        }
        if (Math.abs(total - weight()) > FLOATING_POINT_EPSILON) {
System.err.printf("Weight of edges doesnot equal weight(): %f vs. %f\n",
    total, weight());
            return false;
        }

        // check that it is acyclic


        /**
         * Checks if the pariticular graph is acyclic.
         * Complexity is E.
         */
        UF uf = new UF(grp.V());
        for (Edge e : edges()) {
            int v = e.either(), w = e.other(v);
            if (uf.connected(v, w)) {
                System.err.println("Not a forest");
                return false;
            }
            uf.union(v, w);
        }

        // check that it is a spanning forest
        for (Edge e : grp.edges()) {
            int v = e.either(), w = e.other(v);
            if (!uf.connected(v, w)) {
                System.err.println("Not a spanning forest");
                return false;
            }
        }

        // check that it is a minimal spanning forest
        //(cut optimality conditions)
        for (Edge e : edges()) {

            // all edges in MST except e
            uf = new UF(grp.V());
            for (Edge f : mst) {
                int x = f.either(), y = f.other(x);
                if (f != e) uf.union(x, y);
            }
            
            // check that e is min weight edge in crossing cut
            for (Edge f : grp.edges()) {
                int x = f.either(), y = f.other(x);
                if (!uf.connected(x, y)) {
                    if (f.weight() < e.weight()) {
                        System.err.println("Edge " + f
                        + " violates cut optimality conditions");
                        return false;
                    }
                }
            }

        }

        return true;
    }
}