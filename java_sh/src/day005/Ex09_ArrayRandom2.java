package day005;

import java.util.Random;

public class Ex09_ArrayRandom2 {

	public static void main(String[] args) {
		
		int arr[] = createArray(1,6,6);
		
		printArray(arr);
		
		
	}
	
	public static int[] createArray(int i, int j, int k) {
		int count = 0;
		int[] array = new int[k];
		Random r = new Random();
		
		while(count < array.length) {
			int ranNum = r.nextInt(j) + i;
			
			if(haveNum(array, ranNum)) continue;
			array[count] = ranNum;
			count++;
		}
		return array;
	}

	public static void printArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
	
	public static boolean haveNum(int[] array, int ranNum) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == ranNum) {
				return true;
			}
		}
		return false;
	}
}
