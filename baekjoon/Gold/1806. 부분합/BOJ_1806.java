import java.io.*;
import java.util.*;

public class BOJ_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] seq = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;

        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        while (right < N) {
            sum += seq[right];
            right++;

            while (sum >= S) {
                minLength = Math.min(minLength, right - left);
                sum -= seq[left];
                left++;
            }
        }

        System.out.println(minLength == Integer.MAX_VALUE ? 0 : minLength);
    }
}
