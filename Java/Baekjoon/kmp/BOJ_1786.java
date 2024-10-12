import java.io.*;

public class BOJ_1786 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String T = br.readLine();
		String P = br.readLine();
		
		int cnt = 0;
		
		// pi: P의 접두사와 접미사가 일치하는 길이를 저장하는 배열
		int[] pi = new int[P.length()];
		
		// ==========패턴 내 일치 부분 찾기 시작 (배열저장)
		// i: 접두사, j: 접미사
		int i = 0;
		for (int j = 1; j < P.length(); j++) {
			// 현재 접두사와 접미사의 문자가 일치하지 않는 경우
			// i를 pi[i - 1]로 이동시켜 일치하는 부분 길이를 줄임
			while (i > 0 && P.charAt(i) != P.charAt(j)) {
				i = pi[i - 1];
			}
			// 현재 접두사와 접미사의 문자가 일치하는 경우
			// i를 증가시키고, pi 배열에 그 값을 저장
			if (P.charAt(i) == P.charAt(j)) {
				pi[j] = ++i;
			}
		}
		
//		System.out.println(Arrays.toString(pi));
		
		// ==========전체 문자열에서 KMP 실행
		i = 0;
		for (int j = 0; j < T.length(); j++) {
			// 현재 접두사와 접미사의 문자가 일치하지 않는 경우
			// i를 pi[i - 1]로 이동
			while (i > 0 && P.charAt(i) != T.charAt(j)) {
				i = pi[i - 1];
			}
			
			// 현재 접두사와 접미사의 문자가 일치하는 경우
			if (P.charAt(i) == T.charAt(j)) {
				// 패턴이 전체 텍스트와 일치하는 경우
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
