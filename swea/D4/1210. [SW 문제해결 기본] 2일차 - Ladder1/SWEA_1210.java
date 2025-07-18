import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1210 {
	static int[][] ladder = new int[100][100];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int T = 0; T < 10; T++) {
			int t = Integer.parseInt(br.readLine());
			
			int x = 0, y = 99;
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
					if (i == 99 && ladder[i][j] == 2) 
						x = j;
				}
			}
			
			while (y != 0) {
				if (x > 0 && ladder[y][x-1] == 1) {
					while (x > 0 && ladder[y][x-1] == 1)
						x -= 1;
				}
				else if (x < 99 && ladder[y][x+1] == 1) {
					while (x < 99 && ladder[y][x+1] == 1)
						x += 1;
				}
				y -= 1;
			}
			System.out.println("#" + t + " " + x);
		}
	}
}