import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2001 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (j != 0)
						arr[i][j] += arr[i][j-1];
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i != 0)
						arr[i][j] += arr[i-1][j];
				}
			}
			
			int max = Integer.MIN_VALUE;
			for (int i = M-1; i < N; i++) {
				for (int j = M-1; j < N; j++) {
					int sum = arr[i][j];
					if (i >= M)
                        sum -= arr[i-M][j];
                    if (j >= M)
                        sum -= arr[i][j-M];
                    if (i >= M && j >= M)
                        sum += arr[i-M][j-M];
                    
					max = Math.max(max, sum);
				}
			}
			
			System.out.println("#" + t + " " + max);
		}
	}
}
