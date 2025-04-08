package kr.co.khedu.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class OutputStreamTest {

	public static void main(String[] args) throws IOException {
		// 파일을 읽어서 출력한다. => 파일을 가져오는 객체를 생성한다.
		FileInputStream fis = new FileInputStream("res/exams.txt");
		// 보조스트림을 사용한다.(속도, 편리성 개선)
		Scanner s = new Scanner(fis);
		
		// 첫 라인 날리기
		if(s.hasNextLine()) {
			s.nextLine();
		}
		
		while(true) {
			if(!s.hasNextLine()) {
				break;
			}
			String data = s.nextLine();
			String[] tokens = data.split(",");
			String name = tokens[0];
			int kor = Integer.parseInt(tokens[1]);
			int eng = Integer.parseInt(tokens[2]);
			int math = Integer.parseInt(tokens[3]);
			
			System.out.printf("%-5s %3d %3d %3d total = %3d\n", name, kor, eng, math, kor+eng+math);
		}
		
		s.close();
		fis.close();
		
		// 파일에 내용을 추가해서 저장한다.
		// 파일을 저장하는 객체를 생성한다.
		FileOutputStream fo = new FileOutputStream("res/exams.txt", true);
		// 보조스트림을 사용한다. (PrintStream)
		PrintStream out = new PrintStream(fo);
		
		out.printf("\n%s,%d,%d,%d", "마길동", 100, 100, 100);
		
		out.close();
		fo.close();
		
		// 종료
		System.out.println("End");
		
	}

}
