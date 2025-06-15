import java.util.Arrays;

class Solution {
    
    static int[][] cost = {
        {1, 7, 6, 7, 5, 4, 5, 3, 2, 3}, // 0
        {7, 1, 2, 4, 2, 3, 5, 4, 5, 6}, // 1
        {6, 2, 1, 2, 3, 2, 3, 5, 4, 5}, // 2
        {7, 4, 2, 1, 5, 3, 2, 6, 5, 4}, // 3
        {5, 2, 3, 5, 1, 2, 4, 2, 3, 5}, // 4
        {4, 3, 2, 3, 2, 1, 2, 3, 2, 3}, // 5
        {5, 5, 3, 2, 4, 2, 1, 5, 3, 2}, // 6
        {3, 4, 5, 6, 2, 3, 5, 1, 2, 4}, // 7
        {2, 5, 4, 5, 3, 2, 3, 2, 1, 2}, // 8
        {3, 6, 5, 4, 5, 3, 2, 4, 2, 1}, // 9
    };
    
    public int solution(String numbers) {
        int N = numbers.length();
        int[][][] dp = new int[N + 1][10][10];

        for (int[][] dp2d : dp) {
            for (int[] dp1d : dp2d) {
                Arrays.fill(dp1d, Integer.MAX_VALUE);
            }
        }

        // 시작 위치 (4, 6)
        dp[0][4][6] = 0;

        for (int i = 0; i < N; i++) {
            int next = numbers.charAt(i) - '0';

            for (int l = 0; l < 10; l++) {
                for (int r = 0; r < 10; r++) {
                    if (dp[i][l][r] == Integer.MAX_VALUE) {
                        continue;
                    }

                    // 왼손 이동
                    if (next != r) {
                        dp[i + 1][next][r] = Math.min(dp[i + 1][next][r], dp[i][l][r] + cost[l][next]);
                    }

                    // 오른손 이동
                    if (next != l) {
                        dp[i + 1][l][next] = Math.min(dp[i + 1][l][next], dp[i][l][r] + cost[r][next]);
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int l = 0; l < 10; l++) {
            for (int r = 0; r < 10; r++) {
                result = Math.min(result, dp[N][l][r]);
            }
        }

        return result;
    }
}