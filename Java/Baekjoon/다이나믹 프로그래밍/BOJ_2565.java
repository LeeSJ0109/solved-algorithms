import java.io.*;
import java.util.*;

public class BOJ_2565 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] sequence = new int[N];
		
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list.add(new int[] {A, B});
		}
		
		Collections.sort(list, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		
		for (int i = 0; i < N; i++) {
			sequence[i] = list.get(i)[1];
		}
		
//		System.out.println(Arrays.toString(sequence));
		
		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		
		for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (sequence[j] < sequence[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
		
		int max = 0;
        for (int length : dp) {
        	max = Math.max(max, length);
        }

        System.out.println(N - max);
	}
}
