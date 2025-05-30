import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2477 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        int[] dir = new int[6];
        int[] len = new int[6];

        int maxWidth = 0, maxHeight = 0;
        int maxWidthIdx = 0, maxHeightIdx = 0;

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dir[i] = Integer.parseInt(st.nextToken());
            len[i] = Integer.parseInt(st.nextToken());

            if ((dir[i] == 1 || dir[i] == 2) && len[i] > maxWidth) {
                maxWidth = len[i];
                maxWidthIdx = i;
            }
            if ((dir[i] == 3 || dir[i] == 4) && len[i] > maxHeight) {
                maxHeight = len[i];
                maxHeightIdx = i;
            }
        }

        int minWidth = Math.abs(len[(maxWidthIdx + 5) % 6] - len[(maxWidthIdx + 1) % 6]);
        int minHeight = Math.abs(len[(maxHeightIdx + 5) % 6] - len[(maxHeightIdx + 1) % 6]);

        int area = (maxWidth * maxHeight) - (minWidth * minHeight);
        System.out.println(area * K);
    }
}
