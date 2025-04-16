package kh.arrays_aslist;

import java.util.*;

public class ArrayListLinkedListCompareMain {

	public static void main(String[] args) {
		// ArrayList 0번째 10만번 삽입하는 프로그램
		List<Integer> list1 = new ArrayList<>();
		long startTime = System.nanoTime();
		for(int i = 0; i < 100_000; i++) {
			list1.add(0, i);
		}
		long endTime = System.nanoTime();
		System.out.println("ArrayList = " + (endTime-startTime));
		
		
		
		List<Integer> list2 = new LinkedList<>();
		long startTime2 = System.nanoTime();
		for(int i = 0; i < 100_000; i++) {
			list2.add(0, i);
		}
		long endTime2 = System.nanoTime();
		System.out.println("LinkedList = " + (endTime2-startTime2));
		
		
		
		System.out.println("End");
	}

}
