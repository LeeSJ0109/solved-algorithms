import java.io.*;
import java.util.*;

public class BOJ_16566 {
    @SuppressWarnings("unused")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] mCards = new int[M]; // 민수 카드
        boolean[] used = new boolean[M]; // 사용된 민수 카드

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            mCards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(mCards);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int cCard = Integer.parseInt(st.nextToken()); // 철수가 낸 카드
            // 철수 보다 큰 카드 중 가장 작은 인덱스
            int idx = Arrays.binarySearch(mCards, cCard);
            idx = idx >= 0 ? idx + 1 : -idx - 1;

            // 철수보다 큰 카드 없으면 가장 작은거
            idx %= M;

            while (used[idx]) {
                idx++;
                if (idx == M) {
                    idx = 0;
                }
            }

            used[idx] = true;
            sb.append(mCards[idx]).append('\n');
        }

        System.out.println(sb);
    }
}
