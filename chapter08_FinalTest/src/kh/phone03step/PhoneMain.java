package kh.phone03step;

import java.util.Scanner;

/* 2단계 변수 설정을 배열 형식으로 전환하여 진행
 * 이름, 전화번호, 나이, 성별
 * 변수명을 정하고 n명을 입력받아서 출력하는 프로그램 작성
 * 입출력에 반복문 사용, 인원수는 상수를 사용
 */
public class PhoneMain {
	public static final int COUNT = 2;
	public static void main(String[] args) {
		// 변수 선언(배열을 사용한다)
		String[] name = new String[COUNT];
		String[] phoneNum = new String[COUNT];
		int[] age = new int[COUNT];
		char[] gender = new char[COUNT];
		
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
				for(int i=0 ; i < COUNT; i++) {
					System.out.printf("%d번째 이름 입력 : ", i+1);
					name[i] = s.nextLine();
					System.out.printf("%d번째 전화번호 입력(-제외 입력) : ", i+1);
					phoneNum[i] = s.nextLine();
					System.out.printf("%d번째 나이 입력 : ", i+1);
					age[i] = Integer.parseInt(s.nextLine());
					System.out.printf("%d번째 성별 입력(m/f) : ", i+1);
					gender[i] = s.nextLine().charAt(0);
				}
				break;
			case 2:
				System.out.println("전화번호 출력");
				for(int i = 0; i < COUNT; i++) {
					System.out.printf("%d번째 전화번호 : %-4s %10s %5d %4c\n", i+1, name[i], phoneNum[i], age[i], gender[i]);
				}
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
