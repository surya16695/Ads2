import java.util.*;

class Sample{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = Integer.parseInt(sc.nextLine());
		int n = Integer.parseInt(sc.nextLine());
		Graph g = new Graph(n+3);
		for (int i = 0; i < n; i++) {
			String[] line = sc.nextLine().split(" ");
			g.addEdge(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
		}
		ST<Integer, Integer> st = new ST<>();
		Bag<Integer> sample = g.getBag(s);
		if (sample.iterator().next()==s) {
			System.out.println(s);
			System.out.println(0);
		} else {
			for (int each: sample) {
					DepthFirstSearch df = new DepthFirstSearch(g, each);
					st.put(df.count(), each);
					System.out.println(df.count());
			}
		}
		int count = 0;
		int mem = 0;
		for (int i = 0; i < st.size(); i++) {
			if (st.get(i) < st.get(i+1)) {
				count = st.get(i+1);
				mem = i+1;
			}
		}
		System.out.println(mem);
		System.out.println(count);
	}
}