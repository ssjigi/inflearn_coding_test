import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class Section6_2 {
	public static void main() {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<>();
		
		String str = sc.next();
		// 1. 입력받은 문자열 for 문 돌며 하나씩 확인
		for(Character c : str.toCharArray()) {
			// 2. ')' 문자일 경우 stack에서 계속 pop - '(' 문자 나올 때까지
			if (c == ')') {
				while(stack.pop() != '('); 
			// 3. 다른 문자일 경우 stack 에 push
			} else {
				stack.push(c);
			}
		}
		
		Iterator it = stack.iterator();
		String answer = "";
		while(it.hasNext()) {
			Character ch = (Character) it.next();
			answer += ch;
		}
		
		System.out.println(answer);
	}
}
