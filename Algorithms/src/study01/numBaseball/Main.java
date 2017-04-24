package study01.numBaseball;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[3];
		ArrayList<int[]> answers = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int[] temp = new int[5];
			int a = sc.nextInt();
			String sA = Integer.toString(a);
			for (int k = 0; k < 3; k++) {
				temp[k] = Integer.parseInt(sA.charAt(k) + "");
			}
			temp[3] = sc.nextInt();
			temp[4] = sc.nextInt();
			answers.add(temp);
		}
		System.out.println(findAnswer(answers, n, arr));
	}

	public static int findAnswer(ArrayList<int[]> answers, int answerN, int[] arr) {
		int count =0;
		for(int i=1; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				if(i == j) {
					continue;
				}
				for(int k=1; k<=9; k++) {
					if(j==k || k==i) {
						continue;
					}
					arr[0] = i;
					arr[1] = j;
					arr[2] = k;
					count += compare(arr, answers, answerN);
				}
			}
		}
		return count;
	}

	public static int compare(int[] arr, ArrayList<int[]> answers, int answerN) {
		boolean isPossible=true;
		for (int i = 0; i < answerN; i++) {
			int s = answers.get(i)[3];
			int b = answers.get(i)[4];
			int realS = 0, realB = 0;
			for (int j = 0; j < 3; j++) {
				if (arr[j] == answers.get(i)[j]) {
					realS++;
				}
			}
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					if (j == k) {
						continue;
					} else if (arr[j] == answers.get(i)[k]) {
						realB++;
					}
				}
			}
			if(realS != s || realB != b) {
				isPossible = false;
				return 0;
			}
		}
		if (isPossible == true) {
			return 1;
		}
		return 0;
	}
}
