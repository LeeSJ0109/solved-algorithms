import java.io.*;
import java.util.*;

public class BOJ_16946 {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static Map<Integer, Integer> areaSize = new HashMap<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int id = 2;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    int size = getAreaSize(i, j, id);
                    areaSize.put(id, size);
                    id++;
                }
            }
        }

        printMap();
    }

    static int getAreaSize(int i, int j, int id) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        map[i][j] = id;

        int count = 1;
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (visited[nx][ny] || map[nx][ny] != 0) {
                    continue;
                }

                queue.add(new int[]{nx, ny});
                visited[nx][ny] = true;
                map[nx][ny] = id;
                count++;
            }
        }

        return count;
    }

    static int getTotalSize(int x, int y) {
        Set<Integer> set = new HashSet<>();
        int sum = 1;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            }
            if (map[nx][ny] == 1) {
                continue;
            }

            if (!set.contains(map[nx][ny])) {
                set.add(map[nx][ny]);
                sum += areaSize.get(map[nx][ny]);
            }
        }

        return sum % 10;
    }

    static void printMap() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    sb.append(getTotalSize(i, j));
                }
                else {
                    sb.append(0);
                }
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }
}
