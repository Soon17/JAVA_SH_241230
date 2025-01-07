package day006;

import java.text.CollationElementIterator;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Ex06_ArraySort {

	public static void main(String[] args) {
		int[] arr = new int[] {1,3,5,7,9,2,4,6,8,10};
		
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if(arr[j]>arr[j+1]) {
					int t = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = t;
				}
			}
		}
		Ex03_ArrayCopy.printArray(arr);
		
		int[] arr2 = new int[] {1,3,5,7,9,2,4,6,8,10};
		Arrays.sort(arr2);											//오름차순 정렬
		System.out.println(Arrays.toString(arr2));					//배열을 문자열로 변환
		
		Integer [] arr3 = new Integer[] {1,3,5,7,9,2,4,6,8,10};		//내림차순은 기본 자료형으로 정렬할 수 없음.
		Arrays.sort(arr3, Collections.reverseOrder());				//내림차순 정렬
		System.out.println(Arrays.toString(arr3));					//배열을 문자열로 변환
	}

}
