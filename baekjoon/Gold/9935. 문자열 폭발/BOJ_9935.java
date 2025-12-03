import java.util.*;

public class BOJ_9935 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        String explosion = sc.nextLine();

        int explosionLen = explosion.length();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < string.length(); i++) {
            stack.push(string.charAt(i));

            if (stack.size() >= explosionLen) {
                boolean isExplosion = true;
                for (int j = 0; j < explosionLen; j++) {
                    if (stack.get(stack.size() - explosionLen + j) != explosion.charAt(j)) {
                        isExplosion = false;
                        break;
                    }
                }

                if (isExplosion) {
                    for (int j = 0; j < explosionLen; j++) {
                        stack.pop();
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("FRULA");
        }
        else {
            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }

            System.out.println(sb.toString());
        }

        sc.close();
    }
}
