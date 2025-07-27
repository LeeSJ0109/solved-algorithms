import java.util.Scanner;
 
public class SWEA_4796 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[] h = new int[N];
             
            for (int i = 0; i < N; i++) {
                h[i] = sc.nextInt();
            }
             
            int count = 0;
            int left = 0, right = 0;
            for (int i = 0; i < N - 1; i++) {
                // ±Ø¼Ú°ª Ã£À¸¸é
                if (i != 0 && h[i - 1] > h[i] && h[i] < h[i + 1]) {
                    count += left * right;
                    left = 0;
                    right = 0;
                }
                 
                // ¸¶Áö¸· - 1¹øÂ°°¡ ±Ø´ñ°ª, ¸¶Áö¸·ÀÌ ±Ø¼Ú°ªÀÎ °æ¿ì
                if (i == N - 2 && h[i] > h[i + 1]) {
                    count += left * (right + 1);
                    left = 0;
                    right = 0;
                }
 
                if (h[i] < h[i + 1])
                    left++;
                 
                if (h[i] > h[i + 1])
                    right++;    
            }
             
            System.out.println("#" + t + " " + count);
        }
        sc.close();
    }
}