import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16947 {

    static int N;
    static int[] distance;
    static List<Integer>[] subwayLine; // ����ö �뼱 �׷���
    static Set<Integer> circularLine = new HashSet<>(); // ��ȯ���� ���ϴ� ��
    static boolean foundCycle = false;
    static int lastSearchStation = 1;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        // �Ÿ� �迭 �ʱ�ȭ
        distance = new int[N + 1];
        Arrays.fill(distance, -1);

        subwayLine = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            subwayLine[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            subwayLine[a].add(b);
            subwayLine[b].add(a);
        }

        // ��ȯ�� ã��
        findCircularLine(1, 0);

        // 1�� ���� ��ȯ���� ������ �ʴ� ���
        // ��ȯ���� Ȯ���� ���ԵǴ� ������ ��Ž��
        if (lastSearchStation != 1) {
            circularLine = new HashSet<>();
            findCircularLine(lastSearchStation, 0);
        }

        // ��ȯ���� ���ϴ� �� ������ �Ÿ� ���
        calcDistance();

        for (int i = 1; i <= N; i++) {
            sb.append(distance[i] + " ");
        }

        System.out.println(sb);
    }

    // ��ȯ�� ã�� �Լ�
    static boolean findCircularLine(int current, int prev) {
        circularLine.add(current); // �ϴ� ���翪�� ��ȯ���� ���Խ�Ŵ

        // ���� ���� ����� ��� ���� Ž��
        for (int next : subwayLine[current]) {
            // �������� �ǳʶ�
            if (next == prev) {
                continue;
            }

            // ��ȯ���� �߰��� ���
            if (circularLine.contains(next)) {
                foundCycle = true;
                lastSearchStation = next;
                return true;
            }

            // ������ Ž��
            if (findCircularLine(next, current)) {
                if (foundCycle) {
                    return true;
                }

                circularLine.remove(current);
                return false;
            }
        }

        circularLine.remove(current);
        return false;
    }

    static void calcDistance() {
        Queue<Integer> queue = new LinkedList<>();

        // ��ȯ���� ���Ե� ���� ť�� ����
        for (int i = 1; i <= N; i++) {
            if (circularLine.contains(i)) {
                distance[i] = 0;
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : subwayLine[current]) {
                if (distance[next] == -1) {
                    distance[next] = distance[current] + 1;
                    queue.add(next);
                }
            }
        }
    }
}
