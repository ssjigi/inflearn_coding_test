import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Section6_7 {
	public static void main() {
		Scanner sc = new Scanner(System.in);
		String need = sc.next();
		String total = sc.next();
		Queue<Character> q = new LinkedList<>();
		for (int i = 0; i < total.length(); i++) {
			q.offer(total.charAt(i));
		}
		
		String answer = "NO";
		for (int i = 0; i < need.length(); i++) {
			char c = need.charAt(i);
			while(!q.isEmpty()) {
				char pc = q.poll();
				if (c == pc) {
					break;
				}
			}
		}
		
		if (!q.isEmpty()) {
			answer = "YES";
		}
		
		System.out.println(answer);
	}
}
