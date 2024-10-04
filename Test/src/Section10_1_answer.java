import java.util.Scanner;
// dp bottom 153ms
public class Section10_1_answer {
	
	static int[] dy;
	public static void main() {
		Section10_1_answer T = new Section10_1_answer();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dy = new int[N+1];
		System.out.println(T.solution(N));
	}
	
	public int solution(int n) {
		dy[1] = 1;
		dy[2] = 2;
		for (int i = 3; i <= n; i++) {
			dy[i] = dy[i-2]+dy[i-1];
		}
		return dy[n];
	}
}
