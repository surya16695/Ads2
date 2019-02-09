import java.util.*;

class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = Integer.parseInt(sc.nextLine());
		int n = Integer.parseInt(sc.nextLine());
		Graph g = new Graph(n+1);
		for (int i = 0; i < n; i++) {
			String[] line = sc.nextLine().split(" ");
			g.addEdge(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
		}
		Bag<Integer> sample = g.getBag(s);
		int numb = n+1;
		int count1 = 0;
		int count2 = 0;
		int flag1 = 0;
		int flag2 = 0;
		for (int each: sample) {
			if (each != s) {
				if (g.getBag(each).size()<n+1) {
					if (count1 < g.getBag(each).size()) {
						count1 = g.getBag(each).size();
						flag1 = each;
					}else if (count1 == g.getBag(each).size()) {
						flag2 = each;
						count2 = g.getBag(each).size();
					}
				}
			}
		}
		if (flag1 < flag2) {
			System.out.println(flag1);
			System.out.println(count2);
		} else{
			System.out.println(flag2);
			System.out.println(count1);
		}
	}
}