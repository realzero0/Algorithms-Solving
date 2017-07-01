package study01.programmers.skcnc.no4;

import java.util.*;

public class Main {

}

class Solution {
	public int[] solution(int[] truck, int[] w) {
		int[] truckNum = new int[w.length];
		int[] sortedTruck = Arrays.copyOf(truck, truck.length);
		int maxTruckNum = truck.length-1;
		Arrays.sort(sortedTruck);
		int before = Integer.MAX_VALUE;
        int beforeJ = 0;
		int j = 0;
        int max = Integer.MAX_VALUE;
		for (int i = 0; i < w.length; i++) {
			if(w[i] < before) {
				j = 0;
			} else {
                j = beforeJ;
            }
			if(w[i] > sortedTruck[maxTruckNum]) {
            	j = truck.length;
            }
            if(w[i] > max) {
                j = truck.length;
            }
			for (; j < truck.length; j++) {
				if (truck[j] >= w[i]) {
					if(truck[j] == sortedTruck[maxTruckNum]) {
						truck[j] -= w[i];
						if(truck[j] < sortedTruck[maxTruckNum - 1]) {
							maxTruckNum--;
						}
					} else {
						truck[j] -= w[i];
					}
					before = w[i];
                    beforeJ = j;
					truckNum[i] = j + 1;
					break;
				}
			}
			if (j == truck.length) {
				truckNum[i] = -1;
                if(max > w[i]) {
                    max = w[i];
                }
			}
		}
		return truckNum;
	}
}