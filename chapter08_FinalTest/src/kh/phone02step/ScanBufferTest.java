package kh.phone02step;

import java.util.Scanner;

public class ScanBufferTest {

	public static void main(String[] args) {
		// Scan 입력버퍼가 일으키는 문제 / 기본값을 읽고 => 문자, 문자열을 읽을때 문제 발생
		// 입력 : 23enter => nextInt() 23값이 읽어지고, 엔터값이 버퍼에 남아있어서 문제가 발생한다.
		Scanner scan = new Scanner(System.in);
		System.out.print("정수값 입력 : ");
		int number = scan.nextInt();
		System.out.print("이름 입력 : ");
		String name = scan.nextLine();
		
		
		System.out.printf("number = %d\n", number);
		System.out.printf("name = %s\n", name);
		// nextInt()는 정수값만 읽어가고 정수 입력 후 입력한 엔터(\n)가 남아있다가 다음 스캔 시 문제 발생 유발
		
	}

}
