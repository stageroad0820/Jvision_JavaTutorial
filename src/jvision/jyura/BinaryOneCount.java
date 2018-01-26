package jvision.jyura;

import java.util.Scanner;

public class BinaryOneCount {
	public static void main(String[] args) {
		// 사용자의 입력 값을 받기 위해 Scanner 객체 생성
		Scanner sc = new Scanner(System.in);
		
		// 반복문을 이용해 사용자의 입력 값을 반복해서 받기
		do {
			// 안내 메세지 출력
			System.out.println("0보다 큰 정수를 입력해 주세요.");
			
			// 입력 받은 수를 저장할 변수 생성
			int num = sc.nextInt();
			
			// 만약 입력 받은 수가 0보다 작은 정수일 경우 안내 메세지 출력 후 반복문 처음으로 이동
			if (num < 0) {
				System.out.println("0보다 작은 정수는 입력하실 수 없습니다! 0보다 큰 수를 입력해 주세요.");
				
				// 현재 반복문의 처음으로 되돌아가기
				continue;
			}
			// 입력 받은 수가 0 이상일 경우
			else {
				// 입력 받은 정수를 2진수로 변환하여 문자열 변수에 저장
				String bin = Integer.toBinaryString(num);
				
				// 변환된 2진수에 포함된 1의 개수를 확인하기 위해 임시 변수 생성
				int count = 0;
				
				// 반복문을 이용해 문자열에 저장된 2진수에 포함된 1의 개수 세기
				for (int i = 0; i < bin.length(); i++) {
					// 해당하는 문자열 인덱스에서 같은 문자가 있을 경우 if 문 실행
					if (bin.charAt(i) == '1') {
						// 개수 추가
						count++;
					}
				}
				
				// 결과 출력
				System.out.println("10진수 값: " + num);
				System.out.println("2진수 값: " + bin);
				System.out.println("위의 값에 포함된 1의 개수: " + count);
				
				// 반복문 끝내기
				break;
			}
			
		} while (true);
		
		// 사용한 자원 정리
		sc.close();
	}
}
