package day006;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Ex08_ReversrNumber {

	public static void main(String[] args) {
		/*4자리의 정수를 입력받아 입력받은 정수를 역순으로 출력하는 코드를 작성하세요.*/
		int size = 4;
		int inputNum;
		int[] numArray = new int[size];
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print(size + "자리의 정수를 입력하세요:");
			inputNum = sc.nextInt();
			if(inputNum/power(10,size-1) < 1 || inputNum/power(10,size-1) > 9) {
				System.out.println(size + "자리가 아닙니다.");
				continue;
			}
			break;
		} while(true);
		System.out.println(inputNum);
		
		for (int i = size - 1; i >= 0; i--) {
			numArray[i] = inputNum / power(10, i);
			inputNum %= power(10, i);
		}
		
		System.out.println(Arrays.toString(numArray));
	}
	
	public static int power(int n, int m) {
		int sum = 1;
		for (int i = 0; i < m; i++) {
			sum *= n;
		}
		return sum;
	}

}
