import java.util.*;
/**
 * Class for page rank.
 */
class PageRank {
	/**
	 * Diagraph.
	 */
	private Digraph gr;
	/**
	 * array values.
	 */
	private double[] values;
	/**
	 * Pr values.
	 */
	private double[] prValues;
	/**
	 * test conducting.
	 */
	double check;


	/**
	 * Constructs the object.
	 *
	 * @param      graph  The graph
	 */
	PageRank(Digraph graph) {
		this.gr = graph;
		this.gr = graph;
		values = new double[gr.V()];
		prValues = new double[gr.V()];
		for (int i = 0; i < gr.V(); i++) {
			values[i] = (1.0 / (double)(gr.V()));
		}
		maxPr();
	}
	/**
	 * maxPr value.
	 */
	void maxPr() {
	Digraph tempgr = gr.reverse();
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < gr.V(); j++) {
				check = 0.0;
				for (int each : tempgr.adj(j)) {
					check += (values[each]) / (double)(gr.outdegree(each));
				}
				prValues[j] = check;
			}
			values = prValues.clone();
		}
		for (int k = 0; k < gr.V(); k++) {
			System.out.print(k + " - " + prValues[k] + "\n");
		}
	}
}

/**
 * Class for web search.
 */
class WebSearch {

}


/**
 * Class for solution.
 */
public class Solution {
	/**
	 * main function.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// read the first line of the input to get the number of vertices
		int a = Integer.parseInt(sc.nextLine());
		Digraph g = new Digraph(a);
		// iterate count of vertices times 
		// to read the adjacency list from std input
		// and build the graph
		for (int i = 0; i < a; i++) {
			String[] tokens = sc.nextLine().split(" ");
			for (int j = 1; j < tokens.length; j++) {
				g.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[j]));
				if (tokens.length == 1) {
					for (int k = 0; k < g.V(); k++) {
						if (k != Integer.parseInt(tokens[0])) {
							g.addEdge(Integer.parseInt(tokens[0]), k);
						}
					}
				}	
			}
		}
		System.out.println(g);
		// Create page rank object and pass the graph object to the constructor
		PageRank pr = new PageRank(g);
		// print the page rank object
		// This part is only for the final check case
		
		// File path to the web content
		String file = "WebContent.txt";
		
		// instantiate web search object
		// and pass the page rank object and the file path to the constructor
		
		// read the search queries from std in
		// remove the q= prefix and extract the search word
		// pass the word to iAmFeelingLucky method of web search
		// print the return value of iAmFeelingLucky
		
	}
}
