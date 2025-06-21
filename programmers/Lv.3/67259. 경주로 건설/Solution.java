import java.util.*;

class Solution {
    
    static class Node {
        int x, y, dir, cost;
        
        public Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] board) {
        int N = board.length;
        int[][][] cost = new int[N][N][4];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, 0)); // 아래
        queue.add(new Node(0, 0, 3, 0)); // 오른쪽
        cost[0][0][1] = 0;
        cost[0][0][3] = 0;
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            for (int d = 0; d < 4; d++) {
                int nx = current.x + dx[d];
                int ny = current.y + dy[d];
                
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }
                if (board[nx][ny] == 1) {
                    continue;
                }
                
                int nc = current.cost + (current.dir == d ? 100 : 600);
                
                if (cost[nx][ny][d] > nc) {
                    cost[nx][ny][d] = nc;
                    queue.add(new Node(nx, ny, d, nc));
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for (int d = 0; d < 4; d++) {
            answer = Math.min(answer, cost[N - 1][N - 1][d]);
        }
        
        return answer;
    }
}