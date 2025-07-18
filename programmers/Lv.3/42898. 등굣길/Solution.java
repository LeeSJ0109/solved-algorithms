class Solution {
    
        static final int MOD = 1_000_000_007;

        public int solution(int m, int n, int[][] puddles) {
            int[][] dp = new int[n][m];

            for (int[] puddle : puddles) {
                dp[puddle[1] - 1][puddle[0] - 1] = -1;
            }

            if (dp[0][0] == -1) {
                return 0;
            }
            dp[0][0] = 1;

            for (int i = 1; i < n; i++) {
                if (dp[i][0] == -1) {
                    dp[i][0] = 0;
                }
                else {
                    dp[i][0] = dp[i - 1][0];
                }
            }


            for (int i = 1; i < m; i++) {
                if (dp[0][i] == -1) {
                    dp[0][i] = 0;
                }
                else {
                    dp[0][i] = dp[0][i - 1];
                }
            }

            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if (dp[i][j] == -1) {
                        dp[i][j] = 0;
                    }
                    else {
                        dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
                    }
                }
            }

            return dp[n - 1][m - 1];
        }
    }