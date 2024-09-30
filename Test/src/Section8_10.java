
// 10.미로탐색(DFS)

import java.util.Iterator;
import java.util.Scanner;

public class Section8_10 {
	
	static int[][] arr;
	static int[] dx = { -1, 1, 0, 0 }; // 상, 하, 좌, 우
	static int[] dy = { 0, 0, -1, 1 };
	static int result;
	public static void main() {
		Section8_10 T = new Section8_10();
		Scanner sc = new Scanner(System.in);
		
		arr = new int[8][8];
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		T.DFS(1, 1);
		System.out.println(result);
	}
	
	private void DFS(int x, int y) {
		if (x < 1 || x > 7 || y < 1 || y > 7) return;
		if (arr[x][y] == 1) return;
		
		if (x == 7 && y == 7) {
			result++;
			return;
		}

		arr[x][y] = 1;
		for (int i = 0; i < 4; i++) {
			DFS(x+dx[i], y+dy[i]);
		} 
		arr[x][y] = 0;
		
	}
}
