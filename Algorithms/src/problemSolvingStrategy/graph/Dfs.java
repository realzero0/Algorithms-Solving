package problemSolvingStrategy.graph;

import java.util.*;

public class Dfs {
	static ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
	static ArrayList<Boolean> visited = new ArrayList<>();
	public static void main(String[] args) {
		int V = 10;
		for(int i=0; i<V; i++) {
			adjlist.add(new ArrayList<Integer>());
			visited.add(false);
		}
		adjlist.get(0).add(1);
		adjlist.get(1).add(2);
		adjlist.get(2).add(3);
		adjlist.get(3).add(4);
		adjlist.get(5).addAll(Arrays.asList(6, 7, 8));
		adjlist.get(6).add(0);
		adjlist.get(7).add(1);
		adjlist.get(8).add(3);
		adjlist.get(9).add(2);
		for(int i=0; i< adjlist.size(); i++) {
			if(!visited.get(i)) {
				dfs(i);
			}
		}
		
	}
	public static void dfs(int here) {
//		System.out.println("DFS visits " + here);
		visited.set(here, true);
		for(int i=0; i<adjlist.get(here).size(); i++) {
			int there = adjlist.get(here).get(i);
			if(!visited.get(there)) {
				dfs(there);
			}
		}
		System.out.println(here+1);
		
	}
}
