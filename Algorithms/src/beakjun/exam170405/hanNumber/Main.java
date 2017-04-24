package beakjun.exam170405.hanNumber;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int[] numArray = new int[5];
		int count = 0;
		for (int i=1; i <= input; i++) {
			boolean isHanNum = true;
			int n = i;
			Arrays.fill(numArray, 0);
			int k = 0;
			while (n > 0) {
				numArray[k] = n % 10;
				n /= 10;
				k++;
			}
			for(n=1; n<k-1; n++) {
				if(numArray[n] - numArray[n-1] != numArray[n+1] - numArray[n]) {
					isHanNum = false;
				}
			}
			if(isHanNum == true) {
				count++;
			}
		}
		System.out.println(count);
	}
}
