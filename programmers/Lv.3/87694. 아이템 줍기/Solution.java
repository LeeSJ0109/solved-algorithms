import java.util.*;

class Solution {
    
    static int[][] map = new int[102][102];
    static boolean[][] visited = new boolean[102][102];
    
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for(int[] rect : rectangle) {
            int sx = rect[0] * 2;
            int sy = rect[1] * 2;
            int ex = rect[2] * 2;
            int ey = rect[3] * 2;
            
            for (int x = sx; x <= ex; x++) {
                for (int y = sy; y <= ey; y++) {
                    map[x][y] = 1;
                }
            }
        }
        
        // 사각형 내부영역 처리
        for (int x = 1; x < 102; x++) {
            for (int y = 1; y < 102; y++) {
                if (map[x][y] != 0) {
                    boolean isInside = true;
                        
                    for (int d = 0; d < 8; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                            
                        if (map[nx][ny] == 0) {
                            isInside = false;
                            break;
                        }
                    }
                        
                    if (isInside) {
                        map[x][y] = 2;
                    }
                }
            }
        }
        
        // BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{characterX * 2, characterY * 2});
        visited[characterX * 2][characterY * 2] = true;
        
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                
                if (x == itemX * 2 && y == itemY * 2) {
                    return count / 2;
                }
                
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    
                    if (visited[nx][ny] || map[nx][ny] != 1) {
                        continue;
                    }
                        
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
                
            count++;
        }
        
        return 0;
    }
}