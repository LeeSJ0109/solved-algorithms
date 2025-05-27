import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10942 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] isPalindrome = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            isPalindrome[i][i] = true;
        }

        for (int i = 1; i <= N - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                isPalindrome[i][i + 1] = true;
            }
        }

        // 길이 3이상
        for (int len = 3; len <= N; len++) {
            for (int start = 1; start + len - 1 <= N; start++) {
                int end = start + len - 1;
                if (nums[start] == nums[end] && isPalindrome[start + 1][end - 1]) {
                    isPalindrome[start][end] = true;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            sb.append(isPalindrome[S][E] ? 1 : 0).append("\n");
        }

        System.out.println(sb);
    }
}
