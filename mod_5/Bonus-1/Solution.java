import java.util.*;
// class CC {
//     private boolean[] marked;
//     private int[] id;
//     private int[] size;
//     private int count;
//     CC() {

//     }
//  CC(Graph g) {
//         marked = new boolean[g.ve()];
//         id = new int[g.ve()];
//         size = new int[g.ve()];
//         for (int v = 0; v < g.ve(); v++) {
//             if (!marked[v]) {
//                 dfs(g, v);
//                 count++;
//             }
//         }
//     }
// }
class Solution {
    Solution() {

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        Graph graph = new Graph(v + 1);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.addEdge(a, b);
        }
        CC cc = new CC(graph);
        int sum = 0;
        int tempsum = 0;
            for (int i = 1; i < graph.ve() + 1; i++) {
                sum=0;
                for (int k = 1; k < graph.ve() + 1; k++) {
                    // System.out.println(cc.id[k]+"fwefgweuffwhowihfoiw");
                    // System.out.println("............");
                    // System.out.println(i+"******");
                    // if (i != k) {

                        if (cc.id[k] == i) {
                            sum++;
                        }
                    // } 
                }
            }
            if (tempsum >= sum) {
                tempsum = sum;
            }
            System.out.println(tempsum);
    }
}


