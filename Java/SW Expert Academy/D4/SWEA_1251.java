import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class SWEA_1251 {
     
    static class Edge implements Comparable<Edge> {
        int start, end;
        double weight;
         
        Edge(int start, int end, double weight) {
            super();
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
         
        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.weight, o.weight);
        }
    }
     
    static int N, M;
    static int[] parents;
    static int[] islandX;
    static int[] islandY;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            M = N * (N - 1) / 2;
             
            parents = new int[N];
            Arrays.fill(parents, -1);
             
            islandX = new int[N];
            islandY = new int[N];
             
             
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                islandX[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                islandY[i] = Integer.parseInt(st.nextToken());
            }
             
            double E = Double.parseDouble(br.readLine());
             
            Edge[] edges = new Edge[M];
             
            int idx = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    double dx = islandX[i] - islandX[j];
                    double dy = islandY[i] - islandY[j];
                    double cost = dx * dx + dy * dy;
                     
                    edges[idx++] = new Edge(i, j, cost * E);
                }
            }
             
            Arrays.sort(edges);
             
            int cnt = 0;
            double cost = 0;
            for (Edge edge : edges) {
                if(union(edge.start, edge.end)) {
                    cost += edge.weight;
                    if(++cnt == N-1) break;
                }
            }
             
            System.out.println("#" + t + " " + Math.round(cost));
        }
    }
     
    static int find(int a) {
        if (parents[a] < 0) {
            return a;
        }
        else {
            return parents[a] = find(parents[a]);
        }
    }
 
    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
         
        if (aRoot == bRoot) return false;
 
        parents[bRoot] = parents[aRoot];
        parents[aRoot] = bRoot;
        return true;
    }
}