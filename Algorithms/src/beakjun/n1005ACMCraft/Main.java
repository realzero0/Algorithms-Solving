package beakjun.n1005ACMCraft;

import java.io.*;
import java.util.*;

public class Main {
	public static Node[] nodes = new Node[1001];
	public static int[] indegree = new int[1001];
	public static int[] cost = new int[1001];
	public static Queue<Node> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		int X, Y, W = 0;
		int[] N = new int[T];
		int[] K = new int[T];
		LinkedList<Integer> results = new LinkedList<>();
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			N[i] = Integer.parseInt(st.nextToken());
			K[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N[i]; j++) {
				nodes[j] = new Node();
				nodes[j].v = Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < K[i]; j++) {
				st = new StringTokenizer(br.readLine());
				X = Integer.parseInt(st.nextToken());
				Y = Integer.parseInt(st.nextToken());
				indegree[Y]++;
				nodes[X].num = X;
				nodes[X].next.add(Y);
			}
			W = Integer.parseInt(br.readLine());
			for (int j = 1; j <= N[i]; j++) {
				if (indegree[j] == 0) {
					q.add(nodes[j]);
					cost[j] = nodes[j].v;
				}

			}
			bfs();
			results.add(cost[W]);
			Arrays.fill(cost, 0);
			Arrays.fill(indegree, 0);
		}
		for (int result : results) {
			System.out.println(result);
		}
	}

	public static void bfs() {
		while (!q.isEmpty()) {
			Node node = q.remove();
			for (int i = 0; i < node.next.size(); i++) {
				indegree[node.next.get(i)]--;
				if (cost[node.next.get(i)] < cost[node.num] + nodes[node.next.get(i)].v) {
					cost[node.next.get(i)] = cost[node.num] + nodes[node.next.get(i)].v;
				}
				if (indegree[node.next.get(i)] == 0) {
					q.add(nodes[node.next.get(i)]);
				}
			}
		}
	}
}

class Node {
	int v;
	int num;
	LinkedList<Integer> next = new LinkedList<>();
}
