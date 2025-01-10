package day009;

import java.util.ArrayList;

public class Ex15_Generic {

	public static void main(String[] args) {
		
		Array<String> list1 = new Array<String>(10);
		list1.set(0, "abc");
		list1.set(1, "123");
		System.out.println(list1.get(0));
		System.out.println("------------");
		list1.print();
		
		Array<Integer> list2 = new Array<Integer>(10);
		list2.set(0, 987);
		list2.set(1, 654);
		System.out.println(list2.get(0));
		System.out.println("------------");
		list2.print();
		
		print(1);
		print("123");
	}
	
	public static <T> void print(T t) {
		if(t == null) return;
		System.out.println(t);
	}

}

class Array<T> {

	private T[] list;
	
	public Array(int size) {
		list = (T[])new Object[size];
	}

	public T[] getList() {
		return list;
	}

	public void setList(T[] list) {
		this.list = list;
	}
	/*
	 * 특정 번지의 값을 바꾸고 성공시 데이터 반환, 실패시 null 반환
	 */
	public T set(int index, T data) {
		if(index < 0 || index >= list.length) return null;
		T tmp = list[index];
		list[index] = data;
		return tmp;
	}
	
	public T get(int index) {
		if(index < 0 || index >= list.length) return null;
		return list[index];
	}
	
	public void print() {
		for (T tmp : list) {
			if(tmp != null)
				System.out.println(tmp);
		}
	}
}