package jvision.exam.std1_2g_final2;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/*
 * [문제]
 * [노란색] 버튼을 클릭하면 창 배경색이 노랑색으로 바뀌고, [핑크색] 버튼을 클릭하면 창 배경색이 분홍색이 되도록 프로그래밍 하시오.
 * 최대한 그림과 유사하게 구현하고 나머지는 임의대로 처리하시오.
 * 
 * [배점]
 * 총 15점, 화면 구현시 5점, 이벤트 액션 구현시 10점.
 * 
 * [그림]
 * - 실행 결과와 동일
 * 
 * [제출 파일 정보]
 * - 파일 형식: Executable JAR, *.jar
 * - 파일 이름: 2_{자신의 학번}
 * 
 * [답변 작성 시간: WindowBuilder 사용]
 * ~7분
 */
@SuppressWarnings("serial")
public class Question_02 extends JFrame {
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Question_02 frame = new Question_02();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Question_02() {
		setTitle("문제 2번");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btn_yellow = new JButton("노란색");
		btn_yellow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.YELLOW);
			}
		});
		contentPane.add(btn_yellow);
		
		JButton btn_pink = new JButton("핑크색");
		btn_pink.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.PINK);
			}
		});
		contentPane.add(btn_pink);
	}

}
