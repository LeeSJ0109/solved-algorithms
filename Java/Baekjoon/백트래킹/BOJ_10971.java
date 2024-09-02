import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10971 {

    static int N;
    static int[][] W;
    static boolean[] visited;
    static int start;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        W = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            start = i;
            visited[i] = true;
            DFS(1, i, 0);
            visited[i] = false;
        }

        System.out.println(min);
    }

    static void DFS(int cnt, int prev, int cur) {
        if (cur >= min) {
            return;
        }

        if (cnt == N) {
            if (W[prev][start] != 0) {
                min = Math.min(min, cur + W[prev][start]);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && W[prev][i] != 0) {
                visited[i] = true;
                DFS(cnt + 1, i, cur + W[prev][i]);
                visited[i] = false;
            }
        }
    }
}
