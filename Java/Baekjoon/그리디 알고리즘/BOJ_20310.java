import java.io.*;
import java.util.*;

public class BOJ_20310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        StringBuilder sb = new StringBuilder(S);
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int cnt0 = map.getOrDefault('0', 0) / 2;
        int cnt1 = map.getOrDefault('1', 0) / 2;

        for (int i = S.length() - 1; i >= 0; i--) {
            if (cnt0 == 0) {
                break;
            }

            if (S.charAt(i) == '0') {
                sb.setCharAt(i, ' ');
                cnt0--;
            }
        }

        for (int i = 0; i < S.length(); i++) {
            if (cnt1 == 0) {
                break;
            }

            if (S.charAt(i) == '1' && !(cnt1 == 0)) {
                sb.setCharAt(i, ' ');
                cnt1--;
            }
        }

        System.out.println(sb.toString().replaceAll(" ", ""));
    }
}
