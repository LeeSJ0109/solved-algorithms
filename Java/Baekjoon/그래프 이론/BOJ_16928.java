import java.io.*;
import java.util.*;

public class BOJ_16928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] board = new int[101];

        for (int i = 1; i <= 100; i++) {
            board[i] = i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            board[start] = end;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            board[start] = end;
        }

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[101];

        queue.add(1);
        visited[1] = true;

        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int cur = queue.poll();

                if (cur == 100) {
                    System.out.println(cnt);
                    return;
                }

                for (int d = 1; d <= 6; d++) {
                    int next = cur + d;

                    if (next <= 100 && !visited[next]) {
                        visited[next] = true;
                        queue.add(board[next]);
                    }
                }
            }

            cnt++;
        }
    }
}
