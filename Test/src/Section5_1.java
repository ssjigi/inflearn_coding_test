import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Section5_1 {
	static int T;
	static String R;
	static HashMap<Character, Integer> map;
	public static void main() {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		R = sc.next();
		
		map = new HashMap<>(T);
		
		for (int i = 0; i < R.length(); i++) {
			char c = R.charAt(i);
			
			int count = map.getOrDefault(c, 0);
			count++;
			map.put(c, count);
		}
		
		
		
		List<Character> keyList = new ArrayList<>(map.keySet());
		Collections.sort(keyList, (o1, o2) -> (map.get(o1).compareTo(map.get(o2))));
		
		//for(Character ch : keyList) {
		//	System.out.println(ch + " : " + map.get(ch));	
		//}
		
		System.out.println(keyList.get(keyList.size()-1));
	}
}
