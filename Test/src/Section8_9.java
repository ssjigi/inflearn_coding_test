// 조합 구하기

import java.util.Scanner;

public class Section8_9 {
	static int[] arr;
	static int[] answer;
	static int M;
	static int N;
	public static void main() {
		Section8_9 T = new Section8_9();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 자연수
		M = sc.nextInt(); // 뽑을 개수
		
		arr = new int[N];
		answer = new int[M];
		for (int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		
		T.DFS(0, 0);
	}
	
	void DFS(int L, int target) {
		if (L == M) {
			for (int i = 0; i < answer.length; i++) {
				System.out.print(answer[i] + " ");	
			}
			System.out.println();
		} else {
			if (target == N-1) return;
			for (int i = target; i < arr.length; i++) {
				answer[L] = arr[i];
				DFS(L+1, i+1);
			}
		}
	}
}
