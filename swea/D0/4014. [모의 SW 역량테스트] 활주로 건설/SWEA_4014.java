import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;
            // �� �˻�
            for (int i = 0; i < N; i++) {
                if (canBuildRunway(map[i], X, N)) {
                    result++;
                }
            }

            // �� �˻�
            for (int j = 0; j < N; j++) {
                int[] column = new int[N];
                for (int i = 0; i < N; i++) {
                    column[i] = map[i][j];
                }
                if (canBuildRunway(column, X, N)) {
                    result++;
                }
            }

            System.out.println("#" + t + " " + result);
        }
    }

    static boolean canBuildRunway(int[] line, int X, int N) {
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N - 1; i++) {
            if (line[i] == line[i + 1]) {
                // ���̰� ���� ��� ��� ����
                continue;
            } else if (line[i] + 1 == line[i + 1]) {
                // �ö󰡴� ���� ��ġ ���� ���� üũ
                // ���θ� ��ġ�� �� �ִ� ���
                // ���� ���̰� 1�� ��츸 ����
                // �ö󰡴� ������ ��� ���� ��ġ���� Xĭ��ŭ �ڷ� �˻�
                // �������� ������ ��� ���� ��ġ���� Xĭ��ŭ ������ �˻�
                // ��ġ�� ��ġ�� �̹� �ٸ� ���ΰ� �ְų�, ���̰� ���� ������ ��ġ�� �� ����
                for (int j = 0; j < X; j++) {
                    if (i - j < 0 || visited[i - j] || line[i] != line[i - j]) {
                        return false;
                    }
                    visited[i - j] = true;
                }
            } else if (line[i] - 1 == line[i + 1]) {
                // �������� ���� ��ġ ���� ���� üũ
                for (int j = 1; j <= X; j++) {
                    if (i + j >= N || visited[i + j] || line[i + 1] != line[i + j]) {
                        return false;
                    }
                    visited[i + j] = true;
                }
            } else {
                // ���� ���̰� 1���� ũ�� Ȱ�ַ� ��ġ �Ұ���
                return false;
            }
        }
        return true;
    }
}
