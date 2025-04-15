package kr.co.khedu2;

import java.util.ArrayList;
import java.util.Collections;

public class StudentDataMain {
	
//	public static String[] menu = new String[] {"", "로드", "추가입력", "출력", "최대값", "최소값", "검색", "저장", "삭제", "수정", "종료"};
	public static String menuTitle;
//	public static ArrayList<StudentData> stuList = new ArrayList<StudentData>();
//	static {
//		// exams 파일을 프로그램 실행(main 작동)하기 전에 로드하여 stuList에 세팅한다.
//		examsFileUpload();
//	}
	
	public static void main(String[] args) {
		// 1. 프로젝트 매니저 객체
		ProcessManager pm = ProcessManager.getInstance();
		// 2. 파일에 있는 데이터를 저장하기 위한 컬렉션
		ArrayList<StudentData> stuList = new ArrayList<StudentData>();
		// 3. 파일에 있는 내용을 컬렉션 stuList에 저장
		pm.examsFileUpload(stuList);
		// 4. 변수선언(무한 반복문 실행을 위한 변수)
		boolean stopFlag = false;
		
		
		// 반복(입력, 연산, 출력)
		while(!stopFlag) {
			// 메뉴 보여주기
			Menu.menuDisplay();
			// 메뉴 선택하기
			int no = pm.selectNo();
			
			switch(no) {
			case Menu.LOAD:
				System.out.println("이미 로드가 완료되었습니다.");
				break;
			case Menu.INPUT:
				// 학생 정보 입력하여 컬렉션 stuList에 추가
				pm.stuListInput(stuList);
				break;
			case Menu.OUTPUT:
				// 학생 정보 페이징 기법으로 화면 출력
				pm.stuListPagePrint(stuList);
				break;
			case Menu.MAX:
				// 학생정보 중 총점이 가장 높은 학생 정보 출력
				pm.stuListMax(stuList);
				break;
			case Menu.MIN:
				// 학생정보 중 총점이 가장 낮은 학생 정보 출력
				pm.stuListMin(stuList);
				break;
			case Menu.SEARCH:
				// 학생정보 이름으로 검색하여 출력
				pm.stuListSearch(stuList);
				break;
			case Menu.SAVE:
				// 컬렉션에 저장된 데이터를 파일에 저장
				pm.stuListSave(stuList);
				break;
			case Menu.REMOVE:
				// 컬렉션 stuList에서 학생을 검색하여 삭제
				pm.stuListDel(stuList);
				break;
			case Menu.UPDATE:
				// 학생 점수 수정 함수
				pm.studentDataUpdate(stuList);
				break;
			case Menu.ASC:
				// 오름차순 정렬
				Collections.sort(stuList);
				System.out.println("오름차순 정렬 완료.");
				break;
			case Menu.DESC:
				// 내림차순 정렬
				Collections.sort(stuList, Collections.reverseOrder());
				System.out.println("내림차순 정렬 완료.");
				break;
			case Menu.EXIT:
				stopFlag = true;
				System.out.println("종료합니다.");
				break;
			default: 
				System.out.println("잘못된 번호가 입력됨. 다시요청(1~7)");
				break;
			}
		}//while
		
		// 종료
		System.out.println("End");
	}//main
	
}
