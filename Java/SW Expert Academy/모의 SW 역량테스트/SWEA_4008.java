import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SWEA_4008 {
    static int N;
 
    static int[] op = new int[4];
    static int[] nums;
     
    static int min, max;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            nums = new int[N];
             
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
             
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                op[i] = Integer.parseInt(st.nextToken());
            }
 
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
             
            generatePermutation(0, nums[0]);
             
            System.out.println("#" + t + " " + (max - min));
        }
    }
     
    static void generatePermutation(int depth, int val) {
        if (depth == N - 1) {
            min = Math.min(val, min);
            max = Math.max(val, max);
            return;
        }
         
        for (int i = 0; i < 4; i++) {
            if (op[i] != 0) {
                op[i]--;
                generatePermutation(depth + 1, calculate(i, val, nums[depth + 1]));
                op[i]++;
            }
        }
    }
     
    static int calculate(int op, int num1, int num2) {
        switch (op) {
        case 0:
            return num1 + num2;
        case 1:
            return num1 - num2;
        case 2:
            return num1 * num2;
        case 3:
            return num1 / num2;
        }
        return Integer.MIN_VALUE;
    }
}