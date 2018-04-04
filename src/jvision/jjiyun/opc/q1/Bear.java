package jvision.jjiyun.opc.q1;

import java.util.Base64;
import java.util.Scanner;

public class Bear extends GameObject {
	private Scanner sc;
	
	public Bear(int startX, int startY, int distance) {
		super(startX, startY, distance);
		sc = new Scanner(System.in);
	}

	@Override
	public void move() {
		do {
			System.out.println("\n왼쪽(a), 아래(s), 위(d), 오른쪽(f) >> ");
			char select = sc.next().charAt(0);
			
			switch(select) {
			case 'a':
				x -= distance;
				if (x < 0) {
					x = 0;
				}
				break;
			case 's':
				y += distance;
				if (y > GameMain.MAX_Y - 1) {
					y = GameMain.MAX_Y - 1;
				}
				break;
			case 'd':
				y--;
				
				if (y < 0) {
					y = 0;
				}
				break;
			case 'f':
				x++;
				
				if (x > GameMain.MAX_X - 1) {
					x = GameMain.MAX_X - 1;
				}
				break;
			case '`':
				if (GameMain.isDebug) {
					GameMain.toggleDebug();
					continue;
				}
				else {
					System.out.println("[디버그] 디버그 모드 접근을 위한 코드를 입력하세요.");
					String code = sc.next();
					
					if (code.equals(Base64.getEncoder().encodeToString("Hello World!".getBytes()))) {
						GameMain.toggleDebug();
					}
					else {
						System.out.println("[디버그] 입력한 코드 " + code + " (은)는 일치하지 않는 코드입니다. 디버그 모드 변경을 취소합니다.");
					}
					
					continue;
				}
			case 'b':
				GameMain.getAllPos();
				continue;
			default:
				System.out.println("[오류!] 이동 명령어는 a, s, d, f 만 사용 가능합니다. 다시 입력해 주세요.");
				continue;
			}
			break;
		} while(true);
	}

	@Override
	public char getShape() {
		return 'B';
	}
	
	
}
