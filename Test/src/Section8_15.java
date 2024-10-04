import java.util.ArrayList;
import java.util.Scanner;

public class Section8_15 {
	static int N; // 입력 받을 배열 크기
	static int M; // 뽑을 피자집 개수
	static int[][] arr;
	static ArrayList cityList;
	static ArrayList pizzaList;
	static Point[] pickedPizza;
	static int count;
	static int answer = Integer.MAX_VALUE;
	public static void main() {
		Section8_15 T = new Section8_15();
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N][N];
		cityList = new ArrayList<Point>();
		pizzaList = new ArrayList<Point>();
				
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][j] == 1) {
					cityList.add(new Point(i, j));	
				} else if (arr[i][j] == 2) {
					pizzaList.add(new Point(i, j));
				}
			}
		}
		
		pickedPizza = new Point[M];
		T.DFS(0, 0);
		System.out.println(answer);
	}
	
	private void DFS(int L, int index) {
		if (L == M) {
			// 이중 for문
			int result = 0;
			for (int i = 0; i < cityList.size(); i++) {
				int dis = Integer.MAX_VALUE;
				for (int j = 0; j < pickedPizza.length; j++) {
					Point city = (Section8_15.Point) cityList.get(i);
					Point pizza = pickedPizza[j];
					int newDis = Math.abs(city.x - pizza.x) + Math.abs(city.y - pizza.y);
					dis = Math.min(dis, newDis);
				}
				result += dis;
			}
			
			answer = Math.min(answer, result);
		} else {
			for (int i = index; i < pizzaList.size(); i++) {
				pickedPizza[L] = (Section8_15.Point) pizzaList.get(i);
				DFS(L+1, i+1);
			}
		}
		
	}
	
	public static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
