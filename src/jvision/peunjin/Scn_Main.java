package jvision.peunjin;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Scn_Main extends JFrame {

	private JPanel contentPane;
	private JTextField tf_name;
	private JTextField tf_num;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Scn_Main frame = new Scn_Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Scn_Main() {
		setTitle("201718040-박은진");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_name = new JLabel("이름");
		lbl_name.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_name.setBounds(24, 28, 57, 15);
		contentPane.add(lbl_name);
		
		tf_name = new JTextField();
		tf_name.setBounds(84, 25, 116, 21);
		contentPane.add(tf_name);
		tf_name.setColumns(10);
		
		JLabel lbl_num = new JLabel("학번");
		lbl_num.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_num.setBounds(286, 31, 57, 15);
		contentPane.add(lbl_num);
		
		tf_num = new JTextField();
		tf_num.setColumns(10);
		tf_num.setBounds(346, 28, 116, 21);
		contentPane.add(tf_num);
		
		JPanel pan_grade = new JPanel();
		pan_grade.setBorder(BorderFactory.createTitledBorder("학년"));
		pan_grade.setBounds(24, 91, 100, 180);
		contentPane.add(pan_grade);
		pan_grade.setLayout(null);
		
		ButtonGroup bgroup1 = new ButtonGroup();
		
		JRadioButton rb_1g = new JRadioButton("1학년");
		rb_1g.setBounds(8, 32, 85, 23);
		pan_grade.add(rb_1g);
		
		JRadioButton rb_2g = new JRadioButton("2학년");
		rb_2g.setBounds(8, 57, 85, 23);
		pan_grade.add(rb_2g);
		
		JRadioButton rb_3g = new JRadioButton("3학년");
		rb_3g.setBounds(8, 82, 85, 23);
		pan_grade.add(rb_3g);
		
		JRadioButton rb_4g = new JRadioButton("4학년");
		rb_4g.setBounds(8, 107, 85, 23);
		pan_grade.add(rb_4g);
		
		bgroup1.add(rb_1g);
		bgroup1.add(rb_2g);
		bgroup1.add(rb_3g);
		bgroup1.add(rb_4g);
		
		JPanel pan_gender = new JPanel();
		pan_gender.setBorder(BorderFactory.createTitledBorder("성별"));
		pan_gender.setBounds(136, 91, 100, 180);
		contentPane.add(pan_gender);
		pan_gender.setLayout(null);
		
		ButtonGroup bgroup2 = new ButtonGroup();
		
		JRadioButton rb_f = new JRadioButton("여자");
		rb_f.setBounds(8, 34, 85, 23);
		pan_gender.add(rb_f);
		
		JRadioButton rb_m = new JRadioButton("남자");
		rb_m.setBounds(8, 59, 85, 23);
		pan_gender.add(rb_m);
		
		bgroup2.add(rb_f);
		bgroup2.add(rb_m);
		
		JPanel pan_hobby = new JPanel();
		pan_hobby.setBorder(BorderFactory.createTitledBorder("취미"));
		pan_hobby.setBounds(248, 91, 110, 180);
		contentPane.add(pan_hobby);
		pan_hobby.setLayout(null);
		
		JCheckBox cb_book = new JCheckBox("독서");
		cb_book.setBounds(8, 33, 95, 23);
		pan_hobby.add(cb_book);
		
		JCheckBox cb_movie = new JCheckBox("영화 감상");
		cb_movie.setBounds(8, 58, 95, 23);
		pan_hobby.add(cb_movie);
		
		JCheckBox cb_tv = new JCheckBox("TV 시청");
		cb_tv.setBounds(8, 83, 95, 23);
		pan_hobby.add(cb_tv);
		
		JCheckBox cb_sports = new JCheckBox("운동");
		cb_sports.setBounds(8, 108, 95, 23);
		pan_hobby.add(cb_sports);
		
		JCheckBox cb_study = new JCheckBox("공부");
		cb_study.setBounds(8, 133, 95, 23);
		pan_hobby.add(cb_study);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"학교", "비전대학교", "전북대학교", "전주대학교", "우석대학교", "원광대학교"}));
		comboBox.setBounds(370, 88, 140, 21);
		contentPane.add(comboBox);
		
		JButton cancel = new JButton("취소");
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tf_name.setText("");
				tf_num.setText("");
				
				rb_1g.setSelected(true);
				
				bgroup2.clearSelection();
				
				cb_book.setSelected(false);
				cb_movie.setSelected(false);
				cb_tv.setSelected(false);
				cb_sports.setSelected(false);
				cb_study.setSelected(false);
				
				comboBox.setSelectedIndex(0);
			}
		});
		cancel.setBounds(425, 298, 97, 23);
		contentPane.add(cancel);
		
		JButton ok = new JButton("확인");
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		ok.setBounds(316, 298, 97, 23);
		contentPane.add(ok);
	}
}
