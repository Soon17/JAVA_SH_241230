package day005;

import java.lang.reflect.Array;

public class Ex08_ArraySearch {

	public static void main(String[] args) {
		int[] array = new int[] {1,2,3,4,5};
		int num = 4;
		
		boolean haveNum = contains(array, num);
		
		System.out.println(haveNum ? num + "은 있습니다." : num + "은 없습니다.");
		
		haveNum = contains(array, num, 3);
		System.out.println(haveNum ? num + "은 배열 3개 안에 있습니다." : num + "은 배열 3개 안에 없습니다.");
	}
	
	static boolean contains(int[] arr, int num) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i]==num) {
				return true;
			}
		}
		return false;
	}
	
	static boolean contains(int[] arr, int num, int count) {
		if(arr.length < count) {
			count = arr.length;
		}
		for(int i = 0; i < count; i++) {
			if(arr[i]==num) {
				return true;
			}
		}
		return false;
	}

}
