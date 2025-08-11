import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        // 캘 수 있는 최대 구간 수
        int maxParts = Math.min(minerals.length / 5 + 1, picks[0] + picks[1] + picks[2]);
        
        int parts[][] = new int[maxParts][3];
        for(int i = 0; i < minerals.length && i / 5 < maxParts; i++) {
            String mineral = minerals[i];
            
            if (mineral.equals("diamond")) {
                parts[i / 5][0]++;
            }
            else if (mineral.equals("iron")) {
                parts[i / 5][1]++;
            }
            else {
                parts[i / 5][2]++;
            }
        }
        
        // 다이아 > 철 > 돌 많은 순 정렬
        Arrays.sort(parts, (a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            }
            if (a[1] != b[1]) {
                return b[1] - a[1];
            }
            return b[2] - a[2];
        });

        int index = 0;
        for (int i = 0; i < maxParts; i++) {
            while (index < 3 && picks[index] == 0) {
                index++;
            }
            if (index == 3) {
                break;
            }
            
            int diamond = parts[i][0];
            int iron = parts[i][1];
            int stone = parts[i][2];
            
            if (index == 0) {
                answer += diamond + iron + stone;
            }
            else if (index == 1) {
                answer += 5 * diamond + iron + stone;
            }
            else {
                answer += 25 * diamond + 5 * iron + stone;
            }
            
            picks[index]--;
        }
        
        return answer;
    }
}