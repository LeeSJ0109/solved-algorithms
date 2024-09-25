import java.io.*;
import java.util.*;

public class BOJ_2206 {
	
	static int N, M;
	static char map[][];
	static boolean visited[][][];
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		visited = new boolean[N][M][2];
		
		System.out.println(BFS());
	}
	
	static int BFS() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0, 1});
		visited[0][0][1] = true;
		
		int moveCnt = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				int[] cur = queue.poll();
				int x = cur[0];
				int y = cur[1];
				int cnt = cur[2];
				
				if (x == N - 1 && y == M - 1) {
					return moveCnt;
				}
				
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
						continue;
					}
					
					if (visited[nx][ny][cnt]) {
						continue;
					}
					
					if (map[nx][ny] == '1') {
						if (cnt == 0) {
							continue;
						}
						else {
							queue.add(new int[] {nx, ny, cnt - 1});
							visited[nx][ny][cnt - 1] = true;
						}
					}
					else {
						queue.add(new int[] {nx, ny, cnt});
						visited[nx][ny][cnt] = true;
					}
				}
			}
			
			moveCnt++;
		}
		
		return -1;
	}
}
