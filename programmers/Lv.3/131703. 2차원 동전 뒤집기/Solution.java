class Solution {
    
    static int N, M;
    static int answer = Integer.MAX_VALUE;
    
    static int[][] beginning, target;
    
    public int solution(int[][] b, int[][] t) {
        beginning = b;
        target = t;
        
        N = beginning.length;
        M = beginning[0].length;
        
        DFS(0, 0);
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    static void DFS(int depth, int rCount) {
        if (depth == N) {
            int cCount = 0;
            for (int col = 0; col < M; col++) {
                int flipCol = compCol(col);
                if (flipCol == -1) {
                    return;
                }
                
                cCount += flipCol;
            }
            
            answer = Math.min(answer, rCount + cCount);
                
            return;
        }
        
        // depth 행 안 뒤집기
        DFS(depth + 1, rCount);
            
        // depth 행 뒤집기
        flipRow(depth);
        DFS(depth + 1, rCount + 1);
        flipRow(depth); // 원상 복구
    }
    
    // 행 뒤집기
    static void flipRow(int row) {
        for (int col = 0; col < M; col++) {
            beginning[row][col] ^= 1; // 0 ↔ 1
        }
    }
    
    // 현재 열, 목표 열 비교
    static int compCol(int col) {
        int count = 0;
        
        for (int row = 0; row < N; row++) {
            if (beginning[row][col] == target[row][col]) {
                count++;
            }
        }
        
        if (count == 0) {
            // 전부 반대인 경우
            return 1;
        }
        if (count == N) {
            // 전부 동일한 경우
            return 0;
        }
        return -1; // 섞여있는 경우
    }
}