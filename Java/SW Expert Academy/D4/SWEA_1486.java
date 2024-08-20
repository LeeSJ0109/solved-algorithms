import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SWEA_1486 {
    static int N, B;
    static int[] H;
     
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            H = new int[N];
            min = Integer.MAX_VALUE;
                     
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                H[i] = Integer.parseInt(st.nextToken());
            }
             
            findHeight(0, 0);
             
            System.out.println("#" + t + " " + (min - B));
        }
    }
     
    static void findHeight(int start, int height) {
        if (height >= B) {
            min = Math.min(height, min);
            return;
        }
 
        for (int i = start; i < N; i++) {
            findHeight(i + 1, height + H[i]);
        }
    }
     
}