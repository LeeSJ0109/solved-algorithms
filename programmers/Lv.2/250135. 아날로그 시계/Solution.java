class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;

        int t1 = h1 * 3600 + m1 * 60 + s1;
        int t2 = h2 * 3600 + m2 * 60 + s2;

        if (t1 == 0 || t1 == 43200) {
            answer++;
        }

        for (int t = t1; t < t2; t++) {
            double h = t / 120.0 % 360; // 43200초에 360도, 1초당 1/120도
            double m = t / 10.0 % 360; // 3600초에 360도, 1초당 1/10도
            double s = t * 6.0 % 360; // 60초에 360도, 1초당 6도

            double nh = calc((t + 1) / 120.0 % 360);
            double nm = calc((t + 1) / 10.0 % 360);
            double ns = calc((t + 1) * 6.0 % 360);

            if (s < h && nh <= ns) {
                answer++;
            }
            if (s < m && nm <= ns) {
                answer++;
            }
            if (ns == nh && nh == nm) {
                answer--;
            }
        }

        return answer;
    }
    
    public static double calc(double x) {
        return x == 0 ? 360 : x;
    }
}