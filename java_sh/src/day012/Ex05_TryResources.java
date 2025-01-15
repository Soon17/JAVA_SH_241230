package day012;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex05_TryResources {

	public static void main(String[] args) {
		
		//리소스를 사용한 후 자동으로 닫히게 하고싶을 때
		//try resource문을 사용 
		try(FileInputStream fis = new FileInputStream("src/day012/byte_stream.txt")){
			int data;
			do {
				data = fis.read();
				if(data != -1) {
					System.out.print((char)data);
				}
			} while(data != -1);
		} catch(FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("IO예외 발생");
		}
	}

}
