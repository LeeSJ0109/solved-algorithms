import java.io.*;
import java.util.*;

public class BOJ_11724 {
	
	static int N, M;
	static List<Integer>[] graph;
	static boolean[] visited;
	
	@SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		visited = new boolean[N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (visited[i]) {
				continue;
			}
			
			BFS(i);
			cnt++;
		}
		
		System.out.println(cnt);
	}
	
	static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (int next : graph[cur]) {
				if (visited[next]) {
					continue;
				}
				
				queue.add(next);
				visited[next] = true;
			}
		}
	}
}
