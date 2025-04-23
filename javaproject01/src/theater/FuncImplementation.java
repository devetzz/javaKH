package theater;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FuncImplementation implements ReservationFuncInterface {

	@Override
	public void movieFileUpload(ArrayList<Movie> mvList) {
		FileInputStream fi;
		try {
			fi = new FileInputStream("tableFile/movieTable.txt");
			Scanner s = new Scanner(fi);
			
			// 첫라인 저장
			if(s.hasNextLine()) {
				s.nextLine();
			}
			while(true) {
				if(!s.hasNextLine()) {
					break;
				}
				String[] tokens = s.nextLine().split(",");
				int movieNum = Integer.parseInt(tokens[0]);
				String movieName = tokens[1];
				String releaseDate = tokens[2];
				int reservationCount = Integer.parseInt(tokens[3]);
				
				Movie movie = new Movie(movieNum, movieName, releaseDate, reservationCount);
				mvList.add(movie);
				
				System.out.println("정상적으로 영화 파일을 로드했습니다.");
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("영화 파일 업로드가 실패했습니다.");
			e.printStackTrace();
		}
		
	}

	@Override
	public void movieFileSave(ArrayList<Movie> mvList) {
		
	}

	@Override
	public void reservationFileUpload(ArrayList<Reservation> rsvList) {
		FileInputStream fi;
		try {
			fi = new FileInputStream("tableFile/reservationInfoTable.txt");
			Scanner s = new Scanner(fi);
			
			// 첫라인 저장
			if(s.hasNextLine()) {
				s.nextLine();
			}
			while(true) {
				if(!s.hasNextLine()) {
					break;
				}
				String[] tokens = s.nextLine().split(",");
				int phoneNum = Integer.parseInt(tokens[0]);
				String userName = tokens[1];
				String movieName = tokens[2];
				int seatNum = Integer.parseInt(tokens[3]);
				
				Reservation reservation = new Reservation(phoneNum, userName, movieName, seatNum);
				
				rsvList.add(reservation);
				
				System.out.println("정상적으로 예매 파일을 로드했습니다.");
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("예매 파일 업로드가 실패했습니다.");
			e.printStackTrace();
		}
	}

	@Override
	public void reservationFileSave(ArrayList<Reservation> rsvList) {
		
	}

	@Override
	public void reviewFileUpload(ArrayList<Review> rvList) {
		FileInputStream fi;
		try {
			fi = new FileInputStream("tableFile/reviewTable.txt");
			Scanner s = new Scanner(fi);
			
			// 첫라인 저장
			if(s.hasNextLine()) {
				s.nextLine();
			}
			while(true) {
				if(!s.hasNextLine()) {
					break;
				}
				String[] tokens = s.nextLine().split(",");
				int reviewNum = Integer.parseInt(tokens[0]);
				int movieNum = Integer.parseInt(tokens[1]);
				double reviewRate = Double.parseDouble(tokens[2]);
				String comment = tokens[3];
				
				Review review = new Review(reviewNum, movieNum, reviewRate, comment);
				
				rvList.add(review);
				
				System.out.println("정상적으로 리뷰 파일을 로드했습니다.");
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("리뷰 파일 업로드가 실패했습니다.");
			e.printStackTrace();
		}
	}

	@Override
	public void reviewFileSave(ArrayList<Review> rvList) {
		
	}
	
	@Override
	public void adminLogon() {

	}

	@Override
	public void movieAdd() {
		
	}

	@Override
	public void movieModify() {

	}

	@Override
	public void movieRemove() {

	}

	@Override
	public void movieList() {

	}

	@Override
	public void reservationAsc() {

	}

	@Override
	public void reservationDesc() {

	}

	@Override
	public void reservationMax() {

	}

	@Override
	public void reservationMin() {

	}

	@Override
	public void reservationAdd() {

	}

	@Override
	public void reservationCancle() {

	}

	@Override
	public void reservationCheck() {

	}

	@Override
	public void reservationModify() {

	}

	@Override
	public void reviewWrite() {

	}

	@Override
	public void reviewPrint() {

	}


}
