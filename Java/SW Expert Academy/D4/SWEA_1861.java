import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1861 {

    static int N;
    static int[][] rooms;

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static int maxMove, maxNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            rooms = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    rooms[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            maxMove = 0;
            maxNum = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    move(i, j, 1);
                }
            }

            System.out.println("#" + t + " " + maxNum + " " + maxMove);
        }
    }

    static int move(int x, int y, int count) {

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if (rooms[x][y] + 1 != rooms[nx][ny]) continue;

            count = move(nx, ny, count + 1);

            if (count > maxMove) {
                maxMove = count;
                maxNum = rooms[x][y];
            }

            if (count == maxMove && maxNum > rooms[x][y])
                maxNum = rooms[x][y];

        }

        return count;
    }
}
