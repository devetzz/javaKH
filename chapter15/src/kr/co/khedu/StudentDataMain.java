package kr.co.khedu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentDataMain {
	
//	public static String[] menu = new String[] {"", "로드", "추가입력", "출력", "최대값", "최소값", "검색", "저장", "삭제", "수정", "종료"};
	public static String menuTitle;
//	public static ArrayList<StudentData> stuList = new ArrayList<StudentData>();
//	static {
//		// exams 파일을 프로그램 실행(main 작동)하기 전에 로드하여 stuList에 세팅한다.
//		examsFileUpload();
//	}
	
	public static void main(String[] args) {
		ArrayList<StudentData> stuList = new ArrayList<StudentData>();
		examsFileUpload(stuList);
		// 변수선언
		boolean stopFlag = false;
		
		
		// 반복(입력, 연산, 출력)
		while(!stopFlag) {
			// 메뉴 보여주기
			Menu.menuDisplay();
			// 메뉴 선택하기
			int no = selectNo();
			
			switch(no) {
			case Menu.LOAD:
				System.out.println("이미 로드가 완료되었습니다.");
				break;
			case Menu.INPUT:
			{
				// 키보드 입력 => StudentData 객체 =>  ArrayList => 파일
				System.out.println("★★★ 학생 추가 ★★★");
				Scanner scan = new Scanner(System.in);
				System.out.print("학생 이름 : ");
				String name = scan.nextLine();
				System.out.print("국어 : ");
				int kor = Integer.parseInt(scan.nextLine());
				System.out.print("영어 : ");
				int eng = Integer.parseInt(scan.nextLine());
				System.out.print("수학 : ");
				int math = Integer.parseInt(scan.nextLine());
				int total = kor + eng + math;
				double avg = total / 3.0;
				StudentData stu = new StudentData(name, kor, eng, math);
				stu.setTotal(total);
				stu.setAvg(avg);
				stuList.add(stu);
				System.out.printf("%s 학생 정보가 추가되었습니다.\n", name);
				
			}
				break;
			case Menu.OUTPUT:
			{
				int page = 1;
				Scanner scan = new Scanner(System.in);
				while(true) {
					// 전체페이지를 구한다.
					int totalPage = stuList.size() / 5;
					int remainValue = stuList.size() % 5;
					if(remainValue != 0) {
						totalPage += 1;
					}
					// 해당되는 페이지 시작위치, 끝위치
					int start = 5*(page-1);
					int stop = start+5;
					
					// 마지막 페이지일때 (나머지가 있을때) 끝위치가 1~4 증가
					if(page == totalPage && remainValue != 0) {
						totalPage += 1;
						stop = start+remainValue;
					}
					
					System.out.printf("현재 %d page / 전체 %d page \n", page, totalPage);
					for(int i = start; i < stop; i++) {
						System.out.println(stuList.get(i).toString());
					}
					
					System.out.print("page 선택(-1 : exit) > ");
					page = Integer.parseInt(scan.nextLine());
					if(page == -1) {
						break;
					}
				}
			}
				break;
			case Menu.MAX:
			{
				int max = Integer.MIN_VALUE;
				int index = -1;
				for(int i = 0; i < stuList.size(); i++) {
					StudentData stuData = stuList.get(i);
					if(max < stuData.getTotal()) {
						max = stuData.getTotal();
						index = i;
					}
				}
				System.out.printf("최대값은 total = %5d 입니다.\r", max);
				System.out.printf("최대값을 가진 학생의 정보 : \n%s \r", stuList.get(index));
			}
				break;
			case Menu.MIN:
			{
				int min = Integer.MAX_VALUE;
				int index = -1;
				for(int i = 0; i < stuList.size(); i++) {
					StudentData stuData = stuList.get(i);
					if(min > stuData.getTotal()) {
						min = stuData.getTotal();
						index = i;
					}
				}
				System.out.printf("최소값은 total = %5d 입니다.\r", min);
				System.out.printf("최소값을 가진 학생의 정보 : \n%s \r", stuList.get(index));
			}
				break;
			case Menu.SEARCH:
			{
				Scanner scan = new Scanner(System.in);
				System.out.print("검색할 이름 입력 : ");
				String name = scan.nextLine();
				boolean searchFlag = false;
				for(StudentData data : stuList) {
					if(data.getName().equals(name)) {
						System.out.println(data);
						searchFlag = true;
					}
				}
				if(searchFlag == false) {
					System.out.printf("%s 로 검색된 이름은 없습니다.\n", name);
				}
			}
				break;
			case Menu.SAVE:
			{
				// 파일에서 가져온다. 보조스트림 정의 (PrintStream)
				FileOutputStream fo = null;
				PrintStream out = null;
				try {
					fo = new FileOutputStream("res/exams.txt");
					out = new PrintStream(fo);
					// 컬럼명을 추가한다.
					out.printf("%s", StudentDataMain.menuTitle);
					
					for(int i = 0; i < stuList.size(); i++) {
						StudentData stu = stuList.get(i);
						out.printf("\n%s,%d,%d,%d", stu.getName(), stu.getKor(), stu.getEng(), stu.getMath());
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} finally {
					out.close();
					try {
						fo.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
				System.out.println("ArrayList 내용을 파일에 저장 완료하였습니다.");
				
			}
				break;
			case Menu.REMOVE:
			{
				Scanner scan = new Scanner(System.in);
				System.out.print("삭제할 이름 : ");
				String name = scan.nextLine();
				boolean removeFlag = false;
				for(StudentData stu : stuList) {
					if(stu.getName().equals(name)) {
						System.out.printf("%s 삭제가 완료되었습니다.\n", stu.toString());
						stuList.remove(stu);
						removeFlag = true;
						break;
					}
				}
				if(removeFlag == false) {
					System.out.printf("%s 학생은 없습니다.\n", name);
				}
			}	
				break;
			case Menu.UPDATE:
				// 학생 점수 수정 함수
				studentDataUpdate(stuList);
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
	
	
	
	public static void studentDataUpdate(ArrayList<StudentData> stuList) {
		Scanner scan = new Scanner(System.in);
		System.out.print("수정할 학생 이름 : ");
		String name = scan.nextLine();
		StudentData findStudentData = null;
		for(StudentData stu : stuList) {
			if(stu.getName().equals(name)) {
				findStudentData = stu;
				break;
			}
		}
		if(findStudentData == null) {
			System.out.printf("%s 학생을 찾지 못했습니다.\n", name);
			return;
		}
		System.out.printf("%s 학생의 정보는 %s\n", name, findStudentData.toString());
		System.out.printf("현재 국어 점수: %d => 수정할 점수 > ", findStudentData.getKor());
		int kor = Integer.parseInt(scan.nextLine());
		System.out.printf("현재 영어 점수: %d => 수정할 점수 > ", findStudentData.getEng());
		int eng = Integer.parseInt(scan.nextLine());
		System.out.printf("현재 수학 점수: %d => 수정할 점수 > ", findStudentData.getMath());
		int math = Integer.parseInt(scan.nextLine());
		
		findStudentData.setKor(kor);
		findStudentData.setEng(eng);
		findStudentData.setMath(math);
		int total = kor + eng + math;
		findStudentData.setTotal(total);
		findStudentData.setAvg(total / 3.0);
		System.out.printf("%s 학생의 점수 수정이 완료되었습니다.\n", name);
	}



	private static void examsFileUpload(ArrayList<StudentData> stuList) {
		// 파일에서 가져온다. 보조스트림 정의 (Scanner)
		FileInputStream fi = null;
		try {
			fi = new FileInputStream("res/exams.txt");
			Scanner scan = new Scanner(fi);
			// 첫라인 없앤다.
			if(scan.hasNextLine()) {
				StudentDataMain.menuTitle = scan.nextLine();
			}
			// 무한 반복을 통해 한 라인 씩 가져와서 => String tokens => 형변환시켜서 => StudentData 객체 => ArrayList
			while(true) {
				if(!scan.hasNextLine()) {
					break;
				}
				String data = scan.nextLine();
				String[] tokens = data.split(",");
				String name = tokens[0];
				int kor = Integer.parseInt(tokens[1]);
				int eng = Integer.parseInt(tokens[2]);
				int math = Integer.parseInt(tokens[3]);
				int total = kor + eng + math;
				double avg = total / 3.0;
				StudentData stu = new StudentData(name, kor, eng, math);
				stu.setTotal(total);
				stu.setAvg(avg);
				stuList.add(stu);
			}
			System.out.println("파일에서 ArrayList로 로드가 완료되었습니다.");
			scan.close();
			fi.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("로드에 문제가 발생했습니다. 점검 바랍니다.");
		}finally {
			try {
				fi.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	// 메뉴 선택
	
	public static int selectNo() {
		int no = 0;
		/*do {
		 *  int no = 0;
			Scanner scan = new Scanner(System.in);
			System.out.print("메뉴 선택(1~7) > ");
			//boolean isNumCheck = Pattern.matches("^[1-7]$", String.valueOf(no));
			boolean isNumCheck = true;
			try {
				no = Integer.parseInt(scan.nextLine());
			}catch(NumberFormatException e) {
				// 여기서 조치를 취하면 된다.
				isNumCheck = false;
			}
			
			if (isNumCheck == true && (1 <= no || no <= 7)) {
				break;
			}
			System.out.println("1~7번 중의 번호를 선택하세요!");
		}while(true);*/
		
		do {
			int input = 0;
			Scanner scan = new Scanner(System.in);
			System.out.print("메뉴 선택(1~12) > ");
			boolean noIsNoString = true;
			input = Integer.parseInt(scan.nextLine());
//			try {
//				input = Integer.parseInt(scan.nextLine());
//			}catch(NumberFormatException e) {										// 정수형이 아닐때 예외처리 먼저 진행
//				noIsNoString = false;
//			}
			boolean isNumcheck = Pattern.matches("^[0-9]{1,2}$", String.valueOf(input));	// 입력된 정수에 대해 패턴 검색 진행
			if (isNumcheck == true) {
				no = input;
				break;
			}
			System.out.println("1~12번 중의 번호를 선택하세요!");
		}while(true);

		return no;
		
	}
	
	
	// 번호 선택, 점수 입력, 이름 입력(패턴 검색)
	
}
