import java.io.*;
import java.util.*;

public class BOJ_2623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int current = Integer.parseInt(st.nextToken());

            for (int j = 1; j < k; j++) {
                int next = Integer.parseInt(st.nextToken());
                graph.get(current).add(next);
                indegree[next]++;
                current = next;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            sb.append(current).append("\n");

            for (int next : graph.get(current)) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }

            count++;
        }

        if (count == N) {
            System.out.println(sb);
        }
        else {
            System.out.println(0);
        }
    }
}
