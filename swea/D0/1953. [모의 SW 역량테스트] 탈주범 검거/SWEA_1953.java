import java.io.*;
import java.util.*;
 
public class SWEA_1953 {
     
    static int N, M, R, C, L;
     
    static int[][] map;
    static boolean[][] visited;
     
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());   // 지하 터널 지도의 세로 크기
            M = Integer.parseInt(st.nextToken());   // 지하 터널 지도의 가로 크기
            R = Integer.parseInt(st.nextToken());   // 맨홀 뚜껑이 위치한장소의 세로 위치
            C = Integer.parseInt(st.nextToken());   // 맨홀 뚜껑이 위치한장소의 가로 위치
            L = Integer.parseInt(st.nextToken());   // 탈출 후 소요된 시간 L
             
            map = new int[N][M];
            visited = new boolean[N][M];
             
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            BFS();
             
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visited[i][j]) {
                        cnt++;
                    }
                }
            }
         
            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }
     
    static void BFS() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {R, C});
        visited[R][C] = true;
         
        int time = 1;
         
        while (!queue.isEmpty() && time != L) {
            int size = queue.size();
             
            for (int i = 0; i < size; i++) {
                int x = queue.peek()[0];
                int y = queue.poll()[1];
 
                if (map[x][y] == 0) {
                    visited[x][y] = false;
                    continue;
                }
                if (map[x][y] == 1) {
                    // 상, 하, 좌, 우
                    if (move(x, y, 0)) {
                        visited[x + dx[0]][y + dy[0]] = true;
                        queue.add(new int[] {x + dx[0], y + dy[0]});
                    }
                    if (move(x, y, 1)) {
                        visited[x + dx[1]][y + dy[1]] = true;
                        queue.add(new int[] {x + dx[1], y + dy[1]});
                    }
                    if (move(x, y, 2)) {
                        visited[x + dx[2]][y + dy[2]] = true;
                        queue.add(new int[] {x + dx[2], y + dy[2]});
                    }
                    if (move(x, y, 3)) {
                        visited[x + dx[3]][y + dy[3]] = true;
                        queue.add(new int[] {x + dx[3], y + dy[3]});
                    }
                }
                if (map[x][y] == 2) {
                    // 상, 하
                    if (move(x, y, 0)) {
                        visited[x + dx[0]][y + dy[0]] = true;
                        queue.add(new int[] {x + dx[0], y + dy[0]});
                    }
                    if (move(x, y, 1)) {
                        visited[x + dx[1]][y + dy[1]] = true;
                        queue.add(new int[] {x + dx[1], y + dy[1]});
                    }
                }
                if (map[x][y] == 3) {
                    // 좌, 우
                    if (move(x, y, 2)) {
                        visited[x + dx[2]][y + dy[2]] = true;
                        queue.add(new int[] {x + dx[2], y + dy[2]});
                    }
                    if (move(x, y, 3)) {
                        visited[x + dx[3]][y + dy[3]] = true;
                        queue.add(new int[] {x + dx[3], y + dy[3]});
                    }
                }
                if (map[x][y] == 4) {
                    // 상, 우
                    if (move(x, y, 0)) {
                        visited[x + dx[0]][y + dy[0]] = true;
                        queue.add(new int[] {x + dx[0], y + dy[0]});
                    }
                    if (move(x, y, 3)) {
                        visited[x + dx[3]][y + dy[3]] = true;
                        queue.add(new int[] {x + dx[3], y + dy[3]});
                    }
                }
                if (map[x][y] == 5) {
                    // 하, 우
                    if (move(x, y, 1)) {
                        visited[x + dx[1]][y + dy[1]] = true;
                        queue.add(new int[] {x + dx[1], y + dy[1]});
                    }
                    if (move(x, y, 3)) {
                        visited[x + dx[3]][y + dy[3]] = true;
                        queue.add(new int[] {x + dx[3], y + dy[3]});
                    }
                }
                if (map[x][y] == 6) {
                    // 하, 좌
                    if (move(x, y, 1)) {
                        visited[x + dx[1]][y + dy[1]] = true;
                        queue.add(new int[] {x + dx[1], y + dy[1]});
                    }
                    if (move(x, y, 2)) {
                        visited[x + dx[2]][y + dy[2]] = true;
                        queue.add(new int[] {x + dx[2], y + dy[2]});
                    }
                }
                if (map[x][y] == 7) {
                    // 상, 좌
                    if (move(x, y, 0)) {
                        visited[x + dx[0]][y + dy[0]] = true;
                        queue.add(new int[] {x + dx[0], y + dy[0]});
                    }
                    if (move(x, y, 2)) {
                        visited[x + dx[2]][y + dy[2]] = true;
                        queue.add(new int[] {x + dx[2], y + dy[2]});
                    }
                }
            }
             
            time++;
        }
    }
     
    static boolean move(int x, int y, int dir) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
         
        if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
            return false;
        }
        if (map[nx][ny] == 0 || visited[nx][ny]) {
            return false;
        }
        if (dir == 0) {
            if (map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 7) {
                return false;
            }
        }
        if (dir == 1) {
            if (map[nx][ny] == 3 || map[nx][ny] == 5 || map[nx][ny] == 6) {
                return false;
            }
        }
        if (dir == 2) {
            if (map[nx][ny] == 2 || map[nx][ny] == 6 || map[nx][ny] == 7) {
                return false;
            }
        }
        if (dir == 3) {
            if (map[nx][ny] == 2 || map[nx][ny] == 4 || map[nx][ny] == 5) {
                return false;
            }
        }
         
        return true;
    }
}