import java.util.Scanner;
class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		while (n > 0) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
		}
		System.out.println(minSum(arr, n));
	}
	public static int minSum(int[][] array, int s) {
		int sum = 0;
		for (int i = 0; i < s; i++) {
			for (int j = 0; j < s; j++) {
				int a = array[i - 1][j];
				int b = array[i + 1][j];
				int c = array[i][j - 1];
				int d = array[i][j + 1];
				sum += Math.min(Math.min(a, b), Math.min(c, d));
			}
		}
		return sum;
	}
}