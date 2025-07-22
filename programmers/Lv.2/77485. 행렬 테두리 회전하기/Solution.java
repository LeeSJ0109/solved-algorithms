import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] matrix = new int[rows][columns];

        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = num++;
            }
        }

        int idx = 0;
        for (int[] query : queries) {
            int x1 = query[0] - 1;
            int y1 = query[1] - 1;
            int x2 = query[2] - 1;
            int y2 = query[3] - 1;
            
            int min = Integer.MAX_VALUE;
            Queue<Integer> queue = new LinkedList<>();
            
            // 상
            for (int y = y1; y < y2; y++) {
                queue.add(matrix[x1][y]);
            }
            // 우
            for (int x = x1; x < x2; x++) {
                queue.add(matrix[x][y2]);
            }
            // 하
            for (int y = y2; y > y1; y--) {
                queue.add(matrix[x2][y]);
            }
            // 좌
            for (int x = x2; x > x1; x--) {
                queue.add(matrix[x][y1]);
            }
            
            for (int q : queue) {
                min = Math.min(q, min);
            }
            
            // 상
            for (int y = y1 + 1; y <= y2; y++) {
                matrix[x1][y] = queue.poll();
            }
            // 우
            for (int x = x1 + 1; x <= x2; x++) {
                matrix[x][y2] = queue.poll();
            }
            // 하
            for (int y = y2 - 1; y >= y1; y--) {
                matrix[x2][y] = queue.poll();
            }
            // 좌
            for (int x = x2 - 1; x >= x1; x--) {
                matrix[x][y1] = queue.poll();
            }
            
            answer[idx++] = min;
        }

        return answer;
    }
}
