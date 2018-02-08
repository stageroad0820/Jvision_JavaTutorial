package jvision.jyura;

public class Game369 {
	public static void main(String[] args) {
		// 반복문 실행
		for (int i = 1; i < 100; i++) {
			// 문자열 클래스를 이용해 문자를 비교하기 위해 숫자를 문자열로 변환
			String number = String.valueOf(i);
			
			// 문자열에 3, 6, 9 가 포함되어 있는지 확인
			if (number.contains("3") || number.contains("6") || number.contains("9")) {
				// 문자열의 길이가 1일 경우 = 1의 자리
				if (number.length() == 1) {
					System.out.println(i + " 박수 한번");
				}
				// 문자열의 길이가 2일 경우 = 10의 자리
				else if (number.length() == 2) {
					// 10의 자리에 3, 6, 9 가 포함되는지 확인
					if (number.substring(0, 1).equals("3")|| number.substring(0, 1).equals("6")|| number.substring(0, 1).equals("9")) {
						// 1의 자리에 3, 6, 9 가 포함되는지 확인
						if (number.substring(1, 2).equals("3")|| number.substring(1, 2).equals("6")|| number.substring(1, 2).equals("9")) {
							// 다 포함될 경우 박수 두번
							System.out.println(i + " 박수 두번");
						}
					}
					else {
						// 포함되지 않을 경우 박수 한번
						System.out.println(i + " 박수 한번");
					}
				}
			}
		}
	}
}
