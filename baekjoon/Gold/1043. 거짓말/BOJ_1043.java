import java.io.*;
import java.util.*;

public class BOJ_1043 {

    static int[] parent;
    static ArrayList<Integer>[] party;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // ����� ��
        int M = Integer.parseInt(st.nextToken());   // ��Ƽ�� ��

        parent = new int[N + 1];
        party = new ArrayList[M];

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());   // �̾߱��� ������ �ƴ� ����� ��

        int[] knowTruth = new int[K];

        // ������ �ƴ� ����� ��ȣ
        for (int k = 0; k < K; k++) {
            knowTruth[k] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            party[i] = new ArrayList<>();
            
            // ��Ƽ�� ������ �ο�
            int partyPeople = Integer.parseInt(st.nextToken());
            for (int p = 0; p < partyPeople; p++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        
        // parent �迭 �ʱ�ȭ
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            // ��Ƽ�� ��ǥ: ù ��° ���
            int rep = party[i].get(0);

            for (int j = 1; j < party[i].size(); j++) {
                // ���� ��Ƽ�� ������ �ο����� ���� �������� �з�
                union(rep, party[i].get(j));
            }
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            boolean possible = true;

            // ��Ƽ�� �ִ� ����� �߿� ������ �˰� �ִ� ����� ������ ��������
            // �� ��Ƽ���� �������� �� �� ����
            for (int partyPerson: party[i]) {
                for (int knowPerson: knowTruth) {
                    if (find(partyPerson) == find(knowPerson)) {
                        possible = false;
                        break;
                    }
                }

                if (!possible) {
                    break;
                }
            }

            if (possible) {
                count++;
            }
        }

        System.out.println(count);
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}
