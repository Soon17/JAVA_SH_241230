package alonePractice;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class CliMain {

	public static void main(String[] args) {
		try {
            // 서버에 연결
            Socket socket = new Socket("localhost", 12345);

            // 출력 스트림과 입력 스트림 생성
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            // 서버에 메시지 보내기
            String message = "Hello from Client!";
            outputStream.writeObject(message);

            // 서버로부터 응답 받기
            String response = (String) inputStream.readObject();
            System.out.println("Received from server: " + response);

            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
	}

}
