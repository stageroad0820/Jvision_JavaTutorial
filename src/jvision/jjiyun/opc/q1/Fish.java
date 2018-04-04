package jvision.jjiyun.opc.q1;

public class Fish extends GameObject {
	public Fish(int startX, int startY, int distance) {
		super(startX, startY, distance);		
	}

	private boolean isContinued = false;
	private boolean isMove = true;

	@Override
	public void move() {
		int moved = 0;
		int notMoved = 0;
		
		if (isContinued) {
			if (isMove) {
				
			}
			else {
				
			}
		}
		else {
			int chance = (int)(Math.random() * 100);
			int direction = (int)(Math.random() * 4);
			
			if (chance < 40)  {
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
				
				if (moved < 3) {
					moved++;
					notMoved = 0;
				}
				else {
					notMoved = 0;
					setContinue(true, false);
				}
			}
			else {
				if (notMoved < 2) {
					notMoved++;
					moved = 0;
				}
				else {
					moved = 0;
					setContinue(true, true);
				}
			}
		}
	}

	private void setContinue(boolean isContinue, boolean isMove) {
		this.isContinued = isContinue;
		this.isMove = isMove;
	}
	
	@Override
	public char getShape() {
		return 'F';
	}
}