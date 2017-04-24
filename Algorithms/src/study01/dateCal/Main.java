package study01.dateCal;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		int[] esm = new int[3];
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<esm.length; i++) {
			esm[i] = sc.nextInt();
		}
		int i=1;
		while(true) {
			
			if(esm[0] == 15) {
				esm[0] = 0;
			}
			if(esm[1] == 28) {
				esm[1] = 0;
			}
			if(esm[2] == 19) {
				esm[2] = 0;
			}
			if((i % 15) == esm[0] && (i % 28) == esm[1] && (i % 19) == esm[2]) {
				System.out.println(i);
				return;
			}
			i++;
		}
	}

}
