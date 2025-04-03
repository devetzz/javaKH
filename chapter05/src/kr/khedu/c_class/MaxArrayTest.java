package kr.khedu.c_class;

import java.util.Arrays;

public class MaxArrayTest {

	public static void main(String[] args) {
		// 변수 선언
	
		// int[] a = new int[] {10,20,30,40,50};
		int[] a = new int[5];

		// 입력(정수값 5개 입력한다. 10~100 사이값 입력)
		for (int i = 0; i < a.length; i++) {
			a[i] = (int)(Math.random()*(100 - 10 + 1) + 10);
		}

		// 연산

		// 출력
		System.out.printf("배열값을 문자열로 보여주면 = %s\n",Arrays.toString(a));
		
		// 최소값
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < a.length; i++) {
			if(a[i] < min) {
				min = a[i];
			}
		}
		System.out.printf("최소값은 %d\n", min);
		// 최대값
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < a.length; i++) {
			if(a[i] > max) {
				max = a[i];
			}
		}
		System.out.printf("최대값은 %d\n", max);
		
		/*
		// 버블정렬 (내림차순)
		int imsi = Integer.MAX_VALUE;
		for(int j = 0; j < a.length-1; j++) {
			for(int i = 0; i < a.length-1; i++) {
				if(a[i] < a[i+1]) {
					imsi = a[i];
					a[i] = a[i+1];
					a[i+1] = imsi;
				}
			}
		}
		System.out.printf("내림차순으로 정렬된 문자열 = %s\n", Arrays.toString(a));
		*/
		
		// 정렬 (내림차순)
		int imsi2 = 0;
		for(int j = 0; j < a.length-1; j++) {
			for(int i = 0; i < a.length-(j+1); i++) {
				if(a[i] < a[(a.length-1)-j]) {
					imsi2 = a[(a.length-1)-j];
					a[(a.length-1)-j] = a[i];
					a[i] = imsi2;
				}
			}
		}
		System.out.printf("내림차순으로 정렬된 문자열 = %s\n", Arrays.toString(a));
		
		
		// 정렬 (오름차순)
		for(int j = 0; j < a.length-1; j++) {
			for(int i = 0; i < a.length-(j+1); i++) {
				if(a[i] > a[(a.length-1)-j]) {
					imsi2 = a[(a.length-1)-j];
					a[(a.length-1)-j] = a[i];
					a[i] = imsi2;
				}
			}
		}
		System.out.printf("오름차순으로 정렬된 문자열 = %s\n", Arrays.toString(a));
		
		// 종료
		System.out.println("End");
	}

}
