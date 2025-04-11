package kh.phone06step;

import java.util.ArrayList;
import java.util.Scanner;

/* 
 * 5단계 
 * PhoneInfo(이름, 전화번호, 나이, 성별), 
 * PhoneUnivInfo(이름, 전화번호, 전공, 학년), 
 * PhoneCompanyInfo이름, 전화번호, 회사) 정보를 받기 위한 클래스 설계하여
 * 부모클래스(Phone(이름, 전화번호))를 정의하여 공통적인 부분을 상속받아 관리하도록 한다.
 * 모든 정보를 ArrayList로 관리하여 입력, 출력 하는 프로그램 작성
 */
public class PhoneMain {
	public static final int COUNT = 3;
	public static final String[] majorArray = {"", "컴공", "정보보안", "컴시", "인공지능"};
	public static final String[] companyArray = {"삼성", "엘지", "두산", "기아", "한화", "KT"};
	public static void main(String[] args) {
		// 변수 선언(ArrayList를 사용한다)
//		PhoneInfo[] pi = new PhoneInfo[COUNT];
//		ArrayList<PhoneInfo> piList = new ArrayList<PhoneInfo>();
		// 부모는 upcasting을 통해 모든 자식을 받을 수 있다.
		ArrayList<Phone> piList = new ArrayList<Phone>();

		Scanner s = new Scanner(System.in);
		boolean stopFlag = false;
		
		// 반복(입력, 출력, 연산)
		while(!stopFlag) {
			// 메뉴 선택
			System.out.println("****************");
			System.out.println("1. 데이터 입력");
			System.out.println("2. 데이터 출력");
			System.out.println("3. 데이터 검색");
			System.out.println("4. 데이터 삭제");
			System.out.println("5. 종료");
			System.out.println("****************");
			System.out.print("선택 > ");

			int no = Integer.parseInt(s.nextLine());
			
			// 메뉴 실행
			switch(no) {
			case 1:
				// 일반, 대학, 회사원 정보를 각각 3명씩 입력하는 함수
				inputPhoneInfos(piList);
				break;
			case 2:
				// 일반, 대학, 회사원 정보를 각각 3명씩 출력하는 함수
				printPhoneInfos(piList);
				break;
			case 3:
				System.out.print("검색할 이름 : ");
				String name = s.nextLine();
				boolean findFlag = false;
				for (Phone phone : piList) {
					if(phone.getName().equals(name)) {
						System.out.println(phone.toString());
						findFlag = true;
					}
				}
				if(findFlag == false) {
					System.out.printf("%s 의 정보는 없습니다.", name);
				}
				break;
			case 4:
				break;
			case 5:
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
	
	
	public static void printPhoneInfos(ArrayList<Phone> piList) {
		Scanner s = new Scanner(System.in);
		// 메뉴 선택
		System.out.println("*****************출력할 정보********************");
		System.out.println("1. 일반 정보\t 2. 대학 정보\t 3. 회사 정보");
		System.out.println("*********************************************");
		System.out.print("선택 > ");
		int _no = Integer.parseInt(s.nextLine());
		
		switch(_no) {
		case 1:
			System.out.println("일반인 출력");
			for(Phone phone : piList) {
				if(phone instanceof PhoneInfo) {
					PhoneInfo phoneInfo = (PhoneInfo)phone;
					System.out.println(phoneInfo.toString());
				}
			}
			break;
		case 2:
			System.out.println("대학생 출력");
			for(Phone phone : piList) {
				if(phone instanceof PhoneUnivInfo) {
					PhoneUnivInfo phoneUnivInfo = (PhoneUnivInfo)phone;
					System.out.println(phoneUnivInfo.toString());
				}
			}
			break;
		case 3:
			System.out.println("회사원 출력");
			for(Phone phone : piList) {
				if(phone instanceof PhoneCompanyInfo) {
					PhoneCompanyInfo phoneCompanyInfo = (PhoneCompanyInfo)phone;
					System.out.println(phoneCompanyInfo.toString());
				}
			}
			break;
		}
		
	}


	public static void inputPhoneInfos(ArrayList<Phone> piList) {
		Scanner s = new Scanner(System.in);
		// 메뉴 선택
		System.out.println("*************입력할 정보****************");
		System.out.println("1. 일반 정보\t 2. 대학 정보\t 3. 회사 정보");
		System.out.println("*************************************");
		System.out.print("선택 > ");
		int _no = Integer.parseInt(s.nextLine());
		
		switch(_no) {
		case 1:
			System.out.println("일반 정보 입력");
			for(int i=0 ; i < COUNT; i++) {
				String name = String.format("일반인%d", i+1);
				String phoneNum = String.format("0101111222%d", i+1);
				int age = (int)(Math.random()*(120-20+1)+20);
				char gender = (age % 2 == 0)?('남'):('여');
				Phone phoneInfo = new PhoneInfo(name, phoneNum, age, gender);
				piList.add(phoneInfo);
			}
			System.out.println("일반 정보 입력 완료!");
			break;
		case 2:
			System.out.println("대학 정보 입력");
			for(int i=0 ; i < COUNT; i++) {
				String name = String.format("대학생%d", i+1);
				String phoneNum = String.format("0103333444%d", i+1);
				int year = (int)(Math.random()*(4-1+1)+1);
				String major = majorArray[year];
				PhoneUnivInfo phoneUnivInfo = new PhoneUnivInfo(name, phoneNum, major, year);
				piList.add(phoneUnivInfo);
			}
			System.out.println("대학 정보 입력 완료!");
			break;
		case 3:
			System.out.println("회사 정보 입력");
			for(int i=0 ; i < COUNT; i++) {
				String name = String.format("회사원%d", i+1);
				String phoneNum = String.format("0105555666%d", i+1);
				String company = companyArray[(int)(Math.random()*(5-0+1)+0)];
				PhoneCompanyInfo phoneCompanyInfo = new PhoneCompanyInfo(name, phoneNum, company);
				piList.add(phoneCompanyInfo);
			}
			System.out.println("회사 정보 입력 완료!");
			break;
		}
		
	}

}
