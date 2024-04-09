import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1673 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String input = br.readLine();
		while (input != null) {
			 st = new StringTokenizer(input);
			 int n = Integer.parseInt(st.nextToken());
			 int k = Integer.parseInt(st.nextToken());
			 
			 int result = n, coupon = n;
			 while (coupon >= k) {
				 int q = coupon / k;
				 int r = coupon % k;
				 coupon = r + q;
				 result += q;
			 }
			 
			 System.out.println(result);
			 
			 input = br.readLine();
		}
	}
}
