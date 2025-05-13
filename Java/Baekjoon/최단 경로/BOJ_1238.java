import java.io.*;
import java.util.*;

public class BOJ_1238 {

    static class Road implements Comparable<Road> {
        int to, time;

        Road(int to, int time) {
            this.to = to;
            this.time = time;
        }

        public int compareTo(Road o) {
            return this.time - o.time;
        }
    }

    static int N, M, X;
    static List<Road>[] forwardRoads, reverseRoads;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 학생(마을) 수
        M = Integer.parseInt(st.nextToken()); // 도로 수
        X = Integer.parseInt(st.nextToken()); // 파티 마을

        forwardRoads = new List[N + 1]; // 정방향 도로
        reverseRoads = new List[N + 1]; // 역방향 도로

        for (int i = 1; i <= N; i++) {
            forwardRoads[i] = new ArrayList<>();
            reverseRoads[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            forwardRoads[B].add(new Road(A, T));
            reverseRoads[A].add(new Road(B, T));
        }

        // 파티에서 돌아오는 시간 (X -> i)
        int[] forwardTimes = dijkstra(true);
        // 파티에 참석하는 시간 (i -> X)
        int[] reverseTimes = dijkstra(false);

        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            maxTime = Math.max(maxTime, forwardTimes[i] + reverseTimes[i]);
        }

        System.out.println(maxTime);
    }

    static int[] dijkstra(boolean toParty) {
        List<Road>[] roads = toParty ? forwardRoads : reverseRoads;

        int[] time = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Road> pq = new PriorityQueue<>();

        Arrays.fill(time, Integer.MAX_VALUE);
        pq.add(new Road(X, 0));
        time[X] = 0;

        while (!pq.isEmpty()) {
            Road current = pq.poll();

            if (visited[current.to]) {
                continue;
            }
            visited[current.to] = true;

            for (Road next : roads[current.to]) {
                if (time[next.to] > time[current.to] + next.time) {
                    time[next.to] = time[current.to] + next.time;
                    pq.add(new Road(next.to, time[next.to]));
                }
            }
        }

        return time;
    }
}
