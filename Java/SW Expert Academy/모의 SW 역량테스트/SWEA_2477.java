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

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 접수 창구 수
            int M = Integer.parseInt(st.nextToken()); // 정비 창구 수
            int K = Integer.parseInt(st.nextToken()); // 고객 수
            int A = Integer.parseInt(st.nextToken()); // 고객이 이용한 접수 창구 번호
            int B = Integer.parseInt(st.nextToken()); // 고객이 이용한 정비 창구 번호

            int[] receptionTime = new int[N + 1];   // 접수 창구가 고장을 접수하는 데 걸리는 시간
            int[] repairTime = new int[M + 1];      // 정비 창구가 차량을 정비하는 데 걸리는 시간
            int[] arrivalTimes = new int[K + 1];    // 고객이 차량 정비소를 방문하는 시간

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

            Queue<Customer> receptionQueue = new LinkedList<>(); // 접수 대기큐
            Queue<Customer> repairQueue = new LinkedList<>();    // 정비 대기큐
            Customer[] receptionDesks = new Customer[N + 1];     // 접수 창구 상태
            Customer[] repairDesks = new Customer[M + 1];        // 정비 창구 상태

            int time = 0; // 현재 시간
            int finishedCustomers = 0; // 정비를 마친 고객 수
            int sum = 0;

            while (finishedCustomers < K) {
                // 1. 도착한 고객을 접수 대기열에 추가
                for (int i = 1; i <= K; i++) {
                    if (customers[i].arrivalTime == time) {
                        receptionQueue.offer(customers[i]);
                    }
                }

                // 2. 접수 창구에서 고객 처리
                for (int i = 1; i <= N; i++) {
                    if (receptionDesks[i] != null) {
                        // 접수 중인 고객이 있는 경우
                        if (time - receptionDesks[i].arrivalTime == receptionTime[i]) {
                            // 접수 완료, 정비 대기열로 이동
                            receptionDesks[i].arrivalTime = time;
                            repairQueue.offer(receptionDesks[i]);
                            receptionDesks[i] = null;
                        }
                    }

                    // 비어있는 접수 창구가 있고 대기 중인 고객이 있으면 배정
                    if (receptionDesks[i] == null && !receptionQueue.isEmpty()) {
                        Customer customer = receptionQueue.poll();
                        customer.receptionDesk = i;
                        customer.arrivalTime = time;
                        receptionDesks[i] = customer;
                    }
                }

                // 3. 정비 창구에서 고객 처리
                for (int i = 1; i <= M; i++) {
                    if (repairDesks[i] != null) {
                        // 정비 중인 고객이 있는 경우
                        if (time - repairDesks[i].arrivalTime == repairTime[i]) {
                            // 정비 완료
                            finishedCustomers++;
                            if (repairDesks[i].receptionDesk == A && i == B) {
                                sum += repairDesks[i].id;
                            }
                            repairDesks[i] = null;
                        }
                    }

                    // 비어있는 정비 창구가 있고 대기 중인 고객이 있으면 배정
                    if (repairDesks[i] == null && !repairQueue.isEmpty()) {
                        Customer customer = repairQueue.poll();
                        customer.repairDesk = i;
                        customer.arrivalTime = time;
                        repairDesks[i] = customer;
                    }
                }

                time++;
            }

            // 결과 출력
            System.out.println("#" + t + " " + (sum == 0 ? -1 : sum));
        }
    }
}
