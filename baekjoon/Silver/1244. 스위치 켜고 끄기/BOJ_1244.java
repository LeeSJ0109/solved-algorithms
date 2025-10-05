import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244 {

    static boolean[] switchs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        switchs = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            if (st.nextToken().equals("1")) {
                switchs[i] = true;
            }
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                male(number);
            }
            else {
                female(number);
            }
        }

        printArray();
    }

    static void male(int number) {
        for (int i = number; i < switchs.length; i+=number) {
            switchs[i] = !switchs[i];
        }
    }

    static void female(int number) {
        switchs[number] = !switchs[number];
        for (int i = 1; i < switchs.length; i++) {
            if (number - i == 0 || number + i == switchs.length) {
                break;
            }

            if (switchs[number - i] == switchs[number + i]) {
                switchs[number - i] = !switchs[number - i];
                switchs[number + i] = !switchs[number + i];
            }

            else {
                break;
            }
        }
    }

    static void printArray() {
        for (int i = 1; i < switchs.length; i++) {
            System.out.print(switchs[i] ? 1 + " " : 0 + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
