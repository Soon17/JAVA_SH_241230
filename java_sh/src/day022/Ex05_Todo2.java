package day022;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex05_Todo2 {

	static int count;
	
	public static void main(String[] args) {
		/*
		 * 오늘의 할 일을 입력받아 엔터를 치거나 버튼을 클릭하면
		 * 오늘의 할일이 추가되는 코드를 작성하세요.
		 */
		
		JFrame frame = new JFrame("To-do list");
		frame.setLayout(new BorderLayout());
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		JButton btn = new JButton("버튼");
		panel.add(btn);
		
		JTextField textField = new JTextField(30);
		panel.add(textField);
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		JList<String> list = new JList<String>(listModel);
		JScrollPane scrollPane = new JScrollPane(list);
		
		
		
		textField.addActionListener(e -> {
			String text = textField.getText().trim();

			if(!text.isEmpty()) {
				listModel.addElement(text);
			}
			
			textField.setText("");
		});
		
		btn.addActionListener(e -> {
			String text = textField.getText().trim();

			if(!text.isEmpty()) {
				listModel.addElement(text);
			}
			
			textField.setText("");
		});
		
		frame.add(panel, BorderLayout.NORTH);
		frame.add(scrollPane, BorderLayout.CENTER);
		
		frame.setVisible(true);	
	}

}
