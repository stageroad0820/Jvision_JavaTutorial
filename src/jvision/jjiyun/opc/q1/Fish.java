package jvision.jjiyun.opc.q1;

public class Fish extends GameObject {
	public Fish(int startX, int startY, int distance) {
		super(startX, startY, distance);		
	}

	private final int MAX_MOVED = 1;
	private final int MAX_NOTMOVED = 2;
	
	@Override
	public void move() {
		
		if (GameMain.isContinued) {
			if (GameMain.isMove) {
				int direction = (int)(Math.random() * 4);
				
				switch(direction) {
				case 0:
					y--;
					
					if (y < 0) {
						y = 2;
					}
					break;
				case 1:
					y++;
					
					if (y > GameMain.MAX_Y) {
						y = GameMain.MAX_Y - 2;
					}
					break;
				case 2:
					x--;
					
					if (x < 0) {
						x = 2;
					}
					break;
				case 3:
					x++;
					
					if (x > GameMain.MAX_X) {
						x = GameMain.MAX_X - 2;
					}
					break;
				}
				
				if (GameMain.count != 0) {
					GameMain.count--;
					if (GameMain.isDebug) System.out.println("[디버그] Fish 가 강제로 " + direction + " 방향으로 이동하였습니다. " + GameMain.count + " 턴 남았습니다.");
				}
				else {
					setContinue(false, false);
					if (GameMain.isDebug) System.out.println("[디버그] Fish 의 강제 움직임이 종료되었습니다, 재귀 메소드 move() 가 실행되었습니다.");
					
					move();
				}
			}
			else {
				if (GameMain.count != 0) {
					GameMain.count--;
					if (GameMain.isDebug) System.out.println("[디버그] Fish 가 강제로 움직이지 않았습니다. " + (GameMain.count + 1) + " 턴 남았습니다.");
				}
				else {
					setContinue(false, false);
					if (GameMain.isDebug) System.out.println("[디버그] Fish 의 강제 멈추기가 종료되었습니다, 재귀 메소드 move() 가 실행되었습니다.");
					
					move();
				}
			}
		}
		else {
			int chance = (int)(Math.random() * 100);
			int direction = (int)(Math.random() * 4);
			
			if (chance < 40)  {
				if (GameMain.moved < this.MAX_MOVED) {
					switch(direction) {
					case 0:
						y--;
						
						if (y < 0) {
							y = 2;
						}
						break;
					case 1:
						y++;
						
						if (y > GameMain.MAX_Y - 1) {
							y = GameMain.MAX_Y - 2;
						}
						break;
					case 2:
						x--;
						
						if (x < 0) {
							x = 2;
						}
						break;
					case 3:
						x++;
						
						if (x > GameMain.MAX_X - 1) {
							x = GameMain.MAX_X - 2;
						}
						break;
					}
					
					GameMain.moved++;
					GameMain.notMoved = 0;
					
					if (GameMain.isDebug) System.out.println("[디버그] moved = " + GameMain.moved + ", notMoved = " + GameMain.notMoved);
					if (GameMain.isDebug) System.out.println("[디버그] Fish 가 " + direction + " 방향으로 움직였습니다. 2번 중 " + (2 - GameMain.moved) + " 번 남았습니다.");
				}
				else {
					GameMain.notMoved = 0;
					GameMain.count = GameMain.moved + 1;
					
					if (GameMain.isDebug) System.out.println("[디버그] moved = " + GameMain.moved + ", notMoved = " + GameMain.notMoved + ", count = " + GameMain.count);
					
					setContinue(true, false);
					
					if (GameMain.isDebug) System.out.println("[디버그] setContinue(true, false) 실행, 재귀 메소드 move() 실행.");
					
					move();
				}
			}
			else {
				if (GameMain.notMoved < this.MAX_NOTMOVED) {
					GameMain.notMoved++;
					GameMain.moved = 0;
					
					if (GameMain.isDebug) System.out.println("[디버그] moved = " + GameMain.moved + ", notMoved = " + GameMain.notMoved);
					if (GameMain.isDebug) System.out.println("[디버그] Fish 가 움직이지 않았습니다. 3번 중 " + (3 - GameMain.notMoved) + " 번 남았습니다.");
				}
				else {
					GameMain.moved = 0;
					GameMain.count = GameMain.notMoved;
					
					if (GameMain.isDebug) System.out.println("[디버그] moved = " + GameMain.moved + ", notMoved = " + GameMain.notMoved + ", count = " + GameMain.count);
					
					setContinue(true, true);
					
					if (GameMain.isDebug) System.out.println("[디버그] setContinue(true, true) 실행, 재귀 메소드 move() 실행");
					
					move();
				}
			}
		}
	}

	private void setContinue(boolean isContinue, boolean isMove) {
		GameMain.isContinued = isContinue;
		GameMain.isMove = isMove;
		
		String moving = "";
		
		if (GameMain.isDebug) moving = isMove ? "3번 연속 움직이지 않아" : "2번 연속 움직여";
		
		if (GameMain.isDebug) System.out.println("[디버그] Fish 가 " + moving + "서 setContinue(isContinue, isMove) 값이 각각 " + isContinue + ", " + isMove + " (으)로 변경되었습니다.");
		
		GameMain.moved = 0;
		GameMain.notMoved = 0;
		
		if (GameMain.isDebug) System.out.println("[디버그] 연속된 움직임으로 인해 moved 와 notMoved 변수를 각각 " + GameMain.moved + " 와 " + GameMain.notMoved + " (으)로 변경되었습니다.");
	}
	
	@Override
	public char getShape() {
		return 'F';
	}
}