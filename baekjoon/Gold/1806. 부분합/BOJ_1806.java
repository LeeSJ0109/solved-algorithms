import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] sequence = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;

        int sum = 0;
        int minCount = Integer.MAX_VALUE;

        while (right < N) {
            sum += sequence[right];
            right++;

            while (sum >= S) {
                minCount = Math.min(minCount, right - left);
                sum -= sequence[left];
                left++;
            }
        }

        System.out.println(minCount == Integer.MAX_VALUE ? 0 : minCount);
    }
}
