import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1218 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			int len = Integer.parseInt(br.readLine());
			sb.append("#").append(t).append(" ");
			String str = br.readLine();
			
			if (len % 2 != 0) {
				sb.append(0).append("\n");
				continue;
			}

			int a = 0, b = 0, c = 0, d = 0;
			for (int i = 0; i < len; i++) {
				switch (str.charAt(i)) {
			    case '(': a++; break;
			    case ')': a--; break;
			    case '[': b++; break;
			    case ']': b--; break;
			    case '{': c++; break;
			    case '}': c--; break;
			    case '<': d++; break;
			    case '>': d--; break;
				}
			}
			if (a == b && b == c && c == d && d == 0)
				sb.append(1);
			else 
				sb.append(0);
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
