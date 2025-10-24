import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Customer {
    int id, arrivalTime, receptionDesk, repairDesk;

    Customer(int id, int arrivalTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.receptionDesk = -1;
        this.repairDesk = -1;
    }
}

public class SWEA_2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // �׽�Ʈ ���̽� ��

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // ���� â�� ��
            int M = Integer.parseInt(st.nextToken()); // ���� â�� ��
            int K = Integer.parseInt(st.nextToken()); // �� ��
            int A = Integer.parseInt(st.nextToken()); // ���� �̿��� ���� â�� ��ȣ
            int B = Integer.parseInt(st.nextToken()); // ���� �̿��� ���� â�� ��ȣ

            int[] receptionTime = new int[N + 1];   // ���� â���� ������ �����ϴ� �� �ɸ��� �ð�
            int[] repairTime = new int[M + 1];      // ���� â���� ������ �����ϴ� �� �ɸ��� �ð�
            int[] arrivalTimes = new int[K + 1];    // ���� ���� ����Ҹ� �湮�ϴ� �ð�

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) receptionTime[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) repairTime[j] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int k = 1; k <= K; k++) arrivalTimes[k] = Integer.parseInt(st.nextToken());

            Customer[] customers = new Customer[K + 1];
            for (int i = 1; i <= K; i++) {
                customers[i] = new Customer(i, arrivalTimes[i]);
            }

            Queue<Customer> receptionQueue = new LinkedList<>(); // ���� ���ť
            Queue<Customer> repairQueue = new LinkedList<>();    // ���� ���ť
            Customer[] receptionDesks = new Customer[N + 1];     // ���� â�� ����
            Customer[] repairDesks = new Customer[M + 1];        // ���� â�� ����

            int time = 0; // ���� �ð�
            int finishedCustomers = 0; // ���� ��ģ �� ��
            int sum = 0;

            while (finishedCustomers < K) {
                // 1. ������ ���� ���� ��⿭�� �߰�
                for (int i = 1; i <= K; i++) {
                    if (customers[i].arrivalTime == time) {
                        receptionQueue.offer(customers[i]);
                    }
                }

                // 2. ���� â������ �� ó��
                for (int i = 1; i <= N; i++) {
                    if (receptionDesks[i] != null) {
                        // ���� ���� ���� �ִ� ���
                        if (time - receptionDesks[i].arrivalTime == receptionTime[i]) {
                            // ���� �Ϸ�, ���� ��⿭�� �̵�
                            receptionDesks[i].arrivalTime = time;
                            repairQueue.offer(receptionDesks[i]);
                            receptionDesks[i] = null;
                        }
                    }

                    // ����ִ� ���� â���� �ְ� ��� ���� ���� ������ ����
                    if (receptionDesks[i] == null && !receptionQueue.isEmpty()) {
                        Customer customer = receptionQueue.poll();
                        customer.receptionDesk = i;
                        customer.arrivalTime = time;
                        receptionDesks[i] = customer;
                    }
                }

                // 3. ���� â������ �� ó��
                for (int i = 1; i <= M; i++) {
                    if (repairDesks[i] != null) {
                        // ���� ���� ���� �ִ� ���
                        if (time - repairDesks[i].arrivalTime == repairTime[i]) {
                            // ���� �Ϸ�
                            finishedCustomers++;
                            if (repairDesks[i].receptionDesk == A && i == B) {
                                sum += repairDesks[i].id;
                            }
                            repairDesks[i] = null;
                        }
                    }

                    // ����ִ� ���� â���� �ְ� ��� ���� ���� ������ ����
                    if (repairDesks[i] == null && !repairQueue.isEmpty()) {
                        Customer customer = repairQueue.poll();
                        customer.repairDesk = i;
                        customer.arrivalTime = time;
                        repairDesks[i] = customer;
                    }
                }

                time++;
            }

            // ��� ���
            System.out.println("#" + t + " " + (sum == 0 ? -1 : sum));
        }
    }
}
