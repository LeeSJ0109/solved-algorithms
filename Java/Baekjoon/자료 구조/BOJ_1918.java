import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1918 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String infix = br.readLine();

        Stack<Character> stack = new Stack<>();

        for (char c : infix.toCharArray()) {
            if ('A' <= c && c <= 'Z') {
                // 피연산자는 바로 출력
                sb.append(c);
            }
            else if (c == '(') {
                stack.push(c);
            }
            else if (c == ')') {
                // '('가 나올 때까지 pop
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }

                stack.pop(); // '(' 제거
            }
            else {
                // 연산자
                while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(c)) {
                    sb.append(stack.pop());
                }

                stack.push(c);
            }
        }

        // 남은 연산자 모두 출력
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }

    static int getPriority(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

}
