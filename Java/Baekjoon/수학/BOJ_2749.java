import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2749 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long index = N % 1_500_000;

        long[] fib = new long[(int)index + 1];
        fib[1] = 1;

        for (int i = 2; i <= index; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % 1_000_000;
        }

        System.out.println(fib[(int)index]);
    }
}
