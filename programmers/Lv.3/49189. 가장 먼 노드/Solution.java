import java.util.*;

class Solution {
    @SuppressWarnings("unchecked")
    public int solution(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n + 1];
        
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        
        visited[1] = true;
        queue.add(1);
        
        int size = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                
                for (int next : graph[current]) {
                    if (visited[next]) {
                        continue;
                    }

                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        
        return size;
    }
}