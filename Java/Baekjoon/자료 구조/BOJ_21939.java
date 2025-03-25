import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_21939 {

    static class Problem implements Comparable<Problem> {
        int num;
        int level;

        public Problem(int num, int level) {
            this.num = num;
            this.level = level;
        }

        @Override
        public int compareTo(Problem o) {
            // 난이도가 같으면 문제 번호가 작은 것 부터
            if (this.level == o.level) {
                return this.num - o.num;
            }

            // 난이도 기준 정렬
            return this.level - o.level;
        }
    }

    static PriorityQueue<Problem> easyQueue = new PriorityQueue<>();
    static PriorityQueue<Problem> hardQueue = new PriorityQueue<>(Comparator.reverseOrder());

    static Map<Integer, Integer> problemMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            add(P, L);
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "recommend": {
                    int x = Integer.parseInt(st.nextToken());
                    sb.append(recommend(x)).append("\n");
                    break;
                }
                case "add": {
                    int P = Integer.parseInt(st.nextToken());
                    int L = Integer.parseInt(st.nextToken());
                    add(P, L);
                    break;
                }
                case "solved": {
                    int P = Integer.parseInt(st.nextToken());
                    solved(P);
                    break;
                }
            }
        }

        System.out.println(sb);
    }

    static int recommend(int x) {
        if (x == 1) {
            while (true) {
                Problem problem = hardQueue.peek();
                if (problemMap.get(problem.num) != problem.level) {
                    hardQueue.poll();
                }

                return hardQueue.peek().num;
            }
        }
        else {
            while (true) {
                Problem problem = easyQueue.peek();
                if (problemMap.get(problem.num) != problem.level) {
                    easyQueue.poll();
                }

                return easyQueue.peek().num;
            }
        }
    }

    static void add(int P, int L) {
        Problem problem = new Problem(P, L);
        easyQueue.add(problem);
        hardQueue.add(problem);
        problemMap.put(P, L);
    }

    static void solved(int P) {
        problemMap.put(P, 0);
    }
}
