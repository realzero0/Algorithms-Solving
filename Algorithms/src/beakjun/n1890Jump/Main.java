package beakjun.n1890Jump;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int gameBoardSize;
    private static int[][] gameBoard;
    private static long[][] countBoard;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        gameBoardSize = Integer.parseInt(br.readLine());

        gameBoard = new int[gameBoardSize][gameBoardSize];
        countBoard = new long[gameBoardSize][gameBoardSize];

        for (int i = 0; i < gameBoardSize; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < gameBoardSize; j++) {
                gameBoard[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        countBoard[gameBoardSize-1][gameBoardSize-1] = 1;

        dfs(0, 0);

        System.out.println(countBoard[0][0]);
    }

    private static void dfs(int x, int y) {
        int goingAvailableValue = gameBoard[x][y];
        if (goingAvailableValue == 0) {
            return;
        }
        if (x + goingAvailableValue < gameBoardSize) {
            if(countBoard[x + goingAvailableValue][y] == 0) {
                dfs(x + goingAvailableValue, y);
            }
            countBoard[x][y] += countBoard[x + goingAvailableValue][y];
        }
        if (y + goingAvailableValue < gameBoardSize) {
            if (countBoard[x][y + goingAvailableValue] == 0) {
                dfs(x, y + goingAvailableValue);
            }
            countBoard[x][y] += countBoard[x][y + goingAvailableValue];
        }
    }
}
