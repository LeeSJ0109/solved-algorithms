import java.io.*;
import java.util.*;

public class BOJ_20327 {

    static int N, R, size;
    static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        size = 1 << N;
        A = new int[size][size];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            switch (k) {
                case 1:
                    calc1(l);
                    break;
                case 2:
                    calc2(l);
                    break;
                case 3:
                    calc3(l);
                    break;
                case 4:
                    calc4(l);
                    break;
                case 5:
                    calc5(l);
                    break;
                case 6:
                    calc6(l);
                    break;
                case 7:
                    calc7(l);
                    break;
                case 8:
                    calc8(l);
                    break;
            }

        }

        printA();
    }

    // 1번 연산: 각 부분 배열을 상하 반전
    static void calc1(int l) {
        int subSize = 1 << l;
        int[][] tmp = new int[size][size];

        for (int x = 0; x < size; x += subSize) {
            for (int y = 0; y < size; y += subSize) {
                for (int i = 0; i < subSize; i++) {
                    for (int j = 0; j < subSize; j++) {
                        tmp[x + i][y + j] = A[x + subSize - 1 - i][y + j];
                    }
                }
            }
        }

        A = tmp;
    }

    // 2번 연산: 각 부분 배열을 좌우 반전
    static void calc2(int l) {
        int subSize = 1 << l;
        int[][] tmp = new int[size][size];

        for (int x = 0; x < size; x += subSize) {
            for (int y = 0; y < size; y += subSize) {
                for (int i = 0; i < subSize; i++) {
                    for (int j = 0; j < subSize; j++) {
                        tmp[x + i][y + j] = A[x + i][y + subSize - 1 - j];
                    }
                }
            }
        }

        A = tmp;
    }

    // 3번 연산: 각 부분 배열을 오른쪽으로 90도 회전
    static void calc3(int l) {
        int subSize = 1 << l;
        int[][] tmp = new int[size][size];

        for (int x = 0; x < size; x += subSize) {
            for (int y = 0; y < size; y += subSize) {
                for (int i = 0; i < subSize; i++) {
                    for (int j = 0; j < subSize; j++) {
                        tmp[x + j][y + subSize - 1 - i] = A[x + i][y + j];
                    }
                }
            }
        }

        A = tmp;
    }

    // 4번 연산: 각 부분 배열을 왼쪽으로 90도 회전
    static void calc4(int l) {
        int subSize = 1 << l;
        int[][] tmp = new int[size][size];

        for (int x = 0; x < size; x += subSize) {
            for (int y = 0; y < size; y += subSize) {
                for (int i = 0; i < subSize; i++) {
                    for (int j = 0; j < subSize; j++) {
                        tmp[x + subSize - 1 - j][y + i] = A[x + i][y + j];
                    }
                }
            }
        }

        A = tmp;
    }

    // 5번 연산: 배열을 상하 반전
    static void calc5(int l) {
        int subSize = 1 << l;
        int[][] tmp = new int[size][size];

        for (int x = 0; x < size; x += subSize) {
            for (int y = 0; y < size; y += subSize) {
                int nx = size - subSize - x;
                int ny = y;
                for (int i = 0; i < subSize; i++) {
                    for (int j = 0; j < subSize; j++) {
                        tmp[nx + i][ny + j] = A[x + i][y + j];
                    }
                }
            }
        }

        A = tmp;
    }

    // 6번 연산: 배열을 좌우 반전
    static void calc6(int l) {
        int subSize = 1 << l;
        int[][] tmp = new int[size][size];

        for (int x = 0; x < size; x += subSize) {
            for (int y = 0; y < size; y += subSize) {
                int nx = x;
                int ny = size - subSize - y; // 좌우 반전
                for (int i = 0; i < subSize; i++) {
                    for (int j = 0; j < subSize; j++) {
                        tmp[nx + i][ny + j] = A[x + i][y + j];
                    }
                }
            }
        }

        A = tmp;
    }

    // 7번 연산: 배열을 오른쪽으로 90도 회전
    static void calc7(int l) {
        int subSize = 1 << l;
        int[][] tmp = new int[size][size];

        for (int x = 0; x < size; x += subSize) {
            for (int y = 0; y < size; y += subSize) {
                int nx = y;
                int ny = size - subSize - x;
                for (int i = 0; i < subSize; i++) {
                    for (int j = 0; j < subSize; j++) {
                        tmp[nx + i][ny + j] = A[x + i][y + j];
                    }
                }
            }
        }

        A = tmp;
    }

    // 8번 연산: 배열을 왼쪽으로 90도 회전
    static void calc8(int l) {
        int subSize = 1 << l;
        int[][] tmp = new int[size][size];

        for (int x = 0; x < size; x += subSize) {
            for (int y = 0; y < size; y += subSize) {
                int nx = size - subSize - y;
                int ny = x;
                for (int i = 0; i < subSize; i++) {
                    for (int j = 0; j < subSize; j++) {
                        tmp[nx + i][ny + j] = A[x + i][y + j];
                    }
                }
            }
        }

        A = tmp;
    }

    static void printA() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(A[i][j]).append(' ');
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }
}
