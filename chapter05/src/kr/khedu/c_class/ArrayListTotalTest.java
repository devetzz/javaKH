package kr.khedu.c_class;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ArrayListTotalTest {
	public static Scanner scan = new Scanner(System.in); 
	public static final int COUNT = 10;
	public static void main(String[] args) {
		// 변수 선언
		boolean stopFlag = false;
		//int a[] = new int[10];
		ArrayList<Integer> aList = new ArrayList<Integer>();
		
		while(!stopFlag) {
			
			menuPrint();

			int choice = 0;

			choice = selectMenu();
			
			
			switch(choice) {
			case 1: 
				// 1. 랜덤 배열 입력
				// 정수형 랜덤값 공식 : (int)(Math.random()*(큰값-작은값+1)+작은값)
				for(int i = 0; i < COUNT; i++) {
					Integer num = (int)(Math.random()*(999-100+1)+100);
					aList.add(num);
				}
				System.out.println("랜덤 배열이 생성되었습니다.");
				break;
			case 2: 
				// 2. 배열 출력
				System.out.print("생성된 배열 : ");
				System.out.println(aList.toString());
				break;
			case 3: 
				// 3. 최대값 출력
				//int max = getMaxValue(a);
				int max = Collections.max(aList);
				System.out.printf("최대값 : %d\n", max);
				break;
			case 4: 
				// 4. 최소값 출력
				//int min = getMinValue(a);
				int min = Collections.min(aList);
				System.out.printf("최소값 : %d\n", min);
				break;
			case 5: 
				// 5. 내림차순 정렬
				//descendingFunc(a);
				aList.sort(Comparator.reverseOrder());
				System.out.println("내림차순 정렬되었습니다.");
				break;
			case 6: 
				// 6. 오름차순 정렬
				//ascendingFunc(a);
				aList.sort(Comparator.naturalOrder());
				System.out.println("오름차순 정렬되었습니다.");
				break;
			case 7: 
				// 7. 배열 검색
				System.out.print("검색할 번호 : ");
				int search = Integer.parseInt(scan.nextLine());
				boolean isSearch = aList.contains(search);
				if (isSearch == true) {
					System.out.printf("%d 숫자가 존재합니다.\n", search);
				}else {
					System.out.printf("검색된 번호가 없습니다.\n");
				}
//				boolean isSearch = false;
//				for(int i = 0; i < a.length; i++) {
//					if (a[i] == search) {
//						isSearch = true;
//						System.out.printf("%d 숫자가 존재합니다.\n", search);
//					}
//				}
//				if(isSearch == false) {
//					System.out.println("검색된 번호가 없습니다.");
//				}
				break;
			case 8: 
				// 8. 종료
				stopFlag = true;
				scan.close();
				System.out.println("종료되었습니다.");
				break;
			default: 
				break;
			}
			
		}
	}
	/*
	private static void ascendingFunc(int[] a) {
		// 오름차순 정령
		int imsi = 0;
		for(int j = 0; j < a.length; j++) {
			for(int i = j; i < a.length; i++) {
				if(a[i] < a[j]) {
					imsi = a[j];
					a[j] = a[i];
					a[i] = imsi;
				}
			}
		}
	}

	private static void descendingFunc(int[] a) {
		// 내림차순 정렬
		int imsi = 0;
		for(int j = 0; j < a.length; j++) {
			for(int i = j; i < a.length; i++) {
				if(a[i] > a[j]) {
					imsi = a[j];
					a[j] = a[i];
					a[i] = imsi;
				}
			}
		}
	}

	private static int getMinValue(int[] a) {
		// 최소값 구하기
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < a.length; i++) {
			if(a[i] < min) {
				min = a[i];
			}
		}
		return min;
	}

	public static int getMaxValue(int[] a) {
		// 최대값 구하기
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < a.length; i++) {
			if(a[i] > max) {
				max = a[i];
			}
		}
		return max;
	}*/

	public static int selectMenu() {
		// 메뉴 입력
		int no = 0;
		do {
			System.out.print("번호 선택(1~8) > ");
			String input = scan.nextLine();
			boolean isNoCheck = Pattern.matches("^[1-8]$", input);
			if(isNoCheck == true) {
				no = Integer.parseInt(input);
				break;
			}
			System.out.println("정확한 번호를 입력하세요!");
		}while(true);
		return no;
	}

	private static void menuPrint() {
		// 메뉴 보기
		System.out.println("******** MENU **********");
		System.out.println("1. 랜덤 배열 입력");
		System.out.println("2. 배열 출력");
		System.out.println("3. 최대값 출력");
		System.out.println("4. 최소값 출력");
		System.out.println("5. 내림차순 정렬");
		System.out.println("6. 오름차순 정렬");
		System.out.println("7. 배열 검색");
		System.out.println("8. 종료");
		System.out.println("************************");
		
	}

}
