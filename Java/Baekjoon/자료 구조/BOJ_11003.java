import java.io.*;
import java.util.*;

public class BOJ_11003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] A = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
		
		Deque<Integer> deque = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (!deque.isEmpty() && deque.peekFirst() <= i - L) {
                deque.pollFirst();
            }
            
            while (!deque.isEmpty() && A[deque.peekLast()] >= A[i]) {
                deque.pollLast();
            }
            
            deque.addLast(i);
            
            sb.append(A[deque.peekFirst()]).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}
