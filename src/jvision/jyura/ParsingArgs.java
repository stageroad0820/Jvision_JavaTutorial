package jvision.jyura;

public class ParsingArgs {
	public static void main(String[] args) {
		// 인자 값으로 받은 모든 수를 더한 값을 저장할 변수 생성
		int sum = 0;
		
		// 반복문을 이용해 인자로 받은 모든 값을 더해 총합 구하기
		for (int i = 0; i < args.length; i++) {
			// 문자열(String)을 32비트 정수형(int)로 변환해 주는 Integer 클래스의 메소드
			int num = Integer.parseInt(args[i]);
			
			// 복합 연산자를 이용해 위에서 변환한 값을 더하고 그 값으로 초기화 (+=)
			sum += num;
		}
		
		// 결과 출력
		System.out.println("sum = " + sum);
	}
}
