package jvision.exam.std1_2g_final2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

/*
 * [문제]
 * 다음 조건에 맞는 프로그램을 작성하시오.
 * 
 * [배점]
 * 총 20점, 각 문항당 5점
 * 
 * [다음]
 * 1) [Start]와 [Help] 메뉴를 구성하시오.
 * 2) [Start] 메뉴에는 (Red), (Yellow), (Exit) 메뉴 항목이 있고, (Exit) 바로 위에 분리자를 추가하시오.
 * 3) [Help] 메뉴에는 (Tip), (Search) 메뉴 항목을 추가하시오.
 * 4) [Start] 의 (Red) 메뉴 항목을 클릭하면 창 배경색이 빨강색으로 바뀌도록 하시오.
 * 
 * [제출 파일 정보]
 * - 파일 형식: Executable JAR, *.jar
 * - 파일 이름: 4_{자신의 학번}
 * 
 * [답변 작성 시간: WindowBuilder 사용]
 * 12분
 */

@SuppressWarnings("serial")
public class Question_04 extends JFrame {
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Question_04 frame = new Question_04();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Question_04() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JMenuBar mStrip_Main = new JMenuBar();
		setJMenuBar(mStrip_Main);
		
		// 1)
		JMenu mItem_Start = new JMenu("Start");
		mStrip_Main.add(mItem_Start);
		
		// 2)
		JMenuItem sItem_Red = new JMenuItem("Red");
		// 4)
		sItem_Red.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.RED);
			}
		});
		mItem_Start.add(sItem_Red);
		
		// 2)
		JMenuItem sItem_Yellow = new JMenuItem("Yellow");
		mItem_Start.add(sItem_Yellow);
		
		JSeparator sItem_Separator = new JSeparator();
		mItem_Start.add(sItem_Separator);
		
		JMenuItem sItem_Exit = new JMenuItem("Exit");
		mItem_Start.add(sItem_Exit);
		
		// 1)
		JMenu mItem_Help = new JMenu("Help");
		mStrip_Main.add(mItem_Help);
		
		// 3)
		JMenuItem hItem_Tip = new JMenuItem("Tip");
		mItem_Help.add(hItem_Tip);
		
		JMenuItem hItem_Search = new JMenuItem("Search");
		mItem_Help.add(hItem_Search);
	}

}
