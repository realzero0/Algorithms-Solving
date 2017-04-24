package beakjun.exam170411;

import java.util.*;

public class TriangleNum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] num = new int[sc.nextInt()];
		for (int i = 0; i < num.length; i++) {
			num[i] = sc.nextInt();
		}
		
		for(int i=0; i< num.length; i++) {
			boolean isSum = false;
			for(int j=1; true; j++) {
				if(num[i] < (j*(j+1)/2)){
//					System.out.println(0);
					break;
				}
				for(int k=j; true; k++) {
					if(num[i] < (j*(j+1)/2) + (k*(k+1)/2)){
//						System.out.println(0);
						break;
					}
					for(int m=k; true; m++) {
						if(num[i] < (j*(j+1)/2) + (k*(k+1)/2) + (m*(m+1)/2)){
//							System.out.println(0);
							break;
						} else if(num[i] == (j*(j+1)/2) + (k*(k+1)/2) + (m*(m+1)/2)) {
							System.out.println(1);
							isSum = true;
							break;
						}
					}
					if(isSum == true) {
						break;
					}
				}
				if(isSum == true) {
					break;
				}
			}
			if(isSum == false) {
				System.out.println(0);
			}
		}
	}
}
