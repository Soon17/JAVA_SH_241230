package day006;

public class Ex03_ArrayCopy {

	public static void main(String[] args) {
		/*arr1의 값들을 arr2에 복사하세요.*/
		
		int[] arr1 = new int[] {1, 3, 5, 7, 9};
		int[] arr2 = new int[arr1.length];
		int[] arr3 = new int[arr2.length];
		int[] arr4 = new int[arr3.length];
		
		for (int i = 0; i < arr1.length; i++) {
			arr2[i] = arr1[i];
		}
		
		System.arraycopy(arr2, 0, arr3, 0, arr2.length);
		
		System.arraycopy(arr3, 0, arr4, 2, 3);
		
		printArray(arr1);
		printArray(arr2);
		printArray(arr3);
		printArray(arr4);
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
