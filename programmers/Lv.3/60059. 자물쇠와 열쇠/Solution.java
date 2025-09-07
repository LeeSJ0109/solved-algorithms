class Solution {
    
    static int N, M, K = 0;
    
    public boolean solution(int[][] key, int[][] lock) {
        N = lock.length;
        M = key.length;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (lock[i][j] == 0) {
                    K++;
                }
            }
        }
        
        for (int r = 0; r < 4; r++) {            
            for (int i = 1 - M; i < N; i++) {
                for (int j = 1 - M; j < N; j++) {
                    if (isPossible(key, lock, i, j)) {
                        return true;
                    }
                }
            }
            
            if (r == 3) {
                break;
            }
            
            key = rotate(key);
        }
        
        return false;
    }
    
    // 시계방향 90도 회전
    static int[][] rotate(int[][] key) {
        int[][] nKey = new int[M][M];
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                nKey[j][M - 1 - i] = key[i][j];
            }
        }
        
        return nKey;
    }
    
    static boolean isPossible(int[][] key, int[][] lock, int x, int y) {
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int nx = i - x;
                int ny = j - y;
                
                if (nx < 0 || nx >= M || ny < 0 || ny >= M) {
                    continue;
                }
                
                if (lock[i][j] + key[nx][ny] != 1) {
                    return false;
                }
                
                if (lock[i][j] == 0) {
                    count++;
                }
            }
        }
        
        return count == K ? true : false;
    }
}