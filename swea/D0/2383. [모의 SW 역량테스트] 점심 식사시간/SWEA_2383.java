import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_2383 {
    static class Person {
        int x, y;

        Person(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Stair {
        int x, y, length;

        Stair(int x, int y, int length) {
            this.x = x;
            this.y = y;
            this.length = length;
        }
    }

    static List<Person> people;
    static Stair[] stairs;
    static int n, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            people = new ArrayList<>();
            stairs = new Stair[2];

            int idx = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    int input = Integer.parseInt(st.nextToken());
                    if (input == 1) {
                        people.add(new Person(i, j));
                    } else if (input > 1) {
                        stairs[idx++] = new Stair(i, j, input);
                    }
                }
            }

            min = Integer.MAX_VALUE;

            DFS(0, new int[people.size()]);

            System.out.println("#" + t + " " + min);
        }
    }

    static void DFS(int idx, int[] selected) {
        if (idx == people.size()) {
            min = Math.min(min, calcTime(selected));
            return;
        }

        // 0번 계단 선택
        selected[idx] = 0;
        DFS(idx + 1, selected);

        // 1번 계단 선택
        selected[idx] = 1;
        DFS(idx + 1, selected);
    }

    @SuppressWarnings("unchecked")
    static int calcTime(int[] selected) {
        List<Integer>[] times = new ArrayList[2];
        times[0] = new ArrayList<>();   // 0번 계단으로 가는 사람들의 계단까지 도달하는 시간
        times[1] = new ArrayList<>();   // 1번 계단으로 가는 사람들의 계단까지 도달하는 시간

        for (int i = 0; i < selected.length; i++) {
            Person p = people.get(i);
            Stair s = stairs[selected[i]];
            // 계단까지 도달하는데 걸리는 시간
            int time = Math.abs(p.x - s.x) + Math.abs(p.y - s.y);
            times[selected[i]].add(time);
        }

        // 각 계단별로 시간을 계산
        int maxTime = 0;
        for (int i = 0; i < 2; i++) {
            List<Integer> timeList = times[i];
            if (timeList.isEmpty()) continue;

            // 각 사람의 계단까지 도달하는 시간을 오름차순으로 정렬
            timeList.sort(Integer::compareTo);

            int len = timeList.size();
            int[] exitTime = new int[len];
            for (int j = 0; j < len; j++) {
                int startTime = timeList.get(j);
                if (j < 3) {
                    // 첫 3명은 바로 계단을 내려갈 수 있음
                    // 이 경우 -> 계단을 다 내려가는 시간은 계단에 도달하는 시간 + 1
                    exitTime[j] = startTime + stairs[i].length + 1;
                } else {
                    // 4번째 사람부터는 앞에 있는 사람이 3명 이상일 경우 -> 계단에 빈 공간 생길 때까지 기다려야함
                    // 계단에 도달한 시간과 3번째 앞사람이 계단을 모두 내려간 시간 중 더 큰값이 내려가는 시간이 됨
                    // 1층에 누군가 도착했을 당시 새로운 사람이 진입할 수 있으므로 순간적으로 4명이 계단에 있을 수 있음 -> 이거 때매 테케 46개만 맞음
                    // exitTime[j - 3] - 1 로 비교
                    exitTime[j] = Math.max(exitTime[j - 3] - 1, startTime) + stairs[i].length + 1;
                }
            }
            maxTime = Math.max(maxTime, exitTime[len - 1]);
        }

        return maxTime;
    }
}
