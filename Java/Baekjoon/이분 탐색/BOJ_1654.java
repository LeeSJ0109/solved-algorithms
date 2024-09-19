import java.io.*;
import java.util.*;

public class BOJ_1654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long min = 1;
		long mid = 0;
		long max = 0;
		
		int[] LAN = new int[N];
		for (int i = 0; i < N; i++) {
			LAN[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, LAN[i]);
		}
		
		while (min <= max) {
			int cnt = 0;
			mid = (min + max) / 2;
			
			for (int i = 0; i < N; i++) {
				cnt += LAN[i] / mid;
			}
			
			if (cnt >= K) {
				min = mid + 1;
			}
			else {
				max = mid - 1;
			}
		}
		
		System.out.println(max);
	}
}
