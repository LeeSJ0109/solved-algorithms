import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0, sum2 = 0;
        
        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        
        if ((sum1 + sum2) % 2 == 1) {
            return -1;
        }
        
        int count = 0;
        int limit = queue1.length * 3;
        
        while (count < limit) {
            if (sum1 == sum2) {
                return count;
            }
            
            if (sum1 > sum2) {
                int value = q1.poll();
                sum1 -= value;
                sum2 += value;
                q2.add(value);
            }
            else {
                int value = q2.poll();
                sum1 += value;
                sum2 -= value;
                q1.add(value);
            }
            
            count++;
        }
        
        return -1;
    }
}