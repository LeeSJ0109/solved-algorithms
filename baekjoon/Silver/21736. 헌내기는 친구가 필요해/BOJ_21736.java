import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_21736 {

    static int N, M;
    static char[][] map;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new char[N][M];

        int startX = 0, startY = 0;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'I') {
                    startX = i;
                    startY = j;
                }
            }
        }

        int result = BFS(startX, startY);
        if (result == 0) {
            System.out.println("TT");
        }
        else {
            System.out.println(result);
        }
    }

    static int BFS(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                if (visited[nx][ny] || map[nx][ny] == 'X') {
                    continue;
                }

                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
                if (map[nx][ny] == 'P') {
                    count++;
                }
            }
        }

        return count;
    }
}
