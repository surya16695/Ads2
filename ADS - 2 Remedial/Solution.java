import java.util.*;

class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = Integer.parseInt(sc.nextLine());
		int n = Integer.parseInt(sc.nextLine());
		Graph g = new Graph(n+3);
		for (int i = 0; i < n; i++) {
			String[] line = sc.nextLine().split(" ");
			g.addEdge(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
		}
		Bag<Integer> sample = g.getBag(s);
		if (sample.iterator().next()==s) {
			System.out.println(s);
			System.out.println(0);
		} else {

			int numb = n+1;
			int count1 = 0;
			int count2 = 0;
			int flag1 = 0;
			int flag2 = 0;
			for (int each: sample) {
				if (each == s) {
					continue;
				}
				if (g.getBag(each).size()< n+1) {
					if (count1 < g.getBag(each).size()) {
						count1 = g.getBag(each).size();
						flag1 = each;
					}else if (count1 == g.getBag(each).size()) {
						flag2 = each;
						count2 = g.getBag(each).size();
					}
				}
			}
			if (flag1 < flag2) {
				int count3 = 0;
				System.out.println(flag1);
				for (int z : g.getBag(flag1)) {
					if (count3 < g.getBag(z).size()) {
						count3 = g.getBag(z).size();
					}

				}
				count1 += count3-1;
				System.out.println(count1);
			} else{
				System.out.println(flag2);
				int count4 = 0;
				for (int z : g.getBag(flag1)) {
					if (count4 < g.getBag(z).size()) {
						count4 = g.getBag(z).size();
					}

				}
				count2 += count4-1;
				System.out.println(count2);
			}
		}
	}

}