import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SWEA_1247 {
     
    static int N;
    static int[][] pos;
    static boolean[] visited;
     
    static int min;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            pos = new int[N + 2][2];
            visited = new boolean[N + 2];
             
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N + 2; i++) {
                pos[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            }
             
            min = Integer.MAX_VALUE;
            DFS(0, 0, 0);
             
            System.out.println("#" + t + " " + min);
        }
    }
     
    static void DFS(int current, int count, int sum) {
        if (sum >= min) return;
         
        if (count == N) {
            sum += Math.abs(pos[current][0] - pos[1][0]) + Math.abs(pos[current][1] - pos[1][1]);
            min = Math.min(min, sum);
            return;
        }
         
        for (int i = 2; i < N + 2; i++) {
            if(!visited[i]) {
                visited[i] = true;
                DFS(i, count + 1, sum + Math.abs(pos[current][0] - pos[i][0]) + Math.abs(pos[current][1] - pos[i][1]));
                visited[i] = false;
            }
        }
    }
}