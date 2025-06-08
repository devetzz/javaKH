package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.MovieVO;

public class MovieManager {
    // 영화 리스트
    public void list(){
        MovieDAO md = new MovieDAO();
        System.out.println("영화 전체 리스트");
        ArrayList<MovieVO> mvList = md.selectAll();
        if(mvList.size() == 0) {
			System.out.println("영화 전체 리스트 내용이 없습니다.");
			return;
		}else if(mvList == null) {
			System.out.println("영화 전체 리스트 에러발생");
			return;
		}
		for( MovieVO data : mvList) {
			System.out.println(data.toString());
		}
    }

    // 영화 등록
    public void register() throws Exception {
		Scanner s = new Scanner(System.in);

		MovieDAO md = new MovieDAO();
		MovieVO mvo = new MovieVO();

		String movieName; // 영화 이름
		String releaseDate; // 개봉일
		
		System.out.println("영화 정보 입력");
		System.out.print("영화 이름 : ");
		movieName = s.nextLine();
		System.out.print("개봉일 : ");
		releaseDate = s.nextLine();

		mvo.setMovieName(movieName);
		mvo.setReleaseDate(releaseDate);

		md.insert(mvo); 

		System.out.println();
		list();
		System.out.println();
	}
    // 영화 수정
    public void update() throws Exception {
		Scanner s = new Scanner(System.in);

		MovieDAO md = new MovieDAO();
		MovieVO mvo = new MovieVO();

		int movieNum; // 입력한 영화 번호
		String movieName; // 영화 이름
		String releaseDate; // 개봉일

		System.out.println("영화 전체 리스트");
		list(); 
		System.out.println();

		System.out.println("수정할 영화 번호 입력");
		System.out.print("영화번호 : ");
		movieNum = Integer.parseInt(s.nextLine());

		System.out.println();
		System.out.println("새로운 정보 모두 입력");
		System.out.print("영화 이름 : ");
		movieName = s.nextLine();
		System.out.print("개봉일 : ");
		releaseDate = s.nextLine();

		mvo.setMovieNum(movieNum);
		mvo.setMovieName(movieName);
		mvo.setReleaseDate(releaseDate);
		int count = md.update(mvo);
		
		if(count == 0) {
			System.out.println("영화 정보 수정 오류발생");
			return; 
		}else {
			System.out.println("영화 정보 수정완료");
		}
		
		System.out.println();
		list(); 
		System.out.println();
	}
    // 영화 삭제
    public void delete() throws Exception {
		Scanner s = new Scanner(System.in);

		MovieDAO md = new MovieDAO();
		MovieVO mvo = new MovieVO();

		int movieNum; // 영화 번호
		list();
		System.out.println();

		System.out.println("삭제할 영화 번호 입력");
		System.out.print("영화 번호 : ");
		movieNum = Integer.parseInt(s.nextLine());
		mvo.setMovieNum(movieNum);
		int count = md.deleteByMovieNum(mvo);
		if(count == 0) {
			System.out.printf("%s 번호 삭제 문제발생\n",movieNum);
		}else {
			System.out.printf("%s 번호 삭제성공\n",movieNum);
		}
		System.out.println();
		list();
		System.out.println();
	}
}
