import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1064 {

    static class Point {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        double distance(Point other) {
            return Math.hypot(this.x - other.x, this.y - other.y);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Point A = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        Point B = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        Point C = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));

        if (isColinear(A, B, C)) {
            System.out.println(-1.0);
            return;
        }

        // 가능한 평행사변형 3가지의 둘레 계산
        double[] perimeters = new double[3];

        perimeters[0] = 2 * (A.distance(B) + A.distance(C));
        perimeters[1] = 2 * (B.distance(A) + B.distance(C));
        perimeters[2] = 2 * (C.distance(A) + C.distance(B));

        double max = Math.max(perimeters[0], Math.max(perimeters[1], perimeters[2]));
        double min = Math.min(perimeters[0], Math.min(perimeters[1], perimeters[2]));

        System.out.printf("%.10f\n", max - min);
    }

    // 세 점이 일직선 위에 있는지 확인 (벡터 외적 == 0)
    static boolean isColinear(Point a, Point b, Point c) {
        // (b.x - a.x) * (c.y - a.y) == (b.y - a.y) * (c.x - a.x)
        return Math.abs((b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x)) < 1e-9;
    }
}
