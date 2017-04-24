package geo.exam01;

import java.util.*;
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		for (int i = 0; i < m * n; i++) {
			System.out.print((i+1) + " ");
			if ((i+1) % m == 0) {
				System.out.println();
			}
		}
	}
}
