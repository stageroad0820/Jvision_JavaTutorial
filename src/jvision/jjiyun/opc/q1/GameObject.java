package jvision.jjiyun.opc.q1;

public abstract class GameObject {
	protected int distance;
	protected int x, y;
	
	public GameObject(int startX, int startY, int distance) {
		this.x = startX;
		this.y = startY;
		this.distance = distance;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean collide(GameObject p) {
		if (this.x == p.getX() && this.y == p.getY()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public abstract void move();
	public abstract char getShape();
}
