package beakjun.n2965kangaroos;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] kangaroos = new int[3];
		for(int i=0; i<3; i++) {
			kangaroos[i] = Integer.parseInt(st.nextToken());
		}
		int a = Math.abs(kangaroos[0] - kangaroos[1]);
		int b = Math.abs(kangaroos[1] - kangaroos[2]);
		System.out.println(Math.max(a, b)-1);
	}

}
