import java.io.*;
import java.util.*;

public class BOJ_7576 {
	
	static int N, M;
	static int[][] tomato;
	static boolean[][] visited;
	static Queue<int[]> queue;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		tomato = new int[N][M];
		visited = new boolean[N][M];
		queue = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if (tomato[i][j] == 1) {
					queue.add(new int[] {i, j});
					visited[i][j] = true;
				}
			}
		}
		
		System.out.println(BFS());
	}
	
	static int BFS() {
		int days = -1;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int x = queue.peek()[0];
				int y = queue.poll()[1];
				
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
						continue;
					}
					
					if (visited[nx][ny] || tomato[nx][ny] == -1) {
						continue;
					}
					
					queue.add(new int[] {nx, ny});
					visited[nx][ny] = true;
					tomato[nx][ny] = 1;
				}
			}
			
			days++;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomato[i][j] == 0) {
					return -1;
				}
			}
		}
		
		return days;
	}
}
