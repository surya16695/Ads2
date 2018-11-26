import java.util.Scanner;
import java.util.HashMap;
class Solution{
	public static void main(String[] args) {
		// Stopwatch time = new Stopwatch();
		Scanner s = new Scanner(System.in);
		int num = Integer.parseInt(s.nextLine());
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		//HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		for(int i =0;i<num;i++){
			int temp = Integer.parseInt(s.nextLine());
			if(!bst.contains(temp)){
				bst.put(temp, 1);
			} else {
				bst.put(temp, bst.get(temp)+1);
			}
		}
		bst.display();
		// bst.getRatio();
		}
}