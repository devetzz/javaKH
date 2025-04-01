package chapter04;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ExamStoreCapsuleMain {

	public static void main(String[] args) {
		
		boolean stopFlag = false;
		int count = 1;
		Scanner scan = new Scanner(System.in);
		Store store = new Store();
		
		
		while(!stopFlag) {
			menuPrint();
			
			int num = 0;
			num = Integer.parseInt(scan.nextLine());
			boolean isNumCheck = Pattern.matches("^[1-5]{1,1}$", String.valueOf(num));

			if(isNumCheck == false) {
				System.out.println("1~5번 중에 선택하세요!!");
				continue;
			}
			
			switch(num) {
			case 1: 
				// 1. 상품 입력
				while(true) {
					
					do {
						String name = "";
						System.out.print("상품명 입력 : ");
						name = scan.nextLine();			
						boolean isNameCheck = Pattern.matches("^[a-z|A-Z|가-힣]{1,20}$", String.valueOf(name));
						if (isNameCheck == true) {
							store.setNameArr(name);
							break;
						}
						System.out.println("문자를 입력하세요!!(영문,한글)");
					}while(true);
					
					do {
						int stock = 0;
						System.out.print("상품 재고 입력 : ");
						stock = Integer.parseInt(scan.nextLine());			
						boolean isStockCheck = Pattern.matches("^[0-9]{1,4}$", String.valueOf(stock));
						if (isStockCheck == true) {
							store.setStockArr(stock);
							break;
						}
						System.out.println("숫자를 입력하세요!!(0~9999)");
					}while(true);
					
					do {
						int price = 0;
						System.out.print("상품 원가 입력 : ");
						price = Integer.parseInt(scan.nextLine());			
						boolean isPriceCheck = Pattern.matches("^[0-9]{1,10}$", String.valueOf(price));
						if (isPriceCheck == true) {
							store.setPriceArr(price);
							break;
						}
						System.out.println("금액을 입력하세요!!");
					}while(true);
					
					
					char yn = 0;
					
					do {
						System.out.print("계속(y/n) : ");
						yn = scan.nextLine().charAt(0);
						if (yn == 'n' || yn == 'N' || yn == 'y' || yn == 'Y') {
							break;
						}
						System.out.println("y 또는 n을 입력해야 합니다.");
					}while(true);
					if(yn == 'n' || yn == 'N') {
						break;
					}else {
						count++;
					}
				}
				break;
			case 2: 
				// 2. 상품 출력
				for (int i = 0; i < count;i++) {
					System.out.printf("| 상품 이름 : %s\t", store.getNameArr());
					System.out.printf("| 상품 재고 : %d\t", store.getStockArr());
					System.out.printf("| 상품 원가 : %d\t", store.getPriceArr());
					System.out.printf("| 부가세 포함 가격 : %.2f\t", store.getTotalArr());
//					if (totalArr.isEmpty()) {
//						System.out.printf("| 학생 총점 : %d\t", 0);
//					}else {
//						System.out.printf("| 학생 총점 : %d\t", totalArr.get(i));
//					}
				}
				break;
			case 3: 
				// 3. 학생 계산
				for (int i = 0; i < count;i++) {
					int total = 0;
					int vat = 0;
					vat = store.getPriceArr() / 10;
					totalArr.add(korArr.get(i)+engArr.get(i));
					avrArr.add((double) totalArr.get(i)/2.0);
					
					
				}
				System.out.println("계산 완료!");
				break;
			case 4: 
				// 4. 학생 검색
				// 검색할 학생을 입력 > nameArr배열에서 해당 이름과 일치하는 학생 검색하여 true일 경우 > 정보 출력 > 계속여부 > 반복
				do {
					String searchName = "";
					System.out.print("검색할 학생 이름 : ");
					searchName = scan.nextLine();
					
					
					if(nameArr.contains(searchName)) {
						int index = nameArr.indexOf(searchName);
						
						System.out.printf("| 학생 이름 : %s\t", nameArr.get(index));
						System.out.printf("| 학생 나이 : %d\t", ageArr.get(index));
						System.out.printf("| 학생 성별 : %c\t", genderArr.get(index));
						System.out.printf("| 학생 국어 : %d\t", korArr.get(index));
						System.out.printf("| 학생 영어 : %d\t", engArr.get(index));
						if (totalArr.isEmpty()) {
							System.out.printf("| 학생 총점 : %d\t", 0);
						}else {
							System.out.printf("| 학생 총점 : %d\t", totalArr.get(index));
						}
						if (avrArr.isEmpty()) {
							System.out.printf("| 학생 평균 : %.1f\t", 0.0);
						}else {
							System.out.printf("| 학생 평균 : %.1f\t", avrArr.get(index));
						}
						if (gradeArr.isEmpty()) {
							System.out.printf("| 학생 등급 : %s\n", 0);
						}else {
							System.out.printf("| 학생 등급 : %s\n", gradeArr.get(index));
						}
					}
					
					
					char yn = 0;
					
					do {
						System.out.print("계속(y/n) : ");
						yn = scan.nextLine().charAt(0);
						if (yn == 'n' || yn == 'N' || yn == 'y' || yn == 'Y') {
							break;
						}
						System.out.println("y 또는 n을 입력해야 합니다.");
					}while(true);
					if(yn == 'n' || yn == 'N') {
						break;
					}
					
				}while(true);
				
				break;
			default: 
				// 5. 종료
				System.out.println("★★★★★★★★★ End ★★★★★★★★★");
				stopFlag = true;
				scan.close();
				break;
			}
			
		}
		

	}
	
	public static void menuPrint() {
		// 메뉴
		System.out.println("★★★★★★★★★ MENU ★★★★★★★★★");
		System.out.println("★ \t1. 상품 입력\t ★");
		System.out.println("★ \t2. 상품 출력\t ★");
		System.out.println("★ \t3. 상품 업데이트\t ★");
		System.out.println("★ \t4. 상품 검색\t ★");
		System.out.println("★ \t5. 종료\t\t ★");
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★");
		
		System.out.print("선택(1~5) > ");
	}

}
