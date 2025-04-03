package self;

import java.util.Arrays;

public class MaxMinSort {

	public static void main(String[] args) {
		
		// 입력(정수값 5개 입력한다. 랜덤값 저장)
		// 공식 : (int)(Math.random()*(큰값-작은값+1)+작은값)
		int[] a = new int[10];

		for (int i = 0; i < a.length; i++) {
			a[i] = (int)(Math.random()*(200 - 10 + 1) + 10);
		}
		// 출력
		System.out.printf("배열값을 문자열로 보여주면 = %s\n",Arrays.toString(a));
		
		// 최대값 구하기
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < a.length; i++) {
			if(a[i] > max) {
				max = a[i];
			}
		}
		System.out.printf("max = %d\n", max);
		
		// 최소값 구하기
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < a.length; i++) {
			if(a[i] < min) {
				min = a[i];
			}
		}
		System.out.printf("min = %d\n", min);

		// 정렬 (오름차순)
		int imsi = 0;
		for(int j = 0; j < a.length; j++) {
			for(int i = j; i < a.length; i++) {
				if(a[i] < a[j]) {
					imsi = a[j];
					a[j] = a[i];
					a[i] = imsi;
				}
			}
		}
		System.out.printf("오름차순으로 정렬된 문자열 = %s\n", Arrays.toString(a));
		// 정렬 (내림차순)
		int imsi2 = 0;
		for(int j = 0; j < a.length; j++) {
			for(int i = j; i < a.length; i++) {
				if(a[i] > a[j]) {
					imsi2 = a[j];
					a[j] = a[i];
					a[i] = imsi2;
				}
			}
		}
		System.out.printf("내림차순으로 정렬된 문자열 = %s\n", Arrays.toString(a));

	}

}
