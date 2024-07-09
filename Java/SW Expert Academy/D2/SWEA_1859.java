import java.util.Scanner;

public class SWEA_1859 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            long[] price = new long[N];

            for (int i = 0; i < N; i++) {
                price[i] = sc.nextInt();
            }

            long high = price[N-1];
            long result = 0;

            for (int i = N-2; i >= 0; i--) {
                if (high < price[i]) high = price[i];
                else result += high - price[i];
            }
            System.out.println("#" + t + " " + result);
        }
        sc.close();
    }
}
