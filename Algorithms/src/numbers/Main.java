package numbers;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		boolean isPrime;
		boolean isFirst = true;
		int firstPrime = 0;
		int sum = 0;
		for(int i = m; i<=n; i++){
			isPrime = true;
			for(int j = 2; j<=(int)Math.sqrt((double)i); j++) {
				if(i%j == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime == true && i>1) {
				if(isFirst == true) {
					firstPrime = i;
					isFirst = false;
				}
				sum = sum+i;	
			}
		}
		if(isFirst == true) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(firstPrime);
		}
	}
}
