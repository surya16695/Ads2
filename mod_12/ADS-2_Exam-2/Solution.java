import java.util.Scanner;
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.nextLine());
		int b = Integer.parseInt(sc.nextLine());
		EdgeWeightedGraph eg = new EdgeWeightedGraph(a);
		while (b > 0) {
			String[] tokens = sc.nextLine().split(" ");
			eg.createEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2]));
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
			DijkstraUndirectedSP dsp = new DijkstraUndirectedSP(eg, Integer.parseInt(path[0]));
			System.out.println((long) dsp.distTo(Integer.parseInt(path[1])));
			break;

		case "ViaPaths":
			// Handle the case of ViaPaths, where three integers are given.
			// First is the source and second is the via is the one where path should pass throuh.
			// third is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			break;

		default:
			break;
		}

	}
}