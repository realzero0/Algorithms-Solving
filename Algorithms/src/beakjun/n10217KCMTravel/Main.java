package beakjun.n10217KCMTravel;

import java.io.*;
import java.util.*;

public class Main {
	public static final StringBuilder POOR_KCM = new StringBuilder("Poor KCM");
	public static final int INF = 100000000;
	public static final int START = 1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] dist = new int[N + 1];
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				edges.add(new ArrayList<>());
				if (i == START) {
					dist[i] = 0;
				} else {
					dist[i] = INF;
				}
			}
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				Edge e = new Edge();
				e.num = Integer.parseInt(st.nextToken());
				e.next = Integer.parseInt(st.nextToken());
				e.cost = Integer.parseInt(st.nextToken());
				e.time = Integer.parseInt(st.nextToken());
				edges.get(e.num).add(e);
			}
			pq.add(new Edge(1, 0, 0));
			while (!pq.isEmpty()) {
				Edge e = pq.remove();
				for (Edge edge : edges.get(e.num)) {
					if (dist[edge.next] > e.time + edge.time && M >= e.cost + edge.cost) {
						dist[edge.next] = e.time + edge.time;
						// 새로 생성해서 Edge들을 넣어야 모든 경우를 전부 고려가능
						pq.add(new Edge(edge.next, e.cost + edge.cost, dist[edge.next]));
					}
				}
			}
			if (dist[N] >= INF) {
				System.out.println(POOR_KCM);
			} else {
				System.out.println(new StringBuilder().append(dist[N]));
			}
		}
	}
}

class Edge implements Comparable<Edge> {
	int num;
	int next;
	int cost;
	int time;

	public Edge() {
	}

	public Edge(int num, int cost, int time) {
		this.num = num;
		this.cost = cost;
		this.time = time;
	}

	@Override
	public int compareTo(Edge o) {
		if (this.time < o.time) {
			return -1;
		} else {
			return 1;
		}
	}
}