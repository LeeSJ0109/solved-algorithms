class Solution {
    
    static int[] darts, count;
    
    public int[] solution(int target) {
        darts = new int[target + 1];
        count = new int[target + 1];
        
        for (int i = 1; i <= target; i++) {
            darts[i] = i;
            
            for (int score = 1; score <= 20; score++) {
                // 트리플
                update(i, i - 3 * score, false);
                // 더블
                update(i, i - 2 * score, false);
                // 싱글
                update(i, i - score, true);
            }
            
            // 불
            update(i, i - 50, true);
        }
        
        return new int[]{darts[target], count[target]};
    }
    
    static void update(int cur, int prev, boolean isSingleOrBull) {
        if (prev < 0) {
            return;
        }
        
        int nDarts = darts[prev] + 1;
        int nCount = count[prev] + (isSingleOrBull ? 1 : 0);
        
        // 더 적은 다트 개수면 갱신
        if (nDarts < darts[cur]) {
            darts[cur] = nDarts;
            count[cur] = nCount;
        }
        // 같은 다트 개수면 싱글 또는 불 많은것 선택
        else if (nDarts == darts[cur]) {
            count[cur] = Math.max(count[cur], nCount);
        }
    }
}