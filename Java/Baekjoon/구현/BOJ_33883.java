import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_33883 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Character> set = new HashSet<>();
        set.add('a');set.add('e');set.add('i');set.add('o');set.add('u');set.add('n');set.add('s');
        String S = br.readLine();

        char[] chars = S.toCharArray();
        int len = chars.length;

        boolean isIrregularity = false;
        if (set.contains(chars[len - 1])) {
            isIrregularity = true;
        }

        set.clear();
        set.add('a');set.add('e');set.add('i');set.add('o');set.add('u');
        for (int i = len - 1; i >= 0; i--) {
            if (set.contains(chars[i])) {
                if (!isIrregularity) {
                    System.out.println(i + 1);
                    return;
                } else {
                    isIrregularity = false;
                }
            }
        }

        System.out.println(-1);
    }
}
