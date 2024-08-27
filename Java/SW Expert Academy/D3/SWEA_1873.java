import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SWEA_1873 {
     
    static int H, W;
    static char[][] map;
    static int x, y;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
             
            map = new char[H][W];
             
            for (int i = 0; i < H; i++) {
                String line = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = line.charAt(j);
                    if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
                        x = i;
                        y = j;
                    }
                }
            }
             
            int N = Integer.parseInt(br.readLine());
            String command = br.readLine();
             
            for (int i = 0; i < N; i++) {
                work(command.charAt(i));
            }
             
            System.out.print("#" + t + " ");
            printMap();
        }
    }
     
    static void work(char cmd) {
        switch (cmd) {
        case 'U':
            if (x > 0 && map[x - 1][y] == '.') {
                map[x][y] = '.';
                map[--x][y] = '^';
            }
            else {
                map[x][y] = '^';
            }
                 
            break;
        case 'D':
            if (x < H - 1 && map[x + 1][y] == '.') {
                map[x][y] = '.';
                map[++x][y] = 'v';
            }
            else {
                map[x][y] = 'v';
            }
             
            break;
        case 'L':
            if (y > 0 && map[x][y - 1] == '.') {
                map[x][y] = '.';
                map[x][--y] = '<';
            }
            else {
                map[x][y] = '<';
            }
             
            break;
        case 'R':
            if (y < W - 1 && map[x][y + 1] == '.') {
                map[x][y] = '.';
                map[x][++y] = '>';
            }
            else {
                map[x][y] = '>';
            }
             
            break;
        case 'S':
            shoot(map[x][y]);
            break;
        }
    }
     
    static void shoot(char direction) {
        int bomb_x = x;
        int bomb_y = y;
         
        switch (direction) {
        case '^':
            while (bomb_x > 0) {
                if (map[--bomb_x][bomb_y] == '*') {
                    map[bomb_x][bomb_y] = '.';
                    break;
                }
                else if (map[bomb_x][bomb_y] == '#') break;
            }
             
            break;
        case 'v':
            while (bomb_x < H - 1) {
                if (map[++bomb_x][bomb_y] == '*') {
                    map[bomb_x][bomb_y] = '.';
                    break;
                }
                else if (map[bomb_x][bomb_y] == '#') break;
            }
             
            break;
        case '<':
            while (bomb_y > 0) {
                if (map[bomb_x][--bomb_y] == '*') {
                    map[bomb_x][bomb_y] = '.';
                    break;
                }
                else if (map[bomb_x][bomb_y] == '#') break;
            }
             
            break;
        case '>':
            while (bomb_y < W - 1) {
                if (map[bomb_x][++bomb_y] == '*') {
                    map[bomb_x][bomb_y] = '.';
                    break;
                }
                else if (map[bomb_x][bomb_y] == '#') break;
            }
            break;
        }
    }
     
    static void printMap() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}