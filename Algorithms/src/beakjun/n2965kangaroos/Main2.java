package beakjun.n2965kangaroos;

import java.io.*;
import java.util.*;

public class Main2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] kangaroos = new int[3];
		for (int i = 0; i < 3; i++) {
			kangaroos[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(Math.max(kangaroos[1] - kangaroos[0], kangaroos[2] - kangaroos[1]) - 1);
	}

}
