package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.BooksVO;

public class BooksDAO {
    // 멤버 변수
    private String selectSQL = "SELECT * FROM BOOKS ORDER BY BOOK_ID DESC";
    private String selectBookIdSQL = "SELECT * FROM BOOKS WHERE BOOK_ID = ?";
    private String selectTitleSQL = "SELECT * FROM BOOKS WHERE TITLE = ?";
    private String insertSQL = "INSERT INTO books VALUES (books_seq.nextval, ?, ?, ?, ?)";
    private String updateSQL = "UPDATE BOOKS SET TITLE = ?, PUBLISHER = ?, YEAR = ?, PRICE = ? WHERE BOOK_ID = ?";
    private String deleteSQL = "DELETE FROM BOOKS WHERE BOOK_ID = ?";
    // 멤버 함수
    // 도서 정보 목록
    public ArrayList<BooksVO> selectAll() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<BooksVO> booksList = new ArrayList<BooksVO>();
        try {
            con = DBUtil.getConnection();
            if(con == null){
                System.out.println("DB 연결 실패");
                return null;
            }
            pstmt = con.prepareStatement(selectSQL);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                int bookId = rs.getInt("BOOK_ID");
                String title =rs.getString("TITLE");
                String publisher = rs.getString("PUBLISHER");
                String year = rs.getString("YEAR");
                int price = rs.getInt("PRICE");
                BooksVO booksVO = new BooksVO(bookId,title,publisher,year,price);
                booksList.add(booksVO);
            }
        } catch (SQLException e) {
            System.out.println("createstatement 오류발생");
        } finally{
            DBUtil.dbClose(con, pstmt, rs);
        }
        return booksList;
    }
    
    // 도서 정보 목록 (조건 : book_id)
    public void selectByBookID(BooksVO booksVO) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getConnection();
            if(con == null){
                System.out.println("DB 연결 실패");
                return;
            }
            pstmt = con.prepareStatement(selectBookIdSQL);
            pstmt.setInt(1, booksVO.getBookId());
            rs = pstmt.executeQuery();

            if(rs.next()) {
                int bookId = rs.getInt("BOOK_ID");
                String title =rs.getString("TITLE");
                String publisher = rs.getString("PUBLISHER");
                String year = rs.getString("YEAR");
                int price = rs.getInt("PRICE");
                BooksVO _booksVO = new BooksVO(bookId,title,publisher,year,price);
                System.out.println(_booksVO.toString());
            }else{
                System.out.println("해당되는 BookID 정보가 없습니다.");
            }

           
        } catch (SQLException e) {
            System.out.println("createstatement 오류발생");
        } finally{
            DBUtil.dbClose(con, pstmt, rs);
        }
    }

    // 도서 정보 검색 (조건 : title)
    public ArrayList<BooksVO> selectByTitle(BooksVO booksVO) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<BooksVO> booksList = new ArrayList<BooksVO>();
        try {
            con = DBUtil.getConnection();
            if(con == null){
                System.out.println("DB 연결 실패");
                return null;
            }
            pstmt = con.prepareStatement(selectTitleSQL);
            pstmt.setString(1, booksVO.getTitle());
            rs = pstmt.executeQuery();

            while(rs.next()) {
                int bookId = rs.getInt("BOOK_ID");
                String title =rs.getString("TITLE");
                String publisher = rs.getString("PUBLISHER");
                String year = rs.getString("YEAR");
                int price = rs.getInt("PRICE");
                BooksVO _booksVO = new BooksVO(bookId,title,publisher,year,price);
                booksList.add(_booksVO);
            }
           
        } catch (SQLException e) {
            System.out.println("createstatement 오류발생");
        } finally{
            DBUtil.dbClose(con, pstmt, rs);
        }
        return booksList;
    }

    // 도서 정보 입력
    public int insert(BooksVO booksVO){
        Connection con = null;
        PreparedStatement pstmt = null;
        int count = 0;
        try {
            con = DBUtil.getConnection();
            if(con == null){
                System.out.println("DB 연결 실패");
                return -1;
            }
            pstmt = con.prepareStatement(insertSQL);
            pstmt.setString(1, booksVO.getTitle());
            pstmt.setString(2, booksVO.getPublisher());
            pstmt.setString(3, booksVO.getYear());
            pstmt.setInt(4, booksVO.getPrice());
            count = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("createstatement 오류발생");
        } finally{
            DBUtil.dbClose(con, pstmt);
        }
        return count;
    }

    // 도서 정보 수정
    public int update(BooksVO booksVO){
        Connection con = null;
        PreparedStatement pstmt = null;
        int count = 0;
        try {
            con = DBUtil.getConnection();
            if(con == null){
                System.out.println("DB 연결 실패");
                return -1;
            }
            pstmt = con.prepareStatement(updateSQL);
            pstmt.setString(1, booksVO.getTitle());
            pstmt.setString(2, booksVO.getPublisher());
            pstmt.setString(3, booksVO.getYear());
            pstmt.setInt(4, booksVO.getPrice());
            pstmt.setInt(5, booksVO.getBookId());
            count = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("createstatement 오류발생");
        } finally{
            DBUtil.dbClose(con, pstmt);
        }
        return count;
    }

    // 도서 정보 삭제
    public int deleteBookId(BooksVO booksVO){
        Connection con = null;
        PreparedStatement pstmt = null;
        int count = 0;
        try {
            con = DBUtil.getConnection();
            if(con == null){
                System.out.println("DB 연결 실패");
                return -1;
            }
            pstmt = con.prepareStatement(deleteSQL);
            pstmt.setInt(1, booksVO.getBookId());
            count = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("createstatement 오류발생");
        } finally{
            DBUtil.dbClose(con, pstmt);
        }
        return count;
    }


}
