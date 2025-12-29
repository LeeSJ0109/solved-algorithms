import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1719 {

    static final int INF = 2_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] time = new int[N + 1][N + 1];
        int[][] next = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(time[i], INF);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            time[a][b] = c;
            time[b][a] = c;

            next[a][b] = b;
            next[b][a] = a;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (time[i][j] > time[i][k] + time[k][j]) {
                        time[i][j] = time[i][k] + time[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        print(next);
    }

    static void print(int[][] next) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < next.length; i++) {
            for (int j = 1; j < next[i].length; j++) {
                if (i == j) {
                    sb.append("- ");
                }
                else {
                    sb.append(next[i][j]).append(" ");
                }
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
