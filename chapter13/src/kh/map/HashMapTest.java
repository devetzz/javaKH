package kh.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		// HashMap 구조를 생성하기
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(1, "홍길동");
		map.put(2, "저길동");
		map.put(3, "구길동");
		System.out.println(map);
		System.out.println("============================");
		
		// 중복된 키값 put 시 덮어쓴다
//		Map<Integer, String> map2 = new HashMap<Integer, String>();
//		map2.put(2, "우길동");
//		map2.putAll(map);
//		System.out.println(map2);
		
		// HashMap 데이터 변경 (replace)
		map.replace(3, "우길동");
		map.replace(2, "저길동", "사길동");
		System.out.println(map);
		
		// HashMap 데이터 추출 (get)
		System.out.println(map.get(1));
		System.out.println(map.containsKey(1));
		System.out.println(map.containsKey(5));
		System.out.println(map.containsValue("홍길동"));
		System.out.println(map.containsValue("김동진"));
		
		Map<String, Student> map2 = new HashMap<String, Student>();
		map2.put("홍길동", new Student(1, "010-1111-2222"));
		map2.put("저길동", new Student(1, "010-1111-2223"));
		map2.put("구길동", new Student(2, "010-1111-2224"));
		
		Student stu = map2.get("저길동");
		System.out.println(stu);
		
		// key값 => Set으로 변경하여 출력 (keySet)
		Set <String> keySet = map2.keySet();
		
		for(String key : keySet) {
			Student _stu = map2.get(key);
			System.out.println(_stu);
		}
		
		// HashMap 제거하기 (remove)
		System.out.println("============================");
		Map<Integer, String> map3 = new HashMap<Integer, String>();
		map3.put(1, "홍길동");
		map3.put(2, "저길동");
		map3.put(3, "구길동");
		System.out.println(map3);
		map3.remove(2, "저길동");
		System.out.println(map3);
		
		
		System.out.println("End");
	}

}
