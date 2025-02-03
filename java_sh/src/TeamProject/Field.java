package TeamProject;

import lombok.Data;

@Data
public class Field {

	private final int maxField = 15;
	private String[][] field = new String[maxField][maxField];
	private boolean isBlack = true;
	
	public Field() {
		fieldClear();
	}
	
	/**
	 * 필드 초기화 함수
	 */
	public void fieldClear() {
		for(int i = 0; i < field.length; i++) {
			for(int j = 0; j < field[i].length; j++) {
				field[i][j] = "─┼─";
			}
		}
	}
	
	/**
	 * 필드 출력 함수
	 */
	public void printField() {
		for (int i = 0; i < field.length; i++) {
			System.out.print("  " + Integer.toHexString(i));
		}
		System.out.println();
		for(int i = 0; i < field.length; i++) {
			System.out.print(Integer.toHexString(i));
			for(int j = 0; j < field[i].length; j++) {
				System.out.print(field[i][j]);
			}
			System.out.println();
		}
	}
	
	/**
	 * 필드 인덱스의 값을 바꿈
	 * @param i
	 * @param j
	 */
	public void setStone(int i, int j) {
		if(isBlack) {
			field[j][i] = "─●─";
		} else {
			field[j][i] = "─○─";
		}
	}
}