package beakjun.n10216CountCircleGroups;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] groupMap = new int[3000][3];
    private static int[][] connectionMap = new int[3000][3000];
    private static int[] visited = new int[3000];
    private static int enemyGroupCount;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCaseCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCaseCount; i++) {
            enemyGroupCount = Integer.parseInt(br.readLine());

            // initialize
            for (int j = 0; j < enemyGroupCount; j++) {
                visited[j] = 0;
                groupMap[j][0] = 0;
                groupMap[j][1] = 0;
                groupMap[j][2] = 0;
                for (int k = 0; k < enemyGroupCount; k++) {
                    connectionMap[j][k] = 0;
                }
            }

            for (int j = 0; j < enemyGroupCount; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                groupMap[j][0] = Integer.parseInt(st.nextToken());
                groupMap[j][1] = Integer.parseInt(st.nextToken());
                groupMap[j][2] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < enemyGroupCount; j++) {
                for (int k = j + 1; k < enemyGroupCount; k++) {
                    int width = groupMap[j][0] - groupMap[k][0];
                    int height = groupMap[j][1] - groupMap[k][1];
                    int radius = groupMap[j][2] + groupMap[k][2];
                    if (radius * radius >= width * width + height * height) {
                        connectionMap[j][k] = 1;
                        connectionMap[k][j] = 1;
                    }
                }
            }
            int count = 0;
            for (int j = 0; j < enemyGroupCount; j++) {
                if (visited[j] == 0) {
                    count++;
                    visited[j] = 1;
                    for (int k = 0; k < enemyGroupCount; k++) {
                        dfs(j, k);
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(int j, int k) {
        if (connectionMap[j][k] != 1 || visited[k] == 1) {
            return;
        }
        visited[k] = 1;
        for (int i = 0; i < enemyGroupCount; i++) {
            dfs(k, i);
        }
    }
}
