package alonePractice;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SubMain {

	public static void main(String[] args) {
		try {
            // 서버 소켓 생성
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is running...");

            // 두 클라이언트 연결 기다리기
            Socket client1 = serverSocket.accept();
            System.out.println("Client 1 connected.");
            ObjectOutputStream oos1 = new ObjectOutputStream(client1.getOutputStream());
            
            Socket client2 = serverSocket.accept();
            System.out.println("Client 2 connected.");
            ObjectOutputStream oos2 = new ObjectOutputStream(client2.getOutputStream());

            
            // 클라이언트 핸들러 객체 생성
            Handler clientHandler = new Handler(oos1, oos2);

            // 1번 클라이언트의 메시지를 2번 클라이언트로 전달하는 스레드
            Thread thread1 = new Thread(() -> {
                try {
                    ObjectInputStream input1 = new ObjectInputStream(client1.getInputStream());
                    while (true) {
                        try {
                            // 1번 클라이언트로부터 메시지 읽기
                            Object msg1 = input1.readObject();
                            System.out.println("Received from Client 1: " + msg1);

                            // 받은 메시지를 2번 클라이언트로 전달
                            clientHandler.send1to2(msg1);
                        } catch (EOFException e) {
                            System.out.println("클라이언트 1 닫힘");
                            break;  // 클라이언트가 연결을 종료하면 루프 종료
                        } catch (IOException | ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            // 2번 클라이언트의 메시지를 1번 클라이언트로 전달하는 스레드
            Thread thread2 = new Thread(() -> {
                try {
                    ObjectInputStream input2 = new ObjectInputStream(client2.getInputStream());
                    while (true) {
                        try {
                            // 2번 클라이언트로부터 메시지 읽기
                            Object msg2 = input2.readObject();
                            System.out.println("Received from Client 2: " + msg2);

                            // 받은 메시지를 1번 클라이언트로 전달
                            clientHandler.send2to1(msg2);
                        } catch (EOFException e) {
                            System.out.println("클라이언트 2 닫힘");
                            break;  // 클라이언트가 연결을 종료하면 루프 종료
                        } catch (IOException | ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            // 스레드 시작
            thread1.start();
            thread2.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
