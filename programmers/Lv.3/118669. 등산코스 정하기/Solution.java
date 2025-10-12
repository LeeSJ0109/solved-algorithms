import java.util.*;

class Solution {
    
    static class Node {
        int v;
        int w; // 현재까지의 최대 intensity

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    
    @SuppressWarnings("unchecked")
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {0, Integer.MAX_VALUE};
        
        List<int[]>[] graph = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 경로 생성
        for (int[] path : paths) {
            int i = path[0];
            int j = path[1];
            int w = path[2];
            
            graph[i].add(new int[]{j, w});
            graph[j].add(new int[]{i, w});
        }

        boolean[] isSummit = new boolean[n + 1];
        for (int summit : summits) {
            isSummit[summit] = true;
        }
        
        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);
        // intensity가 작은거 부터
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        
        for (int gate : gates) {
            intensity[gate] = 0;
            pq.add(new Node(gate, 0));
        }
        
        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int v = current.v;
            int w = current.w;
            
            // 더 좋은 intensity가 이미 있음
            if (intensity[v] < w) {
                continue;
            }
            // 현재 산봉우리인 경우
            if (isSummit[v]) {
                continue;
            }
            
            for (int[] next : graph[v]) {
                int nv = next[0];
                int nw = Math.max(w, next[1]);
                
                // intensity를 줄일 수 있으면 큐에 삽입
                if (nw < intensity[nv]) {
                    intensity[nv] = nw;
                    pq.add(new Node(nv, nw));
                }
            }
        }
        
        // 산봉우리의 번호가 낮은순
        Arrays.sort(summits);
        
        for (int summit : summits) {
            if (intensity[summit] < answer[1]) {
                answer[1] = intensity[summit];
                answer[0] = summit;
            }
        }
        return answer;
    }
}