import java.io.*;
import java.util.*;

public class BOJ_14002 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		
		for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
		
		int max = 0;
        for (int length : dp) {
        	max = Math.max(max, length);
        }

        System.out.println(max);
        
        ArrayList<Integer> list = new ArrayList<>();

        int idx = max;
        for (int i = N - 1; i >= 0; i--) {
			if (dp[i] == idx) {
				list.add(A[i]);
				idx--;
			}
        }
        
        for (int i = max - 1; i >= 0; i--) {
        	System.out.print(list.get(i) + " ");
		}
	}

}
