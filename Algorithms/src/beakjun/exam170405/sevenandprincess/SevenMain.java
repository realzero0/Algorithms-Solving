package beakjun.exam170405.sevenandprincess;

import java.util.*;

public class SevenMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dArray = new int[9];
		int[] realArray = new int[7];
		int sum = 0;
		for(int i=0; i<9; i++) {
			dArray[i] = sc.nextInt();
		}
		
		for(int i=0; i<9; i++) {
			sum += dArray[i];
		}
		for(int i=0; i<9; i++) {
			int tmp = sum;
			sum -= dArray[i];
			for(int j=0; j<9; j++) {
				if(sum - dArray[j] == 100 && i!=j) {
					dArray[i] = -1;
					dArray[j] = -1;
					break;
				}
			}
			sum = tmp;
		}
		Arrays.sort(dArray);
		for(int i=2; i<9; i++) {
			System.out.println(dArray[i]);
		}
	}

}
