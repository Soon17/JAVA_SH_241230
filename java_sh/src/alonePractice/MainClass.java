package alonePractice;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		
		int input;
		Date date;
		ArrayList<String> dl= new ArrayList<String>();
		SimpleDateFormat format = 
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		do {
			Scanner sc = new Scanner(System.in);
			input = sc.nextInt();
			date = new Date();
			
			String time = format.format(date);
			System.out.println(time);
			dl.add(time + " "+ input);
		} while(input != 1);
		
		Collections.sort(dl, Collections.reverseOrder());
		
		System.out.println(dl);
	}
}