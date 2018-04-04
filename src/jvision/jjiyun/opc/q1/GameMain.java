package jvision.jjiyun.opc.q1;

public class GameMain {
	public static final int MAX_X = 10;
	public static final int MAX_Y = 20;
	
	public static int moved = 0;
	public static int notMoved = 0;
	public static int count = 0;
	
	public static boolean isContinued = false;
	public static boolean isMove = false;
	
	private static GameObject[] player = new GameObject[2];
	private char map[][] = new char[MAX_X][MAX_Y];
	
	public GameMain() {
		for (int i = 0; i < MAX_X; i++) {
			for (int j = 0; j < MAX_Y; j++) {
				map[i][j] = '-';
			}
		}
		
		player[0] = new Bear(0, 0, 1);
		player[1] = new Fish(5, 5, 2);
	}
	
	public void onStart() {
		System.out.println("** Bear 의 Fish 먹기 게임을 시작합니다. **");
		
		loadMap();
		
		while (!isGameOver()) {
			for (int i = (player.length - 1); i >= 0; i--) {
				player[i].move();
			}
			
			loadMap();
		}
		
		System.out.println("Bear 가 Fish 를 먹었습니다. Player 가 승리했습니다!");
	}
	
	public void loadMap() {
		for (int i = 0; i < MAX_X; i++) {
			for (int j = 0; j < MAX_Y; j++) {
				map[i][j] = '-';
			}
		}
		
		for (int i = (player.length - 1); i >= 0; i--) {
			map[player[i].getX()][player[i].getY()] = player[i].getShape();
		}
		
		System.out.println();
		for (int j = 0; j < MAX_Y; j++) {
			for (int i = 0; i < MAX_X; i++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public boolean isGameOver() {
		if (player[0].collide(player[1])) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		GameMain game = new GameMain();
		game.onStart();
	}
}
