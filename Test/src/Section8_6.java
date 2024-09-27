// 순열 구하기

import java.util.Scanner;

public class Section8_6 {
	static int arr[];
	static boolean included[];
	static int answer[];
	
	static int M;

	public static void main() {
		Section8_6 T = new Section8_6();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 자연수
		M = sc.nextInt(); // 뽑을 개수
		
		arr = new int[N];
		included = new boolean[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt(); 
		}
		
		answer = new int[M];
		
		T.DFS(0);
	}

	private void DFS(int L) {
		if (L == M) {
			for (int i = 0; i < answer.length; i++) {
				System.out.print(answer[i] + " ");	
			}
			
			System.out.println();
			return;
		} else {
			for (int i = 0; i < arr.length; i++) {
				if (included[i]) { // answer에 이미 포함된 자연수는 다시 추가 하지 않음.
					continue;
				} else {
					answer[L] = arr[i];
					included[i] = true; // answer에 이미 포함 여부
					DFS(L+1);
					included[i] = false; //	dfs 회귀 시 원복
				}
			}
		}
		
	}
}
