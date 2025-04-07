package self;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class EmpMain {
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		// 변수 선언
		boolean stopFlag = false;
		ArrayList<Emp> empList = new ArrayList<Emp>();
		
		// 반복문 (입력, 출력, 계산, 검색, 삭제, 종료)
		while(!stopFlag) {
			// 메뉴 표시
			menuPrint();
			// 메뉴 입력
			int num = inputNum();
			
			switch(num) {
			case 1:
				// 입력
				String name;
				String dept;
				int money;
				char grade;
				
				System.out.println("★★★ 1. 임직원 입력 ★★★");
//				do {
//					System.out.print("이름 : ");
//					name = scan.nextLine();
//					boolean isNameCheck = Pattern.matches("^[a-zA-Z|가-힣]{2,20}$", name);
//					if(isNameCheck == true) {
//						break;
//					}
//					System.out.println("이름을 정확히 입력하세요!");
//					
//				}while(true);
				name = PatternInspection(scan, "이름 : ", "^[a-zA-Z|가-힣]{2,20}$");
				
				
				do {
					System.out.print("부서 : ");
					dept = scan.nextLine();
					boolean isDeptCheck = Pattern.matches("[0-9a-zA-Z|가-힣]{1,20}", dept);
					if(isDeptCheck == true) {
						break;
					}
					System.out.println("부서를 정확히 입력하세요!");
				}while(true);
				
				do {
					System.out.print("급여 : ");
					money = Integer.parseInt(scan.nextLine());
					boolean isMoneyCheck = Pattern.matches("[0-9]*", String.valueOf(money));
					if(isMoneyCheck == true) {
						break;
					}
					System.out.println("급여를 정확히 입력하세요!");
				}while(true);
				
				do {
					System.out.print("등급 : ");
					grade = scan.nextLine().charAt(0);
					boolean isGradeCheck = Pattern.matches("[A,B,C,D,a,b,c,d]{1}", String.valueOf(grade));
					if(isGradeCheck == true) {
						break;
					}
					System.out.println("등급을 정확히 입력하세요!(A,B,C,D)");
				}while(true);
				
				
				Emp emp = new Emp(name, dept, money, grade);
				empList.add(emp);
				
				System.out.println("★★★ 입력 완료 ★★★");
				break;
			case 2:
				// 출력
				System.out.println("★★★ 2. 임직원 출력 ★★★");
				for(int i = 0; i < empList.size(); i++) {
					System.out.println(empList.get(i).toString());
				}
				break;
			case 3:
				// 보너스 계산
				// 등급에 따라 보너스 포인트 부여 A, B, C, 그외
				// 총급여 = 급여 + (급여 * 보너스 포인트)
				System.out.println("★★★ 3. 보너스 계산 ★★★");
				for(int i = 0; i < empList.size(); i++) {
					if(empList.get(i).getGrade() == 'A' || empList.get(i).getGrade() == 'a') {
						empList.get(i).setBonusPoint(0.3);
						empList.get(i).setTotalMoney(empList.get(i).getMoney()+(empList.get(i).getMoney()*empList.get(i).getBonusPoint()));
					}else if(empList.get(i).getGrade() == 'B' || empList.get(i).getGrade() == 'b') {
						empList.get(i).setBonusPoint(0.2);
						empList.get(i).setTotalMoney(empList.get(i).getMoney()+(empList.get(i).getMoney()*empList.get(i).getBonusPoint()));
					}else if(empList.get(i).getGrade() == 'C' || empList.get(i).getGrade() == 'c') {
						empList.get(i).setBonusPoint(0.1);
						empList.get(i).setTotalMoney(empList.get(i).getMoney()+(empList.get(i).getMoney()*empList.get(i).getBonusPoint()));
					}else {
						empList.get(i).setBonusPoint(0.0);
						empList.get(i).setTotalMoney(empList.get(i).getMoney()+(empList.get(i).getMoney()*empList.get(i).getBonusPoint()));
					}
				}
				
				System.out.println("★★★ 보너스 계산 완료 ★★★");
				break;
			case 4:
				// 검색
				System.out.println("★★★ 4. 임직원 검색 ★★★");
				System.out.print("검색할 임직원명 임력 : ");
				String searchName = scan.nextLine();
				boolean searchFlag = false;
				for(int i =0; i < empList.size(); i++) {
					if(empList.get(i).getName().equals(searchName)) {
						System.out.println(empList.get(i).toString());
						searchFlag = true;
					}
				}
				if(searchFlag == false) {
					System.out.println("검색한 임직원은 존재하지 않습니다.");
				}
				break;
			case 5:
				// 삭제
				System.out.println("★★★ 5. 임직원 삭제 ★★★");
				System.out.print("삭제할 임직원명 임력 : ");
				String deleteName = scan.nextLine();
				boolean deleteFlag = false;
				for(int i = 0; i < empList.size(); i++) {
					if(empList.get(i).getName().equals(deleteName)) {
						empList.remove(i);
						System.out.printf("%s 임직원은 삭제되었습니다.\n", empList.get(i).getName());
						deleteFlag = true;
					}
				}
				if(deleteFlag == false) {
					System.out.println("삭제할 임직원은 존재하지 않습니다.");
				}
				break;
			case 6:
				// 종료
				stopFlag = true;
				System.out.println("★★★ 6. 종료합니다 ★★★");
				scan.close();
				break;
			default:
				break;
			}
		}

	}
	public static void menuPrint() {
		// 메뉴
		System.out.println("★★★★★★★★★ MENU ★★★★★★★★★");
		System.out.println("★ \t1. 임직원 입력\t ★");
		System.out.println("★ \t2. 임직원 출력\t ★");
		System.out.println("★ \t3. 보너스 계산\t ★");
		System.out.println("★ \t4. 임직원 검색\t ★");
		System.out.println("★ \t5. 임직원 삭제\t ★");
		System.out.println("★ \t6. 종료\t\t ★");
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★");
	}
	
	public static int inputNum() {
		int num = 0;
		do {
			System.out.print("메뉴 선택(1~6) > ");
			num = Integer.parseInt(scan.nextLine());
			boolean isNumcheck = Pattern.matches("^[1-6]$", String.valueOf(num));
			if (isNumcheck == true) {
				break;
			}
			System.out.println("1~6번 중의 번호를 선택하세요!");
		}while(true);
		
		return num;
	}
	
	public static String PatternInspection(Scanner s, String request, String regex) {
		System.out.print(request);
		String input = s.nextLine();
		if(Pattern.matches(regex, input)) {
			return input; // 유효한 입력값 리턴
		}
		System.out.println("유효한 값을 입력해주세요.");
		return PatternInspection(s, request, regex);
	}
	
}
