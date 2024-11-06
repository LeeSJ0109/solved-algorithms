import java.io.*;
import java.util.*;

public class BOJ_18442 {

    static int V, P;
    static long L;
    static long[] villages, postOffices, result;
    static long minDist = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        L = Long.parseLong(st.nextToken());
        villages = new long[V];
        postOffices = new long[P];
        result = new long[P];

        st = new StringTokenizer(br.readLine());
        for (int v = 0; v < V; v++) {
            villages[v] = Long.parseLong(st.nextToken());
        }

        comb(0, 0);

        System.out.println(minDist);
        for (long r: result) {
            System.out.print(r + " ");
        }
    }

    static void comb(int start, int count) {
        if (count == P) {
        	long sumDist = getDist();
            if (minDist > sumDist) {
                minDist = sumDist;
                result = postOffices.clone();
            }
            return;
        }

        for (int i = start; i < V; i++) {
            postOffices[count] = villages[i];
            comb(i + 1, count + 1);
        }
    }

    static long getDist() {
        long sumDist = 0;

        for (int i = 0; i < V; i++) {
        	long minDistance = Long.MAX_VALUE;
            for (int j = 0; j < P; j++) {
            	long dist = Math.min(Math.abs(villages[i] - postOffices[j]), L - Math.abs(villages[i] - postOffices[j]));
                minDistance = Math.min(minDistance, dist);
            }
            sumDist += minDistance;
        }

        return sumDist;
    }
}
