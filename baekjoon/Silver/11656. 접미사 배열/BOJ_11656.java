import java.io.*;
import java.util.Collections;
import java.util.LinkedList;

public class BOJ_11656 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		
		LinkedList<String> list = new LinkedList<>();
		
		for (int i = 0; i < S.length(); i++) {
			list.add(S.substring(i));
		}
		
		Collections.sort(list);
		
		for (String string : list) {
			System.out.println(string);
		}
	}
}
