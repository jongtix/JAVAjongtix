package p10.chatting;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * 서버는 ServerSocket을 가짐
 * 		SeverSocket이 Socket을 생성
 * */
public class ServerExample {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(5001); // port번호 5001로 서버 소켓 생성
			socket = serverSocket.accept(); // 소켓 생성 메소드
			Thread th1 = new SenderThread(socket);
			Thread th2 = new ReceiverThread(socket);
			th1.start();
			th2.start();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally { // 서버 종료시 소켓을 해제
			try {
				serverSocket.close();
			} catch (Exception e2) {
				
			}
		}
	}
}
