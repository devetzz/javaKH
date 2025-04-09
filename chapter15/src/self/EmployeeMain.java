package self;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class EmployeeMain {

	public static Scanner scan = new Scanner(System.in);
	public static String fieldName;
	public static String[] menu = new String[] {"","가져오기","추가입력","출력","최대값","최소값","검색","삭제","수정","저장","종료"};
	public static ArrayList<Employee> empList = new ArrayList<Employee>();
	static {
		// 파일을 프로그램 실행(main 작동)하기 전에 로드하여 stuList에 세팅한다.
		FileUpload();
	}
	public static void main(String[] args) throws IOException {
		// 변수 선언
		boolean stopFlag = false;
		
		// 반복문
		while(!stopFlag) {
			int no = 0;
			// 메뉴 표시
			menuPrint();
			// 메뉴 선택
			no = Integer.parseInt(PatternInspection(scan, "메뉴 선택(1~10) > ", "^[0-9]{1,2}$"));
			
			switch(menu[no]) {
			case "가져오기":
				System.out.println("이미 인사파일을 가져왔습니다.");
				break;
			case "추가입력":
			{
				// (이름, 부서, 급여, 등급, 보너스포인트, 총급여)
				System.out.println("★★★ 임직원 입력 ★★★");
				String name = PatternInspection(scan, "이름 : ", "^[a-zA-Z|가-힣]{2,20}$");
				String dept = PatternInspection(scan, "부서 : ", "^[0-9a-zA-Z|가-힣]{1,20}$");
				int salary = Integer.parseInt(PatternInspection(scan, "급여 : ", "[0-9]*"));
				char grade = PatternInspection(scan, "등급 : ", "[A,B,C,D,a,b,c,d]{1}").charAt(0);
				double bonus = 0.0;
				if(grade == 'A' || grade == 'a') {
					bonus = 0.3;
				}else if(grade == 'B' || grade == 'b') {
					bonus = 0.2;
				}else if(grade == 'C' || grade == 'c') {
					bonus = 0.1;
				}else{
					bonus = 0.0;
				}
				double total = salary + (salary * bonus);
				
				Employee emp = new Employee(name, dept, salary, grade);
				emp.setBonus(bonus);
				emp.setTotal(total);
				empList.add(emp);
				
				System.out.println("임직원 입력 완료.");
			}
				break;
			case "출력":
				System.out.println("★★★ 임직원 출력 ★★★");
				for(Employee data : empList) {
					System.out.println(data.toString());
				}
				break;
			case "최대값":
				double max = Integer.MIN_VALUE;
				for(Employee data : empList) {
					if (data.getTotal() > max) {
						max = data.getTotal();
					}
				}
				System.out.printf("총급여 최대값은 %.2f 입니다.\n", max);
				break;
			case "최소값":
				double min = Integer.MAX_VALUE;
				for(Employee data : empList) {
					if (data.getTotal() < min) {
						min = data.getTotal();
					}
				}
				System.out.printf("총급여 최소값은 %.2f 입니다.\n", min);
				break;
			case "검색":
				System.out.print("검색할 임직원명 : ");
				String searchName = scan.nextLine();
				boolean isSearched = false;
				for(Employee data : empList) {
					if (data.getName().equals(searchName)) {
						System.out.println(data.toString());
						isSearched = true;
					}
				}
				if(isSearched == false) {
					System.out.printf("임직원 %s 는 찾을 수 없습니다.\n", searchName);
				}
				
				break;
			case "삭제":
				System.out.print("삭제할 임직원명 : ");
				String deleteName = scan.nextLine();
				boolean isDeleted = false;
				Employee deleteEmp = null;
				for(Employee data : empList) {
					if(data.getName().equals(deleteName)) {
						System.out.printf("%s 삭제 완료.\n",deleteName);
						deleteEmp = data; 
						//empList.remove(data);		//for문 안에서 data를 지우면 List의 사이즈가 줄어서 에러가 발생한다.
						isDeleted = true;
					}
				}
				empList.remove(deleteEmp);
				if(isDeleted == false) {
					System.out.printf("%s 임직원은 존재하지 않습니다.\n", deleteName);
				}
				break;
			case "수정":
				System.out.print("수정할 임직원명 : ");
				String modifyName = scan.nextLine();
				Employee modifyEmp = null;
				for(Employee data : empList) {
					if(data.getName().equals(modifyName)) {
						modifyEmp = data;
						break;
					}
				}
				if(modifyEmp == null) {
					System.out.printf("%s 임직원은 존재하지 않습니다.\n", modifyName);
					break;
				}
				
				String dept = PatternInspection(scan, "수정할 부서 : ", "^[0-9a-zA-Z|가-힣]{1,20}$");
				int salary = Integer.parseInt(PatternInspection(scan, "수정할 급여 : ", "[0-9]*"));
				char grade = PatternInspection(scan, "수정할 등급 : ", "[A,B,C,D,a,b,c,d]{1}").charAt(0);
				double bonus = 0.0;
				if(grade == 'A' || grade == 'a') {
					bonus = 0.3;
				}else if(grade == 'B' || grade == 'b') {
					bonus = 0.2;
				}else if(grade == 'C' || grade == 'c') {
					bonus = 0.1;
				}else{
					bonus = 0.0;
				}
				double total = salary + (salary * bonus);
				
				modifyEmp.setName(modifyName);
				modifyEmp.setDept(dept);
				modifyEmp.setSalary(salary);
				modifyEmp.setGrade(grade);
				modifyEmp.setBonus(bonus);
				modifyEmp.setTotal(total);
				System.out.printf("%s 임직원 정보 수정 완료.\n", modifyName);
				
				break;
			case "저장":
			{
				// 파일 내용 모두 지우고 ArrayList의 내용 저장
				FileOutputStream fo = new FileOutputStream("res/Employee.txt");
				PrintStream out = new PrintStream(fo);
				
				// 첫 라인(컬럼명) 만들기 (저장해둔 컬럼명 가져오기)
				out.printf("%s", EmployeeMain.fieldName);
				
				for(Employee data : empList) {
					out.printf("\n%s,%s,%d,%c",data.getName(), data.getDept(), data.getSalary(), data.getGrade());
				}
				
				System.out.println("ArrayList내용을 파일에 저장 완료하였습니다.");
				
				out.close();
				fo.close();
			}
				break;
			case "종료":
				System.out.println("종료합니다.");
				scan.close();
				stopFlag = true;
				break;
			default:
				break;
			
			}
		}
	}


	public static void menuPrint() {
		// 메뉴
		System.out.println("★★★★★★★★ MENU ★★★★★★★★");
		System.out.println("★ \t1. 임직원 가져오기\t ★");
		System.out.println("★ \t2. 임직원 추가입력\t ★");
		System.out.println("★ \t3. 임직원 출력\t ★");
		System.out.println("★ \t4. 급여 최대값\t ★");
		System.out.println("★ \t5. 급여 최소값\t ★");
		System.out.println("★ \t6. 임직원 검색\t ★");
		System.out.println("★ \t7. 임직원 삭제\t ★");
		System.out.println("★ \t8. 임직원 수정\t ★");
		System.out.println("★ \t9. 인사파일 저장\t ★");
		System.out.println("★ \t10. 종료\t\t ★");
		System.out.println("★★★★★★★★★★★★★★★★★★★★★");
	}


	public static String PatternInspection(Scanner s, String text, String regex) {
		System.out.print(text);
		String input = s.nextLine(); 
		if(Pattern.matches(regex, input) == true) {
			return input;
		}
		System.out.println("유효한 값을 입력하세요.");
		return PatternInspection(s, text, regex);
	}

	private static void FileUpload() {
		// 파일에서 가져온다.
		FileInputStream fi;
		try {
			fi = new FileInputStream("res/Employee.txt");
			Scanner scan = new Scanner(fi);
			// 첫라인 버리기 => 컬럼명 저장
			if(scan.hasNextLine()) {
				EmployeeMain.fieldName = scan.nextLine();
				System.out.println(fieldName);
			}
			while(true) {
				if(!scan.hasNextLine()) {
					break;
				}
				String data = scan.nextLine();
				String[] tokens = data.split(",");
				String name = tokens[0];
				String dept = tokens[1];
				int salary = Integer.parseInt(tokens[2]);
				char grade = tokens[3].charAt(0);
				double bonus = 0.0;
				if(grade == 'A' || grade == 'a') {
					bonus = 0.3;
				}else if(grade == 'B' || grade == 'b') {
					bonus = 0.2;
				}else if(grade == 'C' || grade == 'c') {
					bonus = 0.1;
				}else{
					bonus = 0.0;
				}
				double total = salary + (salary * bonus);
				
				Employee emp = new Employee(name, dept, salary, grade);
				emp.setBonus(bonus);
				emp.setTotal(total);
				empList.add(emp);
			}
			System.out.println("인사파일 가져오기가 완료되었습니다.");
			scan.close();
			fi.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("인사파일 가져오기가 실패하였습니다.");
		}
		
	}
}
