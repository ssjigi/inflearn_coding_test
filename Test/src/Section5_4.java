import java.util.HashMap;
import java.util.Scanner;

public class Section5_4 {

	public static void main() {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		int str1_len = str1.length();
		int str2_len = str2.length();
		int answer = 0;
		
		HashMap<Character, Integer> map1 = new HashMap<>();
		HashMap<Character, Integer> map2 = new HashMap<>();
		for(int i = 0; i < str2_len; i++) {
			char c = str1.charAt(i);
			map1.put(c, map1.getOrDefault(c, 0)+1);
		}
		
		for(char c : str2.toCharArray()) {
			map2.put(c, map2.getOrDefault(c, 0)+1);
		}
		
		if (map1.equals(map2)) {
			answer++;
		}
		
		for (int i = 0; i < str1_len - str2_len; i++) {
			char c = str1.charAt(i);
			int val = map1.getOrDefault(c, 0);
			if (val > 1) {
				map1.put(c, val-1);
			} else {
				map1.remove(c);
			}
			
			char c2 = str1.charAt(i+str2_len);
			map1.put(c2, map1.getOrDefault(c2, 0)+1);
			
			if (map1.equals(map2)) {
				answer++;
			}
 		}
		
		System.out.println(answer);
	}

}
