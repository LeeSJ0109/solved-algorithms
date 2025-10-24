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

        // 0�� ��� ����
        selected[idx] = 0;
        DFS(idx + 1, selected);

        // 1�� ��� ����
        selected[idx] = 1;
        DFS(idx + 1, selected);
    }

    @SuppressWarnings("unchecked")
    static int calcTime(int[] selected) {
        List<Integer>[] times = new ArrayList[2];
        times[0] = new ArrayList<>();   // 0�� ������� ���� ������� ��ܱ��� �����ϴ� �ð�
        times[1] = new ArrayList<>();   // 1�� ������� ���� ������� ��ܱ��� �����ϴ� �ð�

        for (int i = 0; i < selected.length; i++) {
            Person p = people.get(i);
            Stair s = stairs[selected[i]];
            // ��ܱ��� �����ϴµ� �ɸ��� �ð�
            int time = Math.abs(p.x - s.x) + Math.abs(p.y - s.y);
            times[selected[i]].add(time);
        }

        // �� ��ܺ��� �ð��� ���
        int maxTime = 0;
        for (int i = 0; i < 2; i++) {
            List<Integer> timeList = times[i];
            if (timeList.isEmpty()) continue;

            // �� ����� ��ܱ��� �����ϴ� �ð��� ������������ ����
            timeList.sort(Integer::compareTo);

            int len = timeList.size();
            int[] exitTime = new int[len];
            for (int j = 0; j < len; j++) {
                int startTime = timeList.get(j);
                if (j < 3) {
                    // ù 3���� �ٷ� ����� ������ �� ����
                    // �� ��� -> ����� �� �������� �ð��� ��ܿ� �����ϴ� �ð� + 1
                    exitTime[j] = startTime + stairs[i].length + 1;
                } else {
                    // 4��° ������ʹ� �տ� �ִ� ����� 3�� �̻��� ��� -> ��ܿ� �� ���� ���� ������ ��ٷ�����
                    // ��ܿ� ������ �ð��� 3��° �ջ���� ����� ��� ������ �ð� �� �� ū���� �������� �ð��� ��
                    // 1���� ������ �������� ��� ���ο� ����� ������ �� �����Ƿ� ���������� 4���� ��ܿ� ���� �� ���� -> �̰� ���� ���� 46���� ����
                    // exitTime[j - 3] - 1 �� ��
                    exitTime[j] = Math.max(exitTime[j - 3] - 1, startTime) + stairs[i].length + 1;
                }
            }
            maxTime = Math.max(maxTime, exitTime[len - 1]);
        }

        return maxTime;
    }
}
