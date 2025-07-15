class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int current = storey % 10; // 현재 자릿수
            int next = storey / 10 % 10; // 다음 자릿수

            if (current > 5 || (current == 5 && next >= 5)) {
                // 올림
                answer += (10 - current);
                storey += (10 - current); // 다음 자릿수 올림
            }
            else {
                // 내림
                answer += current;
            }

            storey /= 10;
        }
        
        return answer;
    }
}