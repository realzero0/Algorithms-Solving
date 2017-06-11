package study01.baedal;

public class Beadal {
	public static void main(String args[]) {
		Solution s = new Solution();
		System.out.println(s.solution(new int[] { 1, 6, 2, 3}));
	}
}

class Solution {
	public int solution(int[] A) {
		// write your code in Java SE 8
		int[] countA = new int[7];
		int count = 0;
		int max = -1;
		int index = 0;
		for (int i = 0; i < A.length; i++) {
			countA[A[i]]++;
			count++;
		}
		for (int i = 1; i <= 3; i++) {
			if (countA[i] > 0 && countA[7 - i] > 0 && (countA[i] > 1 || countA[7 - i] > 1)) {
				if (Math.abs(countA[i] - countA[7 - i]) >= max) {
					index = i;
				}
			}
		}
		if (index == 0) {
			return count - 1;
		} else {
			return Math.min(countA[index], countA[7 - index]) * 2 + (count - countA[index] - countA[7 - index]);
		}
	}

}