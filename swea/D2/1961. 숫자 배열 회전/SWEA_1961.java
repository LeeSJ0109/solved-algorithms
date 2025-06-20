import java.util.Scanner;

public class SWEA_1961 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            System.out.println("#" + t);
            for (int i = 0; i < N; i++) {
                for (int j = N-1; j >= 0; j--) {
                    System.out.print(arr[j][i]);
                }
                System.out.print(" ");
                for (int j = N-1; j >= 0; j--) {
                    System.out.print(arr[N-i-1][j]);
                }
                System.out.print(" ");
                for (int j = 0; j < N; j++) {
                    System.out.print(arr[j][N-i-1]);
                }
                System.out.println();
            }
        }
        sc.close();
    }
}
