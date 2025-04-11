package kh.phone05step;

import java.util.ArrayList;
import java.util.Scanner;

/* 
 * 4단계 변수명을 클래스(PhoneInfo)를 설계하여 관리
 * 이름, 전화번호, 나이, 성별
 * ArrayList로 n명을 입력받아서 출력하는 프로그램 작성
 * 입출력에 반복문 사용, 인원수는 상수를 사용
 */
public class PhoneMain {
	public static final int COUNT = 2;
	public static void main(String[] args) {
		// 변수 선언(ArrayList를 사용한다)
//		PhoneInfo[] pi = new PhoneInfo[COUNT];
		ArrayList<PhoneInfo> piList = new ArrayList<PhoneInfo>();

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
					String name = s.nextLine();
					System.out.printf("%d번째 전화번호 입력(-제외 입력) : ", i+1);
					String phoneNum = s.nextLine();
					System.out.printf("%d번째 나이 입력 : ", i+1);
					int age = Integer.parseInt(s.nextLine());
					System.out.printf("%d번째 성별 입력(m/f) : ", i+1);
					char gender = s.nextLine().charAt(0);
					PhoneInfo phoneInfo = new PhoneInfo(name, phoneNum, age, gender);
//					pi[i] = phoneInfo;
					piList.add(phoneInfo);
				}
				break;
			case 2:
				System.out.println("전화번호 출력");
				for(int i = 0; i < COUNT; i++) {
//					PhoneInfo p = pi[i];
					PhoneInfo p = piList.get(i);
					System.out.printf("%d번째 전화번호 : %-4s %10s %5d %4c\n", i+1, p.getName(), p.getPhoneNum(), p.getAge(), p.getGender());
				}
				break;
			case 3:
				System.out.println("정상적으로 종료되었습니다.");
				stopFlag = true;
				break;
			default:
				System.out.println("1~3번 범위 내에서 선택하세요.");
				break;
			}
		}
		
		
		// 종료
		s.close();
		System.out.println("End");
	}

}
