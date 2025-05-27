import java.io.*;
import java.util.*;

public class BOJ_2655 {

    static class Brick implements Comparable<Brick> {
        int index, area, height, weight;

        public Brick(int index, int area, int height, int weight) {
            this.index = index;
            this.area = area;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Brick o) {
            return o.area - this.area;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Brick[] bricks = new Brick[N];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int area = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            bricks[i - 1] = new Brick(i, area, height, weight);
        }

        // �ظ��� ���� �������� �������� ����
        Arrays.sort(bricks);

        // DP �迭: �� ������ ����� ž�� �ִ� ���̸� ����
        int[] dp = new int[N];

        // �� ������ �ܵ����� ����� ����� ���̴� ���� ��ü�� ����
        for (int i = 0; i < N; i++) {
            dp[i] = bricks[i].height;
        }

        int maxHeight = 0;
        int lastBrick = -1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                // ���� ����(i)�� ���԰� ���� ����(j)���� ������� �� ���� ���� �� ����
                if (bricks[i].weight < bricks[j].weight && dp[i] < dp[j] + bricks[i].height) {
                    dp[i] = dp[j] + bricks[i].height;
                }
            }
            if (dp[i] > maxHeight) {
                maxHeight = dp[i];
                lastBrick = i;
            }
        }

        // ž�� �����ϴ� ������ ����
        List<Integer> result = new ArrayList<>();

        int currentHeight = maxHeight;
        for (int i = lastBrick; i >= 0; i--) {
            if (dp[i] == currentHeight) {
                result.add(bricks[i].index);
                currentHeight -= bricks[i].height;
            }
        }

        System.out.println(result.size());

        for (int index : result) {
            System.out.println(index);
        }
    }
}
