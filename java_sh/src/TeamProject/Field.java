package TeamProject;

import lombok.Data;

@Data
public class Field {

	private final int maxField = 15;
	private String[][] field = new String[maxField][maxField];
	//field[2][2] = 'B';
	/*	OOOOO
	 * 	OOOOO
	 * 	OOBWO
	 * 	OOOOO
	 * 	OOOOO
	 * */
	boolean isBlack = true;
	
	public Field() {
		fieldClear();
	}
	
	public void fieldClear() {
		for(int i = 0; i < field.length; i++) {
			for(int j = 0; j < field[i].length; j++) {
				field[i][j] = "─┼─";
			}
		}
	}
	
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
	
	public void setStone(int i, int j) {
		if(isBlack) {
			field[j][i] = "─●─";
		} else {
			field[j][i] = "─○─";
		}
	}
}