import java.util.*;

class Solution {
    
    static class Node {
        int index;
        char state;
        Node prev, next;
        
        Node(int index) {
            this.index = index;
            this.state = 'O';
        }
    }
    
    public String solution(int n, int k, String[] cmd) {
        Node[] list = new Node[n];
        
        list[0] = new Node(0);
        for (int i = 1; i < n; i++) {
            list[i] = new Node(i);
            list[i].prev = list[i - 1];
            list[i - 1].next = list[i];
        }
        
        Stack<Node> removed = new Stack<>(); // 삭제된 노드
        Node current = list[k]; // 선택중인 노드
        
        for (String c : cmd) {
            char command = c.charAt(0);
            
            switch (command) {
                case 'U': { // 위로 이동
                    int X = Integer.parseInt(c.split(" ")[1]);
                    
                    for (int i = 0; i < X; i++) {
                        current = current.prev;
                    }
                    break;
                }
                case 'D': { // 아래로 이동
                    int X = Integer.parseInt(c.split(" ")[1]);
                    
                    for (int i = 0; i < X; i++) {
                        current = current.next;
                    }
                    break;
                }
                case 'C': { // 삭제
                    current.state = 'X';
                    removed.push(current);
                    
                    if (current.prev != null) {
                        current.prev.next = current.next;
                    }
                    if (current.next != null) {
                        current.next.prev = current.prev;
                    }
                    
                    current = current.next != null ? current.next : current.prev;
                    break;
                }
                case 'Z': { // 복구
                    Node node = removed.pop();
                    node.state = 'O';
                    
                    if (node.prev != null) {
                        node.prev.next = node;
                    }
                    if (node.next != null) {
                        node.next.prev = node;
                    }
                    break;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            sb.append(list[i].state);
        }
        
        return sb.toString();
    }
}