class Solution {
    public int solution(int[] players, int m, int k) {
        int n = players.length;

        int[] expServers = new int[n]; // 증설된 서버의 수
        int expCount = 0; // 증설 횟수

        for (int current = 0; current < n; current++) {
            int player = players[current]; // 현재 게임 이용자의 수
            int expServer = expServers[current]; // 현재 증설된 서버의 수

            while (player >= m * (expServer + 1)) {
                for (int i = current; i < current + k; i++) {
                    if (i >= n) {
                        break;
                    }

                    expServers[i]++;
                }

                expServer++;
                expCount++;
            }
        }


        return expCount;
    }
}