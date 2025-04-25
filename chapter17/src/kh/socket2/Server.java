package kh.socket2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {
		// 변수 선언(서버 소켓)
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		BufferedReader in = null; // 읽기(속도 개선)
		PrintWriter out = null; // 출력 보조스트림
		Scanner sc = new Scanner(System.in);
		
		
		
		// 무한루프(입력, 연산, 출력)
		// 서버 소켓 세팅
		try {
			serverSocket = new ServerSocket(10000);
			System.out.println("연결을 기다리고 있습니다.");
			clientSocket = serverSocket.accept();	// client가 접속 할때 까지 무한 대기, 접속하면 클라이언트 통신 가능한 소켓(주소,포트)
			// inputStream, outputStream
			InputStream is = clientSocket.getInputStream();
			in = new BufferedReader(new InputStreamReader(is));	// client로 부터 값을 읽어옴
			out = new PrintWriter(clientSocket.getOutputStream());
			
			System.out.println("Client와 대화할 수 있는 준비 완료");
			// 무한 루프(입력, 출력)
			while(true) {
				// client가 메시지를 보내기를 기다리고 있다가 입력되면 한문장씩 읽어옴
				// client가 그만하고 싶을때(exit)
				String receiveMessage = in.readLine();
				if(receiveMessage.equals("exit")) {
					System.out.println("Client와 통신을 중단하였습니다.");
					break;
				}
				System.out.println("Client > " + receiveMessage);
				// 답변
				System.out.print("보낼 메시지 > ");
				String sendMessage = sc.nextLine();
				out.write(sendMessage+"\n");
				out.flush();// 버퍼에 있는 값을 강제로 출력할 대상(파일, 소켓)에게 보냄
			}
			
		} catch (IOException e) {
		} finally {
			sc.close();
			out.close();
			try {
				in.close();
				clientSocket.close();
				serverSocket.close();
			} catch (IOException e) {
			}
		}
		
		
		// 종료
		System.out.println("End");
		
	}

}
