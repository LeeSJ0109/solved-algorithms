import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_16934 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        
        // 접두사별 등장 횟수
        Map<String, Integer> prefixCount = new HashMap<>();
        // 닉네임 등장 횟수
        Map<String, Integer> nicknameCount = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String nickname = br.readLine();
            StringBuilder prefix = new StringBuilder();

            boolean flag = false;

            // 접두사 하나씩 늘려가면서 확인
            for (char c : nickname.toCharArray()) {
                prefix.append(c);
                String currentPrefix = prefix.toString();

                // 이미 저장된 접두사면 다음 접두사 확인
                if (prefixCount.containsKey(currentPrefix)) {
                    continue;
                }

                // 아직 저장되지 않은 접두사면 별칭 저장
                sb.append(currentPrefix).append("\n");
                flag = true;
                break;
            }

            // 가능한 별칭이 없는 경우
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
