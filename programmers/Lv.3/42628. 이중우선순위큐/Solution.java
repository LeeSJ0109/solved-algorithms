import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);
        
        for (String operation : operations) {
            String[] op = operation.split(" ");
            String command = op[0];
            int num = Integer.parseInt(op[1]);
            
            if (command.equals("I")) {
                min.add(num);
                max.add(num);
            }
            else {
                if (min.isEmpty() || max.isEmpty()) {
                    continue;
                }
                
                if (num == 1) {
                    int value = max.poll();
                    min.remove(value);
                }
                else {
                    int value = min.poll();
                    max.remove(value);
                }
            }
        }
        if (min.isEmpty() || max.isEmpty()) {
            return new int[]{0, 0};
        }
        
        return new int[]{max.peek(), min.peek()};
    }
}