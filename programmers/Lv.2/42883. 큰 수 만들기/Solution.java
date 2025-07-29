import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        
        int idx = 0;
        
        // 앞에서부터 (전체길이 - k) 수 중에서 가장 큰 수 선택
        for (int i = 0; i < number.length() - k; i++) {
            char max = 0;
            
            for (int j = idx; j <= i + k; j++) {
                if (max < number.charAt(j)) {
                    max = number.charAt(j);
                    idx = j + 1;
                }
            }
            
            answer.append(max);
        }
        
        return answer.toString();
    }
}