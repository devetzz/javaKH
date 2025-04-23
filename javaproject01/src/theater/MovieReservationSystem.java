package theater;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MovieReservationSystem {

	
	public static void main(String[] args) {
		// 변수 선언
		boolean stopFlag = false;
		Scanner s = new Scanner(System.in);
		ArrayList<Movie> mvList = new ArrayList<>();
		ArrayList<Reservation> rsvList = new ArrayList<>();
		ArrayList<Review> rvList = new ArrayList<>();
		
		
		FuncImplementation func = new FuncImplementation();
		func.movieFileUpload(mvList);
		func.reservationFileUpload(rsvList);
		func.reviewFileUpload(rvList);
		
		// 반복문(입력, 출력, 종료)
		while(!stopFlag) {
			// 사용자 선택 메뉴
			Menu.userSelectMenuPrint();
			int userNo = Integer.parseInt(PatternInspection(s,"사용자 입력 > ","^[1-5]{1}$"));
			
			switch(userNo) {
			case Menu.ADMIN:
				// 관리자 메뉴
				Menu.adminMenuPrint();
				int adminNo = Integer.parseInt(PatternInspection(s,"메뉴 입력 > ","^[0,1,2,3,4,5]{1}$"));
				
				switch(adminNo) {
				case Menu.MANAGEMENT:
					// 관리 메뉴
					Menu.manageMenuPrint();
					int manageNo = Integer.parseInt(PatternInspection(s,"메뉴 입력 > ","^[1,2,3,5]{1}$"));
					
					switch(manageNo) {
					case Menu.MOVIEADD:
						break;
					case Menu.MOVIEMODIFY:break;
					case Menu.MOVIEREMOVE:break;
					case Menu.MANAGEEXIT:break;
					}// manage switch
					break;
				case Menu.MOVIELIST:
					break;
				case Menu.MOVIERANK:
					// 순위 메뉴
					Menu.rankMenuPrint();
					int rankNo = Integer.parseInt(PatternInspection(s,"메뉴 입력 > ","^[1-5]{1}$"));
					
					switch(rankNo) {
					case Menu.ACS:break;
					case Menu.DESC:break;
					case Menu.MAX:break;
					case Menu.MIN:break;
					case Menu.RANKEXIT:break;
					}// rank switch
					
					break;
				case Menu.MOVIERESERVATION:
					// 예매 메뉴
					Menu.reservationMenuPrint();
					int reservationNo = Integer.parseInt(PatternInspection(s,"메뉴 입력 > ","^[1-5]{1}$"));
					
					switch(reservationNo) {
					case Menu.RESERVATIONADD:break;
					case Menu.RESERVATIONREMOVE:break;
					case Menu.RESERVATIONPRINT:break;
					case Menu.RESERVATIONMODIFY:break;
					case Menu.RESERVATIONEXIT:break;
					}// reservation switch
					
					break;
				case Menu.MOVIEREVIEW:
					// 리뷰 메뉴
					Menu.reviewMenuPrint();
					int reviewNo = Integer.parseInt(PatternInspection(s,"메뉴 입력 > ","^[1,2,5]{1}$"));
					
					switch(reviewNo) {
					case Menu.REVIEWADD:break;
					case Menu.REVIEWPRINT:break;
					case Menu.REVIEWEXIT:break;
					}// review switch
					
					break;
				case Menu.EXIT:
					stopFlag = true;
					System.out.println("정상적으로 종료되었습니다.");
					break;
				
				}// 2nd switch
				
				
				
				
				break;
			case Menu.USER:
				// 사용자 메뉴
				
				break;
			case Menu.USEREXIT:
				stopFlag = true;
				System.out.println("정상적으로 종료되었습니다.");
				break;
			}// 1st switch
				
			
			
		}//while
		
		
	}//main

	private static String PatternInspection(Scanner s, String string, String regex) {
		System.out.print(string);
		String input = s.nextLine();
		if(Pattern.matches(regex, input)) {
			return input;
		}else {
			System.out.println("유효한 값을 입력해주세요.");
			return PatternInspection(s, string, regex);
		}
	}

}
