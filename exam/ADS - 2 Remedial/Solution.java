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
			di.addEdge(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
		}
		DirectedCycle dy = new DirectedCycle(di);
		int[] s = new int[a];
		if (dy.hasCycle()) {
			int i = 0;
			for (int each : dy.cycle()) {
				s[i] = each;
				i++;
			}
			Arrays.sort(s);
			String str = "";
			int n = removeDuplicates(s, s.length);
			for (int j = 0; j < n; j++) {
				str += s[j]+", ";
			}
			System.out.println(str.substring(0,str.length()-2));
		}else{
			System.out.println("No Self Beneficiaries.");
		}
	}

    static int removeDuplicates(int arr[], int n) {  
        if (n==0 || n==1) 
            return n; 
       
        int[] temp = new int[n]; 
          
        int j = 0; 
        for (int i=0; i<n-1; i++) {
            if (arr[i] != arr[i+1]){

                temp[j++] = arr[i]; 
            } 
        } 
        temp[j++] = arr[n-1];    
          
        for (int i=0; i<j; i++){

            arr[i] = temp[i]; 
        } 
       
        return j; 
    }
}
