package ch15homework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;
import java.util.regex.Pattern;

public class EmployeeSetMain {

	public static String fieldName = null;
	public static void main(String[] args) {
		Set<Employee> set = new HashSet<>();
		
		// 변수선언
		boolean stopFlag = false;
		
		// 파일 로드
		FileUpload(set);
		
		// 반복문
		while(!stopFlag) {
			
			Menu.menuPrint();
			
			Scanner s = new Scanner(System.in);
			int no = Integer.parseInt(PatternInspection(s, "메뉴 선택 > ","^[0-9]{1,2}$"));
			
			switch(no) {
			case 1:
				// 1. 로드
				System.out.println("이미 로드되었습니다.");
				break;
			case 2:
			{
				// 2. 추가 입력
				// (사번, 이름, 부서, 급여, 등급, 보너스포인트, 총급여)
				System.out.println("★★★ 임직원 입력 ★★★");
				// 사번값 : 제일 큰번호+1
				int maxId = Integer.MIN_VALUE;
				for(Employee data : set) {
					if (data.getId() > maxId) {
						maxId = data.getId();
					}
				}
				int id = maxId+1;
				String name = PatternInspection(s, "이름 : ", "^[0-9a-zA-Z|가-힣]{2,20}$");
				String dept = PatternInspection(s, "부서 : ", "^[0-9a-zA-Z|가-힣]{1,20}$");
				int salary = Integer.parseInt(PatternInspection(s, "급여 : ", "[0-9]*"));
				char grade = PatternInspection(s, "등급 : ", "[A,B,C,D,a,b,c,d]{1}").charAt(0);
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
				
				Employee emp = new Employee(id, name, dept, salary, grade);
				emp.setBonus(bonus);
				emp.setTotal(total);
				set.add(emp);
				
				System.out.println("임직원 입력 완료.");
			}
				break;
			case 3: 
				// 3. 출력
				for(Employee data : set) {
					System.out.println(data);
				}
			/*
			{
				int page = 1;
				while(true) {
					System.out.println("임직원 리스트");
					// 전체페이지를 구한다.
					int totalPage = set.size() / 10;
					int remainValue = set.size() % 10;
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
						System.out.println(set.get(i));
					}
					System.out.print("Page 입력 (Exit : -1) > ");
					page = Integer.parseInt(s.nextLine());
					
					if(page == -1) {
						break;
					}
				}
			}
			*/
				break;
			case 4: 
				// 4. 최대값
				double max = Integer.MIN_VALUE;
				for(Employee data : set) {
					if (data.getTotal() > max) {
						max = data.getTotal();
					}
				}
				System.out.printf("총급여 최대값은 %.2f 입니다.\n", max);
				break;
			case 5: 
				// 5. 최소값
				double min = Integer.MAX_VALUE;
				for(Employee data : set) {
					if (data.getTotal() < min) {
						min = data.getTotal();
					}
				}
				System.out.printf("총급여 최소값은 %.2f 입니다.\n", min);
				break;
			case 6: 
				// 6. 검색
				System.out.print("검색할 임직원명 : ");
				String searchName = s.nextLine();
				boolean isSearched = false;
				for(Employee data : set) {
					if (data.getName().equals(searchName)) {
						System.out.println(data.toString());
						isSearched = true;
					}
				}
				if(isSearched == false) {
					System.out.printf("임직원 %s 는 찾을 수 없습니다.\n", searchName);
				}
				break;
			case 7: 
				// 7. 삭제
				System.out.print("삭제할 임직원명 : ");
				String deleteName = s.nextLine();
				boolean isDeleted = false;
				Employee deleteEmp = null;
				for(Employee data : set) {
					if(data.getName().equals(deleteName)) {
						System.out.printf("%s 삭제 완료.\n",deleteName);
						deleteEmp = data; 
						//empList.remove(data);		//for문 안에서 data를 지우면 List의 사이즈가 줄어서 에러가 발생한다.
						isDeleted = true;
					}
				}
				set.remove(deleteEmp);
				if(isDeleted == false) {
					System.out.printf("%s 임직원은 존재하지 않습니다.\n", deleteName);
				}
				break;
			case 8: 
			{
				// 8. 수정
				System.out.print("수정할 임직원명 : ");
				String modifyName = s.nextLine();
				Employee modifyEmp = null;
				for(Employee data : set) {
					if(data.getName().equals(modifyName)) {
						modifyEmp = data;
						break;
					}
				}
				if(modifyEmp == null) {
					System.out.printf("%s 임직원은 존재하지 않습니다.\n", modifyName);
					return;
				}
				
				String dept = PatternInspection(s, "수정할 부서 : ", "^[0-9a-zA-Z|가-힣]{1,20}$");
				int salary = Integer.parseInt(PatternInspection(s, "수정할 급여 : ", "[0-9]*"));
				char grade = PatternInspection(s, "수정할 등급 : ", "[A,B,C,D,a,b,c,d]{1}").charAt(0);
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
			}
				break;
			case 9: 
				// 9. 저장
				FileOutputStream fo = null;
				try {
					fo = new FileOutputStream("res/EmployeeSet.txt");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					System.out.println("파일 저장 실패");
				}
				PrintStream ps = new PrintStream(fo);
				
				ps.printf("%s", fieldName);
				
				for(Employee data : set) {
					ps.printf("\n%d,%s,%s,%d,%c", data.getId(), data.getName(), data.getDept(), data.getSalary(), data.getGrade());
				}
				
				ps.close();
				try {
					fo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				System.out.println("파일 저장 완료");
				
				break;
			case 10: 
				// 10. 오름차순 정렬
				List<Employee> tempSet = new ArrayList<>(set);
				Collections.sort(tempSet);
				
				for(Employee data : tempSet) {
					System.out.println(data);
				}
				break;
			case 11: 
				// 11. 내림차순 정렬
				List<Employee> tempSet2 = new ArrayList<>(set);
				Collections.sort(tempSet2, Collections.reverseOrder());
				
				for(Employee data : tempSet2) {
					System.out.println(data);
				}
				break;
			case 12: 
				// 12. 종료
				stopFlag = true;
				System.out.println("정상적으로 종료하였습니다.");
				break;
			}
		}
		
	}

	public static void FileUpload(Set<Employee> set) {
		FileInputStream fi = null;
		Scanner s;
		try {
			fi = new FileInputStream("res/EmployeeSet.txt");
			s = new Scanner(fi);
			if(s.hasNextLine()) {
				fieldName = s.nextLine();
			}
			
			while(true) {
				if(!s.hasNextLine()) {
					break;
				}
				String[] tokens = s.nextLine().split(",");
				int id = Integer.parseInt(tokens[0]);
				String name = tokens[1];
				String dept = tokens[2];
				int salary = Integer.parseInt(tokens[3]);
				char grade = tokens[4].charAt(0);
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
				
				Employee emp = new Employee(id, name, dept, salary, grade);
				emp.setBonus(bonus);
				emp.setTotal(total);
				set.add(emp);
			}
			System.out.println("파일 가져오기 완료");
			s.close();
			fi.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("파일 가져오기 실패");
		}
		
		
	}

	public static String PatternInspection(Scanner s, String str, String regex) {
		System.out.print(str);
		String input = s.nextLine();
		if(Pattern.matches(regex, input) == true) {
			return input;
		}else {
			System.out.println("유효한 값을 입력하세요.");
			return PatternInspection(s, str, regex);
		}
	}

}
