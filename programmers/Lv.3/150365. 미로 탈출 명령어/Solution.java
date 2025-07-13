import java.util.*;

class Solution {
    
    static int N, M, R, C, K;
    // d, l, r, u
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static String[] path = {"d", "l", "r", "u"};
    
    static class Node {
        int x, y;
        int level;
        String path;
        
        Node(int x, int y, int level, String path) {
            this.x = x;
            this.y = y;
            this.level = level;
            this.path = path;
        }
    }
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n;
        M = m;
        R = r;
        C = c;
        K = k;
        
        int dist = Math.abs(x - r) + Math.abs(y - c);
        if (dist > K) {
            return "impossible";
        }
        
        return BFS(x, y);
    }
    
    String BFS(int x, int y) {
        boolean[][][] visited = new boolean[N + 1][M + 1][K + 1];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0, ""));
        visited[x][y][0] = true;
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            // 이동하는 거리 만족
            if (current.level == K) {
                if (current.x == R && current.y == C) {
                    return current.path;
                }
                continue;
            }
            
            int dist = Math.abs(current.x - R) + Math.abs(current.y - C);
            if (dist > K - current.level) {
                continue;
            }
            
            for (int d = 0; d < 4; d++) {
                int nx = current.x + dx[d];
                int ny = current.y + dy[d];
                
                if (nx < 1 || ny < 1 || nx > N || ny > M) {
                    continue;
                }
                if (visited[nx][ny][current.level + 1]) {
                    continue;
                }
                
                visited[nx][ny][current.level + 1] = true;
                queue.add(new Node(nx, ny, current.level + 1, current.path + path[d]));
            }
        }
        
        return "impossible";
    }
}