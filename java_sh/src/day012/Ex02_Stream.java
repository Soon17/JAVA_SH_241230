package day012;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex02_Stream {

	public static void main(String[] args) {
		
		List<Person2> list = new ArrayList<Person2>();
		list.add(new Person2("정순형", 28, "남"));
		list.add(new Person2("박소은", 30, "여"));
		list.add(new Person2("Victoriia", 25, "여"));
		list.add(new Person2("홍길동", 50, "남"));
		
		//모든 사람의 정보를 출력
		Stream<Person2> stream = list.stream();
		stream
			.filter( t -> true)
			.forEach( t -> System.out.println(t));
		System.out.println("----------------------------");
		//여자들의 정보만 출력
		stream = list.stream();
		stream
			.filter( t -> t.getGender().equals("여"))
			.forEach( t -> System.out.println(t));
		System.out.println("----------------------------");
		
		//나이가 30미만인 여자들의 정보만 출력
		stream = list.stream();
		stream
			.filter(t -> t.getGender().equals("여") && t.getAge() < 30)
			.forEach(t -> System.out.println(t));
		System.out.println("----------------------------");
		
		//여자들의 수
		stream = list.stream();
		long count = stream.filter(t -> t.getGender().equals("여"))
							.count();
		System.out.println("여자들의 수: " + count);
		System.out.println("----------------------------");
		
		//사람들의 평균나이
		/*
		 * map()은 Person2를 R로 리턴
		 * mapToInt는 Person2를 Integer로 리턴
		 * average()는 평균을 구하는데 스트림이 빈 경우를 위해 OptionalDouble로 리턴
		 * OptinalDouble은 isPresent() 메소드를 통해 평균의 유무를 파악가능
		 */
		stream = list.stream();
		OptionalDouble avg = stream.mapToInt(Person2::getAge).average();
//		OptionalDouble avg = stream.mapToInt(t -> t.getAge()).average();
		if(avg.isPresent()) {
			System.out.println("평균나이: " + avg.getAsDouble());
		} else {
			System.out.println("일치하는 사람이 없습니다.");
		}
		System.out.println("----------------------------");
		
		stream = list.stream();
		double avg2 = stream.mapToInt(Person2::getAge).average().orElse(0);
		System.out.println("평균나이: " + avg2);
		System.out.println("----------------------------");
		
		/*
		 * 스트림을 객체로 변환
		 */
		stream = list.stream();
		List<Person2> list2 = stream
								.filter(p -> p.getAge() > 30)
								.collect(Collectors.toList());
		System.out.println(list2);
		System.out.println("----------------------------");
		
		/*
		 * 숫자와 함께 출력
		 */
		
		stream = list.stream();
		//숫자 증가를 위한 객체 생성
		AtomicInteger index = new AtomicInteger(0);
		
		stream.forEach(p -> {
			int curIndex = index.getAndIncrement(); //현재 번지를 가져오고 1증가
			System.out.println(curIndex + 1 + ". " + p);
		});
	}

}

@Data
@AllArgsConstructor
class Person2 {
	private String name;
	private int age;
	private String gender;
}