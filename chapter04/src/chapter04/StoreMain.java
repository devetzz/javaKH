package chapter04;

import java.util.Scanner;
import java.util.regex.Pattern;

public class StoreMain {

	public static void main(String[] args) {
		// 변수 선언
		Scanner scan = new Scanner(System.in);
		boolean stopFlag = false;
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
				do {
					String name = "";
					System.out.print("상품 이름 입력 : ");
					name = scan.nextLine();			
					boolean isNameCheck = Pattern.matches("^[a-z|A-Z|가-힣]{1,20}$", String.valueOf(name));
					if (isNameCheck == true) {
						store.setName(name);;
						break;
					}
					System.out.println("문자를 입력하세요!!");
				}while(true);

				do {
					int stock = 0;
					System.out.print("상품 재고 입력 : ");
					stock = Integer.parseInt(scan.nextLine());			
					boolean isStockCheck = Pattern.matches("^[0-9]{1,4}$", String.valueOf(stock));
					if (isStockCheck == true) {
						store.setStock(stock);
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
						store.setPrice(price);
						break;
					}
					System.out.println("금액을 입력하세요!!");
				}while(true);
				break;
			case 2: 
				// 2. 상품 출력
				System.out.println(store.toString());
//				System.out.printf("| 상품 이름 : %s\t", store.getName());
//				System.out.printf("| 상품 재고 : %d\t", store.getStock());
//				System.out.printf("| 상품 원가 : %d\t", store.getPrice());
//				System.out.printf("| 부가세 : %d\t", store.getVat());
//				System.out.printf("| 부가세 포함 가격 : %.2f\t", store.getTotal());
				break;
			case 3: 
				// 3. 상품 계산
				store.calculateVat();
				store.calculateTotal();
				System.out.println("★★★★★ 계산 완료 ★★★★★");
				break;
			case 4: 
				// 4. 상품 검색
				System.out.println("★★★ 검색 기능 점검 중 ★★★");
				break;
			default: 
				// 5. 종료
				System.out.println("★★★★★★★★★ End ★★★★★★★★★");
				stopFlag = true;
				scan.close();
				break;
			}
			
		}// 반복문 종료
		
		
	}
	
	
	public static void menuPrint() {
		// 메뉴
		System.out.println("★★★★★★★★★ MENU ★★★★★★★★★");
		System.out.println("★ \t1. 상품 입력\t ★");
		System.out.println("★ \t2. 상품 출력\t ★");
		System.out.println("★ \t3. 상품 계산\t ★");
		System.out.println("★ \t4. 상품 검색\t ★");
		System.out.println("★ \t5. 종료\t\t ★");
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★");
		
		System.out.print("선택(1~5) > ");
	}
}
