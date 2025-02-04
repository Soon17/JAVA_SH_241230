package day022;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Ex03_Event {

	public static void main(String[] args) {
		JFrame frame = new JFrame("애플리케이션 예제");
		
		frame.setLayout(new FlowLayout());
		frame.setSize(400, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 닫기버튼
		
		JButton btn = new JButton("버튼");
		btn.addActionListener(e ->{
			JOptionPane.showMessageDialog(frame, "버튼 클릭");
		});
		
		JTextField textField = new JTextField(20);
		textField.addActionListener(e -> {
			String text = textField.getText();
			System.out.println(text);
			textField.setText("");
		});
		
		frame.add(textField);
		frame.add(btn);
		
		frame.setVisible(true);
	}

}
