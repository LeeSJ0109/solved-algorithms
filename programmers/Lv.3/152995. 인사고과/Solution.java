import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] wanhoScore = scores[0];
        
        // 근무태도 내림차순, 동료평가 오름차순
        Arrays.sort(scores, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        
        int rank = 1;
        int maxScore = scores[0][1];
        
        for (int[] score : scores) {
            // 인센티브를 받지 못하는 경우
            if (score[1] < maxScore) {
                // 완호 점수인 경우
                if (score == wanhoScore) {
                    return -1;
                }
            }
            else {
                // 완호보다 점수가 높은 경우
                if (score[0] + score[1] > wanhoScore[0] + wanhoScore[1]) {
                    rank++;
                }
                
                maxScore = score[1];
            }
        }
        
        return rank;
    }
}