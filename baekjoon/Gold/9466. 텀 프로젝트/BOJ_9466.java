import java.io.*;
import java.util.*;

public class BOJ_9466 {

    static int N;
    static int count;
    static int[] select;
    static boolean[] visited, finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            count = 0;
            select = new int[N + 1];
            visited = new boolean[N + 1];
            finished = new boolean[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                select[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                setTeam(i);
            }

            System.out.println(N - count);
        }
    }

    static void setTeam(int current) {
        if (visited[current]) {
            return;
        }

        visited[current] = true;
        int next = select[current];

        if (!visited[next]) {
            // 처음 방문하는 경우 -> 계속 진행
            setTeam(next);
        }
        else {
            // 이미 방문한 경우 -> 사이클 발생
            if (!finished[next]) {
                for (int i = next; i != current; i = select[i]) {
                    count++;
                }

                count++;
            }
        }

        finished[current] = true;
    }
}
