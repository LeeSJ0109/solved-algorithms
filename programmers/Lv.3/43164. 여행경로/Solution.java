import java.util.*;

class Solution {
    
    static int N;
    static String[] route;
    static boolean[] visited;

    static boolean finished = false;
    
    public String[] solution(String[][] tickets) {  
        N = tickets.length;
        visited = new boolean[N];
        route = new String[N + 1];
        
        // 티켓 정렬
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        
        // 항상 "ICN" 공항에서 출발
        route[0] = "ICN";
        DFS("ICN", tickets, 0);
        
        return route;
    }
    
    void DFS(String airport, String[][] tickets, int count) {
        if (count == N) {
            finished = true;
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (!visited[i] && airport.equals(tickets[i][0])) {
                visited[i] = true;
                route[count + 1] = tickets[i][1];
                DFS(tickets[i][1], tickets, count + 1);
                
                if (finished) {
                    return;
                }
                
                visited[i] = false;
            }
        }
    }
}