package day019;

public class Ex01_String {

	public static void main(String[] args) {
		
		//주어진 문자열에서 검색어가 몇번 들어가 있는지 확인하는 코드를 작성
		String str = "abcabcaabcadfasabababcadab";
		String search = "ab";
		
		String tmp = str;
		int count = 0;
		int index = tmp.indexOf(search);
		
		do {
			if(index >= 0) {
				count++;
				tmp = tmp.substring(index + search.length());
			}
		} while(index != -1);
		
		System.out.println(count + "번 포함되어있습니다");
	}

}
