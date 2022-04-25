package algorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Hash {

	public static void main(String[] args) {
		
		// HashMap : key, value 쌍으로 구성된 Entry객체를 저장하는 자료 구조
		HashMap<String, String> map = new HashMap<String, String>();
		
		// 선언 방법
		HashMap<String, String> map1 = new HashMap<>(); // 타입 파라미터 생략이 가능
		HashMap<String, String> map2 = new HashMap<>(10, 0.7f); // 초기의 (Capacity, load factor) 지정 가능
																// List는 add하면 저장공간 +1이지만, Map은 +2되므로 메모리 낭비를 줄이기 위해
																// 크기를 지정할 수 있다면 지정해주는 것이 좋음
		HashMap<String, String> map3 = new HashMap<String, String>(10, 0.7f) {{
			put("a", "b");
			put("c", "d");
		}};	//초기값을 선언과 동시에 지정해줄 수 있음
		
		// 데이터 처리
		// 1. 추가
		map.put("a", "b");
		// 2. 삭제
		map.remove("a"); //삭제는 key값으로 삭제
		map.clear(); //전체 삭제
		
		// 3. 출력
		map.put("a", "test1");
		map.put("a", "test0");	// key값 중복 안됨. 가장 나중에 삽입하는 value값이 들어감
		map.put("c", "test3");
		map.put("b", "test2");
		map.put("d", "test3");	// value값 중복 가능
		// (1) 단순 출력
		System.out.println("(1) 단순 출력 : " + map + "\n");
		// (2) entrySet() 활용
		System.out.println("(2) entrySet() 활용");
		for(Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry); // key=value 형태로 출력
			System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
		}System.out.println();
		// (3) KeySet() 활용 -> key값만 필요할 때 사용하고, 많은 양의 데이터를 처리해야 할 때는 entrySet()을 사용하는 것이 좋음
		System.out.println("(3) KeySet() 활용");
		for(String s : map.keySet()) {
			System.out.println("key : " + s + ", value : " + map.get(s)); // ket 활용해 출력
		}System.out.println();
		// (4) Iterator 사용
		System.out.println("(4) Iterator 활용");
		Iterator<Entry<String, String>> iter = map.entrySet().iterator();
		while(iter.hasNext()) {
			Map.Entry<String, String> entry = iter.next();
			System.out.println(entry); // key=value 형태로 출력
			System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
		}System.out.println();
		
		//System.out.println(map.values().stream().sorted());
	}

}
