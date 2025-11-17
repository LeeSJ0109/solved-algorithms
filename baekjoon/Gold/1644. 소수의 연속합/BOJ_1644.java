import java.io.*;
import java.util.*;

public class BOJ_1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        int left = 0, right = 0;
        int sum = 0;

        int count = 0;
        while (true) {
            if (sum < N) {
                if (right == primes.size()) {
                    break;
                }

                sum += primes.get(right++);
            }
            else {
                sum -= primes.get(left++);
            }

            if (sum == N) {
                count++;
            }
        }

        System.out.println(count);
    }
}
