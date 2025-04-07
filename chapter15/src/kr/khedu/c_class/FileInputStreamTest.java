package kr.khedu.c_class;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileInputStreamTest {

	public static void main(String[] args) throws IOException {
		// 변수선언
		FileInputStream fi = new FileInputStream("res/exams.txt");
		Scanner scan = new Scanner(fi);			// 편리기능 보조스트림
		ArrayList<Student> stuList = new ArrayList<Student>();
		
		// 첫 라인 읽어서 버리기
		if(scan.hasNextLine()) {
			scan.nextLine();
		}
		
		// 반복문 (파일 입력, 연산, 출력)
		while(true) {
			if(!scan.hasNextLine()) {			// nextLine은 한줄씩 읽어오기 때문에 읽어올 줄이 있는지 확인
				break;
			}
			String data = scan.nextLine();
			// 연산처리 split
			String[] tokens = data.split(",");
			
			String name = tokens[0];
			int kor = Integer.parseInt(tokens[1]);
			int eng = Integer.parseInt(tokens[2]);
			int math = Integer.parseInt(tokens[3]);
			int total = kor + eng + math;
			double avg = total / 3.0;
			
			Student stu = new Student(name, kor, eng, math);
			stu.setTotal(total);
			stu.setAvg(avg);
			
			stuList.add(stu);
		}
		
		// 위 내용을 출력하는 기능
		for(int i=0; i < stuList.size(); i++) {
			System.out.println(stuList.get(i).toString());
		}
		
		
		// 종료
		scan.close();
		fi.close();
		System.out.println("End");
		
	}

}
