import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String code = br.readLine();
        int codeLength = code.length();

        if (code.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        int[] dp = new int[codeLength + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= codeLength; i++) {
            int subCode = code.charAt(i - 1) - '0';

            if (0 < subCode && subCode <= 9) {
                dp[i] += dp[i - 1];
                dp[i] %= 1_000_000;
            }

            subCode += (code.charAt(i - 2) - '0') * 10;

            if (10 <= subCode && subCode <= 26) {
                dp[i] += dp[i - 2];
                dp[i] %= 1_000_000;
            }
        }

        System.out.println(dp[codeLength]);
    }
}
