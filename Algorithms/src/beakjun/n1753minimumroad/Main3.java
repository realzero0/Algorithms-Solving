package beakjun.n1753minimumroad;

import java.io.*;
import java.util.*;

public class Main3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());

		Node[] dijkstra = new Node[V + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		ArrayList<ArrayList<Node>> edges = new ArrayList<>();
		for (int i = 0; i <= V; i++) {
			ArrayList<Node> e = new ArrayList<>();
			edges.add(e);
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			Node edge = new Node();
			edge.num = new Integer(Integer.parseInt(st.nextToken()));
			edge.next = new Integer(Integer.parseInt(st.nextToken()));
			edge.value = new Integer(Integer.parseInt(st.nextToken()));
			edges.get(edge.num).add(edge);
		}
		for (int i = 1; i <= V; i++) {
			dijkstra[i] = new Node();
			dijkstra[i].num = i;
			if (i == K) {
				dijkstra[i].value = 0;
			} else {
				dijkstra[i].value = 987654321;
			}
			pq.add(dijkstra[i]);
		}

		while (!pq.isEmpty()) {
			Node e = pq.remove();
			if (dijkstra[e.num].value < e.value) {
				continue;
			}
			for (Node edge : edges.get(e.num)) {
				if (dijkstra[edge.next].value > dijkstra[e.num].value + edge.value) {
					dijkstra[edge.next].value = dijkstra[e.num].value + edge.value;
					dijkstra[edge.next].num = edge.next;
					pq.add(dijkstra[edge.next]);
				}
			}
		}

		for (int i = 1; i <= V; i++) {
			if (dijkstra[i].value == 987654321) {
				System.out.println("INF");
			} else {
				System.out.println(dijkstra[i].value);
			}
		}
	}
}

class Node implements Comparable<Node> {
	int num;
	int next;
	int value;

	@Override
	public int compareTo(Node o) {
		if (this.value <= o.value) {
			return -1;
		} else {
			return 1;
		}
	}
}