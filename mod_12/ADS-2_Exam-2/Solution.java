import java.util.Scanner;
/**
 * Class for solution.
 */
public class Solution {
    /**
     * Constructs the object.
     */
    Solution() {

    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = Integer.parseInt(sc.nextLine());
        int b = Integer.parseInt(sc.nextLine());
        EdgeWeightedGraph eg = new EdgeWeightedGraph(a);
        while (b > 0) {
            String[] tokens = sc.nextLine().split(" ");
            eg.createEdge(Integer.parseInt(tokens[0]),
             Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2]));
            b--;
        }
        // Self loops are not allowed...
        // Parallel Edges are allowed...
        // Take the Graph input here...
        

        String caseToGo = sc.nextLine();
        switch (caseToGo) {
        case "Graph":
            System.out.println(eg);
            break;

        case "DirectedPaths":
            // Handle the case of DirectedPaths, where two integers are given.
            // First is the source and second is the destination.
            // If the path exists print the distance between them.
            // Other wise print "No Path Found."
            String[] path = sc.nextLine().split(" ");
            int a1 = Integer.parseInt(path[0]);
            int a2 = Integer.parseInt(path[1]);
            DijkstraUndirectedSP dsp = new DijkstraUndirectedSP(eg, a1);
            if (dsp.hasPathTo(a2)) {
                System.out.println((double) dsp.distTo(a2));
            } else {
                System.out.println("No Path Found.");
            }
            break;

        case "ViaPaths":
            // Handle the case of ViaPaths, where three integers are given.
            // First is the source and second is the via is the one where path should pass throuh.
            // third is the destination.
            // If the path exists print the distance between them.
            // Other wise print "No Path Found."
            String[] paths = sc.nextLine().split(" ");
            int b1 = Integer.parseInt(paths[0]);
            int b2 = Integer.parseInt(paths[1]);
            int b3 = Integer.parseInt(paths[2]);
            DijkstraUndirectedSP dsp1 = new DijkstraUndirectedSP(eg, b1);
            DijkstraUndirectedSP dsp2 = new DijkstraUndirectedSP(eg, b2);
            String s = "";
            if (dsp1.hasPathTo(b2) && dsp2.hasPathTo(b3)) {
                System.out.println((double) dsp1.distTo(b2) + (double) dsp2.distTo(b3));
                for (Edge ed: dsp1.pathTo(b2)) {
                    s += ed.w + " " + ed.v + " ";
                }
                for (Edge ee: dsp2.pathTo(b3)) {
                    s += ee.w + " " + ee.v + " ";
                }
                String se = removeDuplicates(s);
                System.out.println(se);
            } else {
                System.out.println("No Path Found.");
            }
            break;

        default:
            break;
        }

    }
    /**
     * Removes duplicates.
     *
     * @param      input  The input
     *
     * @return     { description_of_the_return_value }
     */
    public static String removeDuplicates(final String input){
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            if(!result.contains(String.valueOf(input.charAt(i)))) {
                result += String.valueOf(input.charAt(i)) + " ";
            }
        }
        return result;
    }
}