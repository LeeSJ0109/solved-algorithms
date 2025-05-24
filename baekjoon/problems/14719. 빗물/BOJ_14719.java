import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14719 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		st.nextToken();
		
		int W = Integer.parseInt(st.nextToken());
		
		int[] block = new int[W];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			block[i] = Integer.parseInt(st.nextToken());
		}
		
		int top_idx = 0;
		for (int i = 1; i < W; i++) {
			if (block[i] > block[top_idx])
				top_idx = i;
		}
		
		int rain = 0;
		
		int left_top = block[0];
		for (int i = 0; i < top_idx; i++) {
			if (block[i] > left_top)
				left_top = block[i];
			 rain += left_top - block[i];
		}
		
		int right_top = block[W-1];
		for (int i = W-1; i > top_idx; i--) {
			if (block[i] > right_top)
				right_top = block[i];
			rain += right_top - block[i];
		}
		
		System.out.println(rain);
	}
}
