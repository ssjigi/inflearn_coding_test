import java.util.HashMap;
import java.util.Scanner;

public class Section5_2 {
	public static void main() {
		// 1. hashmap 에 max 100개의 문자를 모두 넣는다.
		// 2. 두번째 입력된 문자가 hashmap에 포함되어 있으면 continue, 없으면 NO
		
		Scanner sc = new Scanner(System.in);
		String input1 = sc.next();
		String input2 = sc.next();
		
		HashMap<Character, Integer> map1 = new HashMap<>();
		HashMap<Character, Integer> map2 = new HashMap<>();
		for(Character c : input1.toCharArray()) {
			map1.put(c, map1.getOrDefault(c, 0)+1);
		}
		
		for(Character c : input2.toCharArray()) {
			map2.put(c, map2.getOrDefault(c, 0)+1);
		}
		
		String result = map1.equals(map2) ? "YES" : "NO";
		System.out.println(result);
	}
}
