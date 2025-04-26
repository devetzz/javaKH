package theater;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MovieReservationSystem {

	public static String movieField;
	public static String reservationField;
	public static String reviewField;
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
			int no = Integer.parseInt(PatternInspection(s,"사용자 입력 > ","^[1-5]{1}$"));
			
			func.adminLogon(no, s);

			switch(no) {
			case Menu.ADMIN:
				// 관리자 메뉴
				Menu.adminMenuPrint();
				int adminNo = Integer.parseInt(PatternInspection(s,"메뉴 입력 > ","^[0,1,2,3,4,5]{1}$"));
				
				switch(adminNo) {
				case Menu.MANAGEMENT:
					while(true){
						// 관리 메뉴
						Menu.manageMenuPrint();
						int manageNo = Integer.parseInt(PatternInspection(s,"메뉴 입력 > ","^[1,2,3,5]{1}$"));
						switch(manageNo) {
						case Menu.MOVIEADD:
							func.movieAdd(mvList, s);
							break;
						case Menu.MOVIEMODIFY:
							func.movieModify(mvList, s);
							break;
						case Menu.MOVIEREMOVE:
							func.movieRemove(mvList, s);
							break;
						case Menu.MANAGEEXIT:
							func.movieFileSave(mvList, s);
							break;
						}// manage switch
						if(manageNo == 5){
							break;
						}
					}
					break;
				case Menu.MOVIELIST:
					// 개봉 영화 확인
					func.movieList(mvList, s);
					break;
				case Menu.MOVIERANK:
					while(true){	
					// 순위 메뉴
					Menu.rankMenuPrint();
					int rankNo = Integer.parseInt(PatternInspection(s,"메뉴 입력 > ","^[1-5]{1}$"));
					
						switch(rankNo) {
						case Menu.ACS:
							func.reservationAsc(mvList, s);
							break;
						case Menu.DESC:
							func.reservationDesc(mvList, s);
							break;
						case Menu.MAX:
							func.reservationMax(mvList);
							break;
						case Menu.MIN:
							func.reservationMin(mvList);
							break;
						case Menu.RANKEXIT:break;
						}// rank switch
						if(rankNo == 5){
							break;
						}
					}
					break;
				case Menu.MOVIERESERVATION:
					while(true){
						// 예매 메뉴
						Menu.reservationMenuPrint();
						int reservationNo = Integer.parseInt(PatternInspection(s,"메뉴 입력 > ","^[1-5]{1}$"));
						switch(reservationNo) {
						case Menu.RESERVATIONADD:
							func.reservationAdd(rsvList, s);
							break;
						case Menu.RESERVATIONREMOVE:
							func.reservationCancle(rsvList, s);
							break;
						case Menu.RESERVATIONPRINT:
							func.reservationCheck(rsvList, s);
							break;
						case Menu.RESERVATIONMODIFY:
							func.reservationModify(rsvList, s);
							break;
						case Menu.RESERVATIONEXIT:
							func.movieReservationCountUpdate(rsvList, mvList, s);
							func.reservationFileSave(rsvList, s);
							func.movieFileSave(mvList, s);
							break;
						}// reservation switch
						if(reservationNo == 5){
							break;
						}
					}
					break;
				case Menu.MOVIEREVIEW:
					while(true){
						// 리뷰 메뉴
						Menu.reviewMenuPrint();
						int reviewNo = Integer.parseInt(PatternInspection(s,"메뉴 입력 > ","^[1,2,5]{1}$"));
						switch(reviewNo) {
						case Menu.REVIEWADD:
							func.reviewWrite(rvList, mvList, s);
							break;
						case Menu.REVIEWPRINT:
							func.reviewPrint(rvList, s);
							break;
						case Menu.REVIEWEXIT:
							func.reviewFileSave(rvList, s);
							break;
						}// review switch
						if(reviewNo == 5){
							break;
						}
					}
					break;
				case Menu.EXIT:
					stopFlag = true;
					System.out.println("정상적으로 종료되었습니다.");
					break;
				
				}// 2nd admin switch
				
				
				
				
				break;
			case Menu.USER:
				// 사용자 메뉴
				Menu.userMenuPrint();
				int userNo = Integer.parseInt(PatternInspection(s,"메뉴 입력 > ","^[0,1,2,3,4,5]{1}$"));
				switch(userNo) {
					case Menu.MANAGEMENT:
						while(true){
							// 관리 메뉴
							Menu.manageMenuPrint();
							int manageNo = Integer.parseInt(PatternInspection(s,"메뉴 입력 > ","^[1,2,3,5]{1}$"));
							switch(manageNo) {
							case Menu.MOVIEADD:
								func.movieAdd(mvList, s);
								break;
							case Menu.MOVIEMODIFY:
								func.movieModify(mvList, s);
								break;
							case Menu.MOVIEREMOVE:
								func.movieRemove(mvList, s);
								break;
							case Menu.MANAGEEXIT:
								func.movieFileSave(mvList, s);
								break;
							}// manage switch
							if(manageNo == 5){
								break;
							}
						}
						break;
					case Menu.MOVIELIST:
						// 개봉 영화 확인
						func.movieList(mvList, s);
						break;
					case Menu.MOVIERANK:
						while(true){	
						// 순위 메뉴
						Menu.rankMenuPrint();
						int rankNo = Integer.parseInt(PatternInspection(s,"메뉴 입력 > ","^[1-5]{1}$"));
						
							switch(rankNo) {
							case Menu.ACS:
								func.reservationAsc(mvList, s);
								break;
							case Menu.DESC:
								func.reservationDesc(mvList, s);
								break;
							case Menu.MAX:
								func.reservationMax(mvList);
								break;
							case Menu.MIN:
								func.reservationMin(mvList);
								break;
							case Menu.RANKEXIT:break;
							}// rank switch
							if(rankNo == 5){
								break;
							}
						}
						break;
					case Menu.MOVIERESERVATION:
						while(true){
							// 예매 메뉴
							Menu.reservationMenuPrint();
							int reservationNo = Integer.parseInt(PatternInspection(s,"메뉴 입력 > ","^[1-5]{1}$"));
							switch(reservationNo) {
							case Menu.RESERVATIONADD:
								func.reservationAdd(rsvList, s);
								break;
							case Menu.RESERVATIONREMOVE:
								func.reservationCancle(rsvList, s);
								break;
							case Menu.RESERVATIONPRINT:
								func.reservationCheck(rsvList, s);
								break;
							case Menu.RESERVATIONMODIFY:
								func.reservationModify(rsvList, s);
								break;
							case Menu.RESERVATIONEXIT:
								func.movieReservationCountUpdate(rsvList, mvList, s);
								func.reservationFileSave(rsvList, s);
								func.movieFileSave(mvList, s);
								break;
							}// reservation switch
							if(reservationNo == 5){
								break;
							}
						}
						break;
					case Menu.MOVIEREVIEW:
						while(true){
							// 리뷰 메뉴
							Menu.reviewMenuPrint();
							int reviewNo = Integer.parseInt(PatternInspection(s,"메뉴 입력 > ","^[1,2,5]{1}$"));
							switch(reviewNo) {
							case Menu.REVIEWADD:
								func.reviewWrite(rvList, mvList, s);
								break;
							case Menu.REVIEWPRINT:
								func.reviewPrint(rvList, s);
								break;
							case Menu.REVIEWEXIT:
								func.reviewFileSave(rvList, s);
								break;
							}// review switch
							if(reviewNo == 5){
								break;
							}
						}
						break;
					case Menu.EXIT:
						stopFlag = true;
						System.out.println("정상적으로 종료되었습니다.");
						break;
					
					}// 2nd user switch
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
