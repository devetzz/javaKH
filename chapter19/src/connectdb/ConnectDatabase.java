package connectdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConnectDatabase{
    // 오라클 접속 과정
    // 1. 드라이버를 로드
    // 2. url(오라클 서버 주소:포트) 아이디, 패스워드 3. Connection
    // 4. 명령문 전송 -> 실행하고 -> 결과물 가져온다
    // 5. result set = 데이타 클래스
    // 6. Collection Framework
    public static void main(String[] args) {
        Connection conn = null;
        ArrayList<Member> memberList = new ArrayList<Member>();
        // 1. 드라이버 로드 Class.forName() 해당되는 클래스 메모리 로드하는 기능
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("오라클 드라이버 적재 성공");
            //2. url(오라클 서버주소:포트) 아이디, 패스워드
            conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521/xe", "hr", "hr");
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
