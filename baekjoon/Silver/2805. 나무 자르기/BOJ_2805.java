import java.io.*;
import java.util.*;

public class BOJ_2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long min = 1;
		long mid = 0;
		long max = 0;
		
		int[] tree = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, tree[i]);
		}
		
		long result = 0;
		
		while (min <= max) {
			long len = 0;
			mid = (min + max) / 2;
			
			for (int i = 0; i < N; i++) {
				len += Math.max(tree[i] - mid, 0);
			}
			
			if (len < M) {
				max = mid - 1;
			}
			else {
				result = mid;
				min = mid + 1;
			}
		}
		
		System.out.println(result);
	}
}
