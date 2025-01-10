package day009;

import java.util.regex.Pattern;

public class Ex03_Regex {

	public static void main(String[] args) {
		/*
		 * 주어진 문자열이 숫자열로만 되어있는지 확인하시오.
		 */
		String str = "001231ad2";
		String regex = "^\\d+$";
		if(Pattern.matches(regex, str)) {
			System.out.println(str + "은 숫자로만 이루어져 있습니다.");
		} else {
			System.out.println(str + "에 숫자가 아닌 문자가 있습니다.");
		}
	}

}
