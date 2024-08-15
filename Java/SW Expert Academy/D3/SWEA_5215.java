import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215 {
    static int N, L;
    static int[] calorie;
    static int[] taste;
    
    static int sumCalorie = 0;
    static int sumTaste = 0;
    
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            
            calorie = new int[N];
            taste = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                calorie[i] = Integer.parseInt(st.nextToken());
                taste[i] = Integer.parseInt(st.nextToken());
            }
            
            max = 0;
            findMaxScore(0);
            
            System.out.println("#" + t + " " + max);
        }
    }

    public static void findMaxScore(int start) {
        if (sumCalorie > L) return;

        max = Math.max(max, sumTaste);

        for (int i = start; i < N; i++) {
        	sumTaste += calorie[i];
        	sumCalorie += taste[i];
            findMaxScore(i + 1);
            sumTaste -= calorie[i];
        	sumCalorie -= taste[i];
        }
    }
}
