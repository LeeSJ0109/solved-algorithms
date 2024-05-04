import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9019_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            System.out.println(BFS(A, B));
        }

    }

    static String BFS(int S, int E) {
        Queue<Integer> valueQueue = new LinkedList<>();
        Queue<String> cmdQueue = new LinkedList<>();
        boolean[] visited = new boolean[10000];
        visited[S] = true;
        valueQueue.add(S);
        cmdQueue.add("");

        while (!valueQueue.isEmpty()) {
            int value = valueQueue.poll();
            String cmd = cmdQueue.poll();

            if (value == E) {
                return cmd;
            }

            // D
            int nValue = (value * 2) % 10000;
            if (!visited[nValue]) {
                visited[nValue] = true;
                valueQueue.add(nValue);
                cmdQueue.add(cmd + "D");
            }
            // S
            nValue = (value == 0) ? 9999 : value - 1;
            if (!visited[nValue]) {
                visited[nValue] = true;
                valueQueue.add(nValue);
                cmdQueue.add(cmd + "S");
            }
            // L
            nValue = (value % 1000) * 10 + value / 1000;
            if (!visited[nValue]) {
                visited[nValue] = true;
                valueQueue.add(nValue);
                cmdQueue.add(cmd + "L");
            }
            // R
            nValue = (value % 10) * 1000 + (value / 10);
            if (!visited[nValue]) {
                visited[nValue] = true;
                valueQueue.add(nValue);
                cmdQueue.add(cmd + "R");
            }
        }

        return null;
    }
}
