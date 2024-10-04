import java.util.Scanner;

public class Section10_4 {
	static int N;
	static Block[] b;
	static int check;
	static int answer;
	public static void main() {
		Section10_4 T = new Section10_4();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		b = new Block[N];
		for (int i = 0; i < N; i++) {
			int m = sc.nextInt();
			int h = sc.nextInt();
			int w = sc.nextInt();
			b[i] = new Block(m, h, w);
		}
		
		T.DFS(0, 0, null);
		System.out.println(answer);
	}
	
	public void DFS(int L, int sum, Block prev_b) {
		for (int i = 0; i < b.length; i++) {
			if (b[i].included) {
				continue;
			}
			
			if (prev_b == null || (prev_b.m > b[i].m && prev_b.w > b[i].w)) {
				answer = Math.max(answer, sum+b[i].h);
				b[i].included = true;
				DFS(L++, sum+b[i].h, b[i]);
				b[i].included = false;	
			}
		}
		
	}
	
	public static class Block {
		int m;
		int h;
		int w;
		boolean included;
		
		public Block(int m, int h, int w) {
			this.m = m;
			this.h = h;
			this.w = w;
		}
	}
}
