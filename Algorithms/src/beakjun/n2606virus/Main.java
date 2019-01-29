package beakjun.n2606virus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int computerCount = Integer.parseInt(br.readLine());
        int linkedComputerCount = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> computerMap = new HashMap<>();
        boolean[] visited = new boolean[computerCount + 1];

        for (int i = 0; i < linkedComputerCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            computerMap.putIfAbsent(from, new ArrayList<>());
            computerMap.putIfAbsent(to, new ArrayList<>());
            computerMap.get(from).add(to);
            computerMap.get(to).add(from);
        }

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        int i = 0;
        while (!queue.isEmpty()) {
            int start = queue.remove();
            List<Integer> endList = computerMap.get(start);
            for (Integer end : endList) {
                if (visited[end]) {
                    continue;
                }
                visited[end] = true;
                i++;
                queue.add(end);
            }
        }
        System.out.println(i);
    }
}
