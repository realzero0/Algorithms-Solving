package study01.combination;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		int[] arr = new int[n];
		combination(arr, n, r, 0, 0);
	}

	public static void combination(int[] arr, int n, int r, int index, int target) {
		if (r == 0) {
			printCom(arr, index);
		} else if (target == n) {
			return;
		} else {
			arr[index] = target;
			// index를 포함하지 않는 경우 예를 들어 (1, 2, 3)에서 1을 제외한 2, 3의 경우의 수 (1, 2, 4),
			// (1, 3, 4) 등을 구할 때
			combination(arr, n, r - 1, index + 1, target + 1);
			// index를 포함하는 경우 예를 들어 (1, 2, 3)에서 (2, 3, 4) 등 index값을 바꾼 경우
			combination(arr, n, r, index, target + 1);
		}
	}

	public static void printCom(int[] arr, int length) {
		for (int i = 0; i < length; i++) {
			System.out.print(arr[i]+1);
		}
		System.out.println();
	}
}
