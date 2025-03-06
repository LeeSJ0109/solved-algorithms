import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int q1 = 0;
        int q2 = 0;
        int q3 = 0;


        for (int i = 0; i < N; i++) {
            String slices = br.readLine();
            switch (slices) {
                case "1/4":
                    q1++;
                    break;
                case "1/2":
                    q2++;
                    break;
                case "3/4":
                    q3++;
                    break;
            }
        }

        // 3/4 ���� ó��
        int pizzas = q3;

        if (q1 >= q3) {
            q1 -= q3;
        }
        else {
            q1 = 0;
        }

        // 1/2 ���� ó��
        pizzas += q2 / 2;

        // 1/2 ������ 1�� ������ 1/4 ���� 2�� ���
        if (q2 % 2 == 1) {
            pizzas += 1;
            q1 = Math.max(0, q1 - 2);
        }

        // ���� 1/4 ���� ó��
        pizzas += q1 / 4;

        if (q1 % 4 != 0) {
            pizzas += 1;
        }

        System.out.println(pizzas);
    }
}
