package kh.exception;

import java.util.Scanner;

public class DivideByZero {

	public static void main(String[] args) {
		// 예외를 방어하지 못했을 경우
		Scanner s = new Scanner(System.in);
		int num = 0;
		int result = 0;
		
		// num 입력
		boolean value = false;
		String strNum = null;
		// 숫자로 변환이 가능한 것인지 체크
		do {
			System.out.println("input num >> ");
			strNum = s.nextLine();
			// false (다시 입력), true(숫자 확인)
			if(!value) {
				continue;
			}
			value = checkNumber(strNum);
		}while(!value);
		
		num = Integer.parseInt(strNum);
		if(1 <= num && num <= 4) {
			System.out.println("원하는 값이 안됩니다.");
		}
		
		System.out.println("End");
	}

	public static boolean checkNumber(String strNum) {
		try {
			Double.parseDouble(strNum);
		}catch(Exception e) {
			System.out.println("숫자로 변환할 수 없습니다.");
			return false;
		}
		return true;
	}
}
