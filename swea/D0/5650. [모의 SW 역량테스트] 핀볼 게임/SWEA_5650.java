import java.io.*;
import java.util.*;

public class SWEA_5650 {

    static int N;
    static int[][] board;
    static int maxScore;

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine().trim());
            board = new int[N][N];
            maxScore = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == 0) {
                        for (int d = 0; d < 4; d++) {
                            simulation(i, j, d);
                        }
                    }
                }
            }

            System.out.printf("#%d %d\n", t, maxScore);
        }
    }

    static void simulation(int startX, int startY, int dir) {
        int x = startX, y = startY;
        int score = 0;

        while (true) {
            x += dx[dir];
            y += dy[dir];

            if (x < 0 || y < 0 || x >= N || y >= N) {
                dir = (dir == 0) ? 1 : (dir == 1) ? 0 : (dir == 2) ? 3 : 2; 
                score++;
                continue;
            }

            if (board[x][y] == -1) {
            	maxScore = Math.max(maxScore, score);
                break;
            }

            if (board[x][y] >= 1 && board[x][y] <= 5) {
                score++;

                switch (dir) {
                    case 0: // 위
                        if (board[x][y] == 1 || board[x][y] == 4 || board[x][y] == 5) dir = 1;
                        else if (board[x][y] == 2) dir = 3;
                        else if (board[x][y] == 3) dir = 2;
                        break;
                    case 1: // 아래
                        if (board[x][y] == 1) dir = 3;
                        else if (board[x][y] == 2 || board[x][y] == 3 || board[x][y] == 5) dir = 0;
                        else if (board[x][y] == 4) dir = 2;
                        break;
                    case 2: // 왼쪽
                        if (board[x][y] == 1) dir = 0;
                        else if (board[x][y] == 2) dir = 1;
                        else if (board[x][y] == 3 || board[x][y] == 4 || board[x][y] == 5) dir = 3;
                        break;
                    case 3: // 오른쪽
                        if (board[x][y] == 1 || board[x][y] == 2 || board[x][y] == 5) dir = 2;
                        else if (board[x][y] == 3) dir = 1;
                        else if (board[x][y] == 4) dir = 0;
                        break;
                }
                continue;
            }

            else if (board[x][y] >= 6 && board[x][y] <= 10) {
                int[] pos = findOtherWormhole(x, y, board[x][y]);
                x = pos[0];
                y = pos[1];
                continue;
            }

            if (x == startX && y == startY) {
                maxScore = Math.max(maxScore, score);
                break;
            }
        }
    }

    static int[] findOtherWormhole(int x, int y, int num) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == num && (i != x || j != y)) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{x, y};
    }
}
