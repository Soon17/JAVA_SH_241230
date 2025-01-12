package day009;

public class Ex01_String {

	public static void main(String[] args) {
		/*
		 * 파일명이 주어졌을 때 파일이 이미이인지 아닌지 확인하는 코드를 작성하시오.
		 */
		
		String fileName = "test.jpg";
		String[] img = new String[] {"jpg", "bmp", "gif", "png"};
		
		//lastIndexOf(문자열) : 문자열이 있으면 마지막 위치를 보여줌
		int index = fileName.lastIndexOf(".");
		if(index < 0) {
			System.out.println(fileName + "은 이미지 파일이 아닙니다.");
			return;
		}
		//substring(index) : index 번지부터 마지막까지의 문자열 추출
		String sub = fileName.substring(index + 1);
		boolean result = false;
		for (String s : img) {
			if(s.equals(sub)) {
				result = true;
				break;
			}
		}
		if(result)
			System.out.println(fileName + "은 이미지 파일이 맞습니다.");
		else
			System.out.println(fileName + "은 이미지 파일이 아닙니다.");
	}

}
