import java.util.Scanner;

// 최대점수 구하기 (DFS 조합으로 품)
// 채점결과 : 158ms memory 27mb
public class Section10_6 {
	static int N; // 문제 개수
	static int M; // 푸는데 걸리는 전체 시간
	static int[][] arr;
	static int answer;
	public static void main() {
		Section10_6 T = new Section10_6();
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0;  j < 2; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < N; i++) {
			T.DFS(i, 0, 0);	
		}
		
		System.out.println(answer);
	}
	
	public void DFS(int start, int sum_point, int sum_time) {
		if (M >= sum_time) {
			// System.out.println("s = " + start + ", sum_point = " + sum_point + ", sum_time = " + sum_time + ", answer = " + answer);
			answer = Math.max(answer, sum_point);
			for (int i = start; i < N; i++) {
				DFS(i+1, sum_point+arr[i][0], sum_time+arr[i][1]);
			}
		}
//		if (M < sum_time) return;
//		if (M == sum_time) {
//			System.out.println("s = " + start + ", sum_point = " + sum_point + ", sum_time = " + sum_time + ", answer = " + answer);
//			answer = Math.max(answer, sum_point);
//		} else {
//			for (int i = start; i < N; i++) {
//				DFS(i+1, sum_point+arr[i][0], sum_time+arr[i][1]);
//			}
//		}
	}
}
