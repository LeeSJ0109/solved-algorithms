import java.io.*;
import java.util.*;

public class BOJ_19237 {

    static class Shark {
        int x;
        int y;
        int direction;
        boolean exist;

        Shark(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.exist = true;
        }
    }

    static int N, M, K;
    static int[][][] map;
    static int[][][] priority;

    static Shark[] sharks;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N][2];
        sharks = new Shark[M + 1];
        priority = new int[M + 1][4][4];

        // 상어의 위치
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num > 0) {
                    sharks[num] = new Shark(i, j, -1);
                    map[i][j][0] = num;
                    map[i][j][1] = K;
                }
            }
        }

        // 상어의 초기 방향
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            sharks[i].direction = Integer.parseInt(st.nextToken()) - 1;
        }

        // 상어의 이동 우선순위
        for (int i = 1; i <= M; i++) {
            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int d = 0; d < 4; d++) {
                    priority[i][j][d] = Integer.parseInt(st.nextToken()) - 1;
                }
            }
        }

        int time = 0;
        while (time <= 1000) {
            if (getRemainingSharks() == 1) {
                System.out.println(time);
                return;
            }

            move();
            updateMap();
            time++;
        }

        System.out.println(-1);
    }

    static void move() {
        int[][][] newMap = new int[N][N][2];

        for (int i = 1; i <= M; i++) {
            // 상어가 존재하는지 확인
            if (!sharks[i].exist) {
                continue;
            }

            int x = sharks[i].x;
            int y = sharks[i].y;
            int direction = sharks[i].direction;

            boolean moved = false;

            // 냄새가 없는 칸
            for (int d : priority[i][direction]) {
                int nx = x + dx[d], ny = y + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                if (map[nx][ny][1] == 0) {
                    moveShark(i, nx, ny, d, newMap);
                    moved = true;
                    break;
                }
            }

            // 자신의 냄새가 있는 칸
            if (!moved) {
                for (int d : priority[i][direction]) {
                    int nx = x + dx[d], ny = y + dy[d];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                        continue;
                    }

                    if (map[nx][ny][0] == i) {
                        moveShark(i, nx, ny, d, newMap);
                        break;
                    }
                }
            }
        }
    }

    static void moveShark(int shark, int x, int y, int direction, int[][][] newMap) {
        if (newMap[x][y][0] == 0 || newMap[x][y][0] > shark) {
            newMap[x][y][0] = shark;
            newMap[x][y][1] = K;
            sharks[shark].x = x;
            sharks[shark].y = y;
            sharks[shark].direction = direction;
        }
        else {
            sharks[shark].exist = false;
        }
    }

    static void updateMap() {
        // 냄새 감소
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j][1] > 0) {
                    map[i][j][1]--;
                    if (map[i][j][1] == 0) {
                        map[i][j][0] = 0;
                    }
                }
            }
        }

        // 냄새 추가
        for (int i = 1; i <= M; i++) {
            if (sharks[i].exist) {
                int x = sharks[i].x, y = sharks[i].y;
                map[x][y][0] = i;
                map[x][y][1] = K;
            }
        }
    }

    static int getRemainingSharks() {
        int count = 0;

        for (int i = 1; i <= M; i++) {
            if (sharks[i].exist) count++;
        }

        return count;
    }
}
