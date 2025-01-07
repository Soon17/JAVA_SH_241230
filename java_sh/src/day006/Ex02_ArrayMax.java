package day006;

import java.util.Iterator;

public class Ex02_ArrayMax {

	public static void main(String[] args) {
		/*배열에 저장된 값 중 가장 큰 값을 출력하는 코드를 작성하세요*/
		
		int[] arr = new int[] {1, 10, 9, 20, 3, 4};
		
		int max = arr[0];
		
		for(int i = 0; i < arr.length; i++) {
			if(max < arr[i]) max = arr[i];
		}
		
		System.out.println(max);
	
	}

}
