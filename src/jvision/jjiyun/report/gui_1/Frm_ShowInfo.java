package jvision.jjiyun.report.gui_1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Frm_ShowInfo extends JFrame {
	private JPanel contentPane;
	private static JTextArea tboxa_info;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_ShowInfo frame = new Frm_ShowInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Frm_ShowInfo() {
		setTitle("정보 확인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea tboxa_info = new JTextArea();
		tboxa_info.setEditable(false);
		tboxa_info.setBounds(12, 10, 460, 260);
		tboxa_info.setText("입력된 정보가 없습니다.");
		contentPane.add(tboxa_info);
		
		JButton btn_confirm = new JButton("확인");
		btn_confirm.setBounds(375, 278, 97, 23);
		contentPane.add(btn_confirm);
	}
	
	public Frm_ShowInfo(String num, String name, String grade, String gender, String hobby[], String school) {
		setTitle("정보 확인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String hobbies = hobby[0];
		
		if (hobby.length > 1) {
			for (int i = 1; i < hobby.length; i++) {
				hobbies = hobbies + ", " + hobby[i];
			}
		}
		
		tboxa_info = new JTextArea();
		tboxa_info.setEditable(false);
		tboxa_info.setBounds(12, 10, 460, 260);
		tboxa_info.setText("학번: " + num 
				+ "\n이름: " + name 
				+ "\n학년: " + grade 
				+ "\n성별: " + gender 
				+ "\n취미: " + hobbies
				+ "\n대학: " + school);
		contentPane.add(tboxa_info);
		
		JButton btn_confirm = new JButton("확인");
		btn_confirm.setBounds(375, 278, 97, 23);
		btn_confirm.addActionListener(e -> this.dispose());
		contentPane.add(btn_confirm);
	}

	public static void deleteText() {
		if (tboxa_info != null) {
			tboxa_info.setText("");
		}
		else {
			
		}
	}
}
