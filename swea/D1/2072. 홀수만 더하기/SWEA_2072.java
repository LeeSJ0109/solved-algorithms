import java.util.ArrayList;
import java.util.Scanner;
 
public class SWEA_2072 {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int result;
 
        ArrayList<Integer> list;
        for (int t = 0; t < T; t++) {
            result = 0;
            list = new ArrayList<>();
 
            for (int i = 0; i < 10; i++) {
                list.add(input.nextInt());
            }
 
            for (int i = 0; i < 10; i++) {
                if (list.get(i) % 2 == 1) {
                    result = result + list.get(i);
                }
            }
            System.out.println("#" + (t + 1) + " " + result);
        }
    }
}