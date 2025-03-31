import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_11559 {

    static char[][] field = new char[12][6];
    static boolean[][] visited = new boolean[12][6];

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++) {
            field[i] = br.readLine().toCharArray();
        }

        System.out.println(puyoPuyo());
    }

    static int puyoPuyo() {
        int popCount = 0;

        while (true) {
            boolean isPopped = false;
            visited = new boolean[12][6];

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (field[i][j] != '.' && !visited[i][j]) {
                        if (popSamePuyo(i, j)) {
                            isPopped = true;
                        }
                    }
                }
            }

            if (!isPopped) {
                break;
            }

            popCount++;
            applyGravity();
        }

        return popCount;
    }

    static boolean popSamePuyo(int i, int j) {
        List<int[]> sameColorPuyo = new LinkedList<>(); // 같은 색 뿌요를 저장하는 리스트
        Queue<int[]> queue = new LinkedList<>();
        sameColorPuyo.add(new int[]{i, j});
        queue.add(new int[]{i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= 12 || ny < 0 || ny >= 6) {
                    continue;
                }
                if (visited[nx][ny] || field[nx][ny] != field[i][j]) {
                    continue;
                }

                sameColorPuyo.add(new int[]{nx, ny});
                queue.add(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }

        // 같은 색 뿌요가 4개 이상 연결되어 있으면 없애기
        if (sameColorPuyo.size() >= 4) {
            for (int[] puyo : sameColorPuyo) {
                field[puyo[0]][puyo[1]] = '.';
            }

            return true;
        }

        return false;
    }

    // 중력 적용
    static void applyGravity() {
        for (int j = 0; j < 6; j++) {
            Queue<Character> puyo = new LinkedList<>();

            for (int i = 11; i >= 0; i--) {
                if (field[i][j] != '.') {
                    puyo.add(field[i][j]);
                }
            }

            for (int i = 11; i >= 0; i--) {
                if (puyo.isEmpty()) {
                    field[i][j] = '.';
                }
                else {
                    field[i][j] = puyo.poll();
                }
            }
        }
    }
}
