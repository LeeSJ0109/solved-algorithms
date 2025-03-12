import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_21608 {

    static int N;
    static int[][] seats;
    static int[] studentOrder;
    static boolean[][] isLike;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // �ڸ� ��ġ��
        seats = new int[N + 1][N + 1];
        // �л��� ������ ����
        studentOrder = new int[N * N + 1];
        // �л��� �����ϴ� ���踦 ����
        isLike = new boolean[N * N + 1][N * N + 1];

        for (int i = 1; i <= N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            studentOrder[i] = student;

            for (int j = 0; j < 4; j++) {
                int like = Integer.parseInt(st.nextToken());
                isLike[student][like] = true;
            }
        }

        // �ڸ� ��ġ
        for (int student : studentOrder) {
            placeStudent(student);
        }

//        printSeats();

        System.out.println(getSatisfaction());
    }

    // �ڸ� ��ġ
    static void placeStudent(int student) {
        int maxLikeCount = -1, maxEmptyCount = -1;
        int placeX = -1, placeY = -1;

        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                if (seats[x][y] != 0) {
                    continue;
                }

                int likeCount = 0, emptyCount = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx <= 0 || ny <= 0 || nx > N || ny > N) {
                        continue;
                    }
                    if (seats[nx][ny] == 0) {
                        emptyCount++;
                    }
                    else if (isLike[student][seats[nx][ny]]) {
                        likeCount++;
                    }
                }

                // 1. ������ �ڸ��� �����ϴ� �л��� ���� ���� �ڸ��� ��ġ
                // 2. 1�� �����ϴ� �ڸ��� ���� ����, ������ �ڸ� �߿��� ����ִ� ĭ�� ���� ���� �ڸ��� ��ġ
                if (likeCount > maxLikeCount || (likeCount == maxLikeCount && emptyCount > maxEmptyCount)) {
                    maxLikeCount = likeCount;
                    maxEmptyCount = emptyCount;
                    placeX = x;
                    placeY = y;
                }
            }
        }

        seats[placeX][placeY] = student;
    }

    // �ڸ� ���
    static void printSeats() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    // ������ ���ϱ�
    static int getSatisfaction() {
        int[] satisfaction = {0, 1, 10, 100, 1000};

        int sumSatisfaction = 0;
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                int student = seats[x][y];

                int likeCount = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx <= 0 || ny <= 0 || nx > N || ny > N) {
                        continue;
                    }

                    if (isLike[student][seats[nx][ny]]) {
                        likeCount++;
                    }
                }

                sumSatisfaction += satisfaction[likeCount];
            }
        }

        return sumSatisfaction;
    }
}
