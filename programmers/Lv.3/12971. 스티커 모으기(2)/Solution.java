class Solution {
    public int solution(int sticker[]) {
        int N = sticker.length;
        
        if (N == 1) {
            return sticker[0];
        }
        
        int[] dp1 = new int[N];
        int[] dp2 = new int[N];
        
        // 첫번째 스티커 사용
        dp1[0] = sticker[0];
        dp1[1] = Math.max(sticker[0], sticker[1]);
        
        for (int i = 2; i < N - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
        }
        
        // 첫번째 스티커 미사용
        dp2[0] = 0;
        dp2[1] = sticker[1];
        
        for (int i = 2; i < N; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }
        
        return Math.max(dp1[N - 2], dp2[N - 1]);
    }
}