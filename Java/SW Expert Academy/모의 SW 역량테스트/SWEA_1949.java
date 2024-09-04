import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
public class SWEA_1949 {
     
    static int N, K;
    static int[][] map;
    static boolean[][] visited;
     
    static int max;
    static List<int[]> list;
     
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            visited = new boolean[N][N];
             
            max = 0;
            list = new ArrayList<>();
             
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max, map[i][j]);
                }
            }
             
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == max) {
                        list.add(new int[] {i, j});
                    }
                }
            }
             
            max = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 1; k <= K; k++) {
                        for (int[] pos : list) {
                            int x = pos[0];
                            int y = pos[1];
                             
                            map[i][j] -= k;
                            visited[x][y] = true;
                            DFS(x, y, 1);
                            visited[x][y] = false;
                            map[i][j] += k;
                        }
                         
                    }
                }
            }
             
            System.out.println("#" + t + " " + max);
        }
         
    }
     
    static void DFS(int x, int y, int cnt) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
             
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                continue;
            }
            if (visited[nx][ny] || map[x][y] <= map[nx][ny]) {
                continue;
            }
             
            max = Math.max(max, cnt + 1);
            visited[nx][ny] = true;
            DFS(nx, ny, cnt + 1);
            visited[nx][ny] = false;
        }
    }
}