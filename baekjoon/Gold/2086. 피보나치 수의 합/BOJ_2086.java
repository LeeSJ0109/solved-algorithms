import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2086 {

    static final int MOD = 1_000_000_000;

    // 행렬 곱셈
    static long[][] matrixMul(long[][] A, long[][] B) {
        long[][] result = new long[2][2];
        result[0][0] = (A[0][0] * B[0][0] + A[0][1] * B[1][0]) % MOD;
        result[0][1] = (A[0][0] * B[0][1] + A[0][1] * B[1][1]) % MOD;
        result[1][0] = (A[1][0] * B[0][0] + A[1][1] * B[1][0]) % MOD;
        result[1][1] = (A[1][0] * B[0][1] + A[1][1] * B[1][1]) % MOD;
        return result;
    }

    // 행렬 거듭제곱
    static long[][] matrixPow(long[][] M, long p) {
        long[][] result = {{1, 0}, {0, 1}};  // 단위 행렬
        long[][] base = M;

        while (p > 0) {
            if (p % 2 == 1) {
                result = matrixMul(result, base);
            }
            base = matrixMul(base, base);
            p /= 2;
        }

        return result;
    }

    // 피보나치 수 계산
    static long fib(long n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        long[][] F = {{1, 1}, {1, 0}}; // 피보나치 행렬
        long[][] result = matrixPow(F, n - 1);
        return result[0][0]; // Fₙ을 반환
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        System.out.println((fib(B + 2) - fib(A + 1) + MOD) % MOD);
    }
}
