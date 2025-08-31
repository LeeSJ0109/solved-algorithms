import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int N = jobs.length;
        
        // 요청 시간 순 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        int time = 0; // 현재 시간
        int count = 0; // 처리 완료된 작업
        int current = 0; // 현재 처리중인 작업
        int totalTime = 0; // 총 반환 시간
        
        // 작업 시간 기준 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        while (count < N) {
            // 현재 시간 이전의 요청들 큐에 추가
            while (current < N && jobs[current][0] <= time) {
                pq.add(jobs[current++]);
            }
            
            if (pq.isEmpty()) {
                time = jobs[current][0];
            }
            else {
                int[] job = pq.poll();
                time += job[1];
                totalTime += time - job[0];
                count++;
            }
        }
        
        return totalTime / N;
    }
}