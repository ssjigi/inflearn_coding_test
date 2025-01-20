import java.util.Scanner;
import java.util.Stack;

public class Section6_5 {
	public static void main() {
		Scanner sc = new Scanner(System.in);
		String raw = sc.next();
		
		Stack<Character> s = new Stack<>();
	
		int answer = 0;
		for (int i = 0; i < raw.length(); i++) {
			char c = raw.charAt(i);
			if (c == '(') s.push('(');
			else if (c == ')'){ // 1. 닫는 괄호과 레이져인지 막대기의 끝을 뜻하는 것인지 에 따라 분류
				s.pop();
				if (raw.charAt(i-1) == '(') {
					answer += s.size();
				} else {
					answer++;
				}
			}
		}
		
		
// my answer		
//		int count = 0;
//		
//		for (int i = 0; i < raw.length(); i++) {
//			char c = raw.charAt(i);
//			if (c == '(') { // 1. '(' 이면 그 다음이 ')' 인지 확인하고 맞으면 현째까지 stack에 쌓여있는 '(' 갯수만큼 answer에 추가 하거 다다음 char 확인
//				if (raw.length() > i+1 && raw.charAt(i+1) == ')') {
//					answer += count;
//					i++;
//					continue;
//				} else { // 2. '(' 이고 그 다음이 ')' 이 아니면 stack에 push하고 count 1 증가
//					s.push(c);
//					count++;
//				}
//			
//			} else if (c ==')') { // ')' 이면 무조건 answer 1개씩 증가하고, '(' 한개 제거
//				count--;
//				answer++;
//				s.pop();
//			}
//		}
		
		System.out.println(answer);
	}
}