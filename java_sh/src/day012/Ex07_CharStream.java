package day012;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex07_CharStream {

	public static void main(String[] args) {
		
		/*
		 * char_stream.txt 파일에는 "가나다123" 존재
		 */
		
		String filename = "src/day012/char_stream.txt";
		try(FileReader fr = new FileReader(filename)){
			while(fr.ready()) {
				char ch = (char)fr.read();
				System.out.print(ch);
			}
			System.out.println("의 내용을 읽었습니다.");
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("IO 예외발생");
		}
		
		try(FileWriter fw = new FileWriter(filename)){
			String str = "가나다123";
			fw.write(str);
			fw.flush();
			System.out.println(str + "을 파일에 기록했습니다.");
		} catch (IOException e) {
			System.out.println("IO 예외발생");
		}
	}

}
