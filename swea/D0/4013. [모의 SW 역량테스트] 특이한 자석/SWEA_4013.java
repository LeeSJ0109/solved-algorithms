import java.io.*;
import java.util.*;

public class SWEA_4013 {

	static LinkedList<Integer> magnet1, magnet2, magnet3, magnet4;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
        	int K = Integer.parseInt(br.readLine());
        	
        	magnet1 = new LinkedList<>();
        	magnet2 = new LinkedList<>();
        	magnet3 = new LinkedList<>();
        	magnet4 = new LinkedList<>();
        	
        	st = new StringTokenizer(br.readLine());
        	for (int i = 0; i < 8; i++) {
        		magnet1.add(Integer.parseInt(st.nextToken()));
			}
        	st = new StringTokenizer(br.readLine());
        	for (int i = 0; i < 8; i++) {
        		magnet2.add(Integer.parseInt(st.nextToken()));
			}
        	st = new StringTokenizer(br.readLine());
        	for (int i = 0; i < 8; i++) {
        		magnet3.add(Integer.parseInt(st.nextToken()));
			}
        	st = new StringTokenizer(br.readLine());
        	for (int i = 0; i < 8; i++) {
        		magnet4.add(Integer.parseInt(st.nextToken()));
			}

        	for (int i = 0; i < K; i++) {
        		st = new StringTokenizer(br.readLine());
				int magnetNum = Integer.parseInt(st.nextToken());
				int direction = Integer.parseInt(st.nextToken());
				
				rotate(magnetNum, direction);
			}
        	
        	System.out.println("#" + t + " " + (magnet1.get(0) * 1 + magnet2.get(0) * 2 + magnet3.get(0) * 4 + magnet4.get(0) * 8));
        	
        }
	}
	
	static void rotate(int magnetNum, int direction) {
		boolean rotate1 = false;
		boolean rotate2 = false;
		boolean rotate3 = false;
		boolean rotate4 = false;
		
		switch (magnetNum) {
		case 1:
			rotate1 = true;
			
			if (rotate1 && magnet1.get(2) != magnet2.get(6)) {
				rotate2 = true;
			}
			if (rotate2 && magnet2.get(2) != magnet3.get(6)) {
				rotate3 = true;
			}
			if (rotate3 && magnet3.get(2) != magnet4.get(6)) {
				rotate4 = true;
			}
			
			if (rotate1) {
				if (direction == 1) {
					magnet1.addFirst(magnet1.pollLast());
				}
				else {
					magnet1.addLast(magnet1.pollFirst());
				}
				direction *= -1;
			}
			if (rotate2) {
				if (direction == 1) {
					magnet2.addFirst(magnet2.pollLast());
				}
				else {
					magnet2.addLast(magnet2.pollFirst());
				}
				direction *= -1;
			}
			if (rotate3) {
				if (direction == 1) {
					magnet3.addFirst(magnet3.pollLast());
				}
				else {
					magnet3.addLast(magnet3.pollFirst());
				}
				direction *= -1;
			}
			if (rotate4) {
				if (direction == 1) {
					magnet4.addFirst(magnet4.pollLast());
				}
				else {
					magnet4.addLast(magnet4.pollFirst());
				}
			}
			break;
		case 2:
			rotate2 = true;
			if (rotate2 && magnet1.get(2) != magnet2.get(6)) {
				rotate1 = true;
			}
			if (rotate2 && magnet2.get(2) != magnet3.get(6)) {
				rotate3 = true;
			}
			if (rotate3 && magnet3.get(2) != magnet4.get(6)) {
				rotate4 = true;
			}
			
			if (rotate2) {
				if (direction == 1) {
					magnet2.addFirst(magnet2.pollLast());
				}
				else {
					magnet2.addLast(magnet2.pollFirst());
				}
				direction *= -1;
			}
			if (rotate1) {
				if (direction == 1) {
					magnet1.addFirst(magnet1.pollLast());
				}
				else {
					magnet1.addLast(magnet1.pollFirst());
				}
			}
			if (rotate3) {
				if (direction == 1) {
					magnet3.addFirst(magnet3.pollLast());
				}
				else {
					magnet3.addLast(magnet3.pollFirst());
				}
				direction *= -1;
			}
			if (rotate4) {
				if (direction == 1) {
					magnet4.addFirst(magnet4.pollLast());
				}
				else {
					magnet4.addLast(magnet4.pollFirst());
				}
			}
			break;
		case 3:
			rotate3 = true;
			if (rotate3 && magnet3.get(2) != magnet4.get(6)) {
				rotate4 = true;
			}
			if (rotate3 && magnet2.get(2) != magnet3.get(6)) {
				rotate2 = true;
			}
			if (rotate2 && magnet1.get(2) != magnet2.get(6)) {
				rotate1 = true;
			}
			
			if (rotate3) {
				if (direction == 1) {
					magnet3.addFirst(magnet3.pollLast());
				}
				else {
					magnet3.addLast(magnet3.pollFirst());
				}
				direction *= -1;
			}
			if (rotate4) {
				if (direction == 1) {
					magnet4.addFirst(magnet4.pollLast());
				}
				else {
					magnet4.addLast(magnet4.pollFirst());
				}
			}
			if (rotate2) {
				if (direction == 1) {
					magnet2.addFirst(magnet2.pollLast());
				}
				else {
					magnet2.addLast(magnet2.pollFirst());
				}
				direction *= -1;
			}
			if (rotate1) {
				if (direction == 1) {
					magnet1.addFirst(magnet1.pollLast());
				}
				else {
					magnet1.addLast(magnet1.pollFirst());
				}
			}
			break;
		case 4:
			rotate4 = true;
			if (rotate4 && magnet3.get(2) != magnet4.get(6)) {
				rotate3 = true;
			}
			if (rotate3 && magnet2.get(2) != magnet3.get(6)) {
				rotate2 = true;
			}
			if (rotate2 && magnet1.get(2) != magnet2.get(6)) {
				rotate1 = true;
			}
			
			if (rotate4) {
				if (direction == 1) {
					magnet4.addFirst(magnet4.pollLast());
				}
				else {
					magnet4.addLast(magnet4.pollFirst());
				}
				direction *= -1;
			}
			if (rotate3) {
				if (direction == 1) {
					magnet3.addFirst(magnet3.pollLast());
				}
				else {
					magnet3.addLast(magnet3.pollFirst());
				}
				direction *= -1;
			}
			if (rotate2) {
				if (direction == 1) {
					magnet2.addFirst(magnet2.pollLast());
				}
				else {
					magnet2.addLast(magnet2.pollFirst());
				}
				direction *= -1;
			}
			if (rotate1) {
				if (direction == 1) {
					magnet1.addFirst(magnet1.pollLast());
				}
				else {
					magnet1.addLast(magnet1.pollFirst());
				}
			}
			break;
		}
	}
}
