import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1327 {

    static int N, K;
    static String startSequence;
    static String targetSequence;
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        char[] sequence = br.readLine().replaceAll(" ", "").toCharArray();
        char[] sortedSequence = sequence.clone();
        Arrays.sort(sortedSequence);

        startSequence = new String(sequence);
        targetSequence = new String(sortedSequence);

        if (startSequence.equals(targetSequence)) {
            System.out.println(0);
            return;
        }

        BFS();
    }

    static void BFS() {
        Queue<String> queue = new LinkedList<>();
        queue.add(startSequence);
        map.put(startSequence, 0);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            int count = map.get(current);

            for (int i = 0; i + K <= N; i++) {
                StringBuilder sb = new StringBuilder(current.substring(i, i + K));
                String ns = current.substring(0, i) + sb.reverse() + current.substring(i + K);

                if (ns.equals(targetSequence)) {
                    System.out.println(count + 1);
                    return;
                }
                if (map.containsKey(ns)) {
                    continue;
                }

                queue.add(ns);
                map.put(ns, count + 1);
            }
        }

        System.out.println(-1);
    }

}
