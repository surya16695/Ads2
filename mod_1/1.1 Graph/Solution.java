import java.util.Scanner;
// /**
//  * Interface for graph.
//  */
// interface Graph {
//     /**
//      * Verztices num.
//      *
//      * @return     { description_of_the_return_value }
//      */
//     int ver();
//     /**
//      * Edges num.
//      *
//      * @return     { description_of_the_return_value }
//      */
//     int edg();
//     /**
//      * Adds an edge.
//      *
//      * @param      v     { parameter_description }
//      * @param      w     { parameter_description }
//      */
//     void addEdge(int v, int w);
//     /**
//      * Iterator for bag.
//      *
//      * @param      v     { parameter_description }
//      *
//      * @return     { description_of_the_return_value }
//      */
//     Iterable<Integer> adj(int v);
//     /**
//      * Determines if it has edge.
//      *
//      * @param      v     { parameter_description }
//      * @param      w     { parameter_description }
//      *
//      * @return     True if has edge, False otherwise.
//      */
//     boolean hasEdge(int v, int w);
// }
/**
 * Class for graphmaker.
 */
class Graphmaker {
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
    private Bag< Integer > [] adj;

    /**
     * Constructs the object.
     */
    Graphmaker() {

    }

    /**
     * Constructs the object.
     *
     * @param      v1    The v 1
     */
    Graphmaker(final int v1) {
        this.v = v1;
        this.e = 0;
        adj = (Bag< Integer >[]) new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] =  new Bag< Integer >();
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
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     */
    public void addEdge(final int v, final int w) {
        if (v == w) {
            return;
        }
        if (!hasEdge(v, w)) {
            e++;
            adj[v].add(w);
            adj[w].add(v);
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
    /**
     * Prints in list view.
     *
     * @param      ve          { parameter_description }
     * @param      ed          { parameter_description }
     * @param      tokens     The tokens
     *
     * @throws     Exception  { exception_description }
     */
    public void listView(final int ve, final int ed, final String[] tokens) throws Exception {
        if (ed <= 1 && ve <= 1) {
            System.out.println(ver() + " vertices" + ", " + edg() + " edges");
            throw new Exception("No edges");
        } else {
            System.out.println(ver() + " vertices" + ", " + edg() + " edges");
            for (int i = 0; i < tokens.length; i++) {
            String str = "";
            str = tokens[i] + ": ";
            for (int k : adj(i)) {
                str = str + tokens[k] + " ";
            }
            System.out.println(str);
            }
        }
    }
    /**
     * matrix printing.
     *
     * @param      ve         { parameter_description }
     * @param      ed          { parameter_description }
     *
     * @throws     Exception  { exception_description }
     */
    void matrixView(final int ve, final int ed) throws Exception {
        if (ed <= 1 && ve <= 1) {
            System.out.println(ver() + " vertices" + ", " + edg() + " edges");
            throw new Exception("No edges");
        } else {
            System.out.println(ver() + " vertices" + ", " + edg() + " edges");
            int[][] disp = new int[ve][ve];
            for (int i = 0; i  < v; i++) {
                for (int j = 0; j < v; j++) {
                    if (hasEdge(i, j)) {
                        disp[i][j] = 1;
                    }
                }
            }

            for (int i = 0; i < v; i++) {
                for (int j = 0; j < ve; j++) {
                    System.out.print(disp[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
/**
 * Class for solution.
 */
class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int a = Integer.parseInt(sc.nextLine());
        int b = Integer.parseInt(sc.nextLine());
        Graphmaker g = new Graphmaker(a);
        // sc.nextLine();
        String[] line = sc.nextLine().split(",");
        while (sc.hasNext()) {
            String num = sc.nextLine();
            String[] numbers = num.split(" ");
            g.addEdge(Integer.parseInt(numbers[0]),
                Integer.parseInt(numbers[1]));
        }
        switch (input) {
            case "List":
            try {
                g.listView(a, b, line);
            } catch (Exception p) {
                System.out.println(p.getMessage());
            }
            break;
            case "Matrix":
            try {
                g.matrixView(a, b);
            } catch (Exception p) {
                System.out.println(p.getMessage());
            }
            break;
            default:
            break;
        }
    }
}


