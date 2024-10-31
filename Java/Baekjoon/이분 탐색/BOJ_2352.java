import java.io.*;
import java.util.*;

public class BOJ_2352 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] port = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			port[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(getLisLen(port));
	}
	
	static int getLisLen(int[] sequence) {
        ArrayList<Integer> lis = new ArrayList<>();

        for (int num : sequence) {
            int pos = Collections.binarySearch(lis, num);
            if (pos < 0) {
                pos = -(pos + 1);
            }

            if (pos == lis.size()) {
                lis.add(num);
            } else {
                lis.set(pos, num);
            }
        }

        return lis.size();
    }
}
