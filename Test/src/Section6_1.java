import java.util.Scanner;
import java.util.Stack;

public class Section6_1 {
	public static void main() {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<>();
		
		// 1. 문자열 입력 받기
		String str = sc.next();
		// 2. 문자열 for문 돌며 한개씩 확인
		for(Character c : str.toCharArray()) {
			// 3. ( 이면 stack 에 넣음
			if (c == '(') {
				stack.push(c);
			// 4. ) 이면 stack 에서 제거, 만약 제거 할게 없으면 NO
			} else {
				if (stack.isEmpty()) {
					System.out.println("NO");
					return;
				}
				stack.pop();
			}
		}
		
		// 5. for 문 모두 돈 후에 stack size가 0이면 YES
		if (stack.isEmpty()) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
