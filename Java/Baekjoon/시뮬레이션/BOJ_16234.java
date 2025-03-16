import java.io.*;
import java.util.*;

public class BOJ_16234 {

    static int N, L, R;
    static int[][] A;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(move());
    }

    static int move() {
        int days = 0;

        while (true) {
            visited = new boolean[N][N];
            boolean isMoved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) {
                        continue;
                    }

                    if (BFS(i, j)) {
                        isMoved = true;
                    }
                }
            }

            // �α� �̵��� ���°�� break
            if (!isMoved) {
                break;
            }
            days++;
        }

        return days;
    }

    static boolean BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        // ������ �̷�� ������� ����
        List<int[]> union = new ArrayList<>();
        union.add(new int[]{x, y});

        visited[x][y] = true;

        // ������ �̷�� ������� �α��� ��
        int sumPopulation = A[x][y];

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }

                int diff = Math.abs(A[nx][ny] - A[cx][cy]);
                //  �� ������ �α� ���̰� L�� �̻�, R�� ���ϸ� ���տ� ����
                if (diff >= L && diff <= R) {
                    queue.add(new int[]{nx, ny});
                    union.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    sumPopulation += A[nx][ny];
                }
            }
        }

        // ������ ������ ��� �α� �̵�
        if (union.size() > 1) {
            int population = sumPopulation / union.size();
            for (int[] unionPos : union) {
                A[unionPos[0]][unionPos[1]] = population;
            }

            return true;
        }

        return false;
    }
}
