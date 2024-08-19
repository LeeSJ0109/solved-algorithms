import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class SWEA_1225 {
    static Queue<Integer> queue;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int t = 1; t <= 10; t++) {
            br.readLine();
            st = new StringTokenizer(br.readLine());
             
            queue = new LinkedList<>();
            for (int i = 0; i < 8; i++) {
                queue.add(Integer.parseInt(st.nextToken()));
            }
             
            System.out.println("#" + t + " " +generatePassword().replaceAll(",", "").replace("[", "").replace("]", ""));
        }
 
    }
     
    private static String generatePassword() {
        while (true) {
            for (int i = 1; i <= 5; i++) {
                int num = queue.poll() - i;
                if (num <= 0) {
                    num = 0;
                    queue.add(num);
                    return queue.toString();
                }
                else {
                    queue.add(num);
                }
            }
        }
    }
}