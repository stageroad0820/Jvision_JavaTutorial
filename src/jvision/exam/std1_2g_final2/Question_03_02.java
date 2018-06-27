package jvision.exam.std1_2g_final2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

/*
 * 문제 3에 대한 새로운 창
 */
@SuppressWarnings("serial")
public class Question_03_02 extends JFrame {
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Question_03_02 frame = new Question_03_02();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Question_03_02() {
		setTitle("문제 3 - 결과 출력");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea tbox_result = new JTextArea();
		tbox_result.setEditable(false);
		tbox_result.setBounds(12, 10, 410, 230);
		tbox_result.setText("전송된 값이 없습니다.");
		contentPane.add(tbox_result);
	}
	
	public Question_03_02(String types, String toppings, String size) {
		setTitle("문제 3 - 결과 출력");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JTextArea tbox_result = new JTextArea();
		tbox_result.setEditable(false);
		tbox_result.setBounds(12, 10, 410, 241);
		tbox_result.setText("{{ 피자 주문 내역 결과입니다. }}\n\n"
				+ "- 종류: " + types + "\n"
				+ "- 추가 토핑: " + toppings + "\n"
				+ "- 크기: " + size);
		contentPane.add(tbox_result);
	}

}
