import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_12852 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][2];

        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
            dp[i][1] = i - 1;

            if (i % 2 == 0 && dp[i][0] > dp[i / 2][0] + 1) {
                dp[i][0] = dp[i / 2][0] + 1;
                dp[i][1] = i / 2;
            }
            if (i % 3 == 0 && dp[i][0] > dp[i / 3][0] + 1) {
                dp[i][0] = dp[i / 3][0] + 1;
                dp[i][1] = i / 3;
            }
        }

        sb.append(dp[N][0]).append("\n");

        for (int i = N; i != 0; i = dp[i][1]) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}
