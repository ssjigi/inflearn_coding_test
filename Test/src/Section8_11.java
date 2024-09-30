// 미로의 최단거리 (BFS)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Section8_11 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	
	static int arr[][];
	static int result = -1;
	static Queue<Point> q;
	
	public static void main() {
		Section8_11 T = new Section8_11();
		Scanner sc = new Scanner(System.in);
		
		arr = new int[8][8];
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		q = new LinkedList<>();
		arr[1][1] = 1;
		T.BFS();
		System.out.println(result);
	}
	
	private void BFS() {
		q.add(new Point(1, 1, arr[1][1]));
		while(!q.isEmpty()) {
			Point p = q.poll();
			 if (p.x == 7 && p.y == 7) {
				 break;
			 }
			
			for (int i = 0; i < dx.length; i++) {
				int new_x = p.x + dx[i];
				int new_y = p.y + dy[i];
				if (new_x > 0 && new_x < 8 && new_y > 0 && new_y < 8 
						&& arr[new_x][new_y] == 0) {
					q.add(new Point(new_x, new_y, arr[new_x][new_y]));
					arr[new_x][new_y] = 1;
				}
			}
			
			result++;
		}
	}
	
	class Point {
		int x;
		int y;
		int value;
		public Point(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}
	}
}
