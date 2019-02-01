package beakjun.n1890Jump;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int gameBoardSize = Integer.parseInt(br.readLine());

        int[][] gameBoard = new int[gameBoardSize][gameBoardSize];
        int[][] pathValues = new int[gameBoardSize][gameBoardSize];

        for (int i = 0; i < gameBoardSize; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < gameBoardSize; j++) {
                gameBoard[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        LinkedList<int[]> queue = new LinkedList<>();

        pathValues[gameBoard[0][0]][0] = 1;
        pathValues[0][gameBoard[0][0]] = 1;
        queue.add(new int[]{gameBoard[0][0], 0});
        queue.add(new int[]{0, gameBoard[0][0]});

        while (!queue.isEmpty()) {
            int[] position = queue.remove();
            int currentPathValue = pathValues[position[0]][position[1]];
            int goingAvailableValue = gameBoard[position[0]][position[1]];
            if (goingAvailableValue == 0) {
                continue;
            }
            if (position[0] + goingAvailableValue < gameBoardSize) {
                pathValues[position[0] + goingAvailableValue][position[1]] += currentPathValue;
                queue.add(new int[]{position[0] + goingAvailableValue, position[1]});
            }
            if (position[1] + goingAvailableValue < gameBoardSize) {
                pathValues[position[0]][position[1] + goingAvailableValue] += currentPathValue;
                queue.add(new int[]{position[0], position[1] + goingAvailableValue});
            }
        }

        System.out.println(pathValues[gameBoardSize - 1][gameBoardSize - 1]);
    }
}
