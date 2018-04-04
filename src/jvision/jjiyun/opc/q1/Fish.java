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
				}
				else {
					setContinue(false, false);
					move();
				}
			}
			else {
				if (GameMain.count != 0) {
					GameMain.count--;
				}
				else {
					setContinue(false, false);
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
				}
				else {
					GameMain.notMoved = 0;
					GameMain.count = GameMain.moved + 1;
					
					setContinue(true, false);
					move();
				}
			}
			else {
				if (GameMain.notMoved < this.MAX_NOTMOVED) {
					GameMain.notMoved++;
					GameMain.moved = 0;
				}
				else {
					GameMain.moved = 0;
					GameMain.count = GameMain.notMoved;
					
					setContinue(true, true);
					move();
				}
			}
		}
	}

	private void setContinue(boolean isContinue, boolean isMove) {
		GameMain.isContinued = isContinue;
		GameMain.isMove = isMove;
		
		GameMain.moved = 0;
		GameMain.notMoved = 0;
	}
	
	@Override
	public char getShape() {
		return 'F';
	}
}