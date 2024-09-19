import java.io.*;
import java.util.*;

public class BOJ_2606 {
	
	static int N, M;
	static List<Integer>[] graph;

	@SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

		System.out.println(BFS());
	}
	
	static int BFS() {
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visited[1] = true;
		
		int cnt = 0;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (int next : graph[cur]) {
				if (visited[next]) {
					continue;
				}
				
				queue.add(next);
				visited[next] = true;
				cnt++;
			}
		}
		
		return cnt;
	}
}
