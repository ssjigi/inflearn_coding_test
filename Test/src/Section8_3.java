import java.util.Scanner;

public class Section8_3 {
	int N; // 문제 개수
	int M; // 전체 시간
	int[][] arr; // 점수, 시간
	int answer;
	
	public Section8_3() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt(); // 점수
			arr[i][1] = sc.nextInt(); // 시간
		}
		
		DFS(0, 0, 0);
		System.out.println(answer);
	}
	
	private void DFS(int L, int time_sum, int point_sum) {
		if (N > L && M > time_sum + arr[L][1]) {
			DFS(L+1, time_sum + arr[L][1], point_sum + arr[L][0]);
			DFS(L+1, time_sum, point_sum);
		} else {
			if (answer < point_sum) {
				answer = point_sum;
			}
		}
	}
}
