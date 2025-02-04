package day022;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import lombok.extern.jbosslog.JBossLog;

public class Ex01_SwingComponent {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("애플리케이션 예제");
		
//		frame.setLayout(new FlowLayout());
		
		frame.setSize(400, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 닫기버튼
		
		JButton btn = new JButton("버튼");
		frame.add(btn);
		
		JLabel lable = new JLabel("라벨");
		frame.add(lable);
		
		JTextField textField = new JTextField(30);
		frame.add(textField);
		
		JTextArea textArea = new JTextArea(20, 30);
		textArea.append("안녕하세요\n");
		textArea.append("제 이름은 홍길동입니다.\n");
		textArea.setEditable(false);							//false: 읽기 전용, true: 수정 가능
//		frame.add(textArea);
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(btn);
		panel.add(lable);
		panel.add(textField);
		panel.add(textArea);
		
		frame.add(panel);
		
		frame.setVisible(true);									//화면 출력
	}

}
