import java.io.*;
import java.util.*;

public class BOJ_4963 {

    static int w, h;
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> queue;

    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            map = new int[w][h];
            visited = new boolean[w][h];

            queue = new LinkedList<>();
            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < h; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (map[i][j] == 1) {
                        cnt++;
                        queue.add(new int[]{i, j});
                        BFS();
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    static void BFS() {
        while (!queue.isEmpty()) {
            int pos[] = queue.poll();

            for (int d = 0; d < 8; d++) {
                int nx = pos[0] + dx[d];
                int ny = pos[1] + dy[d];

                if (nx < 0 || ny < 0 || nx >= w || ny >= h) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (map[nx][ny] == 0) {
                    continue;
                }

                map[nx][ny] = 0;
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }
    }
}
