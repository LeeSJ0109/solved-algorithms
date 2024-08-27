import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663 {

    static int N;
    static int count;

    static int[] arr;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        isSelected = new boolean[N];

        count = 0;
        nQueen(0);
        System.out.println(count);
    }

    static void nQueen(int depth) {
        if (depth == N) {
            count ++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if (isPossible(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    static boolean isPossible(int depth) {
        for (int i = 0; i < depth; i++) {
            if (arr[depth] == arr[i] || Math.abs(arr[depth] - arr[i]) == Math.abs(depth - i)){
                return false;
            }
        }

        return true;
    }
}
