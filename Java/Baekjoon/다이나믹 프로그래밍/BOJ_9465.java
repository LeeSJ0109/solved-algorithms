import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][N + 1];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    stickers[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[2][N + 1];
            dp[0][1] = stickers[0][1]; // 처음에 위쪽 스티커를 선택하는 경우
            dp[1][1] = stickers[1][1]; // 처음에 아래쪽 스티커를 선택하는 경우

            for (int i = 2; i <= N; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + stickers[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + stickers[1][i];
            }

            sb.append(Math.max(dp[0][N], dp[1][N])).append("\n");
        }

        System.out.println(sb);
    }
}
