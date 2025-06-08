import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import controller.DBUtil;
import controller.FuncImplementation;
import controller.MovieManager;
import controller.ReservationFuncInterface;
import model.MovieVO;
import model.ReservationVO;
import model.ReviewVO;
import view.Menu;

public class MovieReservationSystem {
    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        Connection con = DBUtil.getConnection();
        int choice = 0;
        boolean stopFlag = false;
        boolean adminStop = false;
        boolean userStop = false;
        ArrayList<MovieVO> mvList = new ArrayList<>();
		ArrayList<ReservationVO> rsvList = new ArrayList<>();
		ArrayList<ReviewVO> rvList = new ArrayList<>();

        ReservationFuncInterface func = new FuncImplementation();
        
        if (con == null) {
			System.out.println("디비연결오류");
			return;
		}

        // 메뉴 화면 진행
        while (!stopFlag) {
			// 사용자 선택 메뉴
			clear();
			adminStop = false;
			userStop = false;
			Menu.userSelectMenuPrint();
			int no = Integer.parseInt(PatternInspection(s, "사용자 선택 > ", "^[1-5]{1}$"));

			func.adminLogon(no, s);

			switch (no) {
				case Menu.ADMIN:
					while (!adminStop) {
						// 관리자 메뉴
						clear();
						Menu.adminMenuPrint();
						int adminNo = Integer.parseInt(PatternInspection(s, "메뉴 입력 > ", "^[0,1,2,3,4,5]{1}$"));
						switch (adminNo) {
							case Menu.MANAGEMENT:
								while (true) {
                                    try {
                                        // 관리 메뉴
                                        clear();
                                        Menu.manageMenuPrint();
                                        MovieManager mm = new MovieManager();
                                        int manageNo = Integer.parseInt(PatternInspection(s, "메뉴 입력 > ", "^[1,2,3,5]{1}$"));
                                        switch (manageNo) {
                                            case Menu.MOVIEADD:
                                                // clear();
                                                mm.register();
                                                // func.movieAdd(mvList, s);
                                                Thread.sleep(3000);
                                                break;
                                            case Menu.MOVIEMODIFY:
                                                // clear();
                                                mm.update();
                                                // func.movieModify(mvList, s);
                                                Thread.sleep(3000);
                                                break;
                                            case Menu.MOVIEREMOVE:
                                                // clear();
                                                mm.delete();
                                                // func.movieRemove(mvList, s);
                                                Thread.sleep(3000);
                                                break;
                                            case Menu.MANAGEEXIT:
                                                // func.movieFileSave(mvList, s);
                                                break;
                                        }// manage switch
                                        if (manageNo == 5) {
                                            break;
                                        }
                                    } catch (Exception e) {
                                        System.out.println("\n입력에 오류가 있습니다.\n프로그램을 다시 시작하세요.");
                                    }
								}
								break;
							case Menu.MOVIELIST:
                                try {
                                    // clear();
                                    MovieManager mm = new MovieManager();
                                    // 개봉 영화 확인
                                    mm.list();
                                    // func.movieList(mvList, s);
                                    break;
                                } catch (Exception e){
                                    System.out.println("\n입력에 오류가 있습니다.\n프로그램을 다시 시작하세요.");
                                }
							case Menu.MOVIERANK:
								while (true) {
									clear();
									// 순위 메뉴
									Menu.rankMenuPrint();
									int rankNo = Integer.parseInt(PatternInspection(s, "메뉴 입력 > ", "^[1-5]{1}$"));

									switch (rankNo) {
										case Menu.ACS:
											clear();
											func.reservationAsc(mvList, s);
											break;
										case Menu.DESC:
											clear();
											func.reservationDesc(mvList, s);
											break;
										case Menu.MAX:
											// clear();
											func.reservationMax(mvList);
											Thread.sleep(2000);
											break;
										case Menu.MIN:
											// clear();
											func.reservationMin(mvList);
											Thread.sleep(2000);
											break;
										case Menu.RANKEXIT:
											break;
									}// rank switch
									if (rankNo == 5) {
										break;
									}
								}
								break;
							case Menu.MOVIERESERVATION:
								while (true) {
									// 예매 메뉴
									clear();
									Menu.reservationMenuPrint();
									int reservationNo = Integer
											.parseInt(PatternInspection(s, "메뉴 입력 > ", "^[1-5]{1}$"));

									switch (reservationNo) {
										case Menu.RESERVATIONADD:
											clear();
											func.reservationAdd(rsvList, mvList, s);
											Thread.sleep(3000);
											break;
										case Menu.RESERVATIONREMOVE:
											clear();
											func.reservationCancle(rsvList, s);
											Thread.sleep(3000);
											break;
										case Menu.RESERVATIONPRINT:
											func.reservationCheck(rsvList, s);
											break;
										case Menu.RESERVATIONMODIFY:
											clear();
											func.reservationModify(rsvList, s);
											Thread.sleep(3000);
											break;
										case Menu.RESERVATIONEXIT:
											func.movieReservationCountUpdate(rsvList, mvList, s);
											func.reservationFileSave(rsvList, s);
											func.movieFileSave(mvList, s);
											break;
									}// reservation switch
									if (reservationNo == 5) {
										break;
									}
								}
								break;
							case Menu.MOVIEREVIEW:
								while (true) {
									// 리뷰 메뉴
									clear();
									Menu.reviewMenuPrint();
									int reviewNo = Integer.parseInt(PatternInspection(s, "메뉴 입력 > ", "^[1,2,5]{1}$"));

									switch (reviewNo) {
										case Menu.REVIEWADD:
											clear();
											func.reviewWrite(rvList, mvList, s);
											Thread.sleep(3000);
											break;
										case Menu.REVIEWPRINT:
											func.reviewPrint(rvList, s);
											break;
										case Menu.REVIEWEXIT:
											func.reviewFileSave(rvList, s);
											break;
									}// review switch
									if (reviewNo == 5) {
										break;
									}
								}
								break;
							case Menu.EXIT:
								adminStop = true;
								System.out.println("(관리자)정상적으로 로그아웃 되었습니다.");
								Thread.sleep(2000);
								break;
						}// 2nd admin switch
					}// admin while
					break;



				case Menu.USER:
					while(!userStop){
						// 사용자 메뉴
						clear();
						Menu.userMenuPrint();
						int userNo = Integer.parseInt(PatternInspection(s, "메뉴 입력 > ", "^[0,1,2,3,4,5]{1}$"));
						switch (userNo) {
							case Menu.MOVIELIST:
								clear();
								// 개봉 영화 확인
								func.movieList(mvList, s);
								break;
							case Menu.MOVIERANK:
								while (true) {
									clear();
									// 순위 메뉴
									Menu.rankMenuPrint();
									int rankNo = Integer.parseInt(PatternInspection(s, "메뉴 입력 > ", "^[1-5]{1}$"));
	
									switch (rankNo) {
										case Menu.ACS:
											clear();
											func.reservationAsc(mvList, s);
											break;
										case Menu.DESC:
											clear();
											func.reservationDesc(mvList, s);
											break;
										case Menu.MAX:
											clear();
											func.reservationMax(mvList);
											Thread.sleep(2000);
											break;
										case Menu.MIN:
											clear();
											func.reservationMin(mvList);
											Thread.sleep(2000);
											break;
										case Menu.RANKEXIT:
											break;
									}// rank switch
									if (rankNo == 5) {
										break;
									}
								}
								break;
							case Menu.MOVIERESERVATION:
								while (true) {
									clear();
									// 예매 메뉴
									Menu.reservationMenuPrint();
									int reservationNo = Integer.parseInt(PatternInspection(s, "메뉴 입력 > ", "^[1-5]{1}$"));
	
									switch (reservationNo) {
										case Menu.RESERVATIONADD:
											clear();
											func.reservationAdd(rsvList, mvList, s);
											Thread.sleep(3000);
											break;
										case Menu.RESERVATIONREMOVE:
											clear();
											func.reservationCancle(rsvList, s);
											Thread.sleep(3000);
											break;
										case Menu.RESERVATIONPRINT:
											clear();
											func.reservationCheck(rsvList, s);
											break;
										case Menu.RESERVATIONMODIFY:
											clear();
											func.reservationModify(rsvList, s);
											Thread.sleep(3000);
											break;
										case Menu.RESERVATIONEXIT:
											func.movieReservationCountUpdate(rsvList, mvList, s);
											func.reservationFileSave(rsvList, s);
											func.movieFileSave(mvList, s);
											break;
									}// reservation switch
									if (reservationNo == 5) {
										break;
									}
								}
								break;
							case Menu.MOVIEREVIEW:
								while (true) {
									clear();
									// 리뷰 메뉴
									Menu.reviewMenuPrint();
									int reviewNo = Integer.parseInt(PatternInspection(s, "메뉴 입력 > ", "^[1,2,5]{1}$"));
	
									switch (reviewNo) {
										case Menu.REVIEWADD:
											clear();
											func.reviewWrite(rvList, mvList, s);
											Thread.sleep(3000);
											break;
										case Menu.REVIEWPRINT:
											clear();
											func.reviewPrint(rvList, s);
											break;
										case Menu.REVIEWEXIT:
											func.reviewFileSave(rvList, s);
											break;
									}// review switch
									if (reviewNo == 5) {
										break;
									}
								}
								break;
							case Menu.EXIT:
								userStop = true;
								System.out.println("(사용자)정상적으로 로그아웃 되었습니다.");
								Thread.sleep(2000);
								break;
						}// 2nd user switch
					}// user while
					break;
					
				case Menu.USEREXIT:
					stopFlag = true;
					System.out.println("정상적으로 종료되었습니다.");
					break;
			}// 1st switch
		} // while

    }// main

    private static String PatternInspection(Scanner s, String string, String regex) {
		System.out.print(string);
		String input = s.nextLine();
		if (Pattern.matches(regex, input)) {
			return input;
		} else {
			System.out.println("유효한 값을 입력해주세요.");
			return PatternInspection(s, string, regex);
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
}
