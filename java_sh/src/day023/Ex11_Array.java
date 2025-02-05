package day023;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex11_Array {

	public static void main(String[] args) {
		
		//다음코드의 잘못된 점을 찾아 수정하시오
		Point2[] arr = new Point2[5];
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].getX() + ", " + arr[i].getY());
		}
		//인덱스당 null로 되어있음
	}

}

@Data
@AllArgsConstructor
class Point2 {
	int x, y;
}