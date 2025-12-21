import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_20366 {

    static class Snowball {
        int i;
        int H;

        Snowball(int i, int H) {
            this.i = i;
            this.H = H;
        }
    }

    static class Snowman {
        Snowball head;
        Snowball body;

        Snowman(Snowball head, Snowball body) {
            this.head = head;
            this.body = body;
        }

        public int getSum() {
            return head.H + body.H;
        }

        public boolean isDuplicated(Snowman other) {
            return this.head.i == other.head.i || this.head.i == other.body.i ||
                    this.body.i == other.head.i || this.body.i == other.body.i;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] H = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            H[i] = Integer.parseInt(st.nextToken());
        }

        List<Snowman> snowmans = new ArrayList<Snowman>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                snowmans.add(new Snowman(new Snowball(i, H[i]), new Snowball(j, H[j])));
            }
        }

        snowmans.sort((o1, o2) -> o1.getSum() - o2.getSum());

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < snowmans.size() - 1; i++) {
            Snowman snowman1 = snowmans.get(i);
            Snowman snowman2 = snowmans.get(i + 1);

            if (snowman1.isDuplicated(snowman2)) {
                continue;
            }

            int diff = Math.abs(snowman1.getSum() - snowman2.getSum());
            minDiff = Math.min(minDiff, diff);

            if (minDiff == 0) {
                break;
            }
        }

        System.out.println(minDiff);
    }
}
