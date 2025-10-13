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

        map = new int[size][size]; // 2^N * 2^N ũ�� ����
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

        // �����ִ� ������ ��
        System.out.println(getIceSum());
        // ���� ū ���
        System.out.println(getMaxIceSize());
    }

    // ���̾��
    static void fireStorm(int L) {
        int subSize = 1 << L; // �κа��� ũ�� (2^L)

        // �κа��� ȸ��
        rotate(subSize);

        // ���� ���̱�
        melt();
    }

    // �κа��� ȸ��
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

    // ���� ���̱�
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

    // ���� ���� ��
    static int getIceSum() {
        int sum = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sum += map[i][j];
            }
        }

        return sum;
    }

    // ���� ū ����� �����ϴ� ĭ�� ����
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

