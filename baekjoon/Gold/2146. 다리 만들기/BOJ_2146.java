import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2146 {

    static int N;
    static int[][] map;
    static int minBridgeLength = Integer.MAX_VALUE;

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int islandId = 101;
        // 섬에 고유번호 부여
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    markIsland(i, j, islandId++);
                }
            }
        }

        // 각 섬의 모든 칸에서 다른 섬까지의 최소 다리길이 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 100) {
                    BFS(i, j, map[i][j]);
                }
            }
        }

        System.out.println(minBridgeLength);
    }

    static void markIsland(int i, int j, int id) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        map[i][j] = id;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                if (visited[nx][ny] || map[nx][ny] != 1) {
                    continue;
                }

                map[nx][ny] = id;
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }
    }

    static void BFS(int i, int j, int id) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        queue.add(new int[]{i, j});
        visited[i][j] = true;

        int length = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                        continue;
                    }
                    if (visited[nx][ny] || map[nx][ny] == id) {
                        continue;
                    }
                    // 바다인 경우
                    if (map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                        continue;
                    }

                    minBridgeLength = Math.min(minBridgeLength, length);
                }
            }

            length++;
        }
    }
}
