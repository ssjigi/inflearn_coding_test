import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Section5_5 {
	static int arr[];
	static HashSet<Integer> set;
	public static void main() {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		arr = new int[n1];
		set = new HashSet<>();
		
		for (int i = 0; i < n1; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 1. 3자리 모든 조합 구하기
		for (int i = 0; i < arr.length; i++) {
			DFS(0, 0, 0);
		}
		
		// 
		ArrayList<Integer> answer = new ArrayList<>(set);
		Collections.sort(answer, Collections.reverseOrder());
		if (answer.size() >= n2) {
			System.out.println(answer.get(n2-1));
		} else {
			System.out.println(-1);
		}
	}
	
	public static void DFS(int N, int start, int total) {
		if (N == 3) {
			set.add(total);
		} else {
			for (int i = start; i < arr.length; i++) {
				DFS(N+1, i+1, total + arr[i]);
			}
		}
	}

}
