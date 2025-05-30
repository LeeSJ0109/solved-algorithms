import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1941 {

    static int count = 0;
    static char[][] seat = new char[5][5];
    static boolean[][] visited = new boolean[5][5];

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            seat[i] = br.readLine().toCharArray();
        }

        combination(0, 0, 0);
        System.out.println(count);
    }

    static void combination(int start, int depth, int yCount) {
        if (yCount > 3) {
            return;
        }

        if (depth == 7) {
            if (BFS()) {
                count++;
                return;
            }
        }

        for (int i = start; i < 25; i++) {
            int x = i / 5;
            int y = i % 5;

            visited[x][y] = true;
            combination(i + 1, depth + 1, yCount + (seat[x][y] == 'Y' ? 1 : 0));
            visited[x][y] = false;
        }
    }

    static boolean BFS() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] checked = new boolean[5][5];

        boolean found = false;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (visited[i][j]) {
                    queue.add(new int[] {i, j});
                    checked[i][j] = true;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        int count = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) {
                    continue;
                }
                if (!visited[nx][ny] || checked[nx][ny]) {
                    continue;
                }

                queue.add(new int[] {nx, ny});
                checked[nx][ny] = true;
                count++;
            }
        }

        return count == 7;
    }
}
