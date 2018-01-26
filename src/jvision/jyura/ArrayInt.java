package jvision.jyura;

public class ArrayInt {
	// 메인 메소드
	public static void main(String[] args) {
		// 인스턴스 객체 생성
		ArrayInt inst = new ArrayInt();
		
		// 메소드 테스트를 위해 임시 2차원 배열 생성
		int[][] arr = new int[5][5];
		
		// 디버그용 메세지
		System.out.print("배열에 입력된 값: ");
		
		// 메소드 테스트를 위해 생성한 2차원 배열의 모든 원소를 무작위 값으로 초기화
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				// 2차원 배열 초기화 (랜덤 값은 1~50 까지의 수 중 호출 될 때 마다 다른 수를 해당 배열에 입력)
				arr[i][j] = (int)(Math.random() * 50 + 1);
				
				// 디버그를 위해 배열에 저장되는 모든 값을 "한 줄" 로 출력하기
				System.out.print(arr[i][j] + ", ");
			}
		}
		
		// 디버그용 메세지
		System.out.print("\n");
		
		// 결과 출력
		System.out.println("배열 내 모든 원소의 합: " + inst.sumArrays(arr));
		
	}
	
	// 2차원 배열의 모든 원소의 합을 구하여 리턴하는 메소드
	public int sumArrays(int[][] arr) {
		// 합을 저장하는 변수
		int total = 0;
		
		// 합을 구하는 중첩 반복문
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				// 복합 연산자를 이용해 인자로 받은 배열의 값을 바로 더하고 그 값으로 초기화 (+=)
				total += arr[i][j];
			}
		}
		
		// 구한 값을 리턴
		return total;
	}
}
