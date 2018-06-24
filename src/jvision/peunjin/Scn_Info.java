package jvision.peunjin;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Scn_Info extends JFrame {
	private JTextArea tba;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Scn_Info frame = new Scn_Info();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Scn_Info() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tba = new JTextArea();
		tba.setText("입력된 데이터가 없습니다.");
		tba.setEditable(false);
		tba.setBounds(12, 10, 410, 241);
		contentPane.add(tba);
	}
	
	public Scn_Info(String num, String name, String grade, String gender, String[] hobby, String school) {
		setTitle("201718040-박은진_정보 확인");
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
		
		tba = new JTextArea();
		tba.setEditable(false);
		tba.setBounds(12, 10, 460, 260);
		tba.setText("학번: " + num + "\n이름: " + name + "\n학년: " + grade + "\n성별: " + gender + "\n취미: " + hobbies + "\n대학: " + school);
		contentPane.add(tba);
	}
}
