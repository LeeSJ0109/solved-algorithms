import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16724 {

    static int N, M;
    static char[][] map;
    static int[][] visited;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == 0) {
                    DFS(i, j);
                }
            }
        }

        System.out.println(count);
    }

    static void DFS(int x, int y) {
        visited[x][y] = 1; // 방문 중

        int nx = x, ny = y;
        switch (map[x][y]) {
            case 'U': {
                nx = x - 1;
                break;
            }
            case 'D': {
                nx = x + 1;
                break;
            }
            case 'L': {
                ny = y - 1;
                break;
            }
            case 'R': {
                ny = y + 1;
                break;
            }
        }

        if (visited[nx][ny] == 0) {
            // 한번도 방문 안함
            DFS(nx, ny);
        }
        else if (visited[nx][ny] == 1) {
            count++; // 사이클 발생
        }

        visited[x][y] = 2;
    }
}
