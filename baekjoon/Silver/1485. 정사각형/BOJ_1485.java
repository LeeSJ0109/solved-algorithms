import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1485 {

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            Point[] point = new Point[4];
            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                point[i] = new Point(x, y);
            }

            List<Integer> dists = new ArrayList<>();

            for (int i = 0; i < 4; i++) {
                for (int j = i + 1; j < 4; j++) {
                    dists.add(getDist2(point[i], point[j]));
                }
            }

            Collections.sort(dists);

            boolean isSquare = true;
            // 가장 짧은 거리 4개가 같아야 함 (변)
            for (int i = 0; i < 3; i++) {
                if (!dists.get(i).equals(dists.get(i + 1))) {
                    isSquare = false;
                    break;
                }
            }

            // 가장 긴 거리 2개가 같아야 함 (대각선)
            if (isSquare && !dists.get(4).equals(dists.get(5))) {
                isSquare = false;
            }

            // 변의 길이가 0이면 안 됨 (중복 점)
            if (dists.get(0) == 0) {
                isSquare = false;
            }

            System.out.println(isSquare ? 1 : 0);
        }
    }

    static int getDist2(Point a, Point b) {
        int dx = a.x - b.x;
        int dy = a.y - b.y;
        return dx * dx + dy * dy;
    }
}
