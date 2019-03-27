package beakjun.n1890Jump;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int gameBoardSize = Integer.parseInt(br.readLine());

        int[][] gameBoard = new int[gameBoardSize][gameBoardSize];
        long[][] countBoard = new long[gameBoardSize][gameBoardSize];

        for (int i = 0; i < gameBoardSize; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < gameBoardSize; j++) {
                gameBoard[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        countBoard[0][0] = 1;

        for (int i = 0; i < gameBoardSize; i++) {
            for (int j = 0; j < gameBoardSize; j++) {
                int goingAvailableValue = gameBoard[i][j];
                if (goingAvailableValue == 0) {
                    continue;
                }
                if (i + goingAvailableValue < gameBoardSize) {
                    countBoard[i + goingAvailableValue][j] += countBoard[i][j];
                }
                if (j + goingAvailableValue < gameBoardSize) {
                    countBoard[i][j + goingAvailableValue] += countBoard[i][j];
                }
            }

        }
        System.out.println(countBoard[gameBoardSize - 1][gameBoardSize - 1]);
    }
}
