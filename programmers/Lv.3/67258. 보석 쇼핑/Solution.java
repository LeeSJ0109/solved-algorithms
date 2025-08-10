import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {0, 0};
        
        HashSet<String> set = new HashSet<>();
        for (String gem : gems) {
            set.add(gem);
        }
        // 보석의 전체 종류 개수
        int totalTypes = set.size();
        
        Map<String, Integer> map = new HashMap<>();
        
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        
        for (int right = 0; right < gems.length; right++) {
            map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
            
            // 모든 종류의 보석을 포함할 때까지 right 이동
            // 모든 종류의 보석을 포함하면 left를 당겨서 길이 갱신
            while (map.size() == totalTypes) {
                map.put(gems[left], map.get(gems[left]) - 1);
                
                if (map.get(gems[left]) == 0) {
                    map.remove(gems[left]);
                }
                
                if (right - left < minLength) {
                    minLength = right - left;
                    answer[0] = left + 1;
                    answer[1] = right + 1;
                }
                
                left++;
            }
        }
        
        return answer;
    }
}