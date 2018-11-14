import java.util.Scanner;
import java.util.Arrays;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String[] arr = new String[n];
		int i = 0;
		while (i < n) {
			arr[i] = sc.nextLine();
		}
		LSD le = new LSD();
		le.sort(arr, 8);
		System.out.println(Arrays.toString(arr));
	}
}