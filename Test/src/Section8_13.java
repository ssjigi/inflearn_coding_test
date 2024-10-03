import java.util.Scanner;

// 13. 섬나라 아일랜드(DFS)
public class Section8_13 {
	static int N;
	static int[][] arr;
	static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static int result = 0;

	public static void main() {
		Section8_13 T = new Section8_13();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N+1][N+1];
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				if (arr[i][j] == 1) {
					result++;
					T.DFS(i, j);
				}
			}
		}
		
		System.out.println(result);
	}
	
	private void DFS(int x, int y) {
		arr[x][y] = 0;
		for (int i = 0; i < dx.length; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if (nx > 0 && ny > 0 && nx < N+1 && ny < N+1) {
				if (arr[nx][ny] == 1) {
					DFS(nx, ny);
				}
			}
		}
	}
}
