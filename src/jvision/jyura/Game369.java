package jvision.jyura;

public class Game369 {
	public static void main(String[] args) {
		// 반복문 실행
		for (int i = 1; i < 100; i++) {
			// i 를 10 으로 나눈 나머지가 각각 3, 6, 9 일 경우
			if (i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
				// i 를 10으로 나눈 몫이 각각 3, 6, 9 일 경우
				if (i / 10 == 3 || i / 10 == 6 || i / 10 == 9) {
					// 출력
					System.out.println(i + " 박수 두번");
				}
				// 아닐 경우
				else {
					// 출력
					System.out.println(i + " 박수 한번");
				}
			}
		}
	}
}
