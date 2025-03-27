package chapter02;

import java.util.Scanner;

public class PatternClass {

	public static void main(String[] args) {
		// 변수 선언 및 입력
		Scanner scan = new Scanner(System.in);
		
		
		// 반복문 입력 (for : 카운트에따라 반복, while : 무한반복, do-while : 최초 1번은 무조건 실행)
		for(;true;) {
			
			// 값 체크
			int no = 0;
			do {
				// 값 입력
				System.out.print("no : ");
				no = Integer.parseInt(scan.nextLine());
				if (0 <= no && no <= 100) {
					break;
				}
				System.out.println("정신차려!");
			}while(true);
			
			//하고자하는 내용을 실행하면 된다.
			
			//계속 진행 체크
			char yn = 0;
			do {
				// 값 입력
				System.out.print("계속(y/n)");
				yn = scan.nextLine().charAt(0);
				if(yn == 'n' || yn == 'N' || yn == 'y' || yn == 'Y')
					break;
				System.out.println("정신차려!");
			}while(true);
			
			if(yn == 'n' || yn == 'N') {
				scan.close();
				break;
				
			}
		}
		
	}

}
