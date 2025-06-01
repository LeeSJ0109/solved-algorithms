import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_5639 {

    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
        }

        void insert(int newValue) {
            if (newValue < this.value) {
                if (this.left == null) {
                    this.left = new Node(newValue);
                }
                else {
                    this.left.insert(newValue);
                }
            }
            else {
                if (this.right == null) {
                    this.right = new Node(newValue);
                }
                else {
                    this.right.insert(newValue);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        Node root = null;

        while ((input = br.readLine()) != null && !input.equals("")) {
            int value = Integer.parseInt(input);

            if (root == null) {
                root = new Node(value);
            }
            else {
                root.insert(value);
            }
        }

        postOrder(root);
    }

    static void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }
}
