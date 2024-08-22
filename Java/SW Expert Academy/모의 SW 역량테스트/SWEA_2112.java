import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class SWEA_2112 {
     
    static int D, W, K;
    static int[][] film;
    static int min;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
             
            film  = new int[D][W];
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    film[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            min = Integer.MAX_VALUE;
            makeFilm(0, 0);
            System.out.println("#" + t + " " + min);
        }
    }
     
    // depth: 현재 탐색한 보호 필름의 두께의 깊이
    // count: depth까지의 약품의 투입  횟수
    static void makeFilm(int depth, int count) {
        // 현 시점에서 약품의 투입 횟수가 최솟값 이상이 되면 더 이상의 진행은 의미 없음
        if (count >= min)
            return;
        // 모든 필름 층을 탐색했을 경우
        if (depth == D) {
            if (testPerformance()) {
                min = Math.min(min, count);
            }
            return;
        }
         
        // 약품 투입 안하는 경우
        makeFilm(depth + 1, count);
         
        int[] tmp = film[depth].clone();
         
        // A 약품을 투입하는 경우
        Arrays.fill(film[depth], 0);
        makeFilm(depth + 1, count + 1);
         
        // B 약품을 투입하는 경우
        Arrays.fill(film[depth], 1);
        makeFilm(depth + 1, count + 1);
         
        film[depth] = tmp;
    }
     
    static boolean testPerformance() {
        for (int j = 0; j < W; j++) {
            int count = 1;
            boolean isPass = false;
            for (int i = 1; i < D; i++) {
                if (film[i][j] == film[i - 1][j])
                    count++;
                else
                    count = 1;
                 
                // 이 열이 조건을 만족하면 다음 열 검사
                if (count >= K) {
                    isPass = true;
                    break;
                }
            }
            // 모든 열을 검사했지만 조건을 만족하지 못한 열이 있다면 실패
            if (!isPass) return false;
        }
         
        return true;
    }
}