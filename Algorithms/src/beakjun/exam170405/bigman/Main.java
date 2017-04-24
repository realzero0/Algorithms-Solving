package beakjun.exam170405.bigman;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		Person[] people = new Person[num];
		for (int i = 0; i < num; i++) {
			people[i] = new Person(sc.nextInt(), sc.nextInt());
		}
		Person[] people2 = people.clone();
		Arrays.sort(people);
		people[0].setRank(1);
		for (int i = 0; i < num - 1; i++) {
			if (people[i].compareTo(people[i + 1]) < 0) {
				people[i + 1].setRank(i + 2);
			} else {
				people[i + 1].setRank(people[i].getRank());
			}
		}

		for (int i = 0; i < num; i++) {
			System.out.print(people2[i].getRank() + " ");
		}
	}

	private static class Person implements Comparable<Person> {
		private int height;
		private int weight;
		private int rank;

		Person(int height, int weight) {
			this.height = height;
			this.weight = weight;
		}

		public void setRank(int rank) {
			this.rank = rank;
		}

		public int getRank() {
			return rank;
		}

		@Override
		public int compareTo(Person p1) {
			if (this.height > p1.height && this.weight > p1.weight) {
				return -1;
			} else if (this.height < p1.height && this.weight < p1.weight) {
				return 1;
			} else {
				return 0;
			}
		}
	}
}
