import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2812 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] nums = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]);

        for (int i = 1; i < N; i++) {
            char current = nums[i];

            while (K > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) < current) {
                sb.deleteCharAt(sb.length() - 1);
                K--;
            }

            sb.append(current);
        }

        while (K > 0) {
            sb.deleteCharAt(sb.length() - 1);
            K--;
        }

        System.out.println(sb);
    }
}
