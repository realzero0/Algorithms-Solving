package beakjun.exam170405.bigman;

import java.util.*;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		Person[] people = new Person[num];
		for (int i = 0; i < num; i++) {
			people[i] = new Person(sc.nextInt(), sc.nextInt());
		}
		for(Person p1 : people) {
			for(Person p2 : people) {
				if(p1.height > p2.height && p1.weight > p2.weight) {
					p2.rank++;
				}
			}
		}
		for(Person p : people) {
			System.out.print(p.rank + " ");
		}
	}
	private static class Person {
		private int height;
		private int weight;
		private int rank;
		
		Person(int height, int weight) {
			this.height = height;
			this.weight = weight;
			this.rank = 1;
		}
	}
}
