import java.io.*;

public class BOJ_1786 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String T = br.readLine();
		String P = br.readLine();
		
		int cnt = 0;
		
		// pi: P�� ���λ�� ���̻簡 ��ġ�ϴ� ���̸� �����ϴ� �迭
		int[] pi = new int[P.length()];
		
		// ==========���� �� ��ġ �κ� ã�� ���� (�迭����)
		// i: ���λ�, j: ���̻�
		int i = 0;
		for (int j = 1; j < P.length(); j++) {
			// ���� ���λ�� ���̻��� ���ڰ� ��ġ���� �ʴ� ���
			// i�� pi[i - 1]�� �̵����� ��ġ�ϴ� �κ� ���̸� ����
			while (i > 0 && P.charAt(i) != P.charAt(j)) {
				i = pi[i - 1];
			}
			// ���� ���λ�� ���̻��� ���ڰ� ��ġ�ϴ� ���
			// i�� ������Ű��, pi �迭�� �� ���� ����
			if (P.charAt(i) == P.charAt(j)) {
				pi[j] = ++i;
			}
		}
		
//		System.out.println(Arrays.toString(pi));
		
		// ==========��ü ���ڿ����� KMP ����
		i = 0;
		for (int j = 0; j < T.length(); j++) {
			// ���� ���λ�� ���̻��� ���ڰ� ��ġ���� �ʴ� ���
			// i�� pi[i - 1]�� �̵�
			while (i > 0 && P.charAt(i) != T.charAt(j)) {
				i = pi[i - 1];
			}
			
			// ���� ���λ�� ���̻��� ���ڰ� ��ġ�ϴ� ���
			if (P.charAt(i) == T.charAt(j)) {
				// ������ ��ü �ؽ�Ʈ�� ��ġ�ϴ� ���
				if (i == P.length() - 1) {
					cnt++;
					sb.append(j - P.length() + 2).append("\n");
					i = pi[i];
				}
				else {
					i++;
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(sb);
	}
}
