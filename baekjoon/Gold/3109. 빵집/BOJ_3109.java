import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109 {

	static int R, C;
	static char[][] board;
	static boolean[][] visited;
	static int[] direction = {-1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		visited = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			String line = br.readLine();
			for (int c = 0; c < C; c++) {
				board[r][c] = line.charAt(c);
			}
		}
		
		int count = 0;
        for (int i = 0; i < R; i++) {
            if (setPipe(i, 0)) {
            	count++;
            }
        }
        
        System.out.println(count);
		
	}
	
	static boolean setPipe(int r, int c) {
		if (c == C - 1) return true;
		if (!isValid(r, c)) return false;
		
		visited[r][c] = true;
		
		for (int d : direction) {
            int nr = r + d;
            int nc = c + 1;
            if (setPipe(nr, nc)) {
            	return true;
            }
		}
		
		return false;
	}
	
	static boolean isValid(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C && board[r][c] != 'x' && !visited[r][c];
	}
}
