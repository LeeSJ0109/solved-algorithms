import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10830 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int[][] matrix = new int[N][N];
        int[][] result = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
            result[i][i] = 1;
        }

        while (B > 0) {
            // ������ Ȧ���̸� ���� ����� ����
            if (B % 2 == 1) {
                result = multiplyMatrix(result, matrix);
            }

            // ��� ����
            matrix = multiplyMatrix(matrix, matrix);

            B /= 2;
        }

        printMatrix(result);
    }

    static int[][] multiplyMatrix(int[][] A, int[][] B) {
        int[][] result = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                    result[i][j] %= 1000;
                }
            }
        }

        return result;
    }

    static void printMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
