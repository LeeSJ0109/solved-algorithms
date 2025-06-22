import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Arrays.sort(weights);
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int weight : weights) {
            // 1 : 1
            answer += map.getOrDefault(weight, 0);
            
            // 2 : 1
            if (weight % 2 == 0) {
                answer += map.getOrDefault(weight / 2, 0);
            }
            
            // 3 : 2
            if ((weight * 2) % 3 == 0) {
                answer += map.getOrDefault((weight * 2) / 3, 0);
            }
            
            // 4 : 3
            if ((weight * 3) % 4 == 0) {
                answer += map.getOrDefault((weight * 3) / 4, 0);
            }
            
            map.put(weight, map.getOrDefault(weight, 0) + 1);
        }
        
        
        return answer;
    }
}