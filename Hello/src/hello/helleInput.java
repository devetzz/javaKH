package hello;

import java.util.Scanner;

public class helleInput {

	public static void main(String[] args) {
		// 입력(이름, 나이, 몸무게, 혈액형, 성별)
		String name = "";
		int age = 0;
		double weight = 0.0;
		String bloodType = "";
		boolean gender = false;
		char grade = 0;
		
		// 입력 (키보드로부터 입력을 통해서 값을 가져오는 인터페이스
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름을 입력해주세요 : ");
		name = scan.nextLine();
		
		System.out.print("나이를 입력해주세요 : ");
		age = Integer.parseInt(scan.nextLine());
		
		System.out.print("몸무게를 입력해주세요 : ");
		weight = Double.parseDouble(scan.nextLine());
		
		System.out.print("혈액형을 입력해주세요 : ");
		bloodType = scan.nextLine();
		
		System.out.print("성별을 입력해주세요(true:남자, false:여자) : ");
		gender = Boolean.parseBoolean(scan.nextLine());
		
		System.out.print("등급을 입력해주세요 : ");
		grade = (scan.nextLine()).charAt(0);
		
		
		// 출력
		System.out.printf("name = %s님\n", name);
		System.out.printf("age = %d세\n", age);
		System.out.printf("weight = %6.2fkg\n", weight);
		System.out.printf("bloodType = %s형\n", bloodType);
		
		if(gender == true) {
			System.out.printf("gender = 남자\n");
		}else {
			System.out.printf("gender = 여자\n");
		}
		System.out.printf("grade = %c\n", grade);
		System.out.printf("The End!\n");
		
		scan.close();
	}

}
