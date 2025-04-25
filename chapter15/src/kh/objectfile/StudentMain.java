package kh.objectfile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

// 클래스를 객체로 만들고 -> 파일에 저장하고 -> 다시 가져와서 읽기
public class StudentMain {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// 변수
		Scanner s = new Scanner(System.in);
		
		// 반복문(입력,계산,출력)
		System.out.print("이름 : ");
		String name = s.nextLine();
		System.out.print("번호 : ");
		int num = Integer.parseInt(s.nextLine());
		
		Student stu = new Student(name, num);
		
		fileSave(stu, "res/data.txt");
		
		System.out.print("파일에서 객체를 가져오시겠습니까?(yes/no) : ");
		String answer = s.nextLine();
		if(answer.equals("yes")) {
			Student studata = fileRead("res/data.txt");
			if(studata != null) {
				System.out.println("파일로부터 읽어온 데이터");
				System.out.println(studata.toString());
			}else {
				System.out.println("파일로부터 객체를 읽어오는데 실패했습니다.");
			}
		}
		// 종료
		System.out.println("End");
	}

	private static Student fileRead(String string) throws IOException, ClassNotFoundException {
		FileInputStream fi = new FileInputStream("res/data.txt");
		ObjectInputStream ois = new ObjectInputStream(fi);
		Student studata = (Student)ois.readObject();
		return studata;
		
	}

	private static void fileSave(Student stu, String fileName) throws IOException {
		FileOutputStream fo = new FileOutputStream(fileName);
		// 객체를 통으로 저장하는 방법
		ObjectOutputStream oos = new ObjectOutputStream(fo);
		oos.writeObject(stu);
		
		System.out.println("파일에 객체를 모두 입력했습니다.");
		
	}

}
