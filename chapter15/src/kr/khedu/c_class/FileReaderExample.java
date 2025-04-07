package kr.khedu.c_class;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {

	public static void main(String[] args) throws IOException {
		// 변수 선언
		FileReader fr = new FileReader("test.txt");
		
		
		// 반복(입력, 연산, 출력)
		while(true) {
			int ch = fr.read();
			if (ch == -1) {
				System.out.println();
				break;
			}
			System.out.printf("%c", ch);
		}
		
		// 종료
		fr.close();
		System.out.println("End");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		//Scanner scan = new Scanner(System.in); //키보드로부터 데이터를 읽어오려고 사용된 보조 스트림
		FileReader fr = new FileReader("test.txt");
		
		while(true) {
			int ch = fr.read();		//데이터 1바이트씩 읽어서 4바이트 정수형 변수 저장한다.
			if(ch == -1) {			// read() 메서드는 더이상 읽을 데이터가 없을때 -1을 반환한다.
				break;
			}
			System.out.printf("%c", ch);
		}
		// 입력
		// 연산
		
		// 출력
		
		// 종료
		fr.close();
		System.out.println("End");*/
	}

}
