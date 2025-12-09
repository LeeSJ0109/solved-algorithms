import java.io.*;
import java.util.*;

public class BOJ_11279 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
				
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if (x == 0) {
				System.out.println(pq.peek() == null ? 0 : pq.poll());
			}
			else {
				pq.add(x);
			}
		}
	}
}
