import java.io.*;
import java.util.*;

public class BOJ_9019 {

    static int start, target;

    static class State {
        int value;
        String commands;

        State(int value, String commands) {
            this.value = value;
            this.commands = commands;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            target = Integer.parseInt(st.nextToken());
            System.out.println(BFS());
        }
    }

    static String BFS() {
        Queue<State> queue = new LinkedList<>();
        boolean[] visited = new boolean[10000];
        queue.add(new State(start, ""));
        visited[start] = true;

        while (!queue.isEmpty()) {
            State cur = queue.poll();
            int value = cur.value;
            String commands = cur.commands;

            if (value == target) {
                return commands;
            }

            // D
            int nextValue = (value * 2) % 10000;
            if (!visited[nextValue]) {
                visited[nextValue] = true;
                queue.add(new State(nextValue, commands + "D"));
            }

            // S
            nextValue = (value == 0) ? 9999 : value - 1;
            if (!visited[nextValue]) {
                visited[nextValue] = true;
                queue.add(new State(nextValue, commands + "S"));
            }

            // L
            nextValue = (value % 1000) * 10 + (value / 1000);
            if (!visited[nextValue]) {
                visited[nextValue] = true;
                queue.add(new State(nextValue, commands + "L"));
            }

            // R
            nextValue = (value % 10) * 1000 + (value / 10);
            if (!visited[nextValue]) {
                visited[nextValue] = true;
                queue.add(new State(nextValue, commands + "R"));
            }
        }

        return "";
    }
}
