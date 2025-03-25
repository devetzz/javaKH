package hello;

import java.util.Scanner;

public class MyTestInputFor {

	public static void main(String[] args) {
		// 입력(영화, 감독, 관객수, 상영관, 예약 여부
		String movieName = "";
		String filmDirector = "";
		int people = 0;
		char theaterNum = 0;
		boolean reservation = false;
		int imsi = 0;
		
		// 입력(키보드를 통해 입력)
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < 2; i++) {
			System.out.print("영화 제목 입력 : ");
			movieName = scan.nextLine();
			
			System.out.print("감독 이름 입력 : ");
			filmDirector = scan.nextLine();
			
			System.out.print("관객수 입력 : ");
			people = Integer.parseInt(scan.nextLine());
			
			System.out.print("상영관 입력 : ");
			theaterNum = (scan.nextLine()).charAt(0);
					
			System.out.print("예약 여부 입력(예약:1, 예약안함:0) : ");
			//입력 받은 정수 값에 따라 bool 형식으로 반환
			imsi = Integer.parseInt(scan.nextLine());
			if(imsi == 1) {
				reservation = true;
			}else {
				reservation = false;
			}
			
			System.out.printf("--------------------------------\n");
			// 출력
			System.out.printf("영화 제목 : %s\n",movieName);
			System.out.printf("영화 감독 : %s\n",filmDirector);
			System.out.printf("관객수 : %d 만명\n",people);
			System.out.printf("상영관 : %c\n",theaterNum);
			
			if(reservation == true) {
				System.out.printf("예약 여부 : O\n");
			}else {
				System.out.printf("예약 여부 : X\n");
			}
			System.out.printf("================================\n");
			
		}
		
		scan.close();
	}

}
