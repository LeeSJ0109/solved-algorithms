import java.io.*;
import java.util.*;

public class BOJ_13460 {

    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rx = 0, ry = 0;
        int bx = 0, by = 0;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'R') {
                    rx = i;
                    ry = j;
                }
                if (board[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        System.out.println(BFS(rx, ry, bx, by));
    }

    static int BFS(int rx, int ry, int bx, int by) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{rx, ry, bx, by, 0});
        visited[rx][ry][bx][by] = true;

        while (!queue.isEmpty()) {
            int[] state = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nrx = state[0];
                int nry = state[1];
                int nbx = state[2];
                int nby = state[3];
                int nCount = state[4] + 1;

                boolean isRedIn = false;
                boolean isBlueIn = false;

                // 빨간 구슬 이동
                while (board[nrx + dx[d]][nry + dy[d]] != '#') {
                    nrx += dx[d];
                    nry += dy[d];

                    if (board[nrx][nry] == 'O') {
                        isRedIn = true;
                        break;
                    }
                }
                // 파란 구슬 이동
                while (board[nbx + dx[d]][nby + dy[d]] != '#') {
                    nbx += dx[d];
                    nby += dy[d];

                    if (board[nbx][nby] == 'O') {
                        isBlueIn = true;
                        break;
                    }
                }

                // 파란 구슬이 구멍에 빠진 경우 실패
                if (isBlueIn) {
                    continue;
                }
                if (isRedIn) {
                    return nCount;
                }

                // 위치가 같은 경우 위치 조정
                if (nrx == nbx && nry == nby) {
                    if (d == 0) {
                        // 위쪽으로 이동
                        if (state[0] > state[2]) {
                            nrx -= dx[d];
                        }
                        else {
                            nbx -= dx[d];
                        }
                    }
                    else if (d == 1) {
                        // 아래쪽으로 이동
                        if (state[0] < state[2]) {
                            nrx -= dx[d];
                        }
                        else {
                            nbx -= dx[d];
                        }
                    }
                    else if (d == 2) {
                        // 왼쪽으로 이동
                        if (state[1] > state[3]) {
                            nry -= dy[d];
                        }
                        else {
                            nby -= dy[d];
                        }
                    }
                    else if (d == 3) {
                        // 오른쪽으로 이동
                        if (state[1] < state[3]) {
                            nry -= dy[d];
                        }
                        else {
                            nby -= dy[d];
                        }
                    }
                }

                if (visited[nrx][nry][nbx][nby]) {
                    continue;
                }

                if (nCount < 10) {
                    visited[nrx][nry][nbx][nby] = true;
                    queue.add(new int[]{nrx, nry, nbx, nby, nCount});
                }
            }
        }

        return -1;
    }
}
