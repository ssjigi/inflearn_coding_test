import java.util.Scanner;

public class Section8_2 {
	int total_weight;
	int answer_weight;
	int dog_count;
	int[] arr;
	public Section8_2() {
		Scanner sc = new Scanner(System.in);
		total_weight = sc.nextInt();
		dog_count = sc.nextInt();
		arr = new int[dog_count];
		for (int i = 0; i < dog_count; i++) {
			arr[i] = sc.nextInt();
		}
		
		DFS(0, 0);
		System.out.println(answer_weight);
	}
	
	private void DFS(int L, int current_weight) {
		if (total_weight < current_weight) return;
		
		if (dog_count == L) {
			if (answer_weight < current_weight) {
				answer_weight = current_weight;
			}
		} else {
			DFS(L+1, arr[L]+current_weight);
			DFS(L+1, current_weight);
		}
		
	}
}
