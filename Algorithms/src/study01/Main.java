package study01;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] road = { { 1, 2, 1 }, { 2, 1, 1 }, { 5, 2, 2 }, { 1, 4, 2 }, { 5, 3, 1 }, { 5, 4, 2 } };
		System.out.println(s.solution(5, road, 3));
	}

}

class Solution {
	private static final int N = 1;
	int[] goArr = new int[N + 1];

	public int solution(int N, int[][] road, int K) {
		int answer = 0;

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(1, 0));
		while (!q.isEmpty()) {
			Node node = q.remove();
			int next = node.num;
			for (int i = 0; i < N; i++) {
				if (road[i][0] == next && node.value + road[i][2] <= K) {
					goArr[road[i][1]] = node.value + road[i][2];
					node.value += road[i][2];
					q.add(new Node(road[i][1], node.value + road[i][2]));
				}
				if (road[i][1] == next && node.value + road[i][2] <= K) {
					goArr[road[i][0]] = node.value + road[i][2];
					node.value += road[i][2];
					q.add(new Node(road[i][0], node.value + road[i][2]));
				}
			}
		}
		for (int i = 0; i < N + 1; i++) {
			if (goArr[i] != 0) {
				answer++;
			}
		}
		return answer;
	}
	public void dfs(Node node, int N, int[][] road, int K) {
		if (node.value > K) {
			return;
		}
		for (int i = 0; i < N; i++) {
			if (road[i][0] == node.num) {
				goArr[road[i][1]] = node.value+road[i][2];
				dfs(new Node(road[i][1], node.value+road[i][2]), N, road, K);
			}
			if (road[i][1] == node.num) {
				goArr[road[i][1]] = node.value + road[i][2];
				dfs(new Node(road[i][1], node.value+road[i][2]), N, road, K);
			}
		}
	}

}

	

class Node {
	int num;
	int value;

	public Node(int num, int value) {
		this.num = num;
		this.value = value;
	}
}