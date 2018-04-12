package jvision.proad.algorithms.sorting;

import java.util.Scanner;

public class BubbleSort {
	static int[] arr;
	static boolean isDebug = false;
	static long process = 0L;
	
	public BubbleSort(int size) {
		if (isDebug) System.out.println("[디버그] 생성자 BubbleSort(int size) 호출.");
		
		arr = new int[size];
		
		// 중복을 포함하지 않는 1~100 까지의 무작위 수를 생성하여 배열에 차례대로 입력
		for (int i = 0; i < size; i++) {
			int random = (int)(Math.random() * 100) + 1;
			arr[i] = random;
			
			// 배열 내의 중복 값 확인
			for (int j = 0; j < i; j++) {
				// 중복되는 값이 있을 경우 해당 값에 새로운 값을 덮어 씌우기 위해 i 를 1 줄이고 입력 실행
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
	
	/*
	 * < BubbleSort 의 정렬 방식 >
	 * 1. 맨 오른쪽 끝 숫자와 그 숫자의 왼쪽 숫자에 저울을 두어 비교 시작
	 * 2. 왼쪽에 있는 숫자가 오른쪽에 있는 숫자보다 클 경우 서로의 자리를 바꿈
	 * 3. 자리가 바뀌는 것이 없을 때 까지 계속 반복
	 */
	public int[] sorting(int[] source) {
		if (isDebug) System.out.println("[디버그] 메소드 sorting(int[] source) start.");
		
		long start_algorithm = System.currentTimeMillis();
		
		int left, right, temp;
		int size = source.length;
		int count = 0;
		int[] sorted = new int[source.length];
		
		// 배열 복사
		for (int i = 0; i < source.length; i++) {
			sorted[i] = source[i];
		}
		
		// 배열의 크기만큼 계속 반복문 실행
		while (count <= size) {
			if (isDebug) System.out.println("[디버그] count=" + count + ", size=" + size);
			
			// 배열의 오른쪽 끝 부터 비교 시작
			for (int i = (size - 1); i >= 0; i--) {
				// 2개의 비교 대상 중 i 에 있는 원소를 right 에, i != 0 일 경우 (i-1) 에 있는 원소를 left 에 옮기고, i == 0 일 경우 종료
				right = sorted[i];
				
				if (i != 0) {
					left = sorted[i-1];
					
					// 왼쪽에 있는 숫자가 오른쪽에 있는 숫자보다 클 경우 양쪽 자리 바꾸기 (졍렬 방식 2.)
					if (left > right) {
						temp = left;
						left = right;
						right = temp;
						
						sorted[i] = right;
						sorted[(i-1)] = left;
						
						if (isDebug) System.out.println("[디버그] move sorted[" + i + "]=" + right + " and sorted[" + (i - 1) + "]=" + left);
					}
				}
				else {
					break;
				}
			}
			
			count++;
		}
		
		if (isDebug) System.out.println("[디버그] 메소드 sorting(int[] source) 종료,");
		
		long stop_algorithm = System.currentTimeMillis();
		this.setProcessTime((stop_algorithm - start_algorithm));
		
		if (isDebug) System.out.println("\nPrc_Start: " + start_algorithm + " / Prc_Stop: " + stop_algorithm + " / Prc_Time: " + (stop_algorithm - start_algorithm));
		
		return sorted;
	}
	
	public static void onStart(int size) {
		BubbleSort alg = new BubbleSort(size);
		int[] sorted = alg.sorting(arr);
		
		System.out.print("\n정렬 전: ");
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		
		System.out.println("");
		System.out.print("정렬 후: ");
		
		for (int i = 0; i < sorted.length; i++) {
			System.out.print(sorted[i] + ", ");
		}
		
		System.out.println("");
	}
	
	private void setProcessTime(long time) {
		BubbleSort.process = time;
	}
	
	private static long getProcessTime() {
		return BubbleSort.process;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("버블 정렬을 실행할 배열의 크기를 입력해 주세요: ");
		int size = sc.nextInt();
		
		long prc_start = System.currentTimeMillis();
		
		BubbleSort.onStart(size);
		sc.close();
		
		long prc_stop = System.currentTimeMillis();
		
		if (isDebug) System.out.println("\nPrg_Start: " + prc_start + " / Prg_Stop: " + prc_stop + " / Prg_Time: " + (prc_stop - prc_start));
		
		System.out.println("\n정렬 알고리즘 처리 시간: " + BubbleSort.getProcessTime() + " ms");
		System.out.println("프로그램 처리 시간: " + (prc_stop - prc_start) + " ms");
	}
}
