package kr.khedu.c_class;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileReaderExample {

	public static void main(String[] args) throws IOException {
		// 변수 선언
		//Scanner scan = new Scanner(System.in); //키보드로부터 데이터를 읽어오려고 사용된 보조 스트림
		FileReader fr = new FileReader("test.txt");
		
		while(true) {
			int ch = fr.read();
			if(ch == -1) {
				break;
			}
			System.out.printf("%c", ch);
		}
		// 입력
		// 연산
		
		// 출력
		
		// 종료
		fr.close();
		System.out.println("End");
	}

}
