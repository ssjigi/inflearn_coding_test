import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Section6_3 {
	public static void main() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Queue<Integer>[] queue = new LinkedList[N];
		for (int i = 0; i < queue.length; i++) {
			queue[i] = new LinkedList<>(); 
		}

		// 1. board : queue 배열로 구현하여 입력 받기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int p = sc.nextInt();
				if (p == 0) continue;
				queue[j].offer(p);
			}
		}
		
		int M = sc.nextInt();
		int[] moves = new int[M];
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < M; i++) {
			// 2. 해당 queue 배열에서, 꺼내서 stack 에 넣음. 넣기 직전에 stack front의 값과 비교 
			Queue<Integer> currentQueue = queue[sc.nextInt()-1];
			if (currentQueue.isEmpty()) continue;
  
			int p = currentQueue.poll();
			if (!stack.isEmpty()) {
				int prev = stack.peek();
				// 3. 같으면 stack의 front 제거하고 answer 2 추가
				if (prev == p) {
					stack.pop();
					answer += 2;
				} else {
					// 4. 같지 않으면 stack에 추가
					stack.push(p);
				}
			} else {
				stack.push(p);
			}
			
		}
		
		System.out.println(answer);
	}
	
}
