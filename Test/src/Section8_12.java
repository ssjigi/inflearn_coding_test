import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Section8_12 {
	public static int M; // 가로칸수 (y)
	public static int N; // 세로칸수 (x)
	public static int[][] arr;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };
	public static Queue<Tomato> q;
	public static int result = -1;
	
	public static void main() {
		Section8_12 T = new Section8_12();
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		
		arr = new int[N+1][M+1];
		q = new LinkedList<>();
		
		boolean all_cooked = true;
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < M+1; j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][j] == 1) {
					Tomato t = new Tomato(i, j, arr[i][j], 0);
					q.offer(t);
				} else if (arr[i][j] == 0) {
					all_cooked = false;
				}
			}
		}
		
		if (all_cooked) {
			System.out.println(0);
		} else {
			T.BFS();
			boolean not_cooked = false;
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < M+1; j++) {
					if (arr[i][j] == 0) {
						not_cooked = true;
					}
				}
			}
			
			if (not_cooked) {
				result = -1;
			}
			System.out.println(result);
		}
	}
	
	private void BFS() {
		while(!q.isEmpty()) {
			Tomato t = q.poll();
			for (int i = 0; i < dx.length; i++) {
				int new_x = t.x + dx[i];
				int new_y = t.y + dy[i];
				
				if (new_x > 0 && new_x < N+1 && new_y > 0 && new_y < M+1) {
					if (arr[new_x][new_y] == 0) {
						arr[new_x][new_y] = 1;
						result = t.level+1;
						Tomato new_t = new Tomato(
								new_x, new_y, arr[new_x][new_y], result);
						q.offer(new_t);
					}
				}
			}
		}
	}
	
	public static class Tomato {
		int x;
		int y;
		int value;
		int level;
		public Tomato(int x, int y, int value, int level) {
			this.x = x;
			this.y = y;
			this.value = value;
			this.level = level;
		}
	}
}
