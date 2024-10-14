import java.io.*;
import java.util.*;

public class BOJ_12100 {
    
    static int N;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        simulation(0, board);
        System.out.println(max);
    }

    static void simulation(int cnt, int[][] board) {
        if (cnt == 5) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    max = Math.max(max, board[i][j]);
                }
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int[][] newBoard = move(i, board);
            simulation(cnt + 1, newBoard);
        }
    }

    static int[][] move(int dir, int[][] board) {
        int[][] newBoard = new int[N][N];
        boolean[][] merged = new boolean[N][N]; // 합쳐진 타일을 체크할 배열
        Deque<Integer> deque;

        if (dir == 0) { // 상
            for (int j = 0; j < N; j++) {
                deque = new ArrayDeque<>();
                for (int i = 0; i < N; i++) {
                    if (board[i][j] != 0) {
                        if (!deque.isEmpty() && deque.peekLast() == board[i][j] && !merged[deque.size() - 1][j]) {
                            int last = deque.pollLast();
                            deque.addLast(last * 2);
                            merged[deque.size() - 1][j] = true; // 합쳐졌다고 표시
                        } else {
                            deque.addLast(board[i][j]);
                        }
                    }
                }
                for (int i = 0; i < N; i++) {
                    newBoard[i][j] = deque.isEmpty() ? 0 : deque.pollFirst();
                }
            }
        } else if (dir == 1) { // 하
            for (int j = 0; j < N; j++) {
                deque = new ArrayDeque<>();
                for (int i = N - 1; i >= 0; i--) {
                    if (board[i][j] != 0) {
                        if (!deque.isEmpty() && deque.peekLast() == board[i][j] && !merged[N - 1 - deque.size()][j]) {
                            int last = deque.pollLast();
                            deque.addLast(last * 2);
                            merged[N - 1 - deque.size()][j] = true;
                        } else {
                            deque.addLast(board[i][j]);
                        }
                    }
                }
                for (int i = N - 1; i >= 0; i--) {
                    newBoard[i][j] = deque.isEmpty() ? 0 : deque.pollFirst();
                }
            }
        } else if (dir == 2) { // 좌
            for (int i = 0; i < N; i++) {
                deque = new ArrayDeque<>();
                for (int j = 0; j < N; j++) {
                    if (board[i][j] != 0) {
                        if (!deque.isEmpty() && deque.peekLast() == board[i][j] && !merged[i][deque.size() - 1]) {
                            int last = deque.pollLast();
                            deque.addLast(last * 2);
                            merged[i][deque.size() - 1] = true;
                        } else {
                            deque.addLast(board[i][j]);
                        }
                    }
                }
                for (int j = 0; j < N; j++) {
                    newBoard[i][j] = deque.isEmpty() ? 0 : deque.pollFirst();
                }
            }
        } else { // 우
            for (int i = 0; i < N; i++) {
                deque = new ArrayDeque<>();
                for (int j = N - 1; j >= 0; j--) {
                    if (board[i][j] != 0) {
                        if (!deque.isEmpty() && deque.peekLast() == board[i][j] && !merged[i][N - 1 - deque.size()]) {
                            int last = deque.pollLast();
                            deque.addLast(last * 2);
                            merged[i][N - 1 - deque.size()] = true;
                        } else {
                            deque.addLast(board[i][j]);
                        }
                    }
                }
                for (int j = N - 1; j >= 0; j--) {
                    newBoard[i][j] = deque.isEmpty() ? 0 : deque.pollFirst();
                }
            }
        }

        return newBoard;
    }

}
