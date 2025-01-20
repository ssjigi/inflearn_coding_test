import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Section6_6 {
	public static void main() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int C = sc.nextInt();
		int answer = 0;
		
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		while(!q.isEmpty()) {
			for (int i = 0; i < C-1; i++) {
				q.offer(q.poll());
			}
			answer = q.poll();
		}
		
		System.out.println(answer);
	}
}
