import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		char[] character = line.toCharArray();
		
		int cnt = 0;
		int result = 0;
		for (int i = 0; i < line.length(); i++) {
			if (character[i] == '(') {
				cnt++;
			}
			
			else if (i > 0 && character[i] == ')') {
				cnt--;
				if (character[i - 1] == '(') {
					result += cnt;
				}
				else if (character[i - 1] == ')') {
					result++;
				}
			}
		}
			
		System.out.println(result);
	}
}
