import java.io.*;
import java.util.*;
 
public class SWEA_3307 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] B = new int[N];
            int[] LIS = new int[N];
             
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
             
            for (int i = 0; i < N; i++) {
                LIS[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (B[j] < B[i] && LIS[i] < LIS[j] + 1) {
                        LIS[i] = LIS[j] + 1;
                    }
                }
            }
             
            Arrays.sort(LIS);
             
            System.out.println("#" + t + " " + LIS[N - 1]);
        }
    }
}