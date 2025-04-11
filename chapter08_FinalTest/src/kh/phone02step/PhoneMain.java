package kh.phone02step;

import java.util.Scanner;

/* 1단계 변수 설정
 * 이름, 전화번호, 나이, 성별
 * 변수명을 정하고 2명을 입력받아서 출력하는 프로그램 작성
 */
public class PhoneMain {

	public static void main(String[] args) {
		// 변수 선언(배열을 사용하지 않는다)
		String name1 = null, name2 = null;
		String phoneNum1 = null, phoneNum2 = null;
		int age1 = 0, age2 = 0;
		char gender1 = 0, gender2 = 0;
		
		Scanner s = new Scanner(System.in);
		boolean stopFlag = false;
		
		// 반복(입력, 출력, 연산)
		while(!stopFlag) {
			// 메뉴 선택
			System.out.println("****************");
			System.out.println("1. 전화번호 입력");
			System.out.println("2. 전화번호 출력");
			System.out.println("3. 종료");
			System.out.println("****************");
			System.out.print("선택 > ");

			int no = Integer.parseInt(s.nextLine());
			
			// 메뉴 실행
			
			switch(no) {
			case 1:
				System.out.println("전화번호 입력");
				System.out.print("1번째 이름 입력 : ");
				name1 = s.nextLine();
				System.out.print("1번째 전화번호 입력(-제외 입력) : ");
				phoneNum1 = s.nextLine();
				System.out.print("1번째 나이 입력 : ");
				age1 = Integer.parseInt(s.nextLine());
				System.out.print("1번째 성별 입력(m/f) : ");
				gender1 = s.nextLine().charAt(0);
				
				System.out.print("2번째 이름 입력 : ");
				name2 = s.nextLine();
				System.out.print("2번째 전화번호 입력(-제외 입력) : ");
				phoneNum2 = s.nextLine();
				System.out.print("2번째 나이 입력 : ");
				age2 = Integer.parseInt(s.nextLine());
				System.out.print("2번째 성별 입력(m/f) : ");
				gender2 = s.nextLine().charAt(0);
				break;
			case 2:
				System.out.println("전화번호 출력");
				System.out.printf("1번째 전화번호 : %-4s %10s %5d %2c\n", name1, phoneNum1, age1, gender1);
				System.out.printf("2번째 전화번호 : %-4s %10s %5d %2c\n", name2, phoneNum2, age2, gender2);
				break;
			case 3:
				System.out.println("정상적으로 종료되었습니다.");
				stopFlag = true;
				break;
			default:
				System.out.println("1~3번 범위내에서 선택하세요.");
				break;
			}
		}
		
		
		// 종료
		s.close();
		System.out.println("End");
	}

}
