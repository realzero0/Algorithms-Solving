package jungol;

import java.util.*;

public class String2604 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		int height = 0;
		for (int i = 0; i < input.length(); i++) {
			switch (input.charAt(i)) {
			case '(':
				if (i == 0) {
					height += 10;
				} else if (input.charAt(i - 1) == '(') {
					height += 5;
				} else {
					height += 10;
				}
				break;
			case ')':
				if (i == 0) {
					height += 10;
				} else if (input.charAt(i - 1) == ')') {
					height += 5;
				} else {
					height += 10;
				}
				break;
			default:
				break;
			}
		}
		System.out.println(height);
	}
}
