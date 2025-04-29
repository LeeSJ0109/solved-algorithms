import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600 {
	
	static int K, W, H;
	static int[][] map;
	static boolean[][][] visited;
	
	static int[] dxHorse = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dyHorse = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		visited = new boolean[H][W][K+1];
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(BFS());
	}
	
	static int BFS() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0, K, 0});
		visited[0][0][K] = true;
		
		while (!queue.isEmpty()) {
			int x = queue.peek()[0];
			int y = queue.peek()[1];
			int z = queue.peek()[2];
			int cnt = queue.poll()[3];
			
			if (x == H - 1 && y == W - 1) {
				return cnt;
			}
			
			if (z - 1 >= 0) {
				for (int d = 0; d < 8; d++) {
					int nx = x + dxHorse[d];
					int ny = y + dyHorse[d];
					
					if (nx < 0 || ny < 0 || nx >= H || ny >= W) {
						continue;
					}
					if (visited[nx][ny][z - 1] || map[nx][ny] == 1) {
						continue;
					}
					visited[nx][ny][z - 1] = true;
					queue.add(new int[] {nx, ny, z - 1, cnt + 1});
				}
			}
			
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if (nx < 0 || ny < 0 || nx >= H || ny >= W) {
					continue;
				}
				if (visited[nx][ny][z] || map[nx][ny] == 1) {
					continue;
				}
				visited[nx][ny][z] = true;
				queue.add(new int[] {nx, ny, z, cnt + 1});
//				System.out.println(nx + " " + ny + " " + z);
			}
		}
		
		return -1;
	}
}