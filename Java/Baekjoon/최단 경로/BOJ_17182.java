import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17182 {

    static int N, K;
    static int[][] time;
    static boolean[] visited;

    static int minTime = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        time = new int[N][N];
        visited = new boolean[N];

        visited[K] = true;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                time[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 플로이드-워셜: 모든 행성 간 최단 시간 계산
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (time[i][j] > time[i][k] + time[k][j]) {
                        time[i][j] = time[i][k] + time[k][j];
                    }
                }
            }
        }

        DFS(K, 1, 0);
        System.out.println(minTime);
    }

    static void DFS(int current, int count, int totalTime) {
        if (totalTime >= minTime) {
            return;
        }

        if (count == N) {
            minTime = Math.min(minTime, totalTime);
            return;
        }

        for (int next = 0; next < N; next++) {
            if (!visited[next]) {
                visited[next] = true;
                DFS(next, count + 1, totalTime + time[current][next]);
                visited[next] = false;
            }
        }
    }
}
