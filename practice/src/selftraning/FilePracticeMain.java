package selftraning;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;


public class FilePracticeMain {
	
	public static Scanner s = new Scanner(System.in);
	public static ArrayList<FilePractice> fileList = new ArrayList<FilePractice>();
	public static String fieldName;
	public static boolean stopFlag = false;
	static {
		// main 시작 전에 파일 내용 로드
		FileUpload();
	}
	public static void main(String[] args) throws IOException{
		// 변수 선언
		// 반복문
		while(!stopFlag) {
			// 메뉴
			menuDisplay();
			
			int no = Integer.parseInt(PatternInspection(s, "번호 입력(1~5) > ", "^[1-5]{1}$"));
			
			switch(no) {
			case 1:
				// 로드
				System.out.println("이미 로드 완료 되었습니다.");
				break;
			case 2:
				// 추가 입력
			{
				// (이름, 부서, 급여, 등급, 보너스포인트, 총급여)
				System.out.println("★★★ 임직원 입력 ★★★");
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
				
				FilePractice fp = new FilePractice(name, dept, salary, grade);
				fp.setBonus(bonus);
				fp.setTotal(total);
				fileList.add(fp);
				
				System.out.println("임직원 입력 완료.");
			}
				break;
			case 3:
				// 출력(페이징 처리)
				int page = 1;
				// 반복문
				while(true) {
					// 전체 페이지를 구하기
					int totalPage = fileList.size() / 10;
					int remainValue = fileList.size() % 10;
					if (remainValue != 0) {
						totalPage += 1;
					}
					
					// 해당되는 페이지의 시작위치, 끝위치 구하기
					int first = 10 * (page - 1);
					int last = first + 10;
					
					// 마지막 페이지의 나머지가 있을때 끝위치 정의
					if(page == totalPage && remainValue != 0) {
						last = first + remainValue;
					}
					// for문 통한 페이지별 출력
					System.out.printf("전체 %d 페이지 중 %d 페이지\n", totalPage, page);
					for(int i = first; i < last; i++) {
						System.out.println(fileList.get(i));
					}
					System.out.print("페이지 선택(Exit : -1) > ");
					page = Integer.parseInt(s.nextLine());

					// 출력 빠져나가기
					if(page == -1) {
						break;
					}
				}
				break;
			case 4:
				// 저장
				// 파일 내용 모두 지우고 ArrayList내의 데이터를 저장
				FileOutputStream fo = new FileOutputStream("res/Employee.txt");
				PrintStream print = new PrintStream(fo);
				// 첫라인 만들기
				print.printf("%s", FilePracticeMain.fieldName);
				// for문을 통해 파일에 데이터 저장
				for(FilePractice fp : fileList) {
					print.printf("\n%s,%s,%d,%c", fp.getName(), fp.getDept(), fp.getSalary(), fp.getGrade());
				}
				System.out.println("파일에 데이터 저장이 완료되었습니다.");
				
				print.close();
				fo.close();
				break;
			case 5:
				stopFlag = true;
				System.out.println("정상적으로 종료되었습니다.");
				break;
			
			}
			
			
		}//while
	}

	public static void FileUpload() {
		FileInputStream fi;
		try {
			fi = new FileInputStream("res/Employee.txt");
			Scanner s = new Scanner(fi);
			// 첫 라인 따로 저장
			if(s.hasNextLine()) {
				FilePracticeMain.fieldName = s.nextLine();
			}
			// 무한 반복을 통해 파일을 읽어와서 ArrayList에 넣는 과정
			while(true) {
				// 다음라인이 없으면 무한반복 탈출
				if(!s.hasNextLine()) {
					break;
				}
				// 1라인씩 가져와기
				String data = s.nextLine();
				// 가져온 1라인 split을 통해 쪼개서 tokens[]에 저장(형변환 동시 진행)
				String[] tokens = data.split(",");
				String name = tokens[0];
				String dept = tokens[1];
				int salary = Integer.parseInt(tokens[2]);
				char grade = tokens[3].charAt(0);
				// 기타 연산
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
				
				// 쪼갠 값 및 연산 결과 객체에 저장
				FilePractice fp = new FilePractice(name, dept, salary, grade);
				fp.setBonus(bonus);
				fp.setTotal(total);
				// 만든 객체를 ArrayList에 저장
				FilePracticeMain.fileList.add(fp);
			}
			System.out.println("인사파일 로드가 완료되었습니다.");
			s.close();
			fi.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("인사파일 로드가 실패되었습니다.");
			stopFlag = true;
		}
		
	}

	public static String PatternInspection(Scanner s, String qustion, String regex) {
		String input = null;
		boolean checkPattern = false;
		boolean isInteger = true;
		System.out.print(qustion);
		try {
			input = s.nextLine();
		} catch(NumberFormatException e) {
			isInteger = false;
		}
		if(checkPattern = Pattern.matches(regex, input)) {
			return input;
		}else {
			System.out.println("유효한 값을 입력하세요!");
			return PatternInspection(s, qustion, regex);
		}
		
	}

	public static void menuDisplay() {
		// 메뉴
		System.out.println("★★★★★★★★ MENU ★★★★★★★★");
		System.out.println("★ \t1. 임직원 가져오기\t ★");
		System.out.println("★ \t2. 임직원 추가입력\t ★");
		System.out.println("★ \t3. 임직원 출력\t ★");
		System.out.println("★ \t4. 인사파일 저장\t ★");
		System.out.println("★ \t5. 종료\t\t ★");
		System.out.println("★★★★★★★★★★★★★★★★★★★★★");
		
	}
	
	
}
