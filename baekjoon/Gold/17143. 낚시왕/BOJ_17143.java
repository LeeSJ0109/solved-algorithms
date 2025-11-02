import java.io.*;
import java.util.*;

public class BOJ_17143 {

    static class Shark {
        int s; // 속력
        int d; // 이동 방향
        int z; // 크기

        Shark(int s, int d, int z) {
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    static int R, C, M;
    static Shark[][] map;

    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Shark[R + 1][C + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            map[r][c] = new Shark(s, d, z);
        }

        int total = 0;

        for (int c = 1; c <= C; c++) {
            total += catchShark(c); // 상어 잡기, 잡은 상어 크기 누적
            moveShark(); // 상어 이동
        }

        System.out.println(total);
    }

    // 땅과 제일 가까운 상어를 잡기
    static int catchShark(int c) {
        for (int r = 1; r <= R; r++) {
            if (map[r][c] == null) {
                continue;
            }

            int size = map[r][c].z;
            map[r][c] = null;

            return size;
        }

        return 0;
    }

    // 상어 이동
    static void moveShark() {
        Shark[][] newMap = new Shark[R + 1][C + 1];

        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {
                if (map[r][c] == null) {
                    continue;
                }

                Shark shark = map[r][c];
                int nr = r;
                int nc = c;
                int s = shark.s;
                int d = shark.d;
                int z = shark.z;

                // 속도 최적화: 상하/좌우 주기로 줄임
                if (d == 1 || d == 2) {
                    s %= (R - 1) * 2;
                }
                else {
                    s %= (C - 1) * 2;
                }

                for (int i = 0; i < s; i++) {
                    nr += dx[d];
                    nc += dy[d];

                    // 격자판의 경계를 넘는 경우 방향 전환
                    if (nr < 1 || nr > R || nc < 1 || nc > C) {
                        nr -= dx[d];
                        nc -= dy[d];
                        d = (d == 1) ? 2 : (d == 2) ? 1 : (d == 3) ? 4 : 3;
                        nr += dx[d];
                        nc += dy[d];
                    }
                }

                if (newMap[nr][nc] == null) {
                    newMap[nr][nc] = new Shark(s, d, z);
                }
                else {
                    // 크기가 큰 상어만 남음
                    if (newMap[nr][nc].z < z) {
                        newMap[nr][nc] = new Shark(s, d, z);
                    }
                }
            }
        }

        map = newMap;
    }
}
