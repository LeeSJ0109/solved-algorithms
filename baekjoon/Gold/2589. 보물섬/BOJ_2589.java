import java.io.*;
import java.util.*;

public class BOJ_2589 {
	
	static int L, W;
	static char[][] map;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		map = new char[L][W];
		for (int i = 0; i < L; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 'L') {
					BFS(i, j);
				}
			}
		}
		
		System.out.println(max);
	}
	
	static void BFS(int i, int j) {
		boolean[][] visited = new boolean[L][W];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {i, j});
		visited[i][j] = true;
		
		int time = -1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for (int s = 0; s < size; s++) {
				int[] cur = queue.poll();
				int x = cur[0];
				int y = cur[1];
				
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if (nx < 0 || nx >= L || ny < 0 || ny >= W) {
						continue;
					}
					
					if (visited[nx][ny] || map[nx][ny] == 'W') {
						continue;
					}
					
					queue.add(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}
			
			time++;
		}
		
		max = Math.max(max, time);
	}
}
