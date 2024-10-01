import java.io.*;
import java.util.*;

public class SWEA_3282 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] items = new int[N + 1][2];
			for (int i = 1; i < N + 1; i++) {
				st = new StringTokenizer(br.readLine());
				int w = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				items[i] = new int[] {v, w};
			}
			
			int[][] Knapsack = new int[N + 1][K + 1];
			
			for (int i = 1; i < N + 1; i++) {
				for (int w = 1; w < K + 1; w++) {
					if (items[i][1] > w) {
						Knapsack[i][w] = Knapsack[i - 1][w];
					}
					else {
						Knapsack[i][w] = Math.max(items[i][0] + Knapsack[i - 1][w - items[i][1]],
								Knapsack[i - 1][w]);
					}
				}
			}
			
			System.out.println("#" + t + " " + Knapsack[N][K]);
		}
	}
}
