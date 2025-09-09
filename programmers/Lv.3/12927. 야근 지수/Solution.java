import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        int sum = 0;
        
        for (int work : works) {
            sum += work;
        }
        
        if (sum <= n) {
            return 0;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        long answer = 0;
        
        for (int work : works) {
            pq.add(work);
        }
        
        for (int i = 0; i < n; i++) {
            pq.add(pq.poll() - 1);
        }
        
        while (!pq.isEmpty()) {
            long work = pq.poll();
            
            if (work == 0) {
                break;
            }
            
            answer += work * work;
        }
        
        return answer;
    }
}