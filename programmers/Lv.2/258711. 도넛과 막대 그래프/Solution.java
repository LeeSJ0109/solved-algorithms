import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        // answer[0] : 생성한 정점 -> in = 0, out > 1
        // answer[1] : 도넛 모양 그래프 -> 모든 정점 in >= 1, out = 1
        // answer[2] : 막대 모양 그래프 -> 마지막 정점 in >= 1, out = 0
        // answer[3] : 8자 모양 그래프 -> 정점 중 한 개 in >= 2, out = 2
        
        Map<Integer, Integer> in = new HashMap<>(); // 들어오는 간선
        Map<Integer, Integer> out = new HashMap<>(); // 나가는 간선
        
        for (int[] edge : edges) {
            out.put(edge[0], out.getOrDefault(edge[0], 0) + 1);
            in.put(edge[1], in.getOrDefault(edge[1], 0) + 1);
        }
        
        for (int node : out.keySet()) {
            // out 간선의 개수가 2개 이상인 정점 중에서 
            if (out.get(node) > 1) {
                // in 간선이 없으면 생성한 정점
                if (!in.containsKey(node)) {
                    answer[0] = node;
                }
                // in 간선이 있으면 8자 그래프
                else {
                    answer[3] += 1;
                }
            }
        }
        
        for (int node : in.keySet()) {
            // in 간선이 있는 정점중에서 out 간선이 없으면 막대 그래프
            if(!out.containsKey(node)) {
                answer[2] += 1;
            }
        }
        
        // 도넛 그래프 개수 = 생성한 정점의 out 간선 개수 - 막대 그래프 개수 - 8자 그래프 개수
        answer[1] = out.get(answer[0]) - answer[2] - answer[3];
        
        return answer;
    }
}