import java.io.*;
import java.util.*;

class SegmentTree {
	private long[] tree;
    private long[] arr;
    private int N;
    
    public SegmentTree(long[] array) {
        N = array.length;
        arr = array;
        tree = new long[N * 4];
        init(1, 0, N - 1);
    }
    
    private void init(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } 
        else {
            int mid = (start + end) / 2;
            init(node * 2, start, mid);
            init(node * 2 + 1, mid + 1, end);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }
    
    public long query(int left, int right) {
        return query(1, 0, N - 1, left, right);
    }
    
    private long query(int node, int start, int end, int left, int right) {
        // 1. [left,right]와 [start,end]가 겹치지 않는 경우
    	if (right < start || end < left) {
            return 0;
        }
    	// 2. [left,right]가 [start,end]를 완전히 포함하는 경우
    	// 3. [start,end]가 [left,right]를 완전히 포함하는 경우
        if (left <= start && end <= right) {
            return tree[node]; // 구간 안
        }
        // 4. [left,right]와 [start,end]가 겹쳐져 있는 경우
        int mid = (start + end) / 2;
        long leftSum = query(node * 2, start, mid, left, right);
        long rightSum = query(node * 2 + 1, mid + 1, end, left, right);
        return leftSum + rightSum;
    }
    
    public void update(int index, long value) {
        update(1, 0, N - 1, index, value);
    }

    private void update(int node, int start, int end, int index, long value) {
        // 1. [start, end]에 index가 포함되는 경우
    	if (start == end) {
            arr[index] = value;
            tree[node] = value;
        } 
    	// 2. [start, end]에 index가 포함되지 않는 경우
        else {
            int mid = (start + end) / 2;
            if (start <= index && index <= mid) {
                update(node * 2, start, mid, index, value);
            } 
            else {
                update(node * 2 + 1, mid + 1, end, index, value);
            }
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }
}

public class BOJ_2042 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		long[] arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}

		SegmentTree segmentTree = new SegmentTree(arr);

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken()) - 1;
			long c = Long.parseLong(st.nextToken());

			if (a == 1) {
				segmentTree.update(b, c);
			}
			if (a == 2) {
				System.out.println(segmentTree.query(b, (int) c - 1));
			}
		}
	}
}
