package beakjun.n2667buildingNumbering;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int mapSize = Integer.parseInt(br.readLine());

        int[][] map = new int[mapSize][mapSize];

        for (int i = 0; i < mapSize; i++) {
            String mapLine = br.readLine();
            for (int j = 0; j < mapSize; j++) {
                map[i][j] = mapLine.charAt(j) - 48;
            }
        }

        List<int[]> direction = new ArrayList<>();
        direction.add(new int[] { 0, 1 });
        direction.add(new int[] { 1, 0 });

        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0 });

        while (!queue.isEmpty()) {
            int[] position = queue.remove();

        }

    }
}
