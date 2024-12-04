import java.io.*;
import java.util.*;

public class BOJ_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < N; i++) {
                String input = br.readLine().split(" ")[1];
                map.put(input, map.getOrDefault(input, 0) + 1);
            }

            int result = 1;
            for (int count: map.values()) {
                result *= (count + 1);
            }

            System.out.println(result - 1);
        }
    }
}
