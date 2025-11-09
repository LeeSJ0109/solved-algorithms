import java.io.*;
import java.util.*;

public class BOJ_9328 {

    static int h, w;
    static char[][] map;

    static Set<Character> keySet;
    static Map<Character, List<int[]>> doorMap;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            map = new char[h + 2][w + 2];

            for (int i = 0; i < h + 2; i++) {
                if (i == 0 || i == h + 1) {
                    Arrays.fill(map[i], '.');
                    continue;
                }

                String line = br.readLine();
                for (int j = 0; j < w + 2; j++) {
                    if (j == 0 || j == w + 1) {
                        map[i][j] = '.';
                        continue;
                    }

                    map[i][j] = line.charAt(j - 1);
                }
            }

            keySet = new HashSet<>();
            doorMap = new HashMap<>();

            String keys = br.readLine();
            for (int key = 0; key < keys.length(); key++) {
                keySet.add(keys.charAt(key));
            }

            for (char c = 'A'; c <= 'Z'; c++) {
                doorMap.put(c, new ArrayList<>());
            }

            System.out.println(BFS());
        }
    }

    static int BFS() {
        boolean[][] visited = new boolean[h + 2][w + 2];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= h + 2 || ny >= w + 2) {
                    continue;
                }
                if (visited[nx][ny] || map[nx][ny] == '*') {
                    continue;
                }

                char c = map[nx][ny];
                if (isDocument(c)) {
                    count++;
                }
                else if (isDoor(c)) {
                    char needKey = Character.toLowerCase(c);
                    
                    // 문에 맞는 열쇠가 없음
                    if (!keySet.contains(needKey)) {
                        doorMap.get(c).add(new int[]{nx, ny});
                        continue;
                    }
                }
                else if (isKey(c)) {
                    if (!keySet.contains(c)) {
                        keySet.add(c);
                        
                        char targetDoor = Character.toUpperCase(c);
                        // 열쇠에 맞는 문 전부 큐에 추가
                        for (int[] door : doorMap.get(targetDoor)) {
                            queue.add(door);
                        }

                        doorMap.get(targetDoor).clear();
                    }
                }

                map[nx][ny] = '.';
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }

        return count;
    }

    static boolean isDocument(char c) {
        return c == '$';
    }

    static boolean isDoor(char c) {
        return c >= 'A' && c <= 'Z';
    }

    static boolean isKey(char c) {
        return c >= 'a' && c <= 'z';
    }
}
