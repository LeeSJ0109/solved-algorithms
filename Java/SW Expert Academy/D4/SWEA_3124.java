import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class SWEA_3124 {
     
    static class Edge implements Comparable<Edge> {
        int start, end, weight;
         
        Edge(int start, int end, int weight) {
            super();
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
         
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
     
    static int V;
    static int[] parents;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
             
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
             
            parents = new int[V + 1];
            Edge[] edges = new Edge[E];
             
            Arrays.fill(parents, -1);
             
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                 
                edges[i] = new Edge(A, B, C);
            }
             
            Arrays.sort(edges);
             
            int cnt = 0;
            long cost = 0;
            for (Edge edge : edges) {
                if(union(edge.start, edge.end)) {
                    cost += edge.weight;
                    if(++cnt == V-1) break;
                }
            }
             
            System.out.println("#" + t + " " + cost);
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