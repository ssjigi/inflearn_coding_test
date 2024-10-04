import java.util.Scanner;
// 계단오르기 - 중복있는 순열 DFS로 풀기, 244ms
public class Section10_1 {

	static int N;
	static int answer;
	public static void main() {
		Section10_1 T = new Section10_1();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		T.DFS(0, 0);
		System.out.println(answer);
	}
	
	void DFS(int L, int sum) {
		if (sum > N) return;
		if (sum == N) {
			answer++;
		} else {
			for (int i = 1; i < 3; i++) {
				DFS(L+1, sum+i);
			}
		}
	}
}
