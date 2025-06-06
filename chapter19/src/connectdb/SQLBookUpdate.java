package connectdb;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class SQLBookUpdate{
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Connection conn = null;
        ArrayList<Books> bookList = new ArrayList<Books>();
        // 1. 드라이버 로드 Class.forName() 해당되는 클래스 메모리 로드하는 기능
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("오라클 드라이버 적재 성공");
            // 2단계 1. db.properties 파일 경로를 가져온다.
            String filePath = "D:/gitCode/javaKH/chapter19/src/connectdb/db.properties";
            // 2단계 2. properties 객체를 만든다.
            Properties properties = new Properties();
            // 2단계 3. properties 객체에 해당된 파일을 로드한다.
            properties.load(new FileReader(filePath));
            System.out.println("db.properties 로드 성공");
            //2단계 4. 로드된 파일을 properties 키값으로 value 가져온다.
            String url = properties.getProperty("url");
            String id = properties.getProperty("id");
            String pwd = properties.getProperty("pwd");

            System.out.println(url + " " + id + " " + pwd);
            //2. url(오라클 서버주소:포트) 아이디, 패스워드
            conn = DriverManager.getConnection(url, id, pwd);
            if(conn == null){
                System.out.println("오라클 서버 연결 실패했습니다.");
            }else{
                System.out.println("오라클 서버 연결 성공했습니다.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("오라클 드라이버를 찾을 수 없습니다.");
        } catch (SQLException e){
            System.out.println("오라클 서버 연결 실패했습니다.");
        }

        // 4. Statement
        try {
            // Statement stmt = conn.createStatement();
            // update 1. 수정할 리스트를 보여주고 수정할 조건을 입력
            System.out.println("몇번을 수정하시겠습니까? ");
            Scanner sc = new Scanner(System.in);
            int _bookId = Integer.parseInt(sc.nextLine());


            // 5. DML 오라클에서 실행(executeQuery, executeUpdate) 후 결과 출력
            String selectSQL = "SELECT * FROM BOOKS WHERE BOOK_ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(selectSQL);
            pstmt.setInt(1, _bookId);

            ResultSet rs = pstmt.executeQuery();
            // 6. Collection Framework
            if(rs.next()){
                int bookId = rs.getInt("BOOK_ID");
                String title = rs.getString("TITLE");
                String publisher = rs.getString("PUBLISHER");
                String year = rs.getString("YEAR");
                int price = rs.getInt("PRICE");
                Books books =  new Books(bookId, title, publisher, year, price);
                bookList.add(books);
            }

            // 7. 출력
            for(Books data : bookList){
                System.out.println(data.toString());
            }

            System.out.print("update title : ");
            String title = sc.nextLine();
            System.out.print("update publisher : ");
            String publisher = sc.nextLine();
            System.out.print("update year : ");
            String year = sc.nextLine();
            System.out.print("update price : ");
            int price = Integer.parseInt(sc.nextLine());
            Books books = new Books(_bookId, title, publisher, year, price);

            // update 2. update 쿼리문
            String updateSQL = "UPDATE BOOKS SET TITLE = ?, PUBLISHER = ?, YEAR = ?, PRICE = ? WHERE BOOK_ID = ?";
            pstmt = conn.prepareStatement(updateSQL);
            pstmt.setString(1, books.getTitle());
            pstmt.setString(2, books.getPublisher());
            pstmt.setString(3, books.getYear());
            pstmt.setInt(4, books.getPrice());
            pstmt.setInt(5, books.getBookId());
            
            // 5. DML 오라클에서 실행(executeQuery, executeUpdate) 후 (결과, 결과 count) 출력
            int count = pstmt.executeUpdate();
            if(count == 0){
                System.out.println("update 실패");
            }else{
                System.out.println("update 성공. 리턴값 = " + count);
            }

            sc.close();
        } catch (SQLException e) {
            System.out.println("createStatement 오류발생");
        }
    }

}
