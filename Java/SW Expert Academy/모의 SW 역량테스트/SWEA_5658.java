import java.io.*;
import java.util.*;
 
public class SWEA_5658 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int len = N / 4;
             
            String str = br.readLine();
            sb.append(str).append(str);
            str = sb.toString();
             
            HashSet<String> set = new HashSet<>();
             
            for (int i = 0; i < N; i++) {
                set.add(str.substring(i, i + len));
            }
             
            ArrayList<String> list = new ArrayList<>(set);
            Collections.sort(list, Collections.reverseOrder());
             
            System.out.println("#" + t + " " + Integer.parseInt(list.get(K-1), 16));
        }
    }
}