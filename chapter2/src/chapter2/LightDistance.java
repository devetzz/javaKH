package chapter2;

import java.util.Scanner;

public class LightDistance {

	public static void main(String[] args) {
		// 빛이 n일 동안 이동한 거리, 일 수 입력 받아서 결과 출력
		// 거리 = 속도 x 시간
		final double LIGHT_SPEED = 3e5;		// 300000.0
		int day = 0;
		double distance = 0.0;
		boolean stopFlag = false;
		
		Scanner sc = new Scanner(System.in);
		
		for( ; !stopFlag; ) {
			
			boolean flag = false;
			
			System.out.print("일 수 입력 : ");
			day = Integer.parseInt(sc.nextLine());
			distance = LIGHT_SPEED * (double)day * 24 * 60 * 60;
			System.out.printf("빛이 %d일 동안 이동한 거리는 %.2fKm 입니다.\n", day, distance);
			
			do{
				char yn = 0;
				System.out.print("계속하시겠습니까?(Y/N) : ");
				yn = (sc.nextLine()).charAt(0);
				if(yn == 'y' || yn == 'Y') {
					stopFlag = false;
					flag = true;
				}else if(yn == 'n' || yn == 'N') {
					stopFlag = true;
					flag = true;
					sc.close();
				}else {
					System.out.println("((Warning))y, Y, n, N 중에 입력하세요!!");
					flag = false;
				}
			}while(!flag);
				
			
		}
		
		System.out.println("==========Finish==========");
		
	}

}
