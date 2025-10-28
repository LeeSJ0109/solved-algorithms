import java.io.*;
import java.util.*;

public class BOJ_20303 {

    static int N, M, K;
    static int[] candy;
    static boolean[] visited;
    static List<List<Integer>> friends = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        candy = new int[N + 1]; // 아이들이 받은 사탕의 수
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            friends.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            candy[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends.get(a).add(b);
            friends.get(b).add(a);
        }

        List<int[]> groupInfos = new ArrayList<>(); // 그룹 정보 (인원 수, 사탕 합)
        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                continue;
            }

            groupInfos.add(getGroupInfo(i));
        }

        int[] dp = new int[K];
        for(int[] groupInfo : groupInfos) {
            int count = groupInfo[0];
            int candy = groupInfo[1];

            for (int i = K - 1; i >= count; i--) {
                dp[i] = Math.max(dp[i], dp[i - count] + candy);
            }
        }

        System.out.println(dp[K - 1]);
    }

    static int[] getGroupInfo(int num) {
        Queue<Integer> queue = new LinkedList<>();
        visited[num] = true;
        queue.add(num);

        int sum = 0; // 사탕의 합
        int count = 0; // 인원 수

        while(!queue.isEmpty()) {
            int current = queue.poll();
            sum += candy[current];
            count++;

            for (int next : friends.get(current)) {
                if (visited[next]) {
                    continue;
                }

                visited[next] = true;
                queue.add(next);
            }
        }

        return new int[]{count, sum};
    }
}
