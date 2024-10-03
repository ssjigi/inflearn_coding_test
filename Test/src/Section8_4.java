import java.util.Scanner;

public class Section8_4 {
	static int N; // 1~N번까지 구슬
	static int M; // M 개 뽑기
	static int[] arr;
	static int[] answer;
	public static void main() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		answer = new int[M];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
		
		DFS(0);
	}
	
	static void DFS(int L) {
		if (L==M) {
			for (int i = 0; i < answer.length; i++) {
				System.out.print(answer[i] + " ");
			}
			System.out.println();
			return;
		} else {
			for (int i = 0; i < arr.length; i++) {
				answer[L] = i+1;
				DFS(L+1);
			}
		}
	}
	
}
