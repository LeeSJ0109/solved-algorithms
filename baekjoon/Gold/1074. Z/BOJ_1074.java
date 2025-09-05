import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1074 {

    static int visitingOrder = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        int size = (int) Math.pow(2, N);

        find(size, r, c);
        System.out.println(visitingOrder);
    }

    static void find(int size, int r, int c) {

        if (size == 1) {
            return;
        }

        int nSize = size / 2;

        // ¿ÞÂÊ À§Ä­
        if (r < nSize && c < nSize) {
            find(nSize, r, c);
        }
        // ¿À¸¥ÂÊ À§Ä­
        else if (r < nSize && c >= nSize) {
            visitingOrder += nSize * nSize;
            find(nSize, r, c - nSize);
        }
        // ¿ÞÂÊ ¾Æ·¡Ä­
        else if (r >= nSize && c < nSize) {
            visitingOrder += 2 * nSize * nSize;
            find(nSize, r - nSize, c);
        }
        // ¿À¸¥ÂÊ ¾Æ·¡Ä­
        else {
            visitingOrder += 3 * nSize * nSize;
            find(nSize, r - nSize, c - nSize);
        }
    }
}
