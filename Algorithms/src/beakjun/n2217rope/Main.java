package beakjun.n2217rope;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] ropes = new int[N];
		for(int i = 0; i<N; i++) {
			ropes[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(ropes);
		int max = -1;
		int k;
		for(int i = 0; i<N; i++) {
			k = ropes[i] * (N - i);
			if(k > max) {
				max = k;
			}
		}
		System.out.println(max);
	}

}
