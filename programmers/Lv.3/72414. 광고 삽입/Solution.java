class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = timeToInt(play_time);
        int advTime = timeToInt(adv_time);
        
        int[] view = new int[playTime + 1];
        
        for (String log : logs) {
            String[] splitLog = log.split("-");
            int start = timeToInt(splitLog[0]);
            int end = timeToInt(splitLog[1]);
            
            for (int i = start; i < end; i++) {
                view[i]++;
            }
        }
        
        long sum = 0;
        for (int i = 0; i < advTime; i++) {
            sum += view[i];
        }
        
        long max = sum;
        
        int advStartTime = 0;
        for (int i = advTime; i < playTime; i++) {
            // 광고 삽입 구간 1초씩 움직이면서 누적 재생시간 갱신
            sum += view[i] - view[i - advTime];
                
            if (sum > max) {
                max = sum;
                advStartTime = i - advTime + 1;
            }
        }
        
        return timetoString(advStartTime);
    }
    
    // HH:MM:SS -> 초 단위 시간
    static int timeToInt(String time) {
        String[] hms = time.split(":");
        int h = Integer.parseInt(hms[0]);
        int m = Integer.parseInt(hms[1]);
        int s = Integer.parseInt(hms[2]);
        int sec = h * 3600 + m * 60 + s;
        
        return sec;
    }
    
    // 초 단위 시간 -> HH:MM:SS
    static String timetoString(int time) {
        int h = time / 3600;
        time %= 3600;
        int m = time / 60;
        int s = time % 60;
        
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}