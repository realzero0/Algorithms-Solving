package greedy.exam01;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[][] conferences = new int[N][4];
		boolean[] isPossible = new boolean[N];
		boolean[] result = new boolean[100];
		boolean isEmpty = true;
		int m = 0;
		for (int i = 0; i < N; i++) {
			conferences[i][0] = s.nextInt();
			conferences[i][1] = s.nextInt();
			conferences[i][2] = s.nextInt();
			conferences[i][3] = conferences[i][2] - conferences[i][1];
		}
		heapSort(conferences);
		for (int m1 = (int) ((Math.random()*10)%N), i=0; i < 3*N; i++,m1=(int) ((Math.random()*10)%N)) {
			isEmpty = true;
			for (int j = conferences[m1][1]; j < conferences[m1][2]; j++) {
				if(result[j] == true) {
					isEmpty = false;
					break;
				}
			}
			if(isEmpty == true) {
				for (int j = conferences[m1][1]; j < conferences[m1][2]; j++) {
					result[j] = true;
				}
				isPossible[m1] = true;
			}
		}
		for(int i=0; i<N; i++) {
			if(isPossible[i] == true) {
				m = m + 1;
			}
		}
		System.out.println(m);
		for(int i=0; i<N; i++) {
			if(isPossible[i] == true) {
				System.out.print(conferences[i][0] + " ");
			}
		}

	}

	public static void heapSort(int[][] arr) {
		int len = arr.length;
		for (int k = len / 2; k > 0; k--) {
			downHeap(arr, k, len);
		}
		do {
			int[] temp = arr[0];
			arr[0] = arr[len - 1];
			arr[len - 1] = temp;
			len = len - 1;
			downHeap(arr, 1, len);
		} while (len > 1);

	}

	private static void downHeap(int arr[][], int k, int len) {
		int j;

		int[] temp = arr[k - 1];
		while (k <= len / 2) {
			j = 2 * k;
			if ((j < len) && (arr[j - 1][3] < arr[j][3]))
				j++;
			if (temp[3] >= arr[j - 1][3])
				break;

			arr[k - 1] = arr[j - 1];
			k = j;
		}
		arr[k - 1] = temp;
	}
}
