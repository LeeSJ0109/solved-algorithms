class Solution {
    public int solution(int n, int[] money) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        for (int coin : money) {
            for (int current = coin; current <= n; current++) {
                dp[current] += dp[current - coin];
                dp[current] %= 1_000_000_007;
            }
        }
        
        return dp[n];
    }
}