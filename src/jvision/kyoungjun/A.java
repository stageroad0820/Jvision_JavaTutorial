package jvision.kyoungjun;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class A extends JFrame {
	public A() {
		setTitle("201718038-김영준");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
 
		JLabel stuId = new JLabel("학번");
		JTextField stuIdTf = new JTextField();
		stuId.setBounds(30, 30, 50, 30);
		stuIdTf.setBounds(90, 30, 100, 30);
		
		JLabel name = new JLabel("이름");
		JTextField nameTf = new JTextField();
		name.setBounds(290, 30, 50, 30); 
		nameTf.setBounds(350, 30, 100, 30);
		
		TitledBorder title1 = new TitledBorder("학년");
		JRadioButton rb1 = new JRadioButton("1학년", true);
		JRadioButton rb2 = new JRadioButton("2학년");
		JRadioButton rb3 = new JRadioButton("3학년");
		JRadioButton rb4 = new JRadioButton("4학년");
		
		JPanel pan1 = new JPanel(new GridLayout(4, 1));
		JPanel pan2 = new JPanel(new GridLayout(2, 1));
		JPanel pan3 = new JPanel(new GridLayout(5, 1));
		
		TitledBorder title2 = new TitledBorder("성별");
		JRadioButton rb5 = new JRadioButton("여자");
		JRadioButton rb6 = new JRadioButton("남자");
		
		TitledBorder title3 = new TitledBorder("취미");
		JCheckBox cb1 = new JCheckBox("독서");
		JCheckBox cb2 = new JCheckBox("영화감상");
		JCheckBox cb3 = new JCheckBox("TV시청");
		JCheckBox cb4 = new JCheckBox("운동");
		JCheckBox cb5 = new JCheckBox("공부");
		
		
		pan1.add(rb1);
		pan1.add(rb2);
		pan1.add(rb3);
		pan1.add(rb4);
		pan1.setBorder(title1);
		pan1.setBounds(30, 90, 100, 200);
 
		
		pan2.add(rb5);
		pan2.add(rb6);
		pan2.setBorder(title2);
		pan2.setBounds(140, 90, 100, 100);
 
		
		pan3.add(cb1);
		pan3.add(cb2);
		pan3.add(cb3);
		pan3.add(cb4);
		pan3.add(cb5);
		pan3.setBorder(title3);
		pan3.setBounds(250, 90, 100, 200);
 
		JComboBox<String> combox = new JComboBox<>(new String[] {"학교", "비전대", "전북대", "전주대", "우석대", "원광대"});
		combox.setBounds(360, 90, 100, 25);
 
		JButton ok = new JButton("확인");
		JButton cencle = new JButton("취소");
		ok.setBounds(30, 300, 100, 25);
		cencle.setBounds(140, 300, 100, 25);
		
		
		add(stuId);
		add(stuIdTf);
		add(name);
		add(nameTf);
		add(pan1);
		add(pan2);
		add(pan3);
		add(combox);
		add(ok);
		add(cencle);
 
		setSize(500, 400);
		setVisible(true);
	}
 
	public static void main(String[] args) {
		new A();
	}
}
