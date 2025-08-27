import java.util.*;

class Solution {
    
    static class State {
        String word;
        int count;
        
        State(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        Set<String> set = new HashSet<>();
        
        for (String word : words) {
            set.add(word);
        }
        
        if (!set.contains(target)) {
            return 0;
        }
        
        int N = words.length;
        boolean[] visited = new boolean[N];
        
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(begin, 0));
        
        while(!queue.isEmpty()) {
            State current = queue.poll();
            String word = current.word;
            int count = current.count;
            
            if (word.equals(target)) {
                return count;
            }
            
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    continue;
                }
                if (!isConvertible(word, words[i])) {
                    continue;
                }
                
                visited[i] = true;
                queue.add(new State(words[i], count + 1));
            }
        }
        
        return 0;
    }
    
    boolean isConvertible(String w1, String w2) {
        int count = 0;
            
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                count++;
            }
            
            if (count == 2) {
                return false;
            }
        }
            
        return true;
    }
}