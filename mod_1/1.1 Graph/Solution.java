import java.util.*;
interface Graph {
    public int V();
    public int E();
    public void addEdge(int v, int w);
    public Iterable<Integer> adj(int v);
    public boolean hasEdge(int v, int w);
}
class Graphmaker implements Graph {
	int v;
	int e;
	Bag<Integer> [] adj;

	Graphmaker() {

	}

	Graphmaker(int v1) {
        this.v = v1;
        this.e = 0;
		for (int i = 0; i < v; i++) {
			adj[i] =  new Bag<Integer>();
		}
	}

	public int V() {
		return v;
	}

	public int E() {
		return e;
	}

	public void addEdge(int v, int w) {
		if (v == w) {
			return;
		}
		if (!hasEdge(v, w)) {
			e++;
		}
		adj[v].add(w);
		adj[w].add(v);
	}

	public boolean hasEdge(int v, int w) {
		for(int each: adj[v]) {
				if (each == w) {
					return true;
				}
		}
		return false;
    }

	public Iterable<Integer> adj(int v) {
        return adj[v];
    }
    public void listView(int v, int e, String[] tokens) throws Exception {
    	if (e <= 1 && v <= 1) {
    		System.out.println(V() + " vertices" + ", " + E() + " edges");
    		throw new Exception("No edges");
    	} else {
    		System.out.println(V() + " vertices" + ", " + E() + " edges");
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
    void matrixView(int v, int e) throws Exception {
    	if (e <= 1 && v <= 1) {
    		System.out.println(V() + " vertices" + ", " + E() + " edges");
    		throw new Exception("No edges");
    	} else {
    		System.out.println(V() + " vertices" + ", " + E() + " edges");
    		int[][] disp = new int[v][v];
    		for (int i = 0; i  < v; i++) {
    			for (int j = 0; j < v; j++) {
    				if (hasEdge(i, j)) {
    					disp[i][j] = 1;
		    		}
    			}
    		}

    		for (int i = 0; i < v; i++) {
    			for (int j = 0; j < v; j++) {
    				System.out.print(disp[i][j] + " ");
    			}
    			System.out.println();
    		}
    		
    	}
    }
}
class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int a = sc.nextInt();
		int b = sc.nextInt();
		Graphmaker g = new Graphmaker(a);
		String[] line = sc.nextLine().split(",");
		while(sc.hasNext()) {
			String num = sc.nextLine();
			String[] numbers = num.split(" ");
			g.addEdge(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));
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
		}
	}
}