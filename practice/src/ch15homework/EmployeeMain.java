package ch15homework;

import java.io.IOException;
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
		Function f = Function.getInstance();
		ArrayList<Employee> empList = new ArrayList<Employee>();
		f.FileUpload(empList);
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
				f.FuncInput(empList);
				break;
			case MenuInterface.OUTPUT:
				System.out.println("★★★ 임직원 출력 ★★★");
				f.empPrint(empList);
				break;
			case MenuInterface.MAX:
				// 총급여 최대값 출력하는 함수
				f.FuncMax(empList);
				System.out.print(" >> ");
				scan.nextLine();
				break;
			case MenuInterface.MIN:
				// 총급여 최소값 출력하는 함수
				f.FuncMin(empList);
				System.out.print(" >> ");
				scan.nextLine();
				break;
			case MenuInterface.SEARCH:
				// 인사정보 검색 함수
				f.FuncSearch(empList);
				break;
			case MenuInterface.DELETE:
				// 인사정보 삭제 함수
				f.FuncDel(empList);
				break;
			case MenuInterface.UPDATE:
				// 인사정보 수정 함수
				f.FuncUpdate(empList);
				break;
			case MenuInterface.SAVE:
				// 파일 내용 모두 지우고 ArrayList의 내용 저장
				f.FuncSave(empList);
				break;
			case MenuInterface.ASC:
				// 오름차순 정렬
				Collections.sort(empList);
				System.out.println("오름차순 정렬 완료.");
				f.empPrint(empList);
				break;
			case MenuInterface.DESC:
				// 내림차순 정렬
				Collections.sort(empList, Collections.reverseOrder());
				System.out.println("내림차순 정렬 완료.");
				f.empPrint(empList);
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


	// clear 함수
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
		
	// 패턴 검색 함수
	public static String PatternInspection(Scanner s, String text, String regex) {
		System.out.print(text);
		String input = s.nextLine(); 
		if(Pattern.matches(regex, input) == true) {
			return input;
		}
		System.out.println("유효한 값을 입력하세요.");
		return PatternInspection(s, text, regex);
	}
		

}
