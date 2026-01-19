import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1167 {

    static class Node {
        int to;
        int distance;

        Node (int to, int distance) {
            this.to = to;
            this.distance = distance;
        }
    }

    static List<Node>[] tree;
    static int farthestNode;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        tree = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());

            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) {
                    break;
                }
                int distance = Integer.parseInt(st.nextToken());

                tree[from].add(new Node(to, distance));
            }
        }

        // 1차 BFS: 임의의 노드(1번)에서 가장 먼 노드 찾기
        BFS(1);

        // 2차 BFS: 가장 먼 노드에서 다시 가장 먼 거리 구하기 (트리의 지름)
        System.out.println(BFS(farthestNode));
    }

    static int BFS(int start) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[tree.length];
        queue.add(new Node(start, 0));
        visited[start] = true;

        int maxDistance = 0;
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.distance > maxDistance) {
                maxDistance = current.distance;
                farthestNode = current.to;
            }

            for (Node next : tree[current.to]) {
                if (!visited[next.to]) {
                    visited[next.to] = true;
                    queue.add(new Node(next.to, current.distance + next.distance));
                }
            }
        }

        return maxDistance;
    }
}
