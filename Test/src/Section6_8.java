import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Section6_8 {
	public static void main() {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		Queue<P> q = new LinkedList<>();;
		TreeMap<Integer, Integer> maxMap = new TreeMap<>();
		
		for (int i = 0; i < N; i++) {
			int pririty = sc.nextInt();
			P p = new P(i, pririty);
			q.offer(p);
			maxMap.put(p.priority, maxMap.getOrDefault(p.priority, 0) + 1);
		}
		
		int answer = 0;
		while(!q.isEmpty()) {
			P p = q.poll();
			if (p.priority == maxMap.lastKey()) {
				int count = maxMap.get(maxMap.lastKey());
				if (count > 1) {
					maxMap.put(maxMap.lastKey(), count-1);	
				} else {
					maxMap.remove(maxMap.lastKey());
				}
				answer++;
				if (p.number == M) {
					break;
				}
			} else {
				q.offer(p);
			}
			
//			System.out.print(answer + ", max = " + maxMap.lastKey() + " : ");
//			for (Section6_8.P i : q) {
//				System.out.print(i.priority+" ");				
//			}
//			System.out.println();
			
		}
		
		System.out.println(answer);
	}
	
	public static class P {
		int number;
		int priority;
		public P(int number, int priority) {
			this.number = number;
			this.priority = priority;
		}
	}

}
