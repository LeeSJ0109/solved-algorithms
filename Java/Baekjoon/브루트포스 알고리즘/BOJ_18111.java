import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] ground = new int[N][M];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, ground[i][j]);
                max = Math.max(max, ground[i][j]);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int bestHeight = 0;

        for (int h = min; h <= max; h++) {
            int time = 0;
            int inventory = B;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int diff = ground[i][j] - h;

                    if (diff > 0) {
                        time += diff * 2;
                        inventory += diff;
                    }
                    else {
                        time -= diff;
                        inventory += diff;
                    }
                }
            }

            if (inventory >= 0) {
                if (time < minTime || (time == minTime && h > bestHeight)) {
                    minTime = time;
                    bestHeight = h;
                }
            }
        }

        System.out.println(minTime + " " + bestHeight);
    }
}
