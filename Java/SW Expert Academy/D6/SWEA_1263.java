import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1263 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            int[][] adj = new int[N][N];
            int INF = 1000000;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    if (i != j && value == 0) {
                        adj[i][j] = INF;
                    } else {
                        adj[i][j] = value;
                    }
                }
            }

            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (adj[i][j] > adj[i][k] + adj[k][j]) {
                            adj[i][j] = adj[i][k] + adj[k][j];
                        }
                    }
                }
            }

            int minSum = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int j = 0; j < N; j++) {
                    sum += adj[i][j];
                }
                minSum = Math.min(minSum, sum);
            }

            System.out.println("#" + t + " " + minSum);
        }
    }
}
