import java.util.*;

class Solution {
    
    static int N, M;
    static String[] map;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(String[] maps) {
        int answer = 0;
        
        map = maps;
        N = map.length;
        M = map[0].length();
        
        int SX = -1, SY = -1, LX = -1, LY = -1, EX = -1, EY = -1;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j ++) {
                char c = map[i].charAt(j);
                
                if (c == 'S') {
                    SX = i;
                    SY = j;
                }
                else if (c == 'L') {
                    LX = i;
                    LY = j;
                }
                else if (c == 'E') {
                    EX = i;
                    EY = j;
                }
            }
        }
        
        int D1 = BFS(SX, SY, LX, LY);
        if (D1 == -1) {
            return -1;
        }
        answer += D1;
        
        int D2 = BFS(LX, LY, EX, EY);
        if (D2 == -1) {
            return -1;
        }
        answer += D2;
        
        return answer;
    }
    
    static int BFS(int sx, int sy, int ex, int ey) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.add(new int[]{sx, sy});
        visited[sx][sy] = true;
        
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for (int s = 0; s < size; s++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
            
                if (x == ex && y == ey) {
                    return count;
                }
            
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                        continue;
                    }

                    if (visited[nx][ny] || map[nx].charAt(ny) == 'X') {
                        continue;
                    }

                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
            
            count++;
        }
        
        return -1;
    }
}