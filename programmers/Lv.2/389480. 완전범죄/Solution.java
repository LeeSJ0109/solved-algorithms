import java.util.*;

class Solution {
    
    static final int INF = Integer.MAX_VALUE;
    
    public int solution(int[][] info, int n, int m) {
        int size = info.length;
        int[][] dp = new int[size + 1][m];
        
        for (int i = 0; i <= size; i++) {
            Arrays.fill(dp[i], INF);
        }
        
        dp[0][0] = 0;
        
        for (int i = 0; i < size; i++) {
            int A = info[i][0];
            int B = info[i][1];
            
            for (int traceB = 0; traceB < m; traceB++) {
                if (dp[i][traceB] == INF) {
                    continue;
                }
                
                // A가 물건 i를 훔친 경우
                dp[i + 1][traceB] = Math.min(dp[i + 1][traceB], dp[i][traceB] + A);
                
                // B가 물건 i를 훔친 경우
                if (traceB + B < m) {
                    dp[i + 1][traceB + B] = Math.min(dp[i + 1][traceB + B], dp[i][traceB]);
                }
            }
        }
        
        int traceA = INF;
        for(int traceB = 0; traceB < m; traceB++) {
            traceA = Math.min(traceA, dp[size][traceB]);
        }
        
        return traceA < n ? traceA : -1;
    }
}