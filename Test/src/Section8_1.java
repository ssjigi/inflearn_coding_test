import java.util.Scanner;

public class Section8_1 {
	int[] arr;
	int total = 0;
	boolean founded;
	
	public Section8_1() {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		arr = new int[count];
		for (int i = 0; i < count; i++) {
			arr[i] = sc.nextInt();
			total += arr[i];
		}
		
		DFS(0, 0);
	}
	
	public void DFS(int L, int sum) {
		if (founded) return;
		if (L > arr.length-1) return;
		
		if (sum == total/2) {
			System.out.println("YES");
			founded = true;
		} else {
			DFS(L+1, sum+arr[L]);
			DFS(L+1, sum);
		}
	}
}
