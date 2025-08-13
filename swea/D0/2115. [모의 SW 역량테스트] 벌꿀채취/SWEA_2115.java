import java.io.*;
import java.util.*;
 
public class SWEA_2115 {
     
    static int N, M, C;
    static int max;
    static ArrayList<Integer> list;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
             
            int[][] honey = new int[N][N];
            int[][] sumHoney = new int[N][N-M+1];
             
            list = new ArrayList<>();
             
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    honey[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N-M+1; j++) {
                    for (int k = j; k < j+M; k++) {
                        list.add(honey[i][k]);
                    }
                     
                    calcMax(0, 0, 0);
                    sumHoney[i][j] = max;
                     
                    max = 0;
                    list.clear();
                }
            }
             
            int max = 0;
             
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N-M+1; j++) {
                    for (int a = i; a < N; a++) {
                        for (int b = 0; b < N-M+1; b++) {
                            if (i == a && Math.abs(j - b) < M) {
                                break;
                            }
                            else {
                                max = Math.max(max, sumHoney[i][j] + sumHoney[a][b]);
                            }
                        }
                    }
                }
            }
             
            System.out.println("#" + t + " " + max);
        }
    }
     
    static void calcMax(int depth, int sum, int cur) {
        if (sum > C) {
            return;
        }
 
        if (depth == M) {
            max = Math.max(max, cur);
            return;
        }
         
        calcMax(depth + 1, sum, cur);
        calcMax(depth + 1, sum + list.get(depth), cur + (int) Math.pow(list.get(depth), 2));
         
        return;
    }
}