package beakjun.exam170405.seperatesum;

import java.util.*;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int resultNum = 0;
		int sum = 0;
		for (int i=1; i <= input; i++) {
			int n = i;
			sum = i;
			while (n > 0) {
				sum += n % 10;
				n /= 10;
			}
			if (sum == input) {
				resultNum = i;
				break;
			}
		}
		System.out.println(resultNum);
	}

}
