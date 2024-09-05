import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_5643 {

    static int N, M;
    static ArrayList<Integer>[] taller;
    static ArrayList<Integer>[] shorter;
    static boolean[] visited;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            taller = new ArrayList[N + 1];
            shorter = new ArrayList[N + 1];

            for (int i = 1; i <= N; i++) {
                taller[i] = new ArrayList<>();
                shorter[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                taller[a].add(b);
                shorter[b].add(a);
            }

            int count = 0;
            for (int i = 1; i <= N; i++) {
                visited = new boolean[N + 1];
                int tallCount = DFS(i, taller);

                visited = new boolean[N + 1];
                int shortCount = DFS(i, shorter);

                if (tallCount + shortCount == N - 1) {
                    count++;
                }
            }

            System.out.println("#" + t + " " + count);
        }

    }

    static int DFS(int studentNum, ArrayList<Integer>[] student) {
        visited[studentNum] = true;
        int count = 0;

        for (int nextStudent : student[studentNum]) {
            if(!visited[nextStudent]) {
                count += DFS(nextStudent, student) + 1;
            }
        }

        return count;
    }
}
