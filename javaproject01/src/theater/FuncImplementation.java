package theater;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;


public class FuncImplementation implements ReservationFuncInterface {

	@Override
	public void movieFileUpload(ArrayList<Movie> mvList) {
		FileInputStream fi;
		try {
			fi = new FileInputStream("tableFile/movieTable.txt");
			Scanner s = new Scanner(fi);
			
			// 첫라인 저장
			if(s.hasNextLine()) {
				MovieReservationSystem.movieField = s.nextLine();
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
				
			}
			System.out.println("정상적으로 영화 파일을 로드했습니다.");
			
		} catch (FileNotFoundException e) {
			System.out.println("영화 파일 업로드가 실패했습니다.");
			e.printStackTrace();
		}
		
	}

	@Override
	public void movieFileSave(ArrayList<Movie> mvList) {
		FileOutputStream fo = null;
		try {
			fo = new FileOutputStream("tableFile/movieTable.txt");
		} catch (FileNotFoundException e) {
			System.out.println("영화 파일 저장 실패했습니다.");
			e.printStackTrace();
		}
		PrintStream ps = new PrintStream(fo);
		
		ps.printf("%s", MovieReservationSystem.movieField);
		
		for(Movie data : mvList) {
			ps.printf("%d,%s,%s,%d\n", data.getMovieNum(), data.getMovieName(), data.getReleaseDate(), data.getReservationCount());
		}
		
		ps.close();
		try {
			fo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("---영화 파일 저장 완료---");
	}

	@Override
	public void reservationFileUpload(ArrayList<Reservation> rsvList) {
		FileInputStream fi;
		try {
			fi = new FileInputStream("tableFile/reservationInfoTable.txt");
			Scanner s = new Scanner(fi);
			
			// 첫라인 저장
			if(s.hasNextLine()) {
				MovieReservationSystem.reservationField = s.nextLine();
			}
			while(true) {
				if(!s.hasNextLine()) {
					break;
				}
				String[] tokens = s.nextLine().split(",");
				String phoneNum = tokens[0];
				String userName = tokens[1];
				String movieName = tokens[2];
				int seatNum = Integer.parseInt(tokens[3]);
				
				Reservation reservation = new Reservation(phoneNum, userName, movieName, seatNum);
				
				rsvList.add(reservation);
				
			}
			System.out.println("정상적으로 예매 파일을 로드했습니다.");
			
		} catch (FileNotFoundException e) {
			System.out.println("예매 파일 업로드가 실패했습니다.");
			e.printStackTrace();
		}
	}

	@Override
	public void reservationFileSave(ArrayList<Reservation> rsvList) {
		FileOutputStream fo = null;
		try {
			fo = new FileOutputStream("tableFile/movieTable.txt");
		} catch (FileNotFoundException e) {
			System.out.println("예매 파일 저장 실패했습니다.");
			e.printStackTrace();
		}
		PrintStream ps = new PrintStream(fo);
		
		ps.printf("%s", MovieReservationSystem.reservationField);
		
		for(Reservation data : rsvList) {
			ps.printf("%s,%s,%s,%d\n", data.getPhoneNum(), data.getUserName(), data.getMovieName(), data.getSeatNum());
		}
		
		ps.close();
		try {
			fo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("---예매 파일 저장 완료---");
	}

	@Override
	public void reviewFileUpload(ArrayList<Review> rvList) {
		FileInputStream fi;
		try {
			fi = new FileInputStream("tableFile/reviewTable.txt");
			Scanner s = new Scanner(fi);
			
			// 첫라인 저장
			if(s.hasNextLine()) {
				MovieReservationSystem.reviewField = s.nextLine();
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
				
			}
			System.out.println("정상적으로 리뷰 파일을 로드했습니다.");
			
		} catch (FileNotFoundException e) {
			System.out.println("리뷰 파일 업로드가 실패했습니다.");
			e.printStackTrace();
		}
	}

	@Override
	public void reviewFileSave(ArrayList<Review> rvList) {
		FileOutputStream fo = null;
		try {
			fo = new FileOutputStream("tableFile/reviewTable.txt");
		} catch (FileNotFoundException e) {
			System.out.println("리뷰 파일 저장 실패했습니다.");
			e.printStackTrace();
		}
		PrintStream ps = new PrintStream(fo);
		
		ps.printf("%s", MovieReservationSystem.reviewField);
		
		for(Review data : rvList) {
			ps.printf("%d,%d,%.2f,%s\n", data.getReviewNum(), data.getMovieNum(), data.getReviewRate(), data.getComment());
		}
		
		ps.close();
		try {
			fo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("---리뷰 파일 저장 완료---");
	}
	
	@Override
	public void adminLogon() {

	}

	@Override
	public void movieAdd(ArrayList<Movie> mvList, Scanner s) {
		System.out.println("---영화 등록---");
		
		int max = Integer.MIN_VALUE;
		for(Movie data : mvList) {
			if(max < data.getMovieNum()) {
				max = data.getMovieNum();
			}
		}
		int movieNum = max+1;
		
		String movieName = PatternInspection(s, "등록할 영화 이름 : ", "^[가-힣A-Za-z0-9]{1,30}$");
		String releaseDate = PatternInspection(s, "등록할 영화 개봉일 : ", "\\d{4}-\\d{2}-\\d{2}");
		Movie movie = new Movie(movieNum, movieName, releaseDate, 0);
		mvList.add(movie);
	}

	@Override
	public void movieModify(ArrayList<Movie> mvList, Scanner s) {
		System.out.println("---영화 수정---");
		
		String search = PatternInspection(s, "수정할 영화 검색(제목) : ", "^[가-힣A-Za-z0-9]{1,30}$");
		Movie modifyMovie = null;
		for(Movie data : mvList) {
			if(data.getMovieName().equals(search)) {
				modifyMovie = data;
				break;
			}
		}
		if(modifyMovie == null) {
			System.out.printf("%s 는 존재하지 않습니다.\n", search);
		}
		
		String movieName = PatternInspection(s, "수정할 제목 : ", "^[가-힣A-Za-z0-9]{1,30}$");
		String releaseDate = PatternInspection(s, "수정할 개봉일 : ", "\\d{4}-\\d{2}-\\d{2}");
		
		modifyMovie.setMovieName(movieName);
		modifyMovie.setReleaseDate(releaseDate);
		
		System.out.printf("%s 영화 정보 수정 완료.\n", search);
	}

	@Override
	public void movieRemove(ArrayList<Movie> mvList, Scanner s) {
		System.out.println("---영화 삭제---");
		
		System.out.print("삭제할 영화 검색(제목) : ");
		String search = PatternInspection(s, "삭제할 영화 검색(제목) : ", "^[가-힣A-Za-z0-9]{1,30}$");
		Movie removeMovie = null;
		for(Movie data : mvList) {
			if(data.getMovieName().equals(search)) {
				removeMovie = data;
				break;
			}
		}
		if(removeMovie == null) {
			System.out.printf("%s 는 존재하지 않습니다.\n", search);
		}
		
		mvList.remove(removeMovie);
		
		System.out.printf("%s 영화 정보 삭제 완료.\n", search);
	}

	@Override
	public void movieList(ArrayList<Movie> mvList, Scanner s) {
		System.out.println("---개봉 영화 확인---");
		
		int page = 1;
		while(true) {
			// 전체 페이지를 구한다
			int totalPage = mvList.size() / 10;
			int remainValue = mvList.size() % 10;
			if(remainValue != 0) {
				totalPage += 1;
			}
			// 해당 페이지의 시작위치, 끝위치를 구한다.
			int first = 10 * (page - 1);
			int last = first + 10;
			// 마지막페이지에 나머지가 있을때 끝위치를 정한다.
			if(remainValue != 0 && page == totalPage) {
				last = first + remainValue;
			}
			// for문을 통해 페이지별 출력
			System.out.printf("현재 %d / 전체 %d page\n", page, totalPage);
			for(int i = first; i < last; i++) {
				System.out.println(mvList.get(i));
			}
			page = Integer.parseInt(PatternInspection(s, "Page 입력 (Exit : -1) > ", "^[0-9]{1,2}$"));

			if(page == -1) {
				break;
			}
		}
		
	}

	@Override
	public void reservationAsc(ArrayList<Reservation> rsvList) {
		Collections.sort(rsvList);
		System.out.println("---오름차순 정렬 완료---");
	}

	@Override
	public void reservationDesc(ArrayList<Reservation> rsvList) {
		Collections.sort(rsvList, Collections.reverseOrder());
		System.out.println("---내림차순 정렬 완료---");
	}

	@Override
	public void reservationMax(ArrayList<Reservation> rsvList) {

	}

	@Override
	public void reservationMin(ArrayList<Reservation> rsvList) {

	}

	@Override
	public void reservationAdd(ArrayList<Reservation> rsvList, Scanner s) {

	}

	@Override
	public void reservationCancle(ArrayList<Reservation> rsvList, Scanner s) {

	}

	@Override
	public void reservationCheck(ArrayList<Reservation> rsvList) {

	}

	@Override
	public void reservationModify(ArrayList<Reservation> rsvList, Scanner s) {

	}

	@Override
	public void reviewWrite(ArrayList<Review> rvList, Scanner s) {

	}

	@Override
	public void reviewPrint(ArrayList<Review> rvList) {

	}

	@Override
	public String PatternInspection(Scanner s, String string, String regex) {
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
