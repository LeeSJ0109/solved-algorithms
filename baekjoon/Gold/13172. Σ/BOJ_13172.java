import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13172 {

    static final long MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        long result = 0;
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 주사위의 면의 수 Nᵢ
            int S = Integer.parseInt(st.nextToken()); // 모든 면에 적힌 숫자를 더한 값 Sᵢ

            long inverseN = pow(N, MOD - 2); // 모듈러 역원 계산 (페르마의 소정리)
            result = (result + S * inverseN % MOD) % MOD;
        }

        System.out.println(result);
    }

    // 빠른 거듭제곱 알고리즘 (xʸ mod MOD)
    static long pow(long base, long exp) {
        long result = 1;
        base %= MOD;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % MOD;
            }

            base = base * base % MOD;
            exp >>= 1;
        }

        return result;
    }
}
