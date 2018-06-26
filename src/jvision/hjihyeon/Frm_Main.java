package jvision.hjihyeon;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Frm_Main extends JFrame {
	private JPanel contentPane;
	private JTextField tbox_mile;
	private JLabel txt_result;
	private JTextField tbox_result;
	private JLabel txt_mile;
	private JLabel txt_km;

	// 메인 메소드
	public static void main(String[] args) {
		// [WindowBuilder 자동 생성 - 하위 포함] EventQueue(이벤트 큐)를 통해 이벤트들이 순차적으로 실행되도록 설정
		EventQueue.invokeLater(new Runnable() {
			// Runnable 클래스는 무조건 run() 메소드를 먼저 실행하도록 설정되어 있음
			public void run() {
				// try 내부 구문 실행
				try {
					// 인스턴스를 생성하여 클래스 초기화(Initialize)
					System.out.println("[디버그] 프로그램이 실행되었습니다. 초기화를 시작합니다.");
					Frm_Main frame = new Frm_Main();
					
					// 인스턴스의 화면이 보이도록 설정
					System.out.println("[디버그] 프로그램 화면이 보이도록 설정되었습니다. (setVisible=true)");
					frame.setVisible(true);
				}
				// try 내부 구문 실행 중예외가 발생했을 경우 catch 를 실행
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// 클래스 생성자
	public Frm_Main() {
		// 창의 기본 설정: [닫기] 버튼 클릭 시 프로그램이 종료되도록 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 창의 기본 설정: 프로그램의 해상도는 400x170 이고, 프로그램 시작점은 x:100, y:100 에서 실행
		setBounds(100, 100, 400, 170);
		// 창의 기본 설정: 프로그램의 제목은 "단위 변환기: 마일 > 킬로미터" 로 설정
		setTitle("단위 변환기: 마일 > 킬로미터");
		
		// 컨텐츠판에 패널 추가
		contentPane = new JPanel();
		// 판의 가장자리를 "가장자리 없이 사방으로 5만큼 떨어진 곳" 에 생성
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// 프로그램의 컨텐츠판 설정
		setContentPane(contentPane);
		// 판의 레이아웃을 "절대 좌표 레이아웃 (Absolute Layout; null)" 으로 설정
		contentPane.setLayout(null);
		
		// 기본적인 텍스트 레이블 생성
		JLabel txt_info = new JLabel("단위를 환산할 거리를 \"마일\" 단위로 입력해 주세요:");
		// 텍스트 레이블의 위치 지정
		txt_info.setBounds(12, 10, 360, 15);
		// 컨텐츠판에 추가
		contentPane.add(txt_info);
		
		// 이하 텍스트 레이블과 동일
		tbox_mile = new JTextField();
		tbox_mile.setBounds(12, 35, 170, 21);
		contentPane.add(tbox_mile);
		// 가로 길이 설정
		tbox_mile.setColumns(10);
		
		txt_result = new JLabel("환산한 결과는 다음과 같습니다:");
		txt_result.setBounds(12, 66, 360, 15);
		contentPane.add(txt_result);
		
		tbox_result = new JTextField();
		// 해당 텍스트 상자를 수정할 수 없도록 설정
		tbox_result.setEditable(false);
		tbox_result.setBounds(12, 91, 170, 21);
		contentPane.add(tbox_result);
		tbox_result.setColumns(10);
		
		txt_mile = new JLabel("mile");
		txt_mile.setBounds(194, 38, 57, 15);
		contentPane.add(txt_mile);
		
		txt_km = new JLabel("km");
		txt_km.setBounds(194, 94, 57, 15);
		contentPane.add(txt_km);
		
		JButton btn_confirm = new JButton("변환");
		btn_confirm.setBounds(275, 90, 97, 23);
		// 버튼을 클릭할 시 실행할 이벤트 등록
		btn_confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * 입력한 문자열에 대한 필터링 실행
				 * ^: 문자열의 시작
				 * [0-9]: 0~9 까지의 숫자
				 * +: 앞 문자 (여기서는 [0-9])가 1개 이상
				 * $: 문자열의 끝
				 * 
				 * 따라서 숫자만 입력할 수 있도록 설정
				 */
				if (tbox_mile.getText().matches("^[0-9]+$")) {
					// String 값을 반환하는 텍스트 상자의 내용을 int 로 변환하고 소수점 계산을 위해 double 로 형변환
					double mile = (double) Integer.parseInt(tbox_mile.getText());
					// 마일 단위를 킬로미터 단위로 변환
					double result = mile * 1.6;
					
					// 변환된 값을 텍스트 박스에 등록
					tbox_result.setText(result + "");
					System.out.println("[디버그] " + tbox_mile.getText() + " 마일의 값이 " + result + " 킬로미터로 환산되어 출력되었습니다.");
				}
				// 숫자가 입력되지 않았을 경우 경고창을 띄워 숫자만 입력할 수 있도록 유도
				else {
					// 경고창 생성
					System.out.println("[디버그] 숫자가 아닌 다른 내용이 입력되었습니다. 입력 내용: " + tbox_mile.getText());
					JOptionPane.showMessageDialog(null, "텍스트 상자에는 숫자만 입력할 수 있습니다. 다시 입력해 주세요.", "잘못된 데이터 입력", JOptionPane.ERROR_MESSAGE);
					
					// 텍스트 상자 초기화
					tbox_mile.setText("");
				}
			}
		});
		contentPane.add(btn_confirm);
	}
}
