package day023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ex14_Stream {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("안녕", "홍길동", "KH", "테스트", "고길동");
		
		//문자열에 길동이 포함된 문자열을 출력하는 코드를 작성하시오.
		String str ="길동";
		for (String tmp : list) {
			if(tmp.contains(str)) {
				System.out.println(tmp);
			}
		}
		System.out.println("===========================");
		
		//Stream을 이용하여 같은 결과의 코드를 작성하시오.
		Stream<String> stream = list.stream();
		stream.
			filter(s -> s.contains(str)).
			forEach(t -> System.out.println(t));
		System.out.println("===========================");
		
		//Stream을 이용하여 3글자의 문자열을 코드를 작성하시오.
		stream = list.stream(); //stream은 재사용이 불가능. 다시 만들어야 함.
		stream.
			filter(s -> s.length() == 3).
			forEach(t -> System.out.println(t));
	}

}
