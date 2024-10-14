import java.io.*;
import java.util.*;

public class BOJ_12738 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Integer> lis = new ArrayList<>();
		
		for (Integer num : A) {
			int pos = Collections.binarySearch(lis, num);
            if (pos < 0) {
                pos = -(pos + 1); // 삽입 위치
            }
            
            // 현재 숫자가 lis의 길이보다 크면 추가
            if (pos == lis.size()) {
                lis.add(num);
            } 
            // 더 작은 값으로 대체
            else {
                lis.set(pos, num);
            }
		}
		
		System.out.println(lis.size());
	}
	
}
