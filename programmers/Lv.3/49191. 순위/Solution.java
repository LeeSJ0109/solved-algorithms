import java.util.*;

class Solution {
    
    static int N;
    static Map<Integer, List<Integer>> win = new HashMap<>();
    static Map<Integer, List<Integer>> lose = new HashMap<>();
    
    public int solution(int n, int[][] results) {
        N = n;
        
        for (int i = 1; i <= n; i++) {
            win.put(i, new ArrayList<>());
            lose.put(i, new ArrayList<>());
        }
        
        for (int[] result : results) {
            win.get(result[0]).add(result[1]);
            lose.get(result[1]).add(result[0]);
        }
        
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            int winCount = BFS(i, true); // 이긴 경우
            int loseCount = BFS(i, false); // 진 경우
            
            if (winCount + loseCount == N - 1) {
                answer++;
            }
        }
        
        return answer;
    }
    
    int BFS(int start, boolean isWin) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        visited[start] = true;
        queue.add(start);
        
        int count = 0;
        while(!queue.isEmpty()) {
            int current = queue.poll();
            List<Integer> nextList = isWin ? win.get(current) : lose.get(current);
            
            for (int next : nextList) {
                if (visited[next]) {
                    continue;
                }
                
                visited[next] = true;
                queue.add(next);
                count++;
            }
        }
        
        return count;
    }
}