import java.io.*;
import java.util.*;

public class BOJ_1799 {

    static int N;
    static int[][] board;
    static boolean[][] visited;
    static List<int[]> whiteSquare;
    static List<int[]> blackSquare;

    static int[] dx = {-1, -1, 1, 1};
    static int[] dy = {-1, 1, 1, -1};

    static int maxWhite = 0;
    static int maxBlack = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        visited = new boolean[N][N];
        whiteSquare = new ArrayList<>();
        blackSquare = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    if ((i + j) % 2 == 0) {
                        blackSquare.add(new int[]{i, j});
                    }
                    else {
                        whiteSquare.add(new int[]{i, j});
                    }

                }
            }
        }

        whiteDFS(0, 0);
        blackDFS(0, 0);

        System.out.println(maxWhite + maxBlack);
    }

    static void whiteDFS(int idx, int count) {
        if (count + whiteSquare.size() - idx <= maxWhite) {
            return;
        }

        if (idx == whiteSquare.size()) {
            maxWhite = Math.max(maxWhite, count);
            return;
        }

        int x = whiteSquare.get(idx)[0];
        int y = whiteSquare.get(idx)[1];

        // 비숍을 놓는 경우
        if (canPlace(x, y)) {
            visited[x][y] = true;
            whiteDFS(idx + 1, count + 1);
            visited[x][y] = false;
        }

        // 비숍을 놓지 않는 경우
        whiteDFS(idx + 1, count);
    }

    static void blackDFS(int idx, int count) {
        if (count + blackSquare.size() - idx <= maxBlack) {
            return;
        }

        if (idx == blackSquare.size()) {
            maxBlack = Math.max(maxBlack, count);
            return;
        }

        int x = blackSquare.get(idx)[0];
        int y = blackSquare.get(idx)[1];

        // 비숍을 놓는 경우
        if (canPlace(x, y)) {
            visited[x][y] = true;
            blackDFS(idx + 1, count + 1);
            visited[x][y] = false;
        }

        // 비숍을 놓지 않는 경우
        blackDFS(idx + 1, count);
    }

    static boolean canPlace(int x, int y) {
        for (int d = 0; d < 4; d++) {
            int nx = x;
            int ny = y;

            while (true) {
                nx += dx[d];
                ny += dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    break;
                }
                if (visited[nx][ny]) {
                    return false;
                }
            }
        }

        return true;
    }
}
