package beakjun.exam170405.seperatesum;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int resultNum = 0;
		int sum = 0;
		String inputString = Integer.toString(input);
		int i;
		if(input <= 10) {
			i = 1;
		} else {
			i = input - 10 * inputString.length();
		}
		for (; i <= input; i++) {
			String s = Integer.toString(i);
			sum = i;
			for (int j = 0; j < s.length(); j++) {
				sum += (int)s.charAt(j) - 48;
			}
			if(sum == input) {
				resultNum = i;
				break;
			}
		}
		System.out.println(resultNum);
	}
}
