import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            
            Queue<Integer> queue = new LinkedList<>();
            visited[i] = true;
            queue.add(i);
            
            while (!queue.isEmpty()) {
                int current = queue.poll();
                
                for (int nc = 0; nc < n; nc++) {
                    if (computers[current][nc] == 0 || visited[nc]) {
                        continue;
                    }
                    
                    visited[nc] = true;
                    queue.add(nc);
                }
            }
            
            answer++;
        }
        
        return answer;
    }
}