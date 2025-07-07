import java.util.*;

class Solution {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        
        int count = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int s = 0; s < size; s++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                
                if (x == N - 1 && y == M - 1) {
                    return count;
                }
                
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                        continue;
                    }
                    if (maps[nx][ny] == 0 || visited[nx][ny]) {
                        continue;
                    }
                    
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
            
            count++;
        }
        
        return -1;
    }
}