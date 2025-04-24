import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1939 {

    static class Bridge implements Comparable<Bridge> {
        int B; // 목적지 섬
        int C; // 다리의 중량 제한

        Bridge(int B, int C) {
            this.B = B;
            this.C = C;
        }

        @Override
        public int compareTo(Bridge o) {
            return o.C - this.C; // 내림차순
        }
    }

    static int N, M;
    static List<Bridge>[] bridges;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        bridges = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            bridges[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            bridges[A].add(new Bridge(B, C));
            bridges[B].add(new Bridge(A, C));
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int maxWeight = getMaxWeight(A, B);
        System.out.println(maxWeight);
    }

    static int getMaxWeight(int A, int B) {
        PriorityQueue<Bridge> pq = new PriorityQueue<>();
        int[] maxWeight = new int[N + 1];

        Arrays.fill(maxWeight, -1);
        maxWeight[A] = Integer.MAX_VALUE;
        pq.add(new Bridge(A, Integer.MAX_VALUE));

        while (!pq.isEmpty()) {
            Bridge current = pq.poll();

            if (current.B == B) {
                return current.C;
            }

            for (Bridge next : bridges[current.B]) {
                int newWeight = Math.min(current.C, next.C);

                if (newWeight > maxWeight[next.B]) {
                    maxWeight[next.B] = newWeight;
                    pq.add(new Bridge(next.B, newWeight));
                }
            }
        }

        return -1;
    }
}
