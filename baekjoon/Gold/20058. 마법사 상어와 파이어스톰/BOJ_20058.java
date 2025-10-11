import java.io.*;
import java.util.*;

public class BOJ_20058 {

    static int size;
    static int[][] map;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        size = 1 << N; // 2^N

        map = new int[size][size]; // 2^N * 2^N 크기 격자
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] levels = new int[Q];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            levels[i] = Integer.parseInt(st.nextToken());
        }

        for (int level : levels) {
            fireStorm(level);
        }

        // 남아있는 얼음의 합
        System.out.println(getIceSum());
        // 가장 큰 덩어리
        System.out.println(getMaxIceSize());
    }

    // 파이어스톰
    static void fireStorm(int L) {
        int subSize = 1 << L; // 부분격자 크기 (2^L)

        // 부분격자 회전
        rotate(subSize);

        // 얼음 녹이기
        melt();
    }

    // 부분격자 회전
    static void rotate(int subSize) {
        int[][] newMap = new int[size][size];

        for (int x = 0; x < size; x += subSize) {
            for (int y = 0; y < size; y += subSize) {
                for (int i = 0; i < subSize; i++) {
                    for (int j = 0; j < subSize; j++) {
                        newMap[x + j][y + subSize - 1 - i] = map[x + i][y + j];
                    }
                }
            }
        }

        map = newMap;
    }

    // 얼음 녹이기
    static void melt() {
        List<int[]> list = new ArrayList<>();

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (map[x][y] == 0) {
                    continue;
                }

                int count = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= size || ny >= size) {
                        continue;
                    }

                    if (map[nx][ny] > 0) {
                        count++;
                    }
                }

                if (count < 3) {
                    list.add(new int[]{x, y});
                }
            }
        }

        for (int[] p : list) {
            map[p[0]][p[1]]--;
        }
    }

    // 남은 얼음 합
    static int getIceSum() {
        int sum = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sum += map[i][j];
            }
        }

        return sum;
    }

    // 가장 큰 덩어리가 차지하는 칸의 개수
    static int getMaxIceSize() {
        boolean[][] visited = new boolean[size][size];

        int maxIceSize = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (visited[i][j] || map[i][j] <= 0) {
                    continue;
                }

                int iceSize = getIceSize(i, j, visited);
                maxIceSize = Math.max(maxIceSize, iceSize);
            }
        }

        return maxIceSize;
    }

    static int getIceSize(int i, int j, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        int iceSize = 1;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= size || ny >= size) {
                    continue;
                }
                if (visited[nx][ny] || map[nx][ny] == 0) {
                    continue;
                }

                queue.add(new int[]{nx, ny});
                visited[nx][ny] = true;
                iceSize++;
            }
        }

        return iceSize;
    }
}

