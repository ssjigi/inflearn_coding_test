import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Section5_3 {

	public static void main() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int[] arr = new int[N];
		ArrayList<Integer> answer = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i < K; i++) {
			Integer t = (Integer) map.getOrDefault(arr[i], 0);
			map.put(arr[i], t+1);
		}

		answer.add(map.size());
		
		// 1. K개의 부분합 구해서 Hashset에 넣고 hashset length 구하자
		for (int i = 0; i < N-K; i++) {
			Integer lt = (Integer) map.get(arr[i]);
			if (lt > 1) {
				map.put(arr[i], lt-1);
			} else {
				map.remove(arr[i]);
			}
			
			Integer rt = (Integer) map.getOrDefault(arr[i+K], 0);
			map.put(arr[i+K], rt+1);
				
			answer.add(map.size());
		}
		
		for (int i = 0; i < answer.size(); i++) {
			System.out.print(answer.get(i) + " ");
		}
	}
}
