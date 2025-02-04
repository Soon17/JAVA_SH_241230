package day022;

import java.awt.FlowLayout;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex04_Todo {

	static int count;
	
	public static void main(String[] args) {
		/*
		 * 오늘의 할 일을 입력받아 엔터를 치거나 버튼을 클릭하면
		 * 오늘의 할일이 추가되는 코드를 작성하세요.
		 */
		
		JFrame frame = new JFrame("To-do list");
		frame.setSize(400, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setLayout(new FlowLayout());
		JTextField textField = new JTextField(30);
		frame.add(textField);
		JButton btn = new JButton("버튼");
		frame.add(btn);
		JTextArea textArea = new JTextArea(20, 30);
		textArea.setEditable(false);
		frame.add(textArea);
		
		
		
		textField.addActionListener(e -> {
			String text = textField.getText();
			textArea.append("" + ++count + ". " + text + "\n");
			textField.setText("");
		});
		
		btn.addActionListener(e -> {
			String text = textField.getText();
			textArea.append("" + ++count + ". " + text + "\n");
			textField.setText("");
		});
		
		
		frame.setVisible(true);	
	}

}
