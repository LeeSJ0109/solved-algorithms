import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_23309 {

    // ���� �ִ� ����
    static int MAX_STATION_NUM = 1_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // �ش� ���� ����/���� �ε����� �����ϴ� �迭
        int[] nextStation = new int[MAX_STATION_NUM];
        int[] prevStation = new int[MAX_STATION_NUM];

        st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int current = first;

        for (int i = 1; i < N; i++) {
            int next = Integer.parseInt(st.nextToken());
            nextStation[current] = next;
            prevStation[next] = current;
            current = next;
        }

        // ó������ �������� ����
        nextStation[current] = first;
        prevStation[first] = current;

        for (int c = 0; c < M; c++) {
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            int i = Integer.parseInt(st.nextToken());

            switch (type) {
                // ���� ��ȣ i�� ���� ���� ���� ���� ���� ��ȣ�� ����ϰ�,
                // �� ���̿� ���� ��ȣ j�� ���� �����Ѵ�.
                case "BN": {
                    int j = Integer.parseInt(st.nextToken());
                    int next = nextStation[i];

                    // ���� i -> next ����
                    // i -> j -> next ���� ����
                    nextStation[i] = j;
                    prevStation[j] = i;
                    nextStation[j] = next;
                    prevStation[next] = j;

                    sb.append(next).append("\n");
                    break;
                }
                // ���� ��ȣ i�� ���� ���� ���� ���� ��ȣ�� ����ϰ�,
                // �� ���̿� ���� ��ȣ j�� ���� �����Ѵ�.
                case "BP": {
                    int j = Integer.parseInt(st.nextToken());
                    int prev = prevStation[i];

                    // ���� prev -> i ����
                    // prev -> j -> i �� ����
                    nextStation[prev] = j;
                    prevStation[j] = prev;
                    nextStation[j] = i;
                    prevStation[i] = j;

                    sb.append(prev).append("\n");
                    break;
                }
                // ���� ��ȣ i�� ���� ���� ���� ���� ����ϰ�
                // �� ���� ���� ��ȣ�� ����Ѵ�.
                case "CN": {
                    // ���� i -> next -> nextNext
                    // i -> nextNext �� ����
                    int next = nextStation[i];
                    int nextNext = nextStation[next];

                    nextStation[i] = nextNext;
                    prevStation[nextNext] = i;

                    nextStation[next] = 0;
                    prevStation[next] = 0;

                    sb.append(next).append("\n");
                    break;
                }
                // ���� ��ȣ i�� ���� ���� ���� ���� ����ϰ�
                // �� ���� ���� ��ȣ�� ����Ѵ�.
                case "CP": {
                    // ���� prev_prev_station -> prev_station -> i
                    // prev_prev_station -> �� ����
                    int prev = prevStation[i];
                    int prevPrev = prevStation[prev];

                    nextStation[prevPrev] = i;
                    prevStation[i] = prevPrev;

                    nextStation[prev] = 0;
                    prevStation[prev] = 0;

                    sb.append(prev).append("\n");
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}