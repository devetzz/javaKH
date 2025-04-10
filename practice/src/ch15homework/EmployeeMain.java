package ch15homework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;

public class EmployeeMain {

	public static Scanner scan = new Scanner(System.in);
	public static String fieldName;
//	static {
//		// 파일을 프로그램 실행(main 작동)하기 전에 로드하여 stuList에 세팅한다.
//		FileUpload();
//	}
	public static void main(String[] args) throws IOException {
		ArrayList<Employee> empList = new ArrayList<Employee>();
		FileUpload(empList);
		// 변수 선언
		boolean stopFlag = false;
		
		// 반복문
		while(!stopFlag) {
			int no = 0;
			// 메뉴 표시
			clear();
			System.out.println();
			MenuInterface.menuPrint();
			// 메뉴 선택
			no = Integer.parseInt(PatternInspection(scan, "메뉴 선택(1~12) > ", "^[0-9]{1,2}$"));
			
			switch(no) {
			case MenuInterface.LOAD:
				System.out.println("이미 인사파일을 가져왔습니다.");
				System.out.print(" >> ");
				scan.nextLine();
				break;
			case MenuInterface.INPUT:
			{
				// (이름, 부서, 급여, 등급, 보너스포인트, 총급여)
				System.out.println("★★★ 임직원 입력 ★★★");
				String name = PatternInspection(scan, "이름 : ", "^[0-9a-zA-Z|가-힣]{2,20}$");
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
			case MenuInterface.OUTPUT:
				System.out.println("★★★ 임직원 출력 ★★★");

				int page = 1;
				while(true) {
					clear();
					// 전체페이지를 구한다.
					int totalPage = empList.size() / 10;
					int remainValue = empList.size() % 10;
					if(remainValue != 0) {
						totalPage += 1;
					}
					// 해당 페이지의 시작위치, 끝위치를 구한다.
					int first = 10 * (page - 1);
					int last = first + 10;
					// 마지막 페이지에 나머지가 있을때 끝위치를 정한다.
					if(remainValue != 0 && page == totalPage) {
						last = first + remainValue;
					}
					// for문을 통해 페이지별 출력
					System.out.printf("현재 %d / 전체 %d page\n", page, totalPage);
					for(int i = first; i < last; i++) {
						System.out.println(empList.get(i));
					}
					System.out.print("Page 입력 (Exit : -1) > ");
					page = Integer.parseInt(scan.nextLine());
					
					if(page == -1) {
						break;
					}
				}
				break;
			case MenuInterface.MAX:
				double max = Integer.MIN_VALUE;
				for(Employee data : empList) {
					if (data.getTotal() > max) {
						max = data.getTotal();
					}
				}
				System.out.printf("총급여 최대값은 %.2f 입니다.\n", max);
				System.out.print(" >> ");
				scan.nextLine();
				break;
			case MenuInterface.MIN:
				double min = Integer.MAX_VALUE;
				for(Employee data : empList) {
					if (data.getTotal() < min) {
						min = data.getTotal();
					}
				}
				System.out.printf("총급여 최소값은 %.2f 입니다.\n", min);
				System.out.print(" >> ");
				scan.nextLine();
				break;
			case MenuInterface.SEARCH:
				System.out.print("검색할 임직원명 : ");
				String searchName = scan.nextLine();
				boolean isSearched = false;
				for(Employee data : empList) {
					if (data.getName().equals(searchName)) {
						System.out.println(data.toString());
						System.out.print(" >> ");
						scan.nextLine();
						isSearched = true;
					}
				}
				if(isSearched == false) {
					System.out.printf("임직원 %s 는 찾을 수 없습니다.\n", searchName);
					System.out.print(" >> ");
					scan.nextLine();
				}
				
				break;
			case MenuInterface.DELETE:
				System.out.print("삭제할 임직원명 : ");
				String deleteName = scan.nextLine();
				boolean isDeleted = false;
				Employee deleteEmp = null;
				for(Employee data : empList) {
					if(data.getName().equals(deleteName)) {
						System.out.printf("%s 삭제 완료.\n",deleteName);
						System.out.print(" >> ");
						scan.nextLine();
						deleteEmp = data; 
						//empList.remove(data);		//for문 안에서 data를 지우면 List의 사이즈가 줄어서 에러가 발생한다.
						isDeleted = true;
					}
				}
				empList.remove(deleteEmp);
				if(isDeleted == false) {
					System.out.printf("%s 임직원은 존재하지 않습니다.\n", deleteName);
					System.out.print(" >> ");
					scan.nextLine();
				}
				break;
			case MenuInterface.UPDATE:
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
					System.out.print(" >> ");
					scan.nextLine();
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
				System.out.print(" >> ");
				scan.nextLine();
				
				break;
			case MenuInterface.SAVE:
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
				System.out.print(" >> ");
				scan.nextLine();
				
				out.close();
				fo.close();
			}
				break;
			case MenuInterface.ASC:
				// 오름차순 정렬
				Collections.sort(empList);
				System.out.println("오름차순 정렬 완료.");
				System.out.print(" >> ");
				scan.nextLine();
				break;
			case MenuInterface.DESC:
				// 내림차순 정렬
				Collections.sort(empList, Collections.reverseOrder());
				System.out.println("내림차순 정렬 완료.");
				System.out.print(" >> ");
				scan.nextLine();
				break;
			case MenuInterface.EXIT:
				System.out.println("종료합니다.");
				scan.close();
				stopFlag = true;
				break;
			default:
				break;
			
			}
		}
	}



	public static void clear() {
		try {
            String operatingSystem = System.getProperty("os.name");
            if (operatingSystem.contains("Windows")) {
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
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

	private static void FileUpload(ArrayList<Employee> empList) {
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
