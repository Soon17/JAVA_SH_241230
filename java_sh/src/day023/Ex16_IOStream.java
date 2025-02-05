package day023;

import java.io.FileReader;
import java.io.FileWriter;

public class Ex16_IOStream {

	public static void main(String[] args) {
		
		String fileName = "src/day023/ex16.txt";
		
		/*
		 * FileWriter(파일명) : 기존파일을 지우고 새로 만듦.
		 * FileWriter(파일명, boolean) : true면 이어쓰기, false면 덮어쓰기(새로만들기)
		 */
		try(FileWriter fw = new FileWriter(fileName)){
			fw.write("안녕하세요\n");
			fw.write("제 이름은 홍길동입니다.\n");
			fw.flush();
		} catch(Exception e) {}
		
		try(FileReader fr = new FileReader(fileName)){
			while(fr.ready()) {
				char c = (char)fr.read();
				System.out.print(c);
			}
		} catch(Exception e) {}
	}

}
