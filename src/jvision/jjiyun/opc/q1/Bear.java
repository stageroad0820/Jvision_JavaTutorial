package jvision.jjiyun.opc.q1;

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
			System.out.println("왼쪽(a), 아래(s), 위(d), 오른쪽(f) >> ");
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
				if (y > GameMain.MAX_Y) {
					y = GameMain.MAX_Y;
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
				
				if (x > GameMain.MAX_X) {
					x = GameMain.MAX_X;
				}
				break;
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
