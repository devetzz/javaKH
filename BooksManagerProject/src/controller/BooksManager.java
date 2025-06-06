package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.BooksVO;

public class BooksManager {
    public static Scanner sc = new Scanner(System.in);

    // 도서 목록 매니저
    public static void booksList() {
        BooksDAO booksDAO = new BooksDAO();
        System.out.println("******도서 정보 리스트******");
        ArrayList<BooksVO> _booksList = booksDAO.selectAll();
        if(_booksList.size() <= 0 || _booksList == null){
            System.out.println("도서 정보 리스트에서 에러가 발생하였습니다.");
        }
        for(BooksVO data : _booksList){
            System.out.println(data.toString());
        }
    }
    // 도서 입력 매니저
    public static void booksInsert() {
        BooksDAO booksDAO = new BooksDAO();
        BooksVO booksVO = null;
        // 사용자가 입력한것 처럼 처리
        System.out.print("Input Title : ");
        String title = sc.nextLine();
        System.out.print("Input Publisher : ");
        String publisher = sc.nextLine();
        System.out.print("Input Year : ");
        String year = sc.nextLine();
        System.out.print("Input Price : ");
        int price = Integer.parseInt(sc.nextLine());

        booksVO = new BooksVO(0, title, publisher, year, price);
        
        int count = booksDAO.insert(booksVO);
        if(count == 0){
            System.out.println("입력에 문제가 발생하였습니다.");
        }else{
            System.out.println("입력 성공!");
        }
    }
    // 도서 수정 매니저
    public static void booksUpdate() {
        BooksDAO booksDAO = new BooksDAO();
        BooksVO booksVO = null;

        booksList();
        // 선택 도서 정보
        System.out.print("수정할 번호 : ");
        int bookId = Integer.parseInt(sc.nextLine());
        booksVO = new BooksVO();
        booksVO.setBookId(bookId);
        booksDAO.selectByBookID(booksVO);
        
        // 사용자가 입력한것 처럼 처리
        System.out.print("Update Title : ");
        String title = sc.nextLine();
        System.out.print("Update Publisher : ");
        String publisher = sc.nextLine();
        System.out.print("Update Year : ");
        String year = sc.nextLine();
        System.out.print("Update Price : ");
        int price = Integer.parseInt(sc.nextLine());

        booksVO = new BooksVO(bookId, title, publisher, year, price);
        
        int count = booksDAO.update(booksVO);
        if(count == 0){
            System.out.println("수정에 문제가 발생하였습니다.");
        }else{
            System.out.println("수정 성공!");
        }
    }
    // 도서 삭제 매니저
    public static void booksDelete() {
        BooksDAO booksDAO = new BooksDAO();
        BooksVO booksVO = null;

        booksList();
        // 선택 도서 정보
        System.out.print("삭제할 번호 : ");
        int bookId = Integer.parseInt(sc.nextLine());
        booksVO = new BooksVO();
        booksVO.setBookId(bookId);
        int count = booksDAO.deleteBookId(booksVO);
        
        if(count == 0){
            System.out.println("삭제에 문제가 발생하였습니다.");
        }else{
            System.out.println("삭제 성공!");
        }
    }
    // 도서 검색 매니저
    public static void booksSearch() {
        BooksDAO booksDAO = new BooksDAO();
        BooksVO booksVO = null;

        System.out.print("검색할 제목 : ");
        String Title = sc.nextLine();
        booksVO = new BooksVO();
        booksVO.setTitle(Title);

        ArrayList<BooksVO> booksList = booksDAO.selectByTitle(booksVO);
        if(booksList.size() <= 0 || booksList == null){
            System.out.println("도서 정보 검색 에러가 발생하였습니다.");
        }
        for(BooksVO data : booksList){
            System.out.println(data.toString());
        }
    }
}
