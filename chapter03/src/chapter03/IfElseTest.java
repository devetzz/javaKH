package chapter03;

import java.util.Scanner;
import java.util.regex.Pattern;

//학생이름과 점수를 입력받는다. 등급(A, B, C, D, F)을 처리해서 출력한다.
public class IfElseTest {

    public static void main(String[] args) {
        //변수선언
        Scanner scan = new Scanner(System.in);
        String name = null;
        int score = 0;
        char grade = 0; 
        
        do {
            System.out.print("학생이름:");                    //입력(이름, 점수)
            name = scan.nextLine();
            boolean isNameCheck = Pattern.matches("^[가-힣]{2,4}$", name);
            if(isNameCheck == true) {
                break;
            }
            System.out.println("올바르게 입력새주세요.");
        }while(true);

        do {
            System.out.print("학생점수:");
            score =Integer.parseInt(scan.nextLine());
            boolean isScoreCheck = Pattern.matches("^[0-9]{1,3}$", String.valueOf(score));
            if(isScoreCheck == true && score <= 100) {
                break;
            }
            System.out.println("올바르게 입력해주세요.");
        }while(true);
         
        
        
        if (score >= 90) {                             //입력(이름, 점수)
            grade = 'A';
        }else if(80 <= score && score < 90 ) {
            grade = 'B';
        }else if(70 <= score && score < 80 ) {
            grade = 'C';
        }else if(60 <= score && score < 70 ) {
            grade = 'D';
        }else {
            grade = 'F';
        }
        //출력
        System.out.printf("%s 점수 %d점 등급: %c등급입니다.\n",name,score,grade);
        
        //종료
        scan.close();
        System.out.println("The end!");
    }
}