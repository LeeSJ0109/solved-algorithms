import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] data = new int[N][N];
        
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				data[i][j] = str.charAt(j) - '0';
			}
		}
		
		QuadTree(data, 0, 0, N);
	}
	
	// ���� �����͸� 4������� ����
	static void QuadTree(int[][] data, int i, int j, int size) {
		// ���� �����Ͱ� ��� ���� ���ڸ� ����
		if (isUniform(data, i, j, size)) {
			if (data[i][j] == 0) 
				System.out.print(0);
			else 
				System.out.print(1);
			return;
		}

		int newSize = size / 2;
		
		// ��� ���������� "(" ��� ������ ")"
		System.out.print("(");
		QuadTree(data, i, j, newSize);
		QuadTree(data, i, j + newSize, newSize);
		QuadTree(data, i + newSize, j, newSize);
		QuadTree(data, i + newSize, j + newSize, newSize);
		System.out.print(")");
	}
	
	// ��� ĭ�� ���� �������� üũ
	static boolean isUniform(int[][] data, int i, int j, int size) {
		int value = data[i][j];
		
		for (int a = i; a < i + size; a++) {
			for (int b = j; b < j + size; b++) {
				if (data[a][b] != value)
					return false;
			}
		}
		return true;
	}
}