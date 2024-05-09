import java.io.*;
import java.util.*;

public class BOJ_4179 {
    static int R, C;
    static char map[][];

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static Queue<int[]> jh;
    static Queue<int[]> fire;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
            
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        jh = new LinkedList<>();
        fire = new LinkedList<>();

        map = new char[C][R];

        for (int j = 0; j < C; j++) {
            String line = br.readLine();
            for (int k = 0; k < R; k++) {
                map[j][k] = line.charAt(k);
                if (map[j][k] == 'J')
                    jh.add(new int[]{j, k});
                else if (map[j][k] == 'F')
                    fire.add(new int[]{j, k});
            }
        }

        int time = BFS();
        if (time == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(time);
        }
    }

    public static int BFS() {
        int time = 0;
        while (!jh.isEmpty()) {
            time++;

            int size = fire.size();
            for (int f = 0; f < size; f++) {
                int[] pos = fire.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = pos[0] + dx[i];
                    int ny = pos[1] + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < C && ny < R && map[nx][ny] == '.') {
                        fire.add(new int[]{nx, ny});
                        map[nx][ny] = 'F';
                    }
                }
            }

            size = jh.size();
            for (int s = 0; s < size; s++) {
                int[] pos = jh.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = pos[0] + dx[i];
                    int ny = pos[1] + dy[i];

                    if (nx < 0 || ny < 0 || nx >= C || ny >= R)
                        return time;

                    if (map[nx][ny] == '.') {
                        jh.add(new int[]{nx, ny});
                        map[nx][ny] = 'J';
                    }
                }
            }
        }
        return -1;
    }
}