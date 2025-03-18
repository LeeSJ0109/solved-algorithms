import java.io.*;
import java.util.*;

public class BOJ_15683 {

    static class CCTV {
        int x;
        int y;
        int type;

        public CCTV(int x, int y, char type) {
            this.x = x;
            this.y = y;
            this.type = type - '0';
        }
    }

    static int N, M;
    static char[][] office;
    static List<CCTV> cctvList = new ArrayList<>();

    static int minSize = Integer.MAX_VALUE;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][][] cctvDirection = {
            // type: 0
            {},
            // type: 1
            {{0}, {1}, {2}, {3}},
            // type: 2
            {{0, 2}, {1, 3}},
            // type: 3
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
            // type: 4
            {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
            // type: 5
            {{0, 1, 2, 3}},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        office = new char[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                office[i][j] = st.nextToken().charAt(0);
                if ('1' <= office[i][j] && office[i][j] <= '5') {
                    cctvList.add(new CCTV(i, j, office[i][j]));
                }
            }
        }

        setDirection(0);
        System.out.println(minSize);
    }

    static void setDirection(int count) {
        if (count == cctvList.size()) {
            // 사각지대 크기 계산
            minSize = Math.min(minSize, getSize());
            return;
        }

        CCTV cctv = cctvList.get(count);
        int x = cctv.x;
        int y = cctv.y;
        int type = cctv.type;

        for (int[] directions : cctvDirection[type]) {
            // 현재 사무실 정보 복사
            char[][] temp = new char[N][M];
            for (int i = 0; i < N; i++) {
                temp[i] = office[i].clone();
            }

            for (int direction : directions) {
                // 감시하는 영역 표시
                monitor(x, y, direction);
            }

            setDirection(count + 1);
            // 원상복구
            office = temp;
        }
    }

    // 감시하는 영역 표시
    static void monitor(int x, int y, int direction) {
        while (true) {
            x += dx[direction];
            y += dy[direction];

            if (x < 0 || y < 0 || x >= N || y >= M) {
                break;
            }
            if (office[x][y] == '6') {
                break;
            }

            // 감시하는 영역 표시
            if (office[x][y] == '0') {
                office[x][y] = '#';
            }
        }
    }

    // 사각지대의 크기 구함
    static int getSize() {
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (office[i][j] == '0') {
                    count++;
                }
            }
        }

        return count;
    }
}
