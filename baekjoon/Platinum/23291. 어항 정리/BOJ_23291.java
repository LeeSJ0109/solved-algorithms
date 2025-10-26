import java.io.*;
import java.util.*;

public class BOJ_23291 {

    static int N, K;
    static int[][] fishbowl;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        fishbowl = new int[N][N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fishbowl[N - 1][i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        while (getMax() - getMin() > K) {
            cleanup();

            count++;
        }

        System.out.println(count);
    }

    static void cleanup() {
        addFish();
        firstLift();
        rotate1();
        adjust();
        lineUp();
        rotate2();
        adjust();
        lineUp();
    }

    // 물고기의 수가 가장 적은 어항에 물고기를 한 마리 넣기
    static void addFish() {
        int min = getMin();

        for (int i = 0; i < N; i++) {
            if (fishbowl[N - 1][i] == min) {
                fishbowl[N - 1][i]++;
            }
        }
    }

    // 가장 왼쪽에 있는 어항을 그 어항의 오른쪽에 있는 어항의 위에 올려 놓기
    static void firstLift() {
        fishbowl[N - 2][1] = fishbowl[N - 1][0];
        fishbowl[N - 1][0] = 0;
    }

    // 2개 이상 쌓여있는 어항을 모두 공중 부양시킨 다음, 전체를 시계방향으로 90도 회전
    // 이후 공중 부양시킨 어항을 바닥에 있는 어항의 위에 올려놓기
    static void rotate1() {
        int index = 1; // 회전시킬 어항의 첫 인덱스
        int width = 1; // 회전시킬 어항의 너비
        int height = 2; // 회전시킬 어항의 높이

        while (index + width + height <= N) {
            int[][] newFishbowl = new int[N][N];

            // 회전, 올려놓기
            for (int h = 0; h < height; h++) {
                for (int w = 0; w < width; w++) {
                    int x = N - h - 1;
                    int y = index + w;
                    int nx = N - width + w - 1;
                    int ny = index + width + h;

                    newFishbowl[nx][ny] = fishbowl[x][y];
                    fishbowl[x][y] = 0;
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (newFishbowl[i][j] != 0) {
                        fishbowl[i][j] = newFishbowl[i][j];
                    }
                }
            }

            index += width;
            int h = height;
            height = width + 1;
            width = h;
        }
    }

    // 어항에 있는 물고기의 수를 조절
    static void adjust() {
        int[][] adjFishbowl = new int[N][N]; // 조절할 물고기 수

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (fishbowl[x][y] == 0) {
                    continue;
                }

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                        continue;
                    }
                    if (fishbowl[nx][ny] == 0) {
                        continue;
                    }

                    int diff = (fishbowl[x][y] - fishbowl[nx][ny]) / 5; // 물고기 수의 차이를 5로 나눈 몫
                    // diff가 0보다 크면, 물고기 diff마리를 물고기 많은 곳 -> 적은 곳으로 이동
                    if (diff > 0) {
                        adjFishbowl[x][y] -= diff;
                        adjFishbowl[nx][ny] += diff;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                fishbowl[i][j] += adjFishbowl[i][j];
            }
        }
    }
    
    // 어항을 바닥에 일렬로 놓기
    static void lineUp() {
        int[] linedUp = new int[N];

        int idx = 0;
        for (int j = 0; j < N; j++) {
            for (int i = N - 1; i >= 0; i--) {
                if (fishbowl[i][j] == 0) {
                    continue;
                }

                linedUp[idx++] = fishbowl[i][j];
                fishbowl[i][j] = 0;
            }
        }

        for (int i = 0; i < N; i++) {
            fishbowl[N - 1][i] = linedUp[i];
        }
    }

    // 가운데를 중심으로 왼쪽 N/2개를 공중 부양시켜 전체를 시계 방향으로 180도 회전
    // 이후 오른쪽 N/2개의 위에 놓기 (2번 반복)
    static void rotate2() {
        // 첫번째 회전
        for (int i = 0; i < N / 2; i++) {
            fishbowl[N - 2][N - 1 - i] = fishbowl[N - 1][i];
            fishbowl[N - 1][i] = 0;
        }

        // 두번째 회전
        for (int i = N / 2; i < N / 4 * 3; i++) {
            fishbowl[N - 4][N + N / 2 - 1 - i] = fishbowl[N - 1][i];
            fishbowl[N - 3][N + N / 2 - 1 - i] = fishbowl[N - 2][i];
            fishbowl[N - 1][i] = 0;
            fishbowl[N - 2][i] = 0;
        }
    }

    static int getMin() {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            if (0 < fishbowl[N - 1][i] && fishbowl[N - 1][i] < min) {
                min = fishbowl[N - 1][i];
            }
        }

        return min;
    }

    static int getMax() {
        int max = 0;

        for (int i = 0; i < N; i++) {
            if (fishbowl[N - 1][i] > max) {
                max = fishbowl[N - 1][i];
            }
        }

        return max;
    }

    static void printFishbowl() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(fishbowl[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}
