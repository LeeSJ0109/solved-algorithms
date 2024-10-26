import java.io.*;

public class BOJ_1058 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		char[][] friends = new char[N][N];
		for (int i = 0; i < N; i++) {
			friends[i] = br.readLine().toCharArray();
		}
		
		int[][] reachable = new int[N][N];
		
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j) {
						continue;
					}
					if (friends[i][j] == 'Y' || (friends[i][k] == 'Y' && friends[k][j] == 'Y')) {
						reachable[i][j] = 1;
					}
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				if (reachable[i][j] == 1) {
					sum++;
				}
			}
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}
}
