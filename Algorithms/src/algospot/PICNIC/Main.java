package algospot.PICNIC;

import java.util.*;

public class Main {
	static ArrayList<Integer[][]> allOfCouples = new ArrayList<>();
	static int[] studentNum;
	static ArrayList<Integer> students = new ArrayList<>();
	static int possibleCount = 0;
	static boolean isPossible = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// case의 수
		int inputCount = sc.nextInt();
		// student의 수
		studentNum = new int[inputCount];
		for (int i = 0; i < inputCount; i++) {
			studentNum[i] = sc.nextInt();
			// 학생 쌍의 수
			int couplesOfStudents = sc.nextInt();
			Integer[][] friends = new Integer[couplesOfStudents][2];
			for (int j = 0; j < couplesOfStudents; j++) {
				friends[j][0] = sc.nextInt();
				friends[j][1] = sc.nextInt();
			}
			allOfCouples.add(friends);
		}

		for (int i = 0; i < inputCount; i++) {
			possibleCount = 0;
			findCouple(i, 0, allOfCouples.get(i).length, studentNum[i] / 2);

			System.out.println(possibleCount);
		}
	}
	//current는 0에서 하나씩 증가시켜야함
	public static void findCouple(int order, int current, int couples, int toPick) {
		if (toPick == 0) {
			isPossible = false;
			for (int i = 0; i < students.size(); i++) {
				int count = 0;
				for (int j = 0; j < students.size(); j++) {
					if (students.get(i) == students.get(j)) {
						count++;
					}
				}
				if (count == 1) {
					isPossible = true;
				} else {
					isPossible = false;
					return;
				}
			}
			if (isPossible == true) {
				possibleCount++;
			}
			return;
		}
		for (; current < couples; current++) {
			Integer[] friends = allOfCouples.get(order)[current];
			students.add(friends[0]);
			students.add(friends[1]);
			findCouple(order, current + 1, couples, toPick - 1);
			students.remove(students.size() - 1);
			students.remove(students.size() - 1);
		}

	}
}
