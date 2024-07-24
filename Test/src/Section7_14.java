import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Section7_14 {
	private static HashMap<Integer, ArrayList> map = new HashMap<>();
	private static boolean visit[];
	
	private static Queue<Integer> queue = new LinkedList<>();
	static int nodes;
	static int edges;
	static int L;
	
	public Section7_14() {
		Scanner sc = new Scanner(System.in);
		nodes = sc.nextInt();
		edges = sc.nextInt();
		
		 
		for (int i = 1; i <= nodes; i++) {
			map.put(i, new ArrayList<Integer>());
		}
		
		visit = new boolean[nodes+1];
		
		for (int i = 0; i < edges; i++) {
			int n = sc.nextInt();
			int e = sc.nextInt();
			map.get(n).add(e);
		}
		
		for (int i = 1; i <= map.size(); i++) {
			ArrayList list = map.get(i);
			System.out.print(i);
			for (int j = 0; j < list.size(); j++) {
				System.out.print(" " + list.get(j));
			}
			System.out.println();
		}
		
		for (int i = 2; i <= nodes; i++) {
			System.out.print(i + " : ");
			BFS(i);	
		}

	}
	
	public static void BFS(int target) {
		L = 0;
		queue.clear();
		queue.add(1);
		for (int i = 1; i < visit.length; i++) {
			visit[i] = false;
		}
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int node = queue.poll();
				visit[node] = true;
				if (node == target) {
					System.out.println(L);
					return;
				}
				
				ArrayList<Integer> list = map.get(node);
				for (Integer n : list) {
					if (!visit[n]) {
						queue.add(n);	
					}
				}
			}
			
			L++;
		}
		
	}
}
