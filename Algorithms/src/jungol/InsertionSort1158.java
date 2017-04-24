package jungol;

import java.util.*;

public class InsertionSort1158 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int arraySize = s.nextInt();
		int[] inputArray = new int[arraySize];
		for(int i =0; i<arraySize; i++) {
			inputArray[i] = s.nextInt();
		}
		
		for(int i=1; i<inputArray.length; i++) {
			for(int j=i-1; j>=0; j--) {
				if(inputArray[j] > inputArray[j+1]) {
					int temp = inputArray[j+1];
					inputArray[j+1] = inputArray[j];
					inputArray[j] = temp;
				}
			}
			for(int k : inputArray) {
				System.out.print(k + " ");
			}
			System.out.println();
		}
	}
}
