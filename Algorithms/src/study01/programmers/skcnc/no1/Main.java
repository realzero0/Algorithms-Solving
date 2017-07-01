package study01.programmers.skcnc.no1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution {
	public int[] solution(int[] truck, int[] w) {
		int[] truckNum = new int[truck.length];
		int t = 0;
		for (int i = 0; i < w.length; i++) {
			for (int j = 0; j < truck.length; j++) {
				if (truck[j] > w[i]) {
					truck[j] -= w[i];
					truckNum[t++] = j;
				}
			}
		}
		return truckNum;
	}
}