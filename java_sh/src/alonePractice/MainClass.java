package alonePractice;

public class MainClass {
	
	private static final int maxField = 15;
	private static String[][] field = new String[maxField][maxField];
	
    public static void main(String[] args) {
    	fieldClear();
    	System.out.println(printField());
    }
    
    /**
	 * 필드 초기화 함수
	 */
	public static void fieldClear() {
		for(int i = 0; i < field.length; i++) {
			for(int j = 0; j < field[i].length; j++) {
				field[i][j] = "─┼─";
			}
		}
	}
	
	/**
	 * 필드 출력 함수
	 */
	public static String printField() {
		String fld = "";
		for (int i = 0; i < field.length; i++) {
			fld += "  " + Integer.toHexString(i);
		}
		fld += "\n";
		for(int i = 0; i < field.length; i++) {
			fld += Integer.toHexString(i);
			for(int j = 0; j < field[i].length; j++) {
				fld += field[i][j];
			}
			fld += "\n";
		}
		return fld;
	}
}