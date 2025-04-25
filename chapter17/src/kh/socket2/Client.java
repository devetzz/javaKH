package kh.socket2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// 변수 선언
		Socket clientSocket = null;
		BufferedReader in = null; // 읽기(속도 개선)
		PrintWriter out = null; // 출력 보조스트림
		Scanner sc = new Scanner(System.in);
		
		// 무한 루프(입력, 계산, 출력)
		try {
			clientSocket = new Socket("192.168.30.181", 10000);
			
			InputStream is = clientSocket.getInputStream();
			in = new BufferedReader(new InputStreamReader(is));	// server로 부터 값을 읽어옴
			out = new PrintWriter(clientSocket.getOutputStream());	// server 에게 답장하는 객체
			
			
			while(true) {
				System.out.print("보낼 메시지 > ");
				String sendMessage = sc.nextLine();
				// 내가 exit 입력하면 server와 내가 모두 종료되야함
				if(sendMessage.equals("exit")) {
					out.println(sendMessage);
					out.flush();
					break;
				}
				// 입력이 exit가 아니면 전송
				out.println(sendMessage);
				out.flush();
			
				// server가 보내올 메시지를 기다림
				String reciveMessage = in.readLine();
				System.out.println("Server > " + reciveMessage);
			}
		} catch (Exception e) {
		} finally {
			sc.close();
			out.close();
			try {
				in.close();
				clientSocket.close();
			} catch (IOException e) {
			}
		}
		
		// 종료
		System.out.println("End");
	}

}
