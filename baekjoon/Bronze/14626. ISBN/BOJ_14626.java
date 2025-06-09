import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_14626 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ISBN = br.readLine();

        int sum = 0;
        int index = -1;

        for (int i = 0; i < 13; i++) {
            char c = ISBN.charAt(i);

            if (c == '*') {
                index = i;
            }
            else {
                sum += (c - '0') * (i % 2 == 0 ? 1 : 3);
            }
        }

        for (int i = 0; i <= 9; i++) {
            if ((sum + i * (index % 2 == 0 ? 1 : 3)) % 10 == 0) {
                System.out.println(i);
                return;
            }
        }
    }
}
