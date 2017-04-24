package beakjun.exam170405.decreasingNum;

import java.util.*;

public class Main {
	static ArrayList<Integer> store = new ArrayList<>();
	static ArrayList<Long> sort = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int count = 0;

		for (int i = 1; i < 10; i++) {
			store.clear();
			decreasingNum(i);
		}
		long[] sorted = new long[sort.size()];
		for(int i=0; i<sort.size(); i++) {
			sorted[i] = sort.get(i);
		}
		Arrays.sort(sorted);
		if(input <= sorted.length && input >=1) {
		System.out.println(sorted[input-1]);
		} else if(input == 0){
			System.out.println(0);
		} else {
			System.out.println(-1);
		}
	}

	public static void decreasingNum(int beforeNum) {
		if (beforeNum < 0) {
			return;
		}
		store.add(beforeNum);
		sort.add(tolong());
		for(int i=beforeNum-1; i>=0; i--) {
			decreasingNum(i);
		}
		// 배열에 있는 값을 제거해줘야 다른 값이 추가될 수 있음
		store.remove(store.size()-1);
	}
	
	public static long tolong() {
		long result = 0;
		for(int i=0; i<store.size(); i++) {
			result += (long)store.get(store.size()-i-1)*Math.pow(10, i);
		}
		return result;
	}
}
