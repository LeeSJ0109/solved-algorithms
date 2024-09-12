import java.io.*;
import java.util.*;

public class BOJ_2696 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int M = sc.nextInt();
			List<Integer> list = new ArrayList<>();
			
			System.out.println(M /2 + 1);
			for (int i = 1; i <= M; i++) {
				list.add(sc.nextInt());
				
				if (i % 2 == 1) {
					Collections.sort(list);
					System.out.print(list.get(i / 2) + " ");
				}
			}
			System.out.println();
		}

        sc.close();
	}
}