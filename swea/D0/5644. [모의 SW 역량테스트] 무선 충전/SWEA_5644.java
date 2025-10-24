import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_5644 {
    static int M, A;
    static int[] moveA, moveB;
    static int[][] chargers;

    // �̵����� ����, ��, ��, ��, ��
    static int[] dx = {0, 0, 1, 0, -1};
    static int[] dy = {0, -1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());

            moveA = new int[M + 1];
            moveB = new int[M + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) moveA[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) moveB[i] = Integer.parseInt(st.nextToken());

            chargers = new int[A][4];
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                chargers[i][0] = Integer.parseInt(st.nextToken()); // x ��ǥ
                chargers[i][1] = Integer.parseInt(st.nextToken()); // y ��ǥ
                chargers[i][2] = Integer.parseInt(st.nextToken()); // ����
                chargers[i][3] = Integer.parseInt(st.nextToken()); // ����
            }

            System.out.println("#" + t + " " + getMaxCharge());
        }
    }

    static int getMaxCharge() {
        int totalCharge = 0;
        int[] userA = {1, 1};
        int[] userB = {10, 10};

        for (int t = 0; t <= M; t++) {
            userA[0] += dx[moveA[t]];
            userA[1] += dy[moveA[t]];
            userB[0] += dx[moveB[t]];
            userB[1] += dy[moveB[t]];

            ArrayList<Integer> chargeA = new ArrayList<>();
            ArrayList<Integer> chargeB = new ArrayList<>();

            // A, B�� ���� ����� �� �ִ� �����⸦ ����Ʈ�� ����
            for (int i = 0; i < A; i++) {
                if (isAvailable(userA[0], userA[1], i)) chargeA.add(i);
                if (isAvailable(userB[0], userB[1], i)) chargeB.add(i);
            }

            int maxCharge = 0;

            // A�� B�� ��� �����⸦ ����� �� �ִ� ���
            for (int a : chargeA) {
                for (int b : chargeB) {
                    int charge = chargers[a][3];
                    if (a != b)  charge += chargers[b][3];
                    maxCharge = Math.max(maxCharge, charge);
                }
            }

            // A�� ����� �� �ִ� �����Ⱑ �ִ� ���
            if (!chargeA.isEmpty() && chargeB.isEmpty()) {
                for (int a : chargeA) {
                    maxCharge = Math.max(maxCharge, chargers[a][3]);
                }
            }

            // B�� ����� �� �ִ� �����Ⱑ �ִ� ���
            if (chargeA.isEmpty() && !chargeB.isEmpty()) {
                for (int b : chargeB) {
                    maxCharge = Math.max(maxCharge, chargers[b][3]);
                }
            }

            totalCharge += maxCharge;
        }

        return totalCharge;
    }

    static boolean isAvailable(int x, int y, int i) {
        return Math.abs(chargers[i][0] - x) + Math.abs(chargers[i][1] - y) <= chargers[i][2];
    }
}