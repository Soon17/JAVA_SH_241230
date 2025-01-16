package day013;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ex03_IOStream {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		
		//불러오기
		try(FileReader fr = new FileReader("src/day013/string.txt");
				BufferedReader br = new BufferedReader(fr)){
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("불러오기 도중 IO 예외 발생");
		}
		
		//저장하기
		try(FileWriter fw = new FileWriter("src/day013/string.txt", true)){
			fw.write("안녕하세요.\n");							//true를 쓰면 이어쓸 수 있음
			fw.write("제 이름은 홍길동입니다.\n");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
