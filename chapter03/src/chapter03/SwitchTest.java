package chapter03;

import java.util.Scanner;
import java.util.regex.Pattern;

public class SwitchTest {

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
            System.out.println("올바르게 입력해주세요.");
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
         
         
        switch(score/10) {
	        case 10:
	        case 9: grade = 'A'; break;
	        case 8: grade = 'B'; break;
	        case 7: grade = 'C'; break;
	        case 6: grade = 'D'; break;
	        default: grade = 'F'; break;
        }
        
        //출력
        System.out.printf("%s 점수 %d점\n등급: %c등급입니다.\n",name,score,grade);
        
        //종료
        scan.close();
        System.out.println("The end!");
    }
}
