import java.io.*;
import java.util.*;

public class BOJ_1613 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		boolean[][] event = new boolean[n + 1][n + 1];
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int before = Integer.parseInt(st.nextToken());
			int after = Integer.parseInt(st.nextToken());
			
			event[before][after] = true;
		}
		
		for (k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (!event[i][j] && (event[i][k] && event[k][j])) {
						event[i][j] = true;
					}
				}
			}
		}
		
		int s = Integer.parseInt(br.readLine());
		for (int i = 0; i < s; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (event[a][b]) {
				System.out.println(-1);
			}
			else if (event[b][a]) {
				System.out.println(1);
			}
			else {
				System.out.println(0);
			}
		}
	}
}
