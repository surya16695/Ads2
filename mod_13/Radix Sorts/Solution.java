import java.util.Scanner;
import java.util.Arrays;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[] arr = new int[n];
		int i = 0;
		while (i < n) {
			arr[i] = sc.nextInt();
		}
		LSD le = new LSD();
		le.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}