package jvision.jjiyun.opc.q1;

public class GameMain {
	public static final int MAX_X = 10;
	public static final int MAX_Y = 20;
	
	public static int moved = 0;
	public static int notMoved = 0;
	public static int count = 0;
	
	public static boolean isContinued = false;
	public static boolean isMove = false;
	public static boolean isDebug = false; // 디버깅 용도; true 로 바꿀 경우 Fish 의 디버그 메세지 표시 및 디버그용 선택지 'b' 사용 가능
	
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
	
	public static void getAllPos() {
		if (isDebug) {
			System.out.println("GameMain.MAX_X = " + GameMain.MAX_X + ", Bear_X = " + player[0].getX() + ", Fish_X = " + player[1].getX());
			System.out.println("GameMain.MAX_Y = " + GameMain.MAX_Y + ", Bear_Y = " + player[0].getY() + ", Fish_Y = " + player[1].getY());
		}
		else {
			System.out.println("[오류!] 이동 명령어는 a, s, d, f 만 사용 가능합니다. 다시 입력해 주세요.");
		}
	}
	
	public static void toggleDebug() {
		if (isDebug) {
			isDebug = false;
			System.out.println("[디버그] 디버그 모드가 종료되었습니다. 더이상 디버그 메세지가 표시되지 않습니다.");
		}
		else {
			isDebug = true;
			System.out.println("[디버그] 디버그 모드가 실행되었습니다. Fish 에 관해 디버그 메세지가 표시되며 모드를 종료하시려면 똑같은 명령어를 다시 입력해 주세요.");
		}
	}
	
	public static void main(String[] args) {
		GameMain game = new GameMain();
		game.onStart();
	}
}
