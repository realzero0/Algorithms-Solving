package jungol;

import java.util.*;

public class BinarySearch1295 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int sortedArraySize = s.nextInt();
		int[] sortedArray = new int[sortedArraySize];
		for (int i = 0; i < sortedArray.length; i++) {
			sortedArray[i] = s.nextInt();
		}
		int searchArraySize = s.nextInt();
		int[] searchArray = new int[searchArraySize];
		for (int i = 0; i < searchArray.length; i++) {
			searchArray[i] = s.nextInt();
		}
		
		for (int k : searchArray) {
			int start = 0;
			int end = sortedArray.length-1;
			int mid;
			while (true) {
				mid = (end + start) / 2;
				if(end < start) {
					mid = -1;
					break;
				}
				if (sortedArray[mid] > k) {
					end = mid - 1;
				} else if (sortedArray[mid] < k) {
					start = mid + 1;
				} else {
					break;
				}
				
			}
			System.out.println(mid + 1);
		}
	}
}
