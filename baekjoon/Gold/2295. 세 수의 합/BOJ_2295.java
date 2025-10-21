import java.io.*;
import java.util.*;

public class BOJ_2295 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] U = new int[N];
        for (int i = 0; i < N; i++) {
            U[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(U);

        // set <- U[x] + U[y]
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                set.add(U[i] + U[j]);
            }
        }

        int max = 0;

        // U[x] + U[y] + U[z] = k
        // U[x] + U[y] = k - U[z]
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (set.contains(U[j] - U[i])) {
                    max = Math.max(max, U[j]);
                }
            }
        }

        System.out.println(max);
    }
}
