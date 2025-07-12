import java.util.*;

class Solution {
    
    static int N, M;
    static boolean[] visited;
    static String[] userId, bannedId;
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        N = user_id.length;
        M = banned_id.length;
        visited = new boolean[N];
        
        userId = user_id;
        bannedId = banned_id;
        
        DFS(0, 0);
        
        return set.size();
    }
    
    void DFS(int depth, int state) {
         if (depth == M) {
             set.add(state);
             return;
         }
        
        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            if (!isMatch(userId[i], bannedId[depth])) {
                continue;
            }
            
            visited[i] = true;
            DFS(depth + 1, state | (1 << i));
            visited[i] = false;
        }
    }
    
    boolean isMatch(String user_id, String banned_id) {
        if (user_id.length() != banned_id.length()) {
            return false;
        }
        
        for (int i = 0; i < user_id.length(); i++) {
            if (banned_id.charAt(i) == '*') {
                continue;
            } 
            
            if (banned_id.charAt(i) != user_id.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
}