import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630 {
	static int count_0 = 0;
	static int count_1 = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] paper = new int[N][N];
        
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divideAndCount(paper, 0, 0, N);
		
		System.out.println(count_0);
		System.out.println(count_1);
	}
	
	// �����̸� 4������� ������ ���� ���ĭ�� ���� ���̸� ī��Ʈ ����
	static void divideAndCount(int[][] paper, int i, int j, int size) {
		if (isUniform(paper, i, j, size)) {
			if (paper[i][j] == 0) 
				count_0++;
			else 
				count_1++;
			return;
		}

		int newSize = size / 2;
		divideAndCount(paper, i, j, newSize);
		divideAndCount(paper, i, j + newSize, newSize);
		divideAndCount(paper, i + newSize, j, newSize);
		divideAndCount(paper, i + newSize, j + newSize, newSize);
	}
	
	// ��� ĭ�� ���� ������ üũ
	static boolean isUniform(int[][] paper, int i, int j, int size) {
		int value = paper[i][j];
		
		for (int a = i; a < i + size; a++) {
			for (int b = j; b < j + size; b++) {
				if (paper[a][b] != value)
					return false;
			}
		}
		return true;
	}
}