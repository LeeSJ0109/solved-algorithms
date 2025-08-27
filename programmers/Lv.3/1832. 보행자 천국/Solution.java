class Solution {
    
    static final int MOD = 20170805;
    
    public int solution(int N, int M, int[][] cityMap) {
        int answer = 0;
        
        int[][] dpV = new int[N][M]; // 수직 이동 (위쪽 -> 현재 칸)
        int[][] dpH = new int[N][M]; // 수평 이동 (왼쪽 -> 현재 칸)
        
        dpV[1][0] = cityMap[1][0] == 1 ? 0 : 1;
        dpH[0][1] = cityMap[0][1] == 1 ? 0 : 1;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 자동차 통행이 금지된 지역
                if (cityMap[i][j] == 1) {
                    continue;
                }
                
                // 수직 이동
                if (i > 0) {
                    // 위쪽이 회전 금지 구역이면 수직 이동만 유지
                    if (cityMap[i - 1][j] == 2) {
                        dpV[i][j] = (dpV[i][j] + dpV[i - 1][j]) % MOD;
                    }
                    else {
                        dpV[i][j] = (dpV[i][j] + dpV[i - 1][j] + dpH[i - 1][j]) % MOD;
                    }
                }
                
                // 수평 이동
                if (j > 0) {
                    if (cityMap[i][j - 1] == 2) {
                        // 왼쪽이 회전 금지 구역이면 수평 이동만 유지
                        dpH[i][j] = (dpH[i][j] + dpH[i][j - 1]) % MOD;
                    }
                    else {
                        dpH[i][j] = (dpH[i][j] + dpH[i][j - 1] + dpV[i][j - 1]) % MOD;
                    }
                }
            }
        }
        
        answer = (dpV[N - 1][M - 1] + dpH[N - 1][M - 1]) % MOD;
        
        return answer;
    }
}