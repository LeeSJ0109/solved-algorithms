import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_2117 {

    static int N;
    static int[][] map;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            max = 0;

            for (int K = 1; K <= N + 1; K++) {
                int cost = K * K + (K - 1) * (K - 1);
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        int sum = BFS(i, j, K);

                        if (sum * M >= cost) {
                            max = Math.max(max, sum);
                        }
                    }
                }
            }

            System.out.println("#" + t + " " + max);
        }
    }

    static int BFS(int startX, int startY, int K) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        int sum = map[startX][startY];
        int B = 1;
        while (!queue.isEmpty()) {
            if (B == K) {
                return sum;
            }

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int x = queue.peek()[0];
                int y = queue.poll()[1];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                        continue;
                    }
                    if (visited[nx][ny]) {
                        continue;
                    }

                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                    sum += map[nx][ny];
                }
            }

            B++;
        }

        return sum;
    }
}
