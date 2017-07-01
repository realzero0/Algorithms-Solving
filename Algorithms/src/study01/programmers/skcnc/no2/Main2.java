package study01.programmers.skcnc.no2;

public class Main2 {

}
public class Solution2 {
	public int solution(int[][] board, int[] nums) {
    	int bingoCount = 2 * board.length + 2;
    	for(int i = 0; i<nums.length; i++) {
    		for(int x = 0; x < board.length; x++) {
    			boolean isFound = false;
    			for(int y = 0; y < board.length; y++) {
    				if(nums[i] == board[x][y]) {
    					board[x][y] = -1;
    					isFound = true;
    					break;
    				}
    			}
    			if(isFound == true) {
    				break;
    			}
    		}
    	}
    	
  
    	for(int col = 0, row = 0; col < board.length; col++, row++) {
    		if(board[row][col] != -1) {
    			bingoCount -= 2;
    		} else {
    			int k = 0;
    			while(k < board.length && board[row][k] == -1) {
    				k++;
    			}
    			if(k != board.length) {
    				bingoCount--;
    			}
    			k = 0;
    			while(k < board.length && board[k][col] == -1) {
    				k++;
    			}
    			if(k != board.length) {
    				bingoCount--;
    			}
    		}
    	}
    	for(int col = 0, row = 0; col < board.length; col++, row++) {
    		if(board[row][col] != -1) {
    			bingoCount--;
    			break;
    		}
    	}
    	for(int col = 0, row = board.length - 1; col < board.length; col++, row--) {
    		if(board[row][col] != -1) {
    			bingoCount--;
    			break;
    		}
    	}
        return bingoCount;
	}
}