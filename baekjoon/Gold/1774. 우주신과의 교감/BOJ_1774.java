import java.io.*;
import java.util.*;

public class BOJ_1774 {

    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int from, to;
        double distance;

        public Edge(int from, int to, double distance) {
            this.from = from;
            this.to = to;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.distance, o.distance);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        double[][] coordinates = new double[N + 1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            coordinates[i][0] = Double.parseDouble(st.nextToken());
            coordinates[i][1] = Double.parseDouble(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        List<Edge> edges = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                double dx = coordinates[i][0] - coordinates[j][0];
                double dy = coordinates[i][1] - coordinates[j][1];
                double distance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));

                edges.add(new Edge(i, j, distance));
            }
        }

        Collections.sort(edges);

        int count = 0;
        double minDistance = 0;

        for (Edge edge : edges) {
            if (find(edge.to) != find(edge.from)) {
                union(edge.to, edge.from);
                minDistance += edge.distance;
            }

            if (count == N - 1) {
                break;
            }
        }

        System.out.printf("%.2f\n", minDistance);
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);  // 경로 압축
        }
        return parent[x];
    }

    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootY] = rootX;  // 트리 합치기
        }
    }
}
