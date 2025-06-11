import java.util.Scanner;

public class SWEA_2058 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r, sum = 0;

        while (N > 10) {
            r = N % 10;
            N /= 10;
            sum += r;
        }
        sum += N;
        System.out.println(sum);

        sc.close();
    }
}