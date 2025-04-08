import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_22252 {
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Map<String, PriorityQueue> map = new HashMap<>();
        int Q = Integer.parseInt(br.readLine());

        long totalValue = 0;

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            if (command == 1) {
                int k = Integer.parseInt(st.nextToken());

                map.putIfAbsent(name, new PriorityQueue<>(Collections.reverseOrder()));

                for (int j = 0; j < k; j++) {
                    int info = Integer.parseInt(st.nextToken());
                    map.get(name).add(info);
                }
            }
            else if (command == 2) {
                int k = Integer.parseInt(st.nextToken());

                PriorityQueue<Integer> pq = map.get(name);
                int count = k;
                while (true) {
                    if (pq == null || pq.isEmpty() || count == 0) {
                        break;
                    }
                    totalValue += pq.poll();
                    count--;
                }
            }
        }

        System.out.println(totalValue);
    }
}
