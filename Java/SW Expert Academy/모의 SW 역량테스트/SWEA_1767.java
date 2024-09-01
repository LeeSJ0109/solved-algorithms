import java.io.*;
import java.util.*;

public class SWEA_1767 {

    static int N;
    static int[][] processor;
    static List<int[]> cores;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int maxCoreCount;
    static int minLineLength;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            processor = new int[N][N];
            cores = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    processor[i][j] = Integer.parseInt(st.nextToken());
                    // 가장자리가 아닌 코어만 저장
                    if (i > 0 && j > 0 && i < N - 1 && j < N - 1 && processor[i][j] == 1) {
                        cores.add(new int[] {i, j});
                    }
                }
            }

            maxCoreCount = Integer.MIN_VALUE;
            minLineLength = Integer.MAX_VALUE;

            connectCores(0, 0, 0);

            System.out.println("#" + t + " " + minLineLength);
        }

    }

    static void connectCores(int cnt, int coreCount, int lineLength) {
        if (maxCoreCount > coreCount + cores.size() - cnt) {
            return;
        }

        if (cnt == cores.size()) {
            if (maxCoreCount < coreCount) {
                maxCoreCount = coreCount;
                minLineLength = lineLength;
            }
            else if (maxCoreCount == coreCount) {
                if (minLineLength > lineLength) {
                    minLineLength = lineLength;
                }
            }
            return;
        }

        int x = cores.get(cnt)[0];
        int y = cores.get(cnt)[1];

        for (int d = 0; d < 4; d++) {
            int nx = x;
            int ny = y;

            int len = 0;

            while (true) {
                nx += dx[d];
                ny += dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    break;
                }
                if (processor[nx][ny] == 0) {
                    len++;
                }
                else {
                    len = 0;
                    break;
                }
            }

            nx = x;
            ny = y;
            for (int i = 0; i < len; i++) {
                nx += dx[d];
                ny += dy[d];
                processor[nx][ny] = 1;
            }

            if (len == 0) {
                connectCores(cnt + 1, coreCount, lineLength);
            }
            else {
                connectCores(cnt + 1, coreCount + 1, lineLength + len);

                nx = x;
                ny = y;
                for (int i = 0; i < len; i++) {
                    nx += dx[d];
                    ny += dy[d];

                    processor[nx][ny] = 0;
                }
            }
        }
    }
}
