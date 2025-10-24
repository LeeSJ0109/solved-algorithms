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
     
    // depth: ���� Ž���� ��ȣ �ʸ��� �β��� ����
    // count: depth������ ��ǰ�� ����  Ƚ��
    static void makeFilm(int depth, int count) {
        // �� �������� ��ǰ�� ���� Ƚ���� �ּڰ� �̻��� �Ǹ� �� �̻��� ������ �ǹ� ����
        if (count >= min)
            return;
        // ��� �ʸ� ���� Ž������ ���
        if (depth == D) {
            if (testPerformance()) {
                min = Math.min(min, count);
            }
            return;
        }
         
        // ��ǰ ���� ���ϴ� ���
        makeFilm(depth + 1, count);
         
        int[] tmp = film[depth].clone();
         
        // A ��ǰ�� �����ϴ� ���
        Arrays.fill(film[depth], 0);
        makeFilm(depth + 1, count + 1);
         
        // B ��ǰ�� �����ϴ� ���
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
                 
                // �� ���� ������ �����ϸ� ���� �� �˻�
                if (count >= K) {
                    isPass = true;
                    break;
                }
            }
            // ��� ���� �˻������� ������ �������� ���� ���� �ִٸ� ����
            if (!isPass) return false;
        }
         
        return true;
    }
}