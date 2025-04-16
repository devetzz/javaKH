package kh.arrays_aslist;

import java.util.*;

public class ArrayListMain {

	public static void main(String[] args) {
		// List = ArrayList 삽입, 삭제
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		System.out.println(list);
		
		Object[] objArray = list.toArray();
		System.out.println(Arrays.toString(objArray));
		String[] strAttay = list.toArray(new String[5]);
		System.out.println(Arrays.toString(strAttay));
		
		// 종료
		System.out.println("End");
	}

}
