package jvision.jjiyun.report.gui_1;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Frm_Main extends JFrame {
	private JPanel contentPane;
	private JTextField tbox_num;
	private JTextField tbox_name;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_Main frame = new Frm_Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Frm_Main() {
		setTitle("GUI 테스트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txt_num = new JLabel("학번");
		txt_num.setHorizontalAlignment(SwingConstants.CENTER);
		txt_num.setBounds(55, 26, 57, 15);
		contentPane.add(txt_num);
		
		tbox_num = new JTextField();
		tbox_num.setBounds(111, 23, 116, 21);
		contentPane.add(tbox_num);
		tbox_num.setColumns(10);
		
		JLabel txt_name = new JLabel("이름");
		txt_name.setHorizontalAlignment(SwingConstants.CENTER);
		txt_name.setBounds(301, 26, 57, 15);
		contentPane.add(txt_name);
		
		tbox_name = new JTextField();
		tbox_name.setBounds(356, 23, 116, 21);
		contentPane.add(tbox_name);
		tbox_name.setColumns(10);
		
		JPanel pnl_grade = new JPanel();
		pnl_grade.setBorder(BorderFactory.createTitledBorder("학년"));
		pnl_grade.setBounds(28, 74, 125, 180);
		contentPane.add(pnl_grade);
		
		ButtonGroup bg_grade = new ButtonGroup();
		pnl_grade.setLayout(null);
		
		JRadioButton rbt_grade_1g = new JRadioButton("1학년");
		rbt_grade_1g.setSelected(true);
		rbt_grade_1g.setBounds(8, 30, 109, 23);
		rbt_grade_1g.setActionCommand(rbt_grade_1g.getText());
		pnl_grade.add(rbt_grade_1g);
		
		JRadioButton rbt_grade_2g = new JRadioButton("2학년");
		rbt_grade_2g.setBounds(8, 58, 109, 23);
		rbt_grade_2g.setActionCommand(rbt_grade_2g.getText());
		pnl_grade.add(rbt_grade_2g);
		
		JRadioButton rbt_grade_3g = new JRadioButton("3학년");
		rbt_grade_3g.setBounds(8, 86, 109, 23);
		rbt_grade_3g.setActionCommand(rbt_grade_3g.getText());
		pnl_grade.add(rbt_grade_3g);
		
		JRadioButton rbt_grade_4g = new JRadioButton("4학년");
		rbt_grade_4g.setBounds(8, 114, 109, 23);
		rbt_grade_4g.setActionCommand(rbt_grade_4g.getText());
		pnl_grade.add(rbt_grade_4g);
		
		bg_grade.add(rbt_grade_1g);
		bg_grade.add(rbt_grade_2g);
		bg_grade.add(rbt_grade_3g);
		bg_grade.add(rbt_grade_4g);
		
		JPanel pnl_gender = new JPanel();
		pnl_gender.setBorder(BorderFactory.createTitledBorder("성별"));
		pnl_gender.setBounds(170, 74, 125, 180);
		contentPane.add(pnl_gender);
		
		ButtonGroup bg_gender = new ButtonGroup();
		pnl_gender.setLayout(null);
		
		JRadioButton rbt_gender_f = new JRadioButton("여자");
		rbt_gender_f.setBounds(8, 30, 109, 23);
		rbt_gender_f.setActionCommand(rbt_gender_f.getText());
		pnl_gender.add(rbt_gender_f);
		
		JRadioButton rbt_gender_m = new JRadioButton("남자");
		rbt_gender_m.setBounds(8, 58, 109, 23);
		rbt_gender_m.setActionCommand(rbt_gender_m.getText());
		pnl_gender.add(rbt_gender_m);
		
		bg_gender.add(rbt_gender_f);
		bg_gender.add(rbt_gender_m);
		
		JPanel pnl_hobby = new JPanel();
		pnl_hobby.setBorder(BorderFactory.createTitledBorder("취미"));
		pnl_hobby.setBounds(315, 74, 125, 180);
		contentPane.add(pnl_hobby);
		pnl_hobby.setLayout(null);
		
		JCheckBox cbox_hobby_book = new JCheckBox("독서");
		cbox_hobby_book.setBounds(8, 26, 109, 23);
		pnl_hobby.add(cbox_hobby_book);
		
		JCheckBox cbox_hobby_movie = new JCheckBox("영화 감상");
		cbox_hobby_movie.setBounds(8, 54, 109, 23);
		pnl_hobby.add(cbox_hobby_movie);
		
		JCheckBox cbox_hobby_tv = new JCheckBox("TV 시청");
		cbox_hobby_tv.setBounds(8, 82, 109, 23);
		pnl_hobby.add(cbox_hobby_tv);
		
		JCheckBox cbox_hobby_sports = new JCheckBox("운동");
		cbox_hobby_sports.setBounds(8, 110, 109, 23);
		pnl_hobby.add(cbox_hobby_sports);
		
		JCheckBox cbox_hobby_study = new JCheckBox("공부");
		cbox_hobby_study.setBounds(8, 138, 109, 23);
		pnl_hobby.add(cbox_hobby_study);
		
		JComboBox<String> cmb_school = new JComboBox<>();
		cmb_school.setModel(new DefaultComboBoxModel<String>(new String[] {"학교", "비전대학교", "전북대학교", "전주대학교", "우석대학교", "원광대학교"}));
		cmb_school.setBounds(442, 96, 130, 21);
		contentPane.add(cmb_school);
		
		JButton btn_cancel = new JButton("취소");
		btn_cancel.setBounds(475, 278, 97, 23);
		btn_cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tbox_name.setText("");
				tbox_num.setText("");
				
				rbt_grade_1g.setSelected(true);
				
				bg_gender.clearSelection();
				
				cbox_hobby_book.setSelected(false);
				cbox_hobby_movie.setSelected(false);
				cbox_hobby_tv.setSelected(false);
				cbox_hobby_sports.setSelected(false);
				cbox_hobby_study.setSelected(false);
				
				cmb_school.setSelectedIndex(0);
				
				Frm_ShowInfo.deleteText();
			}
		});
		contentPane.add(btn_cancel);
		
		JButton btn_confirm = new JButton("확인");
		btn_confirm.setBounds(366, 278, 97, 23);
		btn_confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> hobby = new ArrayList<>();
				
				if (cbox_hobby_book.isSelected()) hobby.add(cbox_hobby_book.getText());
				if (cbox_hobby_movie.isSelected()) hobby.add(cbox_hobby_movie.getText());
				if (cbox_hobby_tv.isSelected()) hobby.add(cbox_hobby_tv.getText());
				if (cbox_hobby_sports.isSelected()) hobby.add(cbox_hobby_sports.getText());
				if (cbox_hobby_study.isSelected()) hobby.add(cbox_hobby_study.getText());
				
				String[] hobbies = new String[hobby.size()];
				
				for (int i = 0; i < hobbies.length; i++) {
					hobbies[i] = hobby.get(i);
				}
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Frm_ShowInfo info = new Frm_ShowInfo(tbox_num.getText()
									, tbox_name.getText()
									, bg_grade.getSelection().getActionCommand().toString()
									, bg_gender.getSelection().getActionCommand().toString()
									, hobbies
									, cmb_school.getSelectedItem().toString());
							info.setVisible(true);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "데이터를 입력 후 [확인] 버튼을 눌러주세요!", "데이터 입력 안됨", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
			}
		});
		contentPane.add(btn_confirm);
	}
}
