package jvision.exam.std1_2g_final2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

/*
 * [문제]
 * 다음 스케치를 참고하여 피자 주문 프로그램을 작성하시오.
 * 컨트롤 배치와 크기를 화면과 최대한 유사하게 구현하시오.
 * 
 * [배점]
 * 총 40점, 마지막 항목을 제외한 각 항목당 5점, 마지막 항목 10점 
 * 
 * [스케치]
 * - 실행 결과와 동일
 * 
 * [조건 및 배점]
 * 1) 창 크기와 제목 - 5점
 * 2) 레이블: 스케치와 같은 배치 - 5점
 * 3) 종류 (라디오 버튼) - 5점
 * 4) 추가 토핑 (체크 박스) - 5점
 * 5) 크기 (라디오 버튼) - 5점
 * 6) 확인(주문) 버튼과 취소 버튼 - 5점
 * 7) [확인] 버튼을 클릭하면 새로운 창이 떠서 선택한 결과가 출력되도록 하시오. - 10점
 * 
 * [제출 파일 정보]
 * - 파일 형식: Executable JAR, *.jar
 * - 파일 이름: 3_{자신의 학번}
 * 
 * [답변 작성 시간: WindowBuilder 사용]
 * ~20분 (새로운 창 포함)
 */

@SuppressWarnings("serial")
public class Question_03_01 extends JFrame {
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Question_03_01 frame = new Question_03_01();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Question_03_01() {
		// 1)
		setTitle("문제 3 - 피자 주문");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		// 2)
		JLabel txt_welcome = new JLabel("자바 피자에 오신 것을 환영합니다.");
		txt_welcome.setHorizontalAlignment(SwingConstants.CENTER);
		txt_welcome.setBounds(162, 29, 260, 15);
		contentPane.add(txt_welcome);
		
		// 3)
		JPanel pnl_types = new JPanel();
		pnl_types.setBorder(BorderFactory.createTitledBorder("종류"));
		pnl_types.setBounds(33, 80, 150, 150);
		contentPane.add(pnl_types);
		
		ButtonGroup bg_types = new ButtonGroup();
		pnl_types.setLayout(null);
		
		JRadioButton rbt_combo = new JRadioButton("콤보");
		rbt_combo.setBounds(8, 22, 134, 23);
		rbt_combo.setActionCommand(rbt_combo.getText());
		bg_types.add(rbt_combo);
		pnl_types.add(rbt_combo);
		
		JRadioButton rbt_potato = new JRadioButton("포테이토");
		rbt_potato.setBounds(8, 47, 134, 23);
		rbt_potato.setActionCommand(rbt_potato.getText());
		bg_types.add(rbt_potato);
		pnl_types.add(rbt_potato);
		
		JRadioButton rbt_bulgogi = new JRadioButton("불고기");
		rbt_bulgogi.setBounds(8, 72, 134, 23);
		rbt_bulgogi.setActionCommand(rbt_bulgogi.getText());
		bg_types.add(rbt_bulgogi);
		pnl_types.add(rbt_bulgogi);
		
		// 4)
		JPanel pnl_topping = new JPanel();
		pnl_topping.setBorder(BorderFactory.createTitledBorder("추가 토핑"));
		pnl_topping.setBounds(216, 80, 150, 150);
		contentPane.add(pnl_topping);
		pnl_topping.setLayout(null);
		
		JCheckBox cbox_pepper = new JCheckBox("피망");
		cbox_pepper.setBounds(8, 22, 134, 23);
		pnl_topping.add(cbox_pepper);
		
		JCheckBox cbox_cheese = new JCheckBox("치즈");
		cbox_cheese.setBounds(8, 47, 134, 23);
		pnl_topping.add(cbox_cheese);
		
		JCheckBox cbox_pepperoni = new JCheckBox("페퍼로니");
		cbox_pepperoni.setBounds(8, 72, 134, 23);
		pnl_topping.add(cbox_pepperoni);
		
		JCheckBox cbox_bacon = new JCheckBox("베이컨");
		cbox_bacon.setBounds(8, 97, 134, 23);
		pnl_topping.add(cbox_bacon);
		
		// 5)
		JPanel pnl_size = new JPanel();
		pnl_size.setBorder(BorderFactory.createTitledBorder("크기"));
		pnl_size.setBounds(399, 80, 150, 150);
		contentPane.add(pnl_size);
		
		ButtonGroup bg_size = new ButtonGroup();
		pnl_size.setLayout(null);
		
		JRadioButton rbt_small = new JRadioButton("Small");
		rbt_small.setBounds(8, 22, 134, 23);
		rbt_small.setActionCommand(rbt_small.getText());
		bg_size.add(rbt_small);
		pnl_size.add(rbt_small);
		
		JRadioButton rbt_medium = new JRadioButton("Medium");
		rbt_medium.setBounds(8, 50, 134, 23);
		rbt_medium.setActionCommand(rbt_medium.getText());
		bg_size.add(rbt_medium);
		pnl_size.add(rbt_medium);
		
		JRadioButton rbt_large = new JRadioButton("Large");
		rbt_large.setBounds(8, 75, 134, 23);
		rbt_large.setActionCommand(rbt_large.getText());
		bg_size.add(rbt_large);
		pnl_size.add(rbt_large);
		
		// 6)
		JButton btn_order = new JButton("주문");
		btn_order.setBounds(175, 260, 97, 23);
		// 7)
		btn_order.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String toppings = "";
				
				for (int i = 0; i < pnl_topping.getComponentCount(); i++) {
					JCheckBox cbox_temp = (JCheckBox) pnl_topping.getComponent(i);
					
					if (cbox_temp.isSelected()) {
						toppings = toppings + cbox_temp.getText() + ", ";
					}
				}
				
				if ((bg_types.getSelection() == null || bg_size.getSelection() == null) || 
						(bg_types.getSelection() == null && bg_size.getSelection() == null)) {
					Question_03_02 result = new Question_03_02();
					result.setVisible(true);
				}
				else {
					Question_03_02 result = new Question_03_02(bg_types.getSelection().getActionCommand().toString(),
							toppings,
							bg_size.getSelection().getActionCommand().toString());
					result.setVisible(true);
				}
			}
		});
		contentPane.add(btn_order);
		
		// 6)
		JButton btn_cancel = new JButton("취소");
		btn_cancel.setBounds(296, 260, 97, 23);
		btn_cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bg_types.clearSelection();
				bg_size.clearSelection();
				
				cbox_pepper.setSelected(false);
				cbox_cheese.setSelected(false);
				cbox_pepperoni.setSelected(false);
				cbox_bacon.setSelected(false);
			}
		});
		contentPane.add(btn_cancel);
	}
}
