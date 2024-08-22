import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class SWEA_6109 {
     
    static int N;
    static int[][] board ;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            String S = st.nextToken();
             
            board = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            moveTile(S);
             
            System.out.println("#" + t);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
     
    static void moveTile(String direction) {
        int[][] newBoard = new int[N][N];
 
        switch (direction) {
        case "left":
            for (int i = 0; i < N; i++) {
                Queue<Integer> queue = new LinkedList<>();
                int prev = 0;
                int idx = 0;
 
                for (int j = 0; j < N; j++) {
                    int current = board[i][j];
                    if (current == 0) continue;
 
                    if (prev == current) {
                        queue.add(prev * 2);
                        prev = 0;
                    } else {
                        if (prev != 0) queue.add(prev);
                        prev = current;
                    }
                }
                if (prev != 0) queue.add(prev);
 
                while (!queue.isEmpty()) {
                    newBoard[i][idx++] = queue.poll();
                }
            }
            break;
        case "right":
            for (int i = 0; i < N; i++) {
                Queue<Integer> queue = new LinkedList<>();
                int prev = 0;
                int idx = N - 1;
 
                for (int j = N - 1; j >= 0; j--) {
                    int current = board[i][j];
                    if (current == 0) continue;
 
                    if (prev == current) {
                        queue.add(prev * 2);
                        prev = 0;
                    } else {
                        if (prev != 0) queue.add(prev);
                        prev = current;
                    }
                }
                if (prev != 0) queue.add(prev);
 
                while (!queue.isEmpty()) {
                    newBoard[i][idx--] = queue.poll();
                }
            }
            break;
        case "up":
            for (int i = 0; i < N; i++) {
                Queue<Integer> queue = new LinkedList<>();
                int prev = 0;
                int idx = 0;
 
                for (int j = 0; j < N; j++) {
                    int current = board[j][i];
                    if (current == 0) continue;
 
                    if (prev == current) {
                        queue.add(prev * 2);
                        prev = 0;
                    } else {
                        if (prev != 0) queue.add(prev);
                        prev = current;
                    }
                }
                if (prev != 0) queue.add(prev);
 
                while (!queue.isEmpty()) {
                    newBoard[idx++][i] = queue.poll();
                }
            }
            break;
        case "down":
            for (int i = 0; i < N; i++) {
                Queue<Integer> queue = new LinkedList<>();
                int prev = 0;
                int idx = N - 1;
 
                for (int j = N - 1; j >= 0; j--) {
                    int current = board[j][i];
                    if (current == 0) continue;
 
                    if (prev == current) {
                        queue.add(prev * 2);
                        prev = 0;
                    } else {
                        if (prev != 0) queue.add(prev);
                        prev = current;
                    }
                }
                if (prev != 0) queue.add(prev);
 
                while (!queue.isEmpty()) {
                    newBoard[idx--][i] = queue.poll();
                }
            }
            break;
        }
 
        board = newBoard;
    }
}