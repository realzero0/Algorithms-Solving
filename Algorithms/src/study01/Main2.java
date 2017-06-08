package study01;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution1 s = new Solution1();
		System.out.println(s.solution(1213));
	}

}

class Solution1 {
	public int solution(int N) {
		// write your code in Java SE 8
		String a = String.valueOf(N);
		int[] arr = new int[a.length()];
		int[] nums = new int[10];
		int result = 1;
		int subResult = 1;
		if(N == 0) {
			return 1;
		}
		for (int i = 0; i < a.length(); i++) {
			arr[i] = a.charAt(i) - '0';
		}
		
		for (int i = 0; i < arr.length; i++) {
			nums[arr[i]]++;
		}
		for (int i = arr.length; i >= 1; i--) {
			result *= i;
		}
		for (int i = 0; i < nums.length; i++) {
			for (int j = nums[i]; j >= 1; j--) {
				result /= j;
			}
		}
		if (nums[0] > 0) {
			nums[0] -= 1;
			for (int i = arr.length - 1; i >= 1; i--) {
				subResult *= i;
			}
			for (int i = 0; i < nums.length; i++) {
				for (int j = nums[i]; j >= 1; j--) {
					subResult /= j;
				}
			}
			return result - subResult;
		}

		return result;
	}
}