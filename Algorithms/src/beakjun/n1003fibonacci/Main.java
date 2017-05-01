package beakjun.n1003fibonacci;

import java.io.*;
import java.util.*;

public class Main {
	static int[][] zeroAndOnes;
	static int zero, one;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = Integer.parseInt(st.nextToken());
		zeroAndOnes = new int[count][2];
		for(int i=0; i<count; i++) {
			st = new StringTokenizer(br.readLine());
			zero=0;
			one=0;
			fibonacci(Integer.parseInt(st.nextToken()));
			zeroAndOnes[i][0] = zero;
			zeroAndOnes[i][1] = one;
		}
		for(int[] a : zeroAndOnes) {
			System.out.println(a[0] + " " + a[1]);
		}
				
	}
	
	public static int fibonacci(int n) {
	    if (n==0) {
	        zero++;
	        return 0;
	    } else if (n==1) {
	        one++;
	        return 1;
	    } else {
	        return fibonacci(n-1) + fibonacci(n-2);
	    }
	}
}
