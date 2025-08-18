import java.util.*;

class Solution {
    
    static class State {
        int node, sheep, wolf;
        List<Integer> next; // 다음 방문할 수 있는 노드 리스트
        
        State(int node, int sheep, int wolf, List<Integer> next) {
            this.node = node;
            this.sheep = sheep;
            this.wolf = wolf;
            this.next = next;
        }
    }
    
    @SuppressWarnings("unchecked")
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        
        int N = info.length;
        
        List<Integer>[] tree = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
        }
        
        // BFS
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, 0, 0, new ArrayList<>()));
        
        while (!queue.isEmpty()) {
            State current = queue.poll();
            int node = current.node;
            int sheep = current.sheep;
            int wolf = current.wolf;
            
            // 현재 노드 방문
            if (info[node] == 0) {
                sheep++;
            }
            else {
                wolf++;
            }
            
            // 모은 양의 수보다 늑대의 수가 같거나 더 많아지면 무시
            if (wolf >= sheep) {
                continue;
            }
            
            answer = Math.max(answer, sheep);
            
            // 다음 방문할 수 있는 노드들
            List<Integer> next = new ArrayList<>();
            
            for (int cn : current.next) {
                if (cn != node) {
                    next.add(cn);
                }
            }
            
            for (int nextNode : tree[node]) {
                next.add(nextNode);
            }
            
            for (int nextNode : next) {
                queue.add(new State(nextNode, sheep, wolf, next));
            }
        }
        
        return answer;
    }
}