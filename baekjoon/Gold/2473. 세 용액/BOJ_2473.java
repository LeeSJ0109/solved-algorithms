import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2473 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] solutions = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solutions[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(solutions);

        long minDifference = Long.MAX_VALUE;
        long[] threeSolutions = new long[3];

        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                long sum = solutions[i] + solutions[left] + solutions[right];
                long difference = Math.abs(sum);

                if (difference < minDifference) {
                    minDifference = difference;
                    threeSolutions[0] = solutions[i];
                    threeSolutions[1] = solutions[left];
                    threeSolutions[2] = solutions[right];
                }

                if (sum > 0) {
                    right--;
                }
                else if (sum < 0) {
                    left++;
                }
                else {
                    print(threeSolutions);
                    return;
                }
            }
        }

        print(threeSolutions);
    }

    static void print(long[] threeSolutions) {
        System.out.println(threeSolutions[0]
                + " " + threeSolutions[1]
                + " " + threeSolutions[2]
        );
    }
}
