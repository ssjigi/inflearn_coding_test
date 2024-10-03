import java.util.LinkedList;j
import java.util.Queue;
import java.util.Scanner;

public class Section8_13_2 {
	static int N;
	static int[][] arr;
	static int result;
	static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static Queue<Node> q;
	public static void main() {
		Section8_13_2 T = new Section8_13_2();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N+1][N+1];
		q = new LinkedList<>();
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				if (arr[i][j] == 1) {
					arr[i][j] = 0;
					q.offer(new Node(i, j));
					T.BFS(i, j);
					result++;
				}
			}
		}
		
		System.out.println(result);
	}
	
	public void BFS(int x, int y) {
		while(!q.isEmpty()) {
			Node n = q.poll();
			for (int i = 0; i < dx.length; i++) {
				int nx = n.x + dx[i];
				int ny = n.y + dy[i];
				if (nx > 0 && ny > 0 && nx < N+1 && ny < N+1 && arr[nx][ny] == 1) {
					arr[nx][ny] = 0;
					q.offer(new Node(nx, ny));
				}
			}
		}
	}
	
	public static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
