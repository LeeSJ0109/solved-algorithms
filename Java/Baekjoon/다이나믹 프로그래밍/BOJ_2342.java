import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2342 {

    static int[][] cost = {
        {0, 2, 2, 2, 2},
        {2, 1, 3, 4, 3},
        {2, 3, 1, 3, 4},
        {2, 4, 3, 1, 3},
        {2, 3, 4, 3, 1}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> moves = new ArrayList<>();
        while (st.hasMoreTokens()) {
            int x = Integer.parseInt(st.nextToken());
            if (x == 0) {
                break;
            }
            moves.add(x);
        }

        int N = moves.size();
        int[][][] dp = new int[N + 1][5][5];

        for (int[][] dp2d : dp) {
            for (int[] dp1d : dp2d) {
                Arrays.fill(dp1d, Integer.MAX_VALUE);
            }
        }

        // 시작 위치 (0, 0)
        dp[0][0][0] = 0;

        for (int i = 0; i < N; i++) {
            int next = moves.get(i);

            for (int l = 0; l < 5; l++) {
                for (int r = 0; r < 5; r++) {
                    if (dp[i][l][r] == Integer.MAX_VALUE) {
                        continue;
                    }

                    // 왼발로 이동
                    dp[i + 1][next][r] = Math.min(dp[i + 1][next][r], dp[i][l][r] + cost[l][next]);

                    // 오른발로 이동
                    dp[i + 1][l][next] = Math.min(dp[i + 1][l][next], dp[i][l][r] + cost[r][next]);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int l = 0; l < 5; l++) {
            for (int r = 0; r < 5; r++) {
                result = Math.min(result, dp[N][r][l]);
            }
        }

        System.out.println(result);
    }
}
