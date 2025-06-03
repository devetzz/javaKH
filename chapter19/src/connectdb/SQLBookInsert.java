package connectdb;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class SQLBookInsert{
    // 2단계 : 보안 설정 (properties: Map 설정)

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Connection conn = null;
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
            Statement stmt = conn.createStatement();
            // insert 쿼리문을 만들고 데이터를 가져온다.
            Books books = insertFunc();
            String insertSQL = "INSERT INTO books (book_id, title, publisher, year, price) VALUES (bookS_seq.nextval, '" 
                + books.getTitle() + "', '" + books.getPublisher() + "', '" + books.getYear() + "', " + books.getPrice() + ")";

            // 5. DML 오라클에서 실행(executeQuery, executeUpdate) 후 (결과, 결과 count) 출력
            int count = stmt.executeUpdate(insertSQL);
            if(count == 0){
                System.out.println("insert 실패");
            }else{
                System.out.println("insert 성공. 리턴값 = " + count);
            }
        } catch (SQLException e) {
            System.out.println("createStatement 오류발생");
        }
        
    }

    // books 테이블에 저장될 입력값 설정
    private static Books insertFunc() {
        Scanner sc = new Scanner(System.in);
        System.out.print("input title : ");
        String title = sc.nextLine();
        System.out.print("input publisher : ");
        String publisher = sc.nextLine();
        System.out.print("input year : ");
        String year = sc.nextLine();
        System.out.print("input price : ");
        int price = Integer.parseInt(sc.nextLine());
        Books books = new Books(0, title, publisher, year, price);
        sc.close();
        return books;
    }
}
