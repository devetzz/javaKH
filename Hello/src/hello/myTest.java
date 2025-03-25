package hello;

public class myTest {

	public static void main(String[] args) {
		//입력(영화, 감독, 관객수, 상영관, 예약 여부
		String movieName = "";
		String filmDirector = "";
		int people = 0;
		char theaterNum = 0;
		boolean reservation = false;
		
		/*
		movieName = "위플래쉬";
		filmDirector = "데이미언 셔젤";
		people = 300;
		theaterNum = 'J';
		reservation = true;
		*/
		
		
		
		//출력
		System.out.printf("영화 제목 : %s\n",movieName);
		System.out.printf("영화 감독 : %s\n",filmDirector);
		System.out.printf("관객수 : %d 만명\n",people);
		System.out.printf("상영관 : %c\n",theaterNum);
		
		if(reservation == true) {
			System.out.printf("예약 여부 : O\n");
		}else {
			System.out.printf("예약 여부 : X\n");
		}
	}

}
