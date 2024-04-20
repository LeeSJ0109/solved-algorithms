import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1509 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        int N = string.length();

        boolean[][] isPalindrome = new boolean[N][N];

        // 팰린드롬 여부 계산
        for (int length = 0; length < N; length++) {
            for (int start = 0; start + length < N; start++) {
                int end = start + length;

                if (string.charAt(start) == string.charAt(end)) {
                    if (length < 2) {
                        // 길이 1 또는 2일 때는 항상 팰린드롬
                        isPalindrome[start][end] = true;
                    }
                    else {
                        isPalindrome[start][end] = isPalindrome[start + 1][end - 1];
                    }
                }
            }
        }

        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // 최소 분할의 개수 계산
        for (int end = 0; end < N; end++) {
            if (isPalindrome[0][end]) {
                dp[end] = 1;
            }
            else {
                for (int start = 0; start < end; start++) {
                    if (isPalindrome[start + 1][end]) {
                        dp[end] = Math.min(dp[end], dp[start] + 1);
                    }
                }
            }
        }

        System.out.println(dp[N - 1]);
    }
}
