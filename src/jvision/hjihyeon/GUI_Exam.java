package jvision.hjihyeon;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GUI_Exam
  extends JFrame
{
  public GUI_Exam()
  {
    setTitle("마일을 킬로미터로 변환");
    setDefaultCloseOperation(3);
    Container c = getContentPane();
    c.setLayout(new FlowLayout());
    
    JLabel m1 = new JLabel("거리를 마일 단위로 입력하시오");
    JTextField m2 = new JTextField(8);
    JButton m3 = new JButton("   변환    ");
    JTextField m4 = new JTextField(20);
    
    c.add(m1);
    c.add(m2);
    c.add(m3);
    c.add(m4);
    
    setSize(310, 180);
    setVisible(true);
  }
  
  public static void main(String[] args)
  {
    new GUI_Exam();
  }
}
