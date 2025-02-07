package alonePractice;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Handler {
	private ObjectOutputStream output1;  // 1번 클라이언트의 출력 스트림
    private ObjectOutputStream output2;  // 2번 클라이언트의 출력 스트림

    // 생성자에서 두 클라이언트의 ObjectOutputStream을 받음
    public Handler(ObjectOutputStream oos1, ObjectOutputStream oos2) throws IOException {
        this.output1 = oos1;
        this.output2 = oos2;
    }

    // 1번 클라이언트로부터 받은 메시지를 2번 클라이언트로 전달
    public void send1to2(Object msg) {
        try {
            // 1번 클라이언트로부터 받은 메시지를 2번 클라이언트에게 전달
            output2.writeObject(msg);
            output2.flush();
            System.out.println("1메세지 2로 보냄: " + msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 2번 클라이언트로부터 받은 메시지를 1번 클라이언트로 전달
    public void send2to1(Object msg) {
        try {
            // 2번 클라이언트로부터 받은 메시지를 1번 클라이언트에게 전달
            output1.writeObject(msg);
            output1.flush();
            System.out.println("2메세지 1로보냄: " + msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
