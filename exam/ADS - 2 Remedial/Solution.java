import java.util.*;

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.nextLine();
		Digraph di = new Digraph(a);
		for (int i =0; i < b; i++) {
			String[] str = sc.nextLine().split(" ");
			di.addEdge(Integer.parseInt(str[0]), Integer.parseInt(str[0]));
		}
		// DirectedCycle dy = new DirectedCycle(di);
		String s = "";
		for (int j = 0; j < a; j++) {
			DepthFirstDirectedPaths dfs = new DepthFirstDirectedPaths(di, j);
			
			if (dfs.hasPathTo(j)) {
				s += j+", ";
			}
			
		}
		System.out.println(s);
	}
}