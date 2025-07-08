import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int N = routes.length; // 로봇의 수
        int[] idx = new int[N]; // 로봇의 현재 경로 
        int[][] pos = new int[N][2]; // 로봇의 현재 위치
        boolean[] arrive = new boolean[N]; // 로봇의 도착 여부

        for (int i = 0; i < N; i++) {
            idx[i] = 0;
            int start = routes[i][0] - 1;
            pos[i][0] = points[start][0];
            pos[i][1] = points[start][1];
        }
        
        int arriveCount = 0;
        int collisionCount = 0;

        while (true) {
            Map<String, Integer> map = new HashMap<>();
            
            for (int i = 0; i < N; i++) {
                if (arrive[i]) {
                    continue;
                }
                
                int next = routes[i][idx[i]] - 1; // 목표 경로
                
                // 상, 하 먼저 이동
                if (pos[i][0] != points[next][0]) {
                    pos[i][0] += (points[next][0] > pos[i][0] ? 1 : -1);
                }
                // 좌, 우 이동
                else if (pos[i][1] != points[next][1]) {
                    pos[i][1] += (points[next][1] > pos[i][1] ? 1 : -1);
                }
                
                // 목표 위치 도착 -> 다음 목표로 조정 or 도착 처리
                if (pos[i][0] == points[next][0] && pos[i][1] == points[next][1]) {
                    if (idx[i] < routes[i].length - 1) {
                        idx[i]++;
                    }
                    else {
                        arrive[i] = true;
                        arriveCount++;
                    }
                }
                
                // 현재위치 map에 저장
                String key = pos[i][0] + "," + pos[i][1];
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            
            for (int count : map.values()) {
                if (count >= 2) {
                    collisionCount++;
                }
            }
            
            if (arriveCount == N) {
                break;
            }
        }
        
        return collisionCount;
    }
}