import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1094 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        System.out.println(Integer.bitCount(X));
    }
}
