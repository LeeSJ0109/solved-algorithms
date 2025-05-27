import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] price = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = price.clone();
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int k = i - j;

                if (j > k) {
                    break;
                }

                dp[i] = Math.max(dp[i], dp[j] + dp[k]);
            }
        }

        System.out.println(dp[N]);
    }
}
