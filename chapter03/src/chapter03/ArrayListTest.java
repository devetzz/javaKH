package chapter03;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest {

	public static void main(String[] args) {
		// 1차원 배열 String[] name = new String[2];
		Scanner scan = new Scanner(System.in);
		{
			String[] name = new String[2];
			
			for(int i = 0; i < name.length; i ++) {
				System.out.print("이름입력 : ");
				name[i] = scan.nextLine();
			}
			
			for(int i = 0; i < name.length;i++) {
				System.out.printf("name[%d] = %s \n", i ,name[i]);
			}
		}
		
		System.out.println("===================================");
		
		// 배열의 단점을 개선 ArrayList<String>
		// 배열의 개수를 적을 필요가 없다
		ArrayList<String> nameList = new ArrayList<String>(); 

		for(;true;) {
			System.out.print("이름입력 : ");
			String data = scan.nextLine();
			nameList.add(data);
			
			System.out.print("계속하시겠습니까?(y/n)");
			char yn = scan.nextLine().charAt(0);
			
			if (yn == 'n' || yn == 'N') {
				scan.close();
				break;
			}
			
		}

		// 출력
		for(int i = 0; i < nameList.size();i++) {
			System.out.printf("nameList %d번째 = %s\n" , i, nameList.get(i));
		}
		
		// 종료
		scan.close();
		System.out.println("End");
	}

}
