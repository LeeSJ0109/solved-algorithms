import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1449 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] pos = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			pos[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(pos);
		
		int cnt = 1;
		double cur = pos[0] + L - 0.5;
		for (int i = 1; i < N; i++) {
			if (pos[i] < cur) {
				continue;
			}
			else {
				cur = pos[i] + L - 0.5;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
