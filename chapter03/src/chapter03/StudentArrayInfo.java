package chapter03;

import java.util.Scanner;

public class StudentArrayInfo {
	public static final int COUNT = 1;

	public static void main(String[] args) {
		// 학생이름, 성별, 국어, 영어 입력 받아서 총점, 평균 출력
		// 변수 선언
		String[] name = new String[COUNT];
		char[] gender = new char[COUNT];
		int[] kor = new int[COUNT];
		int[] eng = new int[COUNT];
		int[] total = new int[COUNT];
		double[] avr = new double[COUNT];
		boolean stopFlag = false;
		
		Scanner scan = new Scanner(System.in);
		
		while(!stopFlag) {
			
			menuDisplay();
			int no = Integer.parseInt(scan.nextLine());
			
			switch(no) {
			case 1: 
				// 반복문(입력)
				for(int i = 0; i < COUNT; i++) {
					System.out.printf("%d 번째 학생 이름 입력 : ", i+1);
					name[i] = scan.nextLine();
					System.out.printf("%d 번째 학생 성별 입력(남/여) : ", i+1);
					gender[i] = scan.nextLine().charAt(0);
					System.out.printf("%d 번째 학생 국어 점수 입력(0~100) : ", i+1);
					kor[i] = Integer.parseInt(scan.nextLine());
					System.out.printf("%d 번째 학생 영어 점수 입력(0~100) : ", i+1);
					eng[i] = Integer.parseInt(scan.nextLine());
					
				}
				break;
			case 2: 
				System.out.printf("%s\t %s\t %s\t %s\t %s\t %s\n", "이름", "성별", "국어", "영어", "총점", "평균");
				// 반복문(출력)
				for(int i = 0; i < COUNT; i++) {
					System.out.printf("%s\t %c\t %d\t %d\t %d\t %.2f\n",name[i],gender[i],kor[i],eng[i],total[i],avr[i]);
					System.out.println("=============================");
				}
				break;
			case 3: 
				// 반복문(연산)
				for(int i = 0; i < COUNT; i++) {
					total[i] = kor[i] + eng[i];
					avr[i] = total[i] / 2.0;
				}
				System.out.println("성적 계산 완료!");
				break;
			case 4: 
				stopFlag = true;
				System.out.println("종료합니다.");
				scan.close();
				break;
			default: 
				System.out.println("올바르게 입력해주세요!!(1~4 번호 선택)");
				break;
			}
			
		}
//		// 반복문(입력, 연산)
//		for(int i = 0; i < COUNT; i++) {
//			System.out.printf("%d 번째 학생 이름 입력 : ", i+1);
//			name[i] = scan.nextLine();
//			System.out.printf("%d 번째 학생 성별 입력(남/여) : ", i+1);
//			gender[i] = scan.nextLine().charAt(0);
//			System.out.printf("%d 번째 학생 국어 점수 입력(0~100) : ", i+1);
//			kor[i] = Integer.parseInt(scan.nextLine());
//			System.out.printf("%d 번째 학생 영어 점수 입력(0~100) : ", i+1);
//			eng[i] = Integer.parseInt(scan.nextLine());
//			
//			total[i] = kor[i] + eng[i];
//			avr[i] = total[i] / 2.0;
//		}
//		
//		// 반복문(출력)
//		for(int i = 0; i < COUNT; i++) {
//			System.out.printf("이름 : %s\n성별 : %c\n국어 점수 : %d\n영어 점수 : %d\n총점 : %d\n평균 : %.2f\n",name[i],gender[i],kor[i],eng[i],total[i],avr[i]);
//			System.out.println("=======================================");
//		}
		
	}
	public static void menuDisplay() {
		// 메뉴를 보여준다.
			System.out.println("*****메뉴*****");
			System.out.println("1. 성적 입력");
			System.out.println("2. 성적 출력");
			System.out.println("3. 성적 계산");
			System.out.println("4. 종료");
			System.out.println("*************");
					
			System.out.print("선택 > ");
	}

}
