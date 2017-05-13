package puzzle24;

import java.util.*;

public class Main {

	public static void main(String[] args) {

	}

}

class State {
	private ArrayList<State> adjacent;
	private int[][] puzzle = new int[5][5];
	private boolean isLeft, isRight, isUp, isDown;

	State(int[][] puzzle) {
		this.puzzle = puzzle;
		isLeft = true;
		isRight = true;
		isUp = true;
		isDown = true;
	}

	public ArrayList<State> getAdjacent() {
		ArrayList<State> arrList = new ArrayList<>();
		for (int i = 0; i < puzzle.length; i++) {
			for (int j = 0; j < puzzle[0].length; j++) {
				if (puzzle[i][j] == -1) {
					if (i == 0) {
						isLeft = false;
					}
					if (i == puzzle.length) {
						isRight = false;
					}
					if (j == 0) {
						isUp = false;
					}
					if (j == puzzle.length) {
						isDown = false;
					}
					if (isLeft == true) {
						State state = new State(swap(puzzle, i, j, 'l'));
						arrList.add(state);
					}
					if (isRight == true) {
						State state = new State(swap(puzzle, i, j, 'r'));
						arrList.add(state);
					}
					if (isDown == true) {
						State state = new State(swap(puzzle, i, j, 'd'));
						arrList.add(state);
					}
					if (isUp == true) {
						State state = new State(swap(puzzle, i, j, 'u'));
						arrList.add(state);
					}
				}
			}
		}
	}

	public int[][] swap(int[][] puzzle, char direction) {
		switch (direction) {
		case 'l':
			puzzle
			break;
		case 'r':

			break;
		case 'u':

			break;
		case 'd':

			break;
		default:
			break;
		}
	}

}