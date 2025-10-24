import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1952 {

    static int[] ticketPrices = new int[4];
    static int[] plan = new int[12];
    static int minCost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;



        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                ticketPrices[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 12; i++) {
                plan[i] = Integer.parseInt(st.nextToken());
            }

            // �ʱ� ����� 1�� �̿�� �������� ����
            minCost = ticketPrices[3];

            DFS(0, 0);
            System.out.println("#" + t + " " + minCost);
        }
    }

    static void DFS(int month, int currentCost) {
        // ���� ����� �ּ� ����� �Ѿ� ���� ���� �ּҺ���� �� �� ����
        if (currentCost >= minCost) return;

        // ��� ���� ���� Ž������ ���
        if (month >= 12) {
            minCost = Math.min(minCost, currentCost);
            return;
        }

        // 1�� �̿�ǰ� 1�� �̿�� �� �� ���� ����� �����Ͽ� ����
        DFS(month + 1, currentCost + Math.min(plan[month] * ticketPrices[0], ticketPrices[1]));

        // 3�� �̿�� ����ϴ� ���
        DFS(month + 3, currentCost + ticketPrices[2]);
    }
}
