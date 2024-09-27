import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Section8_5 {
	static int M; // 거슬러 줄 금액
	static int answer = Integer.MAX_VALUE;
	static Integer[] arr;
	private Section8_5() {
		
	}
	public static void main() {
		Section8_5 s = new Section8_5();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 동전의 종류 개
		arr = new Integer[N]; // 동전 종류
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr, Collections.reverseOrder()); // 시간 복잡도 줄이기 위해 내림차순으로 큰값부터 답 찾기
		M = sc.nextInt(); // 거슬러 줄 금액
		
		//s.BFS(0, 0);
		s.DFS(0, 0);
		System.out.println(answer);
	}
	
	private void DFS(int L, int sum) {
		if (M < sum) return;
		if (L>=answer) return; // 시간복잡도 줄이기 위해 더 볼필요 없음
		if (M == sum) {
			answer = Math.min(answer, L);
			return;
		} else {
			for (int i = 0; i < arr.length; i++) {
				DFS(L+1, sum+arr[i]);	
			}
		}
	}
}
