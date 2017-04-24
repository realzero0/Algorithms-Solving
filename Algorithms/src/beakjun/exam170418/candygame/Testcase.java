package beakjun.exam170418.candygame;

import java.util.*;

public class Testcase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		Random a = new Random();
		char[][] test = new char[num][num];
		for (int j = 0; j < num; j++) {
			for (int i = 0; i < num; i++) {
				test[i][j] = (char) (a.nextInt(26) + 'A');
			}
		}
		for(char[] aa : test) {
			for(char b : aa) {
				System.out.print(b);
			}
			System.out.println();
		}
	}

}
