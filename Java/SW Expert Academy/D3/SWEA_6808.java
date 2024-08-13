import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6808 {
	static int[] in = new int[9];
    static int[] gyu = new int[9];
    
    static boolean[] usedCards = new boolean[19];
    
    static int win;
    static int lose;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            usedCards = new boolean[19];

            for (int i = 0; i < 9; i++) {
                gyu[i] = Integer.parseInt(st.nextToken());
                usedCards[gyu[i]] = true;
            }

            int idx = 0;
            for (int i = 1; i <= 18; i++) {
                if (!usedCards[i]) {
                    in[idx++] = i;
                }
            }
            
            win = 0;
            lose = 0;
            
            permutations(0);
            
            System.out.println("#" + t + " " + win + " " + lose);
        }
    }
    
    public static void permutations(int idx) {
        if (idx == 9) {
        	int gs = 0;
	        int is = 0;
	        
	        for (int i = 0; i < 9; i++) {
	            if (gyu[i] > in[i]) gs += gyu[i] + in[i];
	            else if (gyu[i] < in[i]) is += gyu[i] + in[i];
	        }
	
	        if (gs > is) win++;
	        else if (gs < is) lose++;
        }

        else {
	        for (int i = idx; i < 9; i++) {
	            swap(in, i, idx);
	            permutations(idx + 1);
	            swap(in, i, idx);
	        }
        }
    }
    
    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
