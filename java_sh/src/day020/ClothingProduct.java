package day020;

import lombok.Data;

@Data
public class ClothingProduct extends Product1{
	
	//분류마다 제품코드 할당할 때 등록된 제품 수를
	//활용하기 때문에 클래스 변수를 이용
	
	private static int count = 0;
}
