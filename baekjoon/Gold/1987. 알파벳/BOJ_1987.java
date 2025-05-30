import java.io.*;
import java.util.*;

public class BOJ_1987 {
	
	static int R, C;
	static char[][] board;
	static boolean[][] visited;
	
	static boolean[] isUsed = new boolean[26];
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = line.charAt(j);
			}
		}
		
		visited[0][0] = true;
		isUsed[board[0][0] - 'A'] = true;
		DFS(0, 0, 1);
		System.out.println(max);
	}
	
	static void DFS(int x, int y, int cnt) {
		max = Math.max(max, cnt);
		
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
				continue;
			}
			
			if (visited[nx][ny]) {
				continue;
			}
			
			if (isUsed[board[nx][ny] - 'A']) {
				continue;
			}
			
			visited[nx][ny] = true;
			isUsed[board[nx][ny] - 'A'] = true;
			DFS(nx, ny, cnt + 1);
			visited[nx][ny] = false;
			isUsed[board[nx][ny] - 'A'] = false;
		}
	}
}
