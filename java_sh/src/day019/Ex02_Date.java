package day019;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

public class Ex02_Date {

	public static void main(String[] args) {
		/*
		 * 문자열이 주어졌을 때 문자열이 날짜 형태인지 확인하는 코드를 작성
		 * 단, 날짜는 yyyy-MM-DD 형태일때만 날짜로 판별
		 */
		ArrayList<String> str = new ArrayList<String>();
		str.add("2025-01-27");	//O
		str.add("25-01-27");	//X
		str.add("2025/01/27"); 	//X
		
		for (String s : str) {
			if(isDate1(s))
				System.out.println("올바른 형식입니다.");
			else
				System.out.println("올바른 형식이 아닙니다.");
		}
		
		System.out.println("-----------------------------");
		
		for (String s : str) {
			if(isDate2(s)){
				System.out.println("올바른 형식입니다.");
			} else {
				System.out.println("올바른 형식이 아닙니다.");
			}			
		}
		
		System.out.println("-----------------------------");
		
		for (String s : str) {
			if(isDate3(s)){
				System.out.println("올바른 형식입니다.");
			} else {
				System.out.println("올바른 형식이 아닙니다.");
			}			
		}
	}
	
	public static boolean isDate1(String str) {
		String[] list = str.split("-");
		
		if(list.length != 3) return false;
		
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private static boolean isDate2(String s) {
		String regex = "^\\d{4}-\\d{1,2}-\\d{2}$";
		return Pattern.matches(regex, s);
	}

	private static boolean isDate3(String s) {
		// TODO Auto-generated method stub
		return false;
	}

}
