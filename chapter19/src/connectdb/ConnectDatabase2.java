package connectdb;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class ConnectDatabase2{
    // 2단계 : 보안 설정 (properties: Map 설정)

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Connection conn = null;
        ArrayList<Member> memberList = new ArrayList<Member>();
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
            // 5. DML 오라클에서 실행(executeQuery, executeUpdate) 후 결과 출력
            ResultSet rs = stmt.executeQuery("SELECT FIRST_NAME, SALARY FROM EMPLOYEES");
            // 6. Collection Framework
            while(rs.next()){
                String firstName = rs.getString("FIRST_NAME");
                int salary = rs.getInt("SALARY");
                Member member =  new Member(firstName, salary);
                memberList.add(member);
            }

            // 7. 출력
            for(Member data : memberList){
                System.out.println(data.toString());
            }

        } catch (SQLException e) {
            System.out.println("createStatement 오류발생");
        }

    }
}
