package geo.exam02;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[][] arr = new int[(n * 2) - 1][(n * 2) - 1];
		int k = 0;
		for (int j = 0, a=n; j < n; j++) {
			for (int i = j ; i < (n * 2) - 1 - j; i++) {
				if (i-j <= ((n * 2) - 1 - (2 * j))/2) {
					arr[i][--a] = k;
				} else {
					arr[i][++a] = k;
				}
				k++;
			}
			for (int i = (n * 2) - 1 - (j + 2); i >= j+1; i--) {
				if (i-j >= ((n * 2) - 1 - (2 * j))/2) {
					arr[i][++a] = k;
				} else {
					arr[i][--a] = k;
				}
				k++;
			}
		}
		for(int i=0; i<(n * 2) - 1; i++) {
			for(int j=0; j<(n * 2) - 1; j++) {
				if(arr[i][j] == 0 && !(i == 0 && j == n-1)) {
					System.out.print("  ");
				} else {
					System.out.print((char) ((arr[i][j]%26)+65) + " ");
				}
			}
			System.out.println();
		}
	}
}
