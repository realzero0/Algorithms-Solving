package beakjun.n1753minimumroad;

import java.io.*;
import java.util.*;

public class Main2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		Edge[] dijkstra = new Edge[V + 1];
		Edge[] edges = new Edge[V + 1];
		for (int i = 1; i <= V; i++) {
			edges[i] = new Edge();
			dijkstra[i] = new Edge();
			dijkstra[i].num = i;
			dijkstra[i].value = Integer.MAX_VALUE - 1000000000;
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			edges[Integer.parseInt(st.nextToken())].addEdge(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		dijkstra[K].value = 0;
		for (int i = 1; i <= V; i++) {
			pq.add(dijkstra[i]);
		}

		while (!pq.isEmpty()) {
			Edge e = pq.remove();
			if (dijkstra[e.num].value < e.value) {
				continue;
			}
			for (Integer[] edge : edges[e.num].edges) {
				if(dijkstra[edge[0]].value > dijkstra[e.num].value + edge[1]) {
					dijkstra[edge[0]].value = dijkstra[e.num].value + edge[1];
					dijkstra[edge[0]].next = e.num;
					pq.add(dijkstra[edge[0]]);
				}
			}
		}

		for (int i = 1; i <= V; i++) {
			if (dijkstra[i].value > 100000000) {
				System.out.println("INF");
			} else {
				System.out.println(dijkstra[i].value);
			}
		}
	}
}

class Edge implements Comparable<Edge> {
	int num;
	int next;
	int value;
	ArrayList<Integer[]> edges = new ArrayList<>();

	@Override
	public int compareTo(Edge o) {
		if (this.value <= o.value) {
			return -1;
		} else {
			return 1;
		}
	}

	public void addEdge(int next, int value) {
		Integer[] edge = new Integer[2];
		edge[0] = new Integer(next);
		edge[1] = new Integer(value);
		edges.add(edge);
	}
}