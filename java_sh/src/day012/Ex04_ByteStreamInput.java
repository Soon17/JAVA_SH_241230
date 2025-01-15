package day012;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex04_ByteStreamInput {

	public static void main(String[] args) {
		
		FileInputStream fis = null;
		
		/*
		 * 파일 경로 두가지
		 * 절대 경로: 현재 파일 위치와 상관없는 경로
		 * 	- D:\dev\jar\lombok.jar
		 * 상대 경로: 현재 파일 위치에 따라 경로가 달라짐
		 * 	- lombok.jar
		 * 	- src\day001\Ex001_HelloWorld.java
		 * 
		 * InputStream은 해당 폴더에 파일이 없으면 FileNotFoundException 생성
		 */
		try{
			fis = new FileInputStream("src/day012/byte_stream");
			int data;
			do{
				data = fis.read();
				if(data != -1) {
					System.out.print((char)data);
				}
			} while(data != -1);
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("파일 읽기에 실패하였습니다.");
		} finally {
			if(fis != null) {
				try{
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}