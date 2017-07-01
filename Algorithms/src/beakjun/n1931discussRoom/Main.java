package beakjun.n1931discussRoom;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		PriorityQueue<Schedule> pq = new PriorityQueue<>();
		Schedule[] schedules = new Schedule[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			schedules[i] = new Schedule();
			schedules[i].start = Integer.parseInt(st.nextToken());
			schedules[i].end = Integer.parseInt(st.nextToken());
			pq.add(schedules[i]);
		}
		int count = 0;
		int before = 0;
		while (!pq.isEmpty()) {
			Schedule s = pq.poll();
			if (s.start >= before) {
				count++;
				before = s.end;
			}
		}
		System.out.println(count);
	}

}

class Schedule implements Comparable<Schedule> {
	int start;
	int end;

	// lha rha
	@Override
	public int compareTo(Schedule o) {
		if (this.end == o.end) {
			if (this.start > o.start) {
				return 1;
			} else {
				return -1;
			}
		} else if (this.end > o.end) {
			return 1;
		} else {
			return -1;
		}
	}
}