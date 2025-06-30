import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        // 고속도로에서 나간 지점 기준 정렬
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1])); 
        
        int cam = Integer.MIN_VALUE; // 카메라가 설치된 위치

        for (int[] route : routes) {
            int start = route[0];
            int end = route[1];
            
            if (cam < start) {
                answer++;
                cam = end;
            }
        }
        
        return answer;
    }
}