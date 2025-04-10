package kh.clear;

import java.util.Scanner;

public class ClearTest {

	public static void main(String[] args) {
		boolean stopFlag = false;
		Scanner scan = new Scanner(System.in);
		
		while(!stopFlag) {
			// 메뉴 보여주기
			clear();
			System.out.println();
			System.out.println("★★★★★★★★★★ MENU ★★★★★★★★★★");
			System.out.println("★ \t1. 로드\t\t ★");
			System.out.println("★ \t2. 추가입력\t ★");
			System.out.println("★ \t3. 종료\t\t ★");
			System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★");
			
			// 메뉴 번호 선택
			System.out.print("메뉴 선택(1~3) > ");
			int no = Integer.parseInt(scan.nextLine());
			
			// 메뉴 선택 기능
			switch(no) {
			case 1:
				System.out.println("로드가 완료되었습니다.");
				System.out.print(" >> ");
				scan.nextLine();
				break;
			case 2:
				System.out.println("추가 입력이 완료되었습니다.");
				System.out.print(" >> ");
				scan.nextLine();
				break;
			case 3:
				System.out.println("정상적으로 종료되었습니다.");
				stopFlag = true;
				break;
			default:break;
			}
			
		}
		// 종료
		scan.close();
		System.out.println("End");
	}

	public static void clear() {
		 try {
             String operatingSystem = System.getProperty("os.name");
             if (operatingSystem.contains("Windows")) {
                 ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                 Process startProcess = pb.inheritIO().start();
                 startProcess.waitFor();
             } else {
                 ProcessBuilder pb = new ProcessBuilder("clear");
                 Process startProcess = pb.inheritIO().start();
                 startProcess.waitFor();
             }
         } catch (Exception e) {
             System.out.println(e);
         }
	}

}
