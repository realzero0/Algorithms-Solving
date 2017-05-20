package study01.combination;

public class AAA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 16;
		int[] stations = {9};
		int w = 2;
		System.out.println(solution(n, stations, w));
	}

	public static int solution(int n, int[] stations, int w) {
		int answer = 0;
		boolean[] state = new boolean[n];
		int[] noStationCount = new int[10001];
		for (int i = 0; i < stations.length; i++) {
			int j, length;
			if (stations[i] - w < 0) {
				j = 0;
			} else {
				j = stations[i] - w - 1;
			}
			if (stations[i] + w < n) {
				length = stations[i] + w;
			} else {
				length = n;
			}
			for (; j < length; j++) {
				state[j] = true;
			}
		}
		int j = 0;
		for (int i = 0; i < n; i++) {
			boolean isFalse = false;
			while (state[i] == false) {
				noStationCount[j]++;
				i++;
				isFalse = true;
			}
			if (isFalse = true) {
				j++;
			}
		}
		for (int i = 0; i < j; i++) {
			int middleCount = noStationCount[i] / ((2 * w) + 1);
			if (noStationCount[i] % ((2 * w) + 1) != 0) {
				middleCount++;
			}
			answer += middleCount;
		}

		return answer;
	}
}
