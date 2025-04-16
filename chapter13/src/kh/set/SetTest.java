package kh.set;

import java.util.*;

public class SetTest {

	public static void main(String[] args) {
		// set 추가한다(중복 불가)
		Set<String> set = new HashSet<>();
		set.add("a");
		set.add("b");
		set.add("c");
		set.add("d");
		System.out.println(set);

		// 가져온다
		for(String data : set) {
			System.out.println(data);
		}
		System.out.println("===================");
		// 향상된 for문 써라~
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		
		System.out.println("End");
	}

}
