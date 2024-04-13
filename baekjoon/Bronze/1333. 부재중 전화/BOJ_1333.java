import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1333 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			for (int j = L * (i + 1) + 5 * i; j < L * (i + 1) + 5 * i + 5; j++) {
				if (j % D == 0) {
					System.out.println(j);
					return;
				}
			}
		}
		
		int i = L * N + 5 * (N - 1);
		while (true) {
			if (i % D == 0) {
				System.out.println(i);
				break;
			}
			i++;
		}
	}
}
