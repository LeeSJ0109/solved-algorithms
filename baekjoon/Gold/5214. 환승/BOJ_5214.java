import java.io.*;
import java.util.*;

public class BOJ_5214 {

    static int N;
    static List<Integer>[] edges;
    static boolean[] visited;
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1 + M];
        visited = new boolean[N + 1 + M];

        for (int i = 1; i <= N + M; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                int cur = Integer.parseInt(st.nextToken());
                edges[cur].add(N + M - i);
                edges[N + M - i].add(cur);
            }
        }

        System.out.println(BFS());
    }

    static int BFS() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 1});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == N) {
                return cur[1];
            }

            for (int next: edges[cur[0]]) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                queue.add(new int[]{next, next > N ? cur[1] : cur[1] + 1});
            }
        }

        return -1;
    }
}
