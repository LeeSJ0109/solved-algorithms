import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BOJ_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String expression = br.readLine();
        Stack<Double> stack = new Stack<>();
        Map<Integer, Double> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            map.put(('A' + i), Double.parseDouble(br.readLine()));
        }

        for (int i = 0; i < expression.length(); i++) {
            int current = expression.charAt(i);

            if (map.containsKey(current)) {
                stack.push(map.get(current));
            } else {
                double var1 = stack.pop();
                double var2 = stack.pop();

                switch (current) {
                    case '+':
                        stack.push(var2 + var1);
                        break;
                    case '-':
                        stack.push(var2 - var1);
                        break;
                    case '*':
                        stack.push(var2 * var1);
                        break;
                    case '/':
                        stack.push(var2 / var1);
                        break;
                }
            }
        }

        System.out.printf("%.2f\n", stack.pop());
    }
}
