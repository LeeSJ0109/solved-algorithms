import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SWEA_3421 {
     
    static int[][] invalid;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
          
        int T = Integer.parseInt(br.readLine());
          
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
             
            invalid = new int[M][2];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                invalid[i] = new int[] {a, b};
            }
             
            int count = 0;
            int totalCombinations = 1 << N;
             
            for (int mask = 0; mask < totalCombinations; mask++) {
                boolean flag = true;
                for (int i = 0; i < M; i++) {
                    if ((mask & (1 << (invalid[i][0]))) != 0 && (mask & (1 << (invalid[i][1]))) != 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) count++;
            }
             
            System.out.println("#" + t + " " + count);
        }
    }
}