import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2096 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] minScore = new int[3];
        int[] maxScore = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            int num = Integer.parseInt(st.nextToken());
            minScore[i] = num;
            maxScore[i] = num;
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int num3 = Integer.parseInt(st.nextToken());

            int[] prevMinScore = minScore.clone();
            int[] prevMaxScore = maxScore.clone();

            minScore[0] = Math.min(prevMinScore[0], prevMinScore[1]) + num1;
            minScore[1] = Math.min(Math.min(prevMinScore[0], prevMinScore[1]), prevMinScore[2]) + num2;
            minScore[2] = Math.min(prevMinScore[1], prevMinScore[2]) + num3;

            maxScore[0] = Math.max(prevMaxScore[0], prevMaxScore[1]) + num1;
            maxScore[1] = Math.max(Math.max(prevMaxScore[0], prevMaxScore[1]), prevMaxScore[2]) + num2;
            maxScore[2] = Math.max(prevMaxScore[1], prevMaxScore[2]) + num3;
        }

        System.out.println(Math.max(Math.max(maxScore[0], maxScore[1]), maxScore[2]) + " " + Math.min(Math.min(minScore[0], minScore[1]), minScore[2]));
    }
}
