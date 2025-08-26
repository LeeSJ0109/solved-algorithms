class Solution {
    public int solution(int[] a) {
        int N = a.length;
        
        if (N < 3) {
            return 2;
        }
        
        int[] prevMin = new int[N];
        int[] nextMin = new int[N];
        
        prevMin[0] = a[0];
        for (int i = 1; i < N; i++) {
            prevMin[i] = Math.min(prevMin[i - 1], a[i]);
        }
        
        nextMin[N - 1] = a[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            nextMin[i] = Math.min(nextMin[i + 1], a[i]);
        }
        
        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (a[i] <= prevMin[i] || a[i] <= nextMin[i]) {
                answer++;
            }
        }
        
        return answer;
    }
}