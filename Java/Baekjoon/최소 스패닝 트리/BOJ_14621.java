import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14621 {

    static class Road implements Comparable<Road> {
        int to;
        int distance;

        Road(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }

        @Override
        public int compareTo(Road o) {
            return this.distance - o.distance;
        }
    }

    static int N, M;
    static char[] univInfo;
    static List<Road>[] roads;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        univInfo = new char[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            univInfo[i] = st.nextToken().charAt(0);
        }

        roads = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            roads[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if (univInfo[u] == univInfo[v]) {
                continue;
            }

            roads[u].add(new Road(v, d));
            roads[v].add(new Road(u, d));
        }

        int distance = getDistance();
        System.out.println(distance);
    }

    static int getDistance() {
        PriorityQueue<Road> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        pq.add(new Road(1, 0));

        int count = 0;
        int distance = 0;
        while (!pq.isEmpty()) {
            Road current = pq.poll();

            if (visited[current.to]) {
                continue;
            }

            visited[current.to] = true;
            distance += current.distance;
            count++;

            if (count == N) {
                return distance;
            }

            for (Road road : roads[current.to]) {
                if (visited[road.to]) {
                    continue;
                }

                pq.add(road);
            }
        }

        return -1;
    }
}
