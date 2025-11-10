import java.io.*;
import java.util.*;

public class BOJ_1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] jewels = new int[N][2];
        int[] C = new int[K]; // 가방에 담을 수 있는 최대 무게

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            jewels[i][0] = M; // 보석의 무게
            jewels[i][1] = V; // 보석의 가격
        }

        for (int i = 0; i < K; i++) {
            C[i] = Integer.parseInt(br.readLine());
        }

        // 보석, 가방 무게순 정렬
        Arrays.sort(jewels, (a, b) -> a[0] - b[0]);
        Arrays.sort(C);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int idx = 0;
        long totalPrice = 0;

        for (int c : C) {
            // 현재 가방에 넣을 수 있는 보석 큐에 추가
            while (idx < N && jewels[idx][0] <= c) {
                pq.add(jewels[idx][1]);
                idx++;
            }

            if (!pq.isEmpty()) {
                totalPrice += pq.poll();
            }
        }

        System.out.println(totalPrice);
    }
}
