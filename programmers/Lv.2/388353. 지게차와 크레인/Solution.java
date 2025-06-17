import java.util.*;

class Solution {
    
    static int N, M;
    static char[][] map;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static final char INSIDE = '1';
    static final char OUTSIDE = '0';
    
    public int solution(String[] storage, String[] requests) {
        N = storage.length;
        M = storage[0].length();
        map = new char[N + 2][M + 2];

        for (char[] row : map) {
            Arrays.fill(row, OUTSIDE);
        }
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                map[i][j] = storage[i - 1].charAt(j - 1);
            }
        }
        
        // requests 처리
    	for (String request : requests) {
            char target = request.charAt(0);
            
            // 지게차 사용
            if (request.length() == 1) {
                useForkLift(target);
            }
            // 크레인 사용
            else {
                useCrane(target);
            }
            
            initMap();
        }
        
        return getRemainingContainers();
    }
    
    // 외부 영역 초기화
    static void initMap() {
        boolean[][] visited = new boolean[N + 2][M + 2];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if (nx < 0 || ny < 0 || nx >= N + 2 || ny >= M + 2 ) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                
                if (map[nx][ny] == INSIDE || map[nx][ny] == OUTSIDE) {
                    map[nx][ny] = OUTSIDE;
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
    
    // 지게차 사용
    static void useForkLift(char target) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == target && canUseForkLift(i, j)) {
                    map[i][j] = INSIDE;
                }
            }
        }
    }
    
    // 크레인 사용
    static void useCrane(char target) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == target) {
                    map[i][j] = INSIDE;
                }
            }
        }
    }

	// 지게차로 창고에서 접근이 가능한지
	static boolean canUseForkLift(int x, int y) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if (map[nx][ny] == OUTSIDE) {
                return true;
            }
        }
        
        return false;
    }
    
    static int getRemainingContainers() {
        int count = 0;
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] != INSIDE && map[i][j] != OUTSIDE) {
                    count++;
                }
            }
        }
        
        return count;
    }
}