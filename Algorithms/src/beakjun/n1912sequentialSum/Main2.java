package beakjun.n1912sequentialSum;

import java.io.*;
import java.util.*;

public class Main2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] array = new int[n + 2];
		int sum = -1001, max = -1001;
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			sum = Math.max(sum + array[i], array[i]);
			max = Math.max(sum, max);
		}
		System.out.println(max);
	}
}