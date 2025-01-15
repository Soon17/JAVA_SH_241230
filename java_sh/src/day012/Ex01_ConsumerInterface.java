package day012;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex01_ConsumerInterface {

	public static void main(String[] args) {

		List<Person> list = new ArrayList<Person>();
		
		list.add(new Person("홍길동", "000101-3", 24));
		list.add(new Person("고길동", "601212-1", 64));
		list.add(new Person("둘리", "000101-1", 24));
		list.add(new Person("또치", "801111-2", 44));
		
		//print를 이용하여 사람들의 이름을 출력
		print(list, t -> System.out.println(t.getName()));
		System.out.println("---------------------------");
		//print를 이용하여 사람들의 전체 정보를 출력
		print(list, t -> System.out.println(t));
		System.out.println("---------------------------");
		//print를 이용하여 사람들의 주민번호를 출력
		print(list, t -> System.out.println(t.getNum()));
		System.out.println("---------------------------");
		
		
		//xx0101-x
		Person p = randomNum(()->{
			int year = (int)(Math.random() * 100);
			DecimalFormat df = new DecimalFormat("##");
			String yearStr = df.format(year);
			int gender = (int)(Math.random() * 4 + 1);
			String num  = yearStr + "0101-" + gender;
			return new Person("", num, 0);
		});
		
		System.out.println(p);
		System.out.println("---------------------------");
		
		//printString을 이용하여 사람들의 이름을 출력
		printString(list, t -> t.getName());
		System.out.println("---------------------------");
		//printString을 이용하여 사람들의 주민번호를 출력
		printString(list, t -> t.getNum());
		System.out.println("---------------------------");
		
		//모든 사람의 나이를 1증가
		replacePerson(list, t->{
			t.setAge(t.getAge() + 1);
			return t;
		});
		print(list, t->System.out.println(t));
		System.out.println("---------------------------");
		
		//홍길동인 사람의 이름을 홍씨라고 변경
		replacePerson(list, t->{
			if(t.getName().equals("홍길동"))
				t.setName("홍씨");
			return t;
		});
		print(list, t->System.out.println(t));
		System.out.println("---------------------------");
	}
	
	public static void replacePerson(List<Person> list, UnaryOperator<Person> op) {
		for (int i = 0; i < list.size(); i++) {
			list.set(i, op.apply(list.get(i)));
		}
	}
	
	/*
	 * Funtion은 매개변수 타입이 A이고 리턴타입이 B
	 * A의 필드를 이용해서 무언가로 가공하고 그 결과를 활용할 때 사용
	 */
	public static void printString(List<Person> list, Function<Person, String> f) {
		for (Person p : list) {
			System.out.println(f.apply(p));
		}
	}
	/*
	 * Supplier는 매개변수가 없고, 리턴타입이 있음
	 */
	public static Person randomNum(Supplier<Person> p) {
		return p.get();
	}
	
	/*
	 * Consumer는 매개변수가 있고, 리턴타입이 없어서 보통 출력문으로 사용
	 */
	public static void print(List<Person> list, Consumer<Person> c) {
		for(Person p : list) {
			c.accept(p);
		}
	}

}

@Data
@AllArgsConstructor
class Person {
	private String name;
	private String num;
	private int age;
}