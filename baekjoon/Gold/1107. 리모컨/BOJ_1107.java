import java.io.*;
import java.util.*;

public class BOJ_1107 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int target = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] broken = new boolean[10];

        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int minPress = Math.abs(target - 100);

        for (int i = 0; i <= 999999; i++) {
            int length = isPossible(i, broken);

            if (length > 0) {
                int press = Math.abs(i - target) + length;
                minPress = Math.min(minPress, press);
            }
        }

        System.out.println(minPress);
    }

    public static int isPossible(int channel, boolean[] broken) {
        String str = String.valueOf(channel);
        for (int i = 0; i < str.length(); i++) {
            if (broken[str.charAt(i) - '0']) {
                return 0;
            }
        }
        return str.length();
    }
}
