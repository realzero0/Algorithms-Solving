package beakjun.n2178miro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static List<int[]> directions = new ArrayList<>();
    private static int[][] miro;
    private static int N;
    private static int M;
    private static LinkedList<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        directions.add(new int[]{0, -1}); // left
        directions.add(new int[]{0, 1}); // right
        directions.add(new int[]{-1, 0}); // up
        directions.add(new int[]{1, 0}); // down

        miro = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == '1') {
                    miro[i][j] = 1;
                }
            }
        }
        queue.add(new int[]{0, 0});
        goDirection();

        System.out.println(miro[N - 1][M - 1]);
    }

    private static void goDirection() {
        while (!queue.isEmpty()) {
            int[] position = queue.remove();
            int x = position[0];
            int y = position[1];
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (newX >= 0 && newY >= 0
                        && newX < N && newY < M) {
                    if (miro[newX][newY] == 1) {
                        miro[newX][newY] = miro[x][y] + 1;
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
        }
    }
}

