import java.io.*;
import java.util.*;

public class BOJ_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] set = new boolean[21];

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] cmd = br.readLine().split(" ");
            int x;
            switch (cmd[0]) {
                case "add":
                    x = Integer.parseInt(cmd[1]);
                    set[x] = true;
                    break;
                case "remove":
                    x = Integer.parseInt(cmd[1]);
                    set[x] = false;
                    break;
                case "check":
                    x = Integer.parseInt(cmd[1]);
                    sb.append(set[x] ? 1 : 0).append("\n");
                    break;
                case "toggle":
                    x = Integer.parseInt(cmd[1]);
                    set[x] = set[x] ? false : true;
                    break;
                case "all":
                    Arrays.fill(set, true);
                    break;
                case "empty":
                    Arrays.fill(set, false);
                    break;
            }
        }
        
        System.out.println(sb);
    }
}
