package chapter03;

import java.util.Scanner;

public class ArrayTest {

	public static void main(String[] args) {
		// 변수 선언(배열 선언)
		int[] score = new int[5];
		Scanner scan = new Scanner(System.in);

		// 반복 입력
		for(int i = 0; i < 5; i++) {
			System.out.printf("score[%d] 입력 요청 : ", i);
			score[i] = Integer.parseInt(scan.nextLine());
		}
		
	
		// 연산
		// 출력
		for(int i = 0; i < score.length; i++) {
			System.out.printf("score[%d] = %d\n", i, score[i]);
		}
		
		// 종료
		scan.close();

	}

}
