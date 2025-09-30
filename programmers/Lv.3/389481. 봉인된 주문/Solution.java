import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        // bans 정렬
        Arrays.sort(bans, (a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            return a.length() - b.length();
        });
        
        // 삭제된 주문 고려해서 n을 보정
        for (int i = 0; i < bans.length; i++) {
            String ban = bans[i];
            String cur = getString(n);
            
            // ban이 현재 주문보다 클 경우 무시
            if (ban.length() > cur.length()) {
                break;
            }
            
            // ban이 현재 주문보다 작을 경우 n++
            if (ban.length() < cur.length()) {
                n++;
            }
            else if (ban.compareTo(cur) <= 0) {
                n++;
            }
        }
        
        return getString(n);
    }
    
    // 숫자 -> 문자열 변환
    static String getString(long num) {
        StringBuilder sb = new StringBuilder();
        
        while (num > 0) {
            int mod = (int)(num % 26);
            num /= 26;
            
            if (mod == 0) {
                // z일 경우 보정
                sb.append('z');
                num--;
            }
            else {
                // {a : 0, b : 1, ...}
                sb.append((char)('a' + mod - 1));
            }
        }
        
        return sb.reverse().toString();
    }
}