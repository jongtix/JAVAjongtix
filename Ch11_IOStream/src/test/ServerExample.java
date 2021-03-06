package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 서버 - 자료를 제공하는 객체
 * 		- 서버는 ServerSocket을 가진다.
 * */
public class ServerExample {
	public static void main(String[] args) {
		ServerSocket serverSocket = null; // 서버 소켓 객체 선언
		try {
			serverSocket = new ServerSocket(); // 서버 소켓 객체 생성
			
			// 서버 소켓의 주소 및 port 번호 세팅
			serverSocket.bind(new InetSocketAddress("localhost", 5004));
			
			while (true) {
				System.out.println("[연결 기다림]");
				Socket socket = serverSocket.accept(); // 요청이 들어오면 accept() 메소드로 소켓 생성
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress(); // 요청이 들어온 client의 주소 정보를 얻어옴.
				System.out.println("[연결 수락함] " + isa.getHostName());
				System.out.println("----연결 완료----");
				
				byte [] bytes = null;
				String message = null;
				
				InputStream is = socket.getInputStream(); // socket으로 들어오는 스트림 얻기
				bytes = new byte[1024]; // byte 단위의 값을 읽어들여 저장하는 배열
				int readByteCnt = is.read(bytes); // 읽어들인만큼 배열에 저장 후 저장된 갯수를 readByteCnt에 대입
				message = new String(bytes, 0, readByteCnt);
				StringTokenizer st = new StringTokenizer(message);
				System.out.println("[데이터 받기 성공] : " + message);
				int number1 = Integer.parseInt(st.nextToken());
				int number2 = Integer.parseInt(st.nextToken());
				String op = st.nextToken();
				double result = 0;
				switch (op) {
				case "+":
					result = number1 + number2;
					break;
				case "-":
					result = number1 - number2;
					break;
				case "x":
					result = number1 * number2;
					break;
				case "/":
					result = (double) number1 / (double) number2;
					break;
				}
				// ---------------- 전송받은 메시지 출력 완료 ---------------------
				
				message = Double.toString(result);
				OutputStream os = socket.getOutputStream(); // 출력 객체 생성
				bytes = message.getBytes(); // String.getBytes() -> 문자열을 byte 배열로 변환
				os.write(bytes); // 전송
				os.flush(); // message 밀어내기
				System.out.println("[데이터 보내기 성공]");
				
				is.close();
				os.close();
				socket.close(); // 소켓 종료
			}
		} catch (Exception e) {
			
		}
		
		// 서버 소켓 종료시 클라이언트와 연결이 있으면 연결을 끊은 후 종료.
		if (!serverSocket.isClosed()) {
			try {
				serverSocket.close();
			} catch (IOException e) {
				
			}
		}
	}
}
