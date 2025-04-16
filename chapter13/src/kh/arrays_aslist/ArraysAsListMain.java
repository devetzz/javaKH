package kh.arrays_aslist;

import java.util.*;

public class ArraysAsListMain {

	public static void main(String[] args) {
		// List = ArrayList 삽입, 삭제
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		System.out.println(list);
		list.remove(0);
		System.out.println(list);
		
		System.out.println("================");
		// List = Arrays.asList 삽입, 삭제
		try {
			List<String> al = Arrays.asList("a","b","c","d");
			System.out.println(al);
			if(al.contains("c")) {
				System.out.println("해당 값이 배열에 있어요");
			}else{
				System.out.println("해당 값이 배열에 없어요");
			}
			al.remove("a");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("list 종료");
		}
		
		
		// 종료
		System.out.println("End");
	}

}
