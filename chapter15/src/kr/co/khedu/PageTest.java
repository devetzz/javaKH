package kr.co.khedu;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PageTest extends Object{
//	// 멤버 변수
//	
//	// 디폴트 생성자 생략되어 있다.
//	public PageTest() {
//		super();
//	}	
	public static ArrayList<StudentData> stuList = new ArrayList<StudentData>();
	public static boolean stopFlag = false;
	public static String menuTitle;
	// 멤버 함수
	public static void main(String[] args) {
		// 변수 선언(해당 되는 데이터를 파일을 가져와서 저장)
		
		// 반복문 (입력, 출력, 연산)
		while(!stopFlag) {
			// 메뉴 출력
			System.out.println("★★★★★★★★ MENU ★★★★★★★★");
			System.out.println("★ \t1. 로드\t\t ★");
			System.out.println("★ \t2. 출력\t\t ★");
			System.out.println("★ \t3. 종료\t\t ★");
			System.out.println("★★★★★★★★★★★★★★★★★★★★★");
			// 메뉴 번호 선택
			int no = 0;
			Scanner scan = new Scanner(System.in);
			
			do {
				int input = 0;
				boolean noIsNoString = true;
				System.out.print("메뉴 선택(1~3) > ");
				//input = Integer.parseInt(scan.nextLine());
				try {
					input = Integer.parseInt(scan.nextLine());
				}catch(NumberFormatException e) {										// 정수형이 아닐때 예외처리 먼저 진행
					noIsNoString = false;
				}
				boolean isNumcheck = Pattern.matches("^[1-3]{1}$", String.valueOf(input));	// 입력된 정수에 대해 패턴 검색 진행
				if (isNumcheck == true || noIsNoString == true) {
					no = input;
					break;
				}
				System.out.println("1~3번 중의 번호를 선택하세요!");
			}while(true);
			
			// 메뉴별 진행
			switch(no) {
			case 1:
				// 로드 실행
				examsFileUpload();
				break;
			case 2:
				// 출력
				int page = 1;
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
				break;
			case 3:
				// 종료
				stopFlag = true;
				System.out.println("정상적으로 종료되었습니다.");
				break;
			}
		}
		
		// 종료
		System.out.println("End");
		

	}
//	// 내부 클래스
//	class InnerClass {}
	private static void examsFileUpload() {
		// 파일에서 가져온다. 보조스트림 정의 (Scanner)
		FileInputStream fi;
		try {
			fi = new FileInputStream("res/exams.txt");
			Scanner scan = new Scanner(fi);
			// 첫라인 없앤다.
			if(scan.hasNextLine()) {
				PageTest.menuTitle = scan.nextLine();
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
				
				PageTest.stuList.add(stu);
			}
			System.out.println("파일에서 ArrayList로 로드가 완료되었습니다.");
			scan.close();
			fi.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("로드에 문제가 발생했습니다. 점검 바랍니다.");
			stopFlag = true;
		}
		
	}

}
