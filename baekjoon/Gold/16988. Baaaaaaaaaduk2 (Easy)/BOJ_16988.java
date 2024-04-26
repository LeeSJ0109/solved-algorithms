import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16988 {

    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static List<int[]> empty = new ArrayList<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int maxCaptured = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0) {
                    empty.add(new int[]{i, j});
                }
            }
        }

        int size = empty.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                simulate(empty.get(i), empty.get(j));
            }
        }

        System.out.println(maxCaptured);
    }

    static void simulate(int[] stone1, int[] stone2) {
        board[stone1[0]][stone1[1]] = 1;
        board[stone2[0]][stone2[1]] = 1;

        int captured = getCaptured();
        maxCaptured = Math.max(maxCaptured, captured);

        board[stone1[0]][stone1[1]] = 0;
        board[stone2[0]][stone2[1]] = 0;
    }

    static int getCaptured() {
        visited = new boolean[N][M];
        int captured = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] || board[i][j] == 0 || board[i][j] == 1) {
                    continue;
                }

                captured += BFS(i, j);
            }
        }

        return captured;
    }

    static int BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;

        int count = 0;
        boolean isCaptured = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            count++;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }

                if (board[nx][ny] == 0) {
                    isCaptured = false;
                }
                else if (board[nx][ny] == 2) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        return isCaptured ? count : 0;
    }
}
