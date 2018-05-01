package jvision.proad.algorithms.searching;

import java.util.Scanner;

@SuppressWarnings("unused")
public class LinearSearch {
	static int[] arr;
	static boolean isDebug = false;
	static long process = 0L;
	
	public LinearSearch(int size) {
		if (isDebug) System.out.println("[디버그] 생성자 LinearSearch(int size) 호출.");
		
		arr = new int[size];
		
		for (int i = 0; i < size; i++) {
			int random = (int)(Math.random() * 100) + 1;
			arr[i] = random;
			
			for (int j = 0; j < i; j++) {
				if(arr[i] == arr[j]) {
					i--;
					break;
				}
			}
		}
		
		if (isDebug) {
			System.out.print("[디버그] 초기화 값: ");
			for (int i = 0; i < size; i++) {
				System.out.print(arr[i] + ", ");
			}
			
			System.out.println("\n[디버그] arr 배열 초기화 완료.");
		}
	}
	
	public int searching(int[] source, String type) {
		
		return 0;
	}
	
	public static void onStart(int size, String type) {
		LinearSearch alg = new LinearSearch(size);
	}
	
	private void setProcess(long time) {
		LinearSearch.process = time;
	}
	
	private long getProcess() {
		return LinearSearch.process;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("검색할 숫자 종류를 선택하세요.");
			System.out.println("[1. 최솟값][2. 최댓값][3.특정값][4.끝내기]");
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				System.out.println("랜덤으로 생성된 배열에서 '최솟값' 을 찾습니다.");
				System.out.println("선형 탐색을 실행할 배열의 크기를 입력해 주세요.");
				int size = sc.nextInt();
				
				long prg_start = System.currentTimeMillis();
				
//				LinearSearch.onStart(size);
				
				long prg_stop = System.currentTimeMillis();
				long prg_time = (prg_stop - prg_start);
				
				if (isDebug) System.out.println("\n[디버그] Prg_Start: " + prg_start + ", Prg_Stop: " + prg_stop + ", Prg_Time: " + prg_time);
				System.out.println("\n탐색 알고리즘 처리 시간: ");
				System.out.println("프로그램 처리 시간: ");
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
				continue;
			}
		} while(true);
	}
}
