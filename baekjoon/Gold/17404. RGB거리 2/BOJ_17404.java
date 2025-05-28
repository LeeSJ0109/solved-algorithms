import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17404 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] R_cost = new int[N];
        int[] G_cost = new int[N];
        int[] B_cost = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R_cost[i] = Integer.parseInt(st.nextToken());
            G_cost[i] = Integer.parseInt(st.nextToken());
            B_cost[i] = Integer.parseInt(st.nextToken());
        }

        int minCost = Integer.MAX_VALUE;

        for (int firstColor = 0; firstColor < 3; firstColor++) {
            int[][] dp = new int[N][3];

            dp[0][0] = (firstColor == 0) ? R_cost[0] : 1000;
            dp[0][1] = (firstColor == 1) ? G_cost[0] : 1000;
            dp[0][2] = (firstColor == 2) ? B_cost[0] : 1000;

            for (int i = 1; i < N; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + R_cost[i];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + G_cost[i];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + B_cost[i];
            }

            for (int lastColor = 0; lastColor < 3; lastColor++) {
                if (firstColor == lastColor) {
                    continue;
                }
                minCost = Math.min(minCost, dp[N - 1][lastColor]);
            }
        }

        System.out.println(minCost);
    }
}
