import java.io.*;
import java.util.*;

public class BOJ_5800 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int K = Integer.parseInt(br.readLine());

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] score = new int[N];
            for (int j = 0; j < N; j++) {
                score[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(score);

            int largestGap = 0;
            for (int j = 1; j < N; j++) {
                largestGap = Math.max(largestGap, score[j] - score[j - 1]);
            }
            System.out.println("Class " + i);
            System.out.println("Max " + score[N-1] + ", Min " + score[0] + ", Largest gap " + largestGap);
        }
    }
}
