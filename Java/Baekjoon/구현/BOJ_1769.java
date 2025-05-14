import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1769 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        int count = 0;
        while (num.length() > 1) {
            int sum = 0;
            for (char c : num.toCharArray()) {
                sum += c - '0';
            }

            num = Integer.toString(sum);
            count++;
        }

        System.out.println(count);
        System.out.println(Integer.parseInt(num) % 3 == 0 ? "YES" : "NO");
    }
}
