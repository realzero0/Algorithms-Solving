package jungol;

import java.util.*;

public class Selection1146 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int arraySize = s.nextInt();
		int min = 0;
		int[] inputArray = new int[arraySize];
		for (int i = 0; i < inputArray.length; i++) {
			inputArray[i] = s.nextInt();
		}
		for (int i = 0; i<inputArray.length-1; i++) {
			min = inputArray[i];
			for (int n = i; n < inputArray.length; n++) {
				if (min > inputArray[n]) {
					min = inputArray[n];
				}
			}
			for (int j = i; j < inputArray.length; j++) {
				if (inputArray[j] == min) {
					int temp = inputArray[i];
					inputArray[i] = inputArray[j];
					inputArray[j] = temp;
				}
			}
			for (int k : inputArray) {
				System.out.print(k + " ");
			}
			System.out.println();
		}
	}
}
