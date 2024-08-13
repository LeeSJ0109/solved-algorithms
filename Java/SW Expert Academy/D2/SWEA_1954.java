import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1954 {
	static int[][] snail;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		for (int t = 1; t <= T; t++) {
			System.out.println("#" + t);
			int N = Integer.parseInt(br.readLine());
			snail = new int[N][N];
			
			int d = 0;
			int x = 0, y = 0, cnt = 1;
			while (cnt <= N*N) {
				snail[x][y] = cnt;
				
				int nx = x + dx[d];
                int ny = y + dy[d];
				
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || snail[nx][ny] != 0) 
                    d = (d + 1) % 4;
                
				x = x + dx[d];
				y = y + dy[d];
				cnt ++;
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
