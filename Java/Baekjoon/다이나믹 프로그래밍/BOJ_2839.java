import java.util.Scanner;

public class BOJ_2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 1];

        for (int i = 0; i <= 5; i++) {
            if (i > N) break;
            if (i == 3 || i == 5){
                dp[i] = 1;
            }
            else dp[i] = 0;
        }

        for (int i = 6; i <= N; i++) {
            if (i > N) break;
            if (dp[i-3] != 0 && dp[i-5] != 0) dp[i] = Math.min(dp[i-3], dp[i-5]) + 1;
            else if (dp[i-3] == 0 && dp[i-5] != 0) dp[i] = dp[i-5] + 1;
            else if (dp[i-3] != 0 && dp[i-5] == 0) dp[i] = dp[i-3] + 1;
            else dp[i] = 0;
        }

        if (dp[N] == 0) System.out.println(-1);
        else System.out.println(dp[N]);

        sc.close();
    }
}
