package study01.programmers.skcnc.no2;

public class Main {

}
class Solution {
    public int solution(int[][] board, int[] nums) {
    	int bingoCount = 0;
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
    	
    	for(int row = 0; row < board.length; row++) {
    		int col = 0;
    		while(board[row][col] == -1) {
    			col++;
    			if(col == board.length) {
    				bingoCount++;
    			}
    		}
    	}
    	for(int col = 0; col < board.length; col++) {
    		int row = 0;
    		while(board[row][col] == -1) {
    			row++;
    			if(row == board.length) {
    				bingoCount++;
    			}
    		}
    	}
    	for(int col = 0, row = 0; col < board.length; col++, row++) {
    		if(board[row][col] != -1) {
    			break;
    		}
    		if(col == board.length - 1) {
    			bingoCount++;
    		}
    	}
    	for(int col = 0, row = board.length - 1; col < board.length; col++, row--) {
    		if(board[row][col] != -1) {
    			break;
    		}
    		if(col == board.length - 1) {
    			bingoCount++;
    		}
    	}
        return bingoCount;
    }
}