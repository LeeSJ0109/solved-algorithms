import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SWEA_1865 {
     
    static int N;
    static int[][] probability;
    static boolean[] visited;
     
    static double max;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
             
            probability = new int[N][N];
            visited = new boolean[N];
            max = 0;
             
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    probability[i][j] = Integer.parseInt(st.nextToken());
                }
 
            }
            DFS(0, 100.0);
            System.out.println("#" + t + " " + String.format("%.6f", max));
        }
    }
     
    static void DFS(int depth, double cur) {
        if (cur <= max)
            return;
         
        if (depth == N) {
            max = Math.max(max, cur);
            return;
        }
         
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                DFS(depth + 1, cur * (probability[depth][i] / 100.0));
                visited[i] = false;
            }
        }
    }
}