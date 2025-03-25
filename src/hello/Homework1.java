package hello;

import java.util.Scanner;

public class Homework1 {

	public static void main(String[] args) {
		// 입력 (대화식 무한 반복 / 한국 올림픽 수영
		// 참가 선수(문자열), 기록(실수), 메달 유무(부울), 메달 색(문자), 누적 메달 수(정수))
		String name = "";
		double score = 0.0;
		boolean medal = false;
		char medalColor = 0;
		int medalNum = 0;
		
		Scanner scan = new Scanner(System.in);
		
		for(boolean stopFlag = false; !stopFlag; ) {
			System.out.println("---------------입력---------------");
			System.out.print("참가 선수명 : ");
			name = scan.nextLine();
			
			System.out.print("기록 : ");
			score = Double.parseDouble(scan.nextLine());
			
			System.out.print("메달 유무 : ");
			medal = Boolean.parseBoolean(scan.nextLine());
			
			System.out.print("메달 색(금:G, 은:S, 동:B) : ");
			medalColor = (scan.nextLine().charAt(0));
			
			System.out.print("누적 메달 수 : ");
			medalNum = Integer.parseInt(scan.nextLine());
			
			//연산
			//출력
			System.out.println("---------------출력---------------");
			System.out.printf("선수명 : %s\n", name);
			System.out.printf("기록 : %.2f\n", score);
			if(medal == true) {
				System.out.printf("메달 유무 : O(%b)\n",medal);	
			}else {
				System.out.printf("메달 유무 : X(%b)\n",medal);
			}
			
			if(medalColor == 'G' || medalColor == 'g' || medalColor == '금') {
				//System.out.printf("메달 색 : %c\n",medalColor);
				System.out.printf("메달 색 : 금메달\n");
			}else if(medalColor == 'S' || medalColor == 's' || medalColor == '은') {
				//System.out.printf("메달 색 : %c\n",medalColor);
				System.out.printf("메달 색 : 은메달\n");
			}else if(medalColor == 'B' || medalColor == 'b' || medalColor == '동') {
				//System.out.printf("메달 색 : %c\n",medalColor);
				System.out.printf("메달 색 : 동메달\n");
			}else {
				System.out.println("잘못된 입력입니다.");
			}
			
			System.out.printf("누적 메달 수 : %d\n", medalNum);
			
			char yn = 0;
			System.out.printf("계속 하시겠습니까? 계속(y), 그만(n) : ");
			yn = scan.nextLine().charAt(0);
			
			if(yn == 'y' || yn == 'Y') {
				stopFlag = false;
			}else if(yn == 'n' || yn == 'N'){
				stopFlag = true;
			}else {
				System.out.println("잘못된 입력입니다.");
				break;
			}
			
			System.out.println("==============================");
			
		}
		
		scan.close();

	}
}
