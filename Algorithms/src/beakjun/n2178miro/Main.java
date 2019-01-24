package beakjun.n2178miro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static Map<String, int[]> directions = new HashMap<>();
    private static int[][] miro;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        directions.put("LEFT", new int[] { 0, -1 });
        directions.put("RIGHT", new int[] { 0, 1 });
        directions.put("UP", new int[] { -1, 0 });
        directions.put("DOWN", new int[] { 1, 0 });

        miro = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                miro[i][j] = line.charAt(j) - 48;
            }
        }

        int x = 0;
        int y = 0;
        goDirection(x, y);

        System.out.println(miro[N - 1][M - 1]);
    }

    public static void goDirection(int x, int y) {
        for (int[] direction : directions.values()) {
            if (x + direction[0] >= 0 && y + direction[1] >= 0
                    && x + direction[0] < N && y + direction[1] < M) {
                if (miro[x + direction[0]][y + direction[1]] == 1) {
                    miro[x + direction[0]][y + direction[1]] = miro[x][y] + 1;
                    goDirection(x + direction[0], y + direction[1]);
                } else if (miro[x][y] + 1 <= miro[x + direction[0]][y + direction[1]]) {
                    miro[x + direction[0]][y + direction[1]] = miro[x][y] + 1;
                    goDirection(x + direction[0], y + direction[1]);
                }
            }
        }
    }
}

