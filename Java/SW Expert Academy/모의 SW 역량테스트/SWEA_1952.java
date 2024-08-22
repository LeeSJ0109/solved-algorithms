import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1952 {

    static int[] ticketPrices = new int[4];
    static int[] plan = new int[12];
    static int minCost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;



        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                ticketPrices[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 12; i++) {
                plan[i] = Integer.parseInt(st.nextToken());
            }

            // 초기 비용을 1년 이용권 가격으로 설정
            minCost = ticketPrices[3];

            DFS(0, 0);
            System.out.println("#" + t + " " + minCost);
        }
    }

    static void DFS(int month, int currentCost) {
        // 현재 비용이 최소 비용을 넘어 갔을 경우는 최소비용이 될 수 없음
        if (currentCost >= minCost) return;

        // 모든 달을 전부 탐색했을 경우
        if (month >= 12) {
            minCost = Math.min(minCost, currentCost);
            return;
        }

        // 1일 이용권과 1달 이용권 중 더 적은 비용을 선택하여 진행
        DFS(month + 1, currentCost + Math.min(plan[month] * ticketPrices[0], ticketPrices[1]));

        // 3달 이용권 사용하는 경우
        DFS(month + 3, currentCost + ticketPrices[2]);
    }
}
