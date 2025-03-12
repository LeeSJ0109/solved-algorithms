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

        // 자리 배치도
        seats = new int[N + 1][N + 1];
        // 학생의 순서를 저장
        studentOrder = new int[N * N + 1];
        // 학생의 좋아하는 관계를 저장
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

        // 자리 배치
        for (int student : studentOrder) {
            placeStudent(student);
        }

//        printSeats();

        System.out.println(getSatisfaction());
    }

    // 자리 배치
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

                // 1. 인접한 자리에 좋아하는 학생이 가장 많은 자리로 배치
                // 2. 1을 만족하는 자리가 여러 개면, 인접한 자리 중에서 비어있는 칸이 가장 많은 자리로 배치
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

    // 자리 출력
    static void printSeats() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 만족도 구하기
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
