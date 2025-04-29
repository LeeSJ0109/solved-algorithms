import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_16934 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        
        // ���λ纰 ���� Ƚ��
        Map<String, Integer> prefixCount = new HashMap<>();
        // �г��� ���� Ƚ��
        Map<String, Integer> nicknameCount = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String nickname = br.readLine();
            StringBuilder prefix = new StringBuilder();

            boolean flag = false;

            // ���λ� �ϳ��� �÷����鼭 Ȯ��
            for (char c : nickname.toCharArray()) {
                prefix.append(c);
                String currentPrefix = prefix.toString();

                // �̹� ����� ���λ�� ���� ���λ� Ȯ��
                if (prefixCount.containsKey(currentPrefix)) {
                    continue;
                }

                // ���� ������� ���� ���λ�� ��Ī ����
                sb.append(currentPrefix).append("\n");
                flag = true;
                break;
            }

            // ������ ��Ī�� ���� ���
            if (!flag) {
                int count = nicknameCount.getOrDefault(nickname, 0) + 1;

                sb.append(nickname)
                        .append(count == 1 ? "" : count)
                        .append("\n");
            }

            prefix = new StringBuilder();
            for (char c : nickname.toCharArray()) {
                prefix.append(c);
                String currentPrefix = prefix.toString();
                prefixCount.put(currentPrefix, prefixCount.getOrDefault(currentPrefix, 0) + 1);
            }
            nicknameCount.put(nickname, nicknameCount.getOrDefault(nickname, 0) + 1);
        }

        System.out.println(sb);
    }
}
