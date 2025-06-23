class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0};
        
        while (!s.equals("1")) {
            int count = 0;
            int size = s.length();
            
            for (int i = 0; i < size; i++) {
                if (s.charAt(i) == '1') {
                    count++;
                }
                else {
                    answer[1]++;
                }
            }
            
            s = Integer.toBinaryString(count);
            answer[0]++;
        }
        
        return answer;
    }
}