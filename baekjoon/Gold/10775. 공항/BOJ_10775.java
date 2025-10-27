import java.io.*;

public class BOJ_10775 {

    static int[] gate;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine()); // 게이트 수
        int P = Integer.parseInt(br.readLine()); // 비행기 수

        gate = new int[G + 1];
        for (int i = 1; i <= G; i++) {
            gate[i] = i;
        }

        int count = 0;
        for (int i = 0; i < P; i++) {
            int g = Integer.parseInt(br.readLine());
            int availableGate = getAvailableGate(g);

            if (availableGate == 0) {
                break;
            }

            gate[availableGate] = getAvailableGate(availableGate - 1);
            count++;
        }

        System.out.println(count);
    }

    static int getAvailableGate(int g) {
        int availableGate = g;

        // 사용할 수 있는 게이트 찾기
        while (availableGate > 0 && gate[availableGate] != availableGate) {
            availableGate = gate[availableGate];
        }

        // 사용할 수 있는 게이트 갱신
        while (g > 0 && gate[g] != g) {
            int next = gate[g];
            gate[g] = availableGate;
            g = next;
        }

        return availableGate;
    }
}