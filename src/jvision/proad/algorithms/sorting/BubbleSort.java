package jvision.proad.algorithms.sorting;

import java.util.Scanner;

/*
 * > 공부하는 로드: 거품 정렬 (Bubble Sort)
 * 
 * > 작동 방식:
 * 1. 배열의 맨 오른쪽 끝에 저울을 두고 저울 좌우에 있는 숫자를 비교합니다.
 * 2. 만약 저울 왼쪽에 있는 숫자가 오른쪽에 있는 숫자보다 클 경우 좌우 숫자를 교체합니다.
 * 3. 비교를 완료했으면 저울을 한칸 왼쪽으로 이동합니다.
 * 4. 만약 저울 왼쪽에 있는 숫자가 오른쪽에 있는 숫자보다 작을 경우 교체하지 않습니다.
 * 5. 저울이 맨 왼쪽으로 왔다면 맨 왼쪽에 있는 숫자는 정렬이 끝났다고 간주하고 다시 처음부터 반복합니다.
 * 6. 위의 방법을 정렬이 끝날 때 까지 반복합니다.
 * 7. 모든 원소가 정렬되면 끝납니다.
 * 
 * > (기준: 원소 20개 * 10번) 평균 작동 시간: 프로그램 전체 8.5ms / 정렬 처리 0ms
 * 
 * [작동 방식 출처: 안드로이드 앱 "알고리즘 도감"]
 * [링크: https://play.google.com/store/apps/details?id=wiki.algorithm.algorithms]
 */
public class BubbleSort {
	static int[] arr;
	static boolean isDebug = false;
	static long process = 0L;
	
	public BubbleSort(int size) {
		if (isDebug) System.out.println("[디버그] 생성자 BubbleSort(int size) 호출.");
		
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
	
	public int[] sorting(int[] source) {
		if (isDebug) System.out.println("[디버그] 메소드 sorting(int[] source) 시작.");
		
		long start_algorithm = System.currentTimeMillis();
		
		int left, right, temp;
		int size = source.length;
		int count = 0;
		int[] sorted = new int[source.length];
		
		for (int i = 0; i < source.length; i++) {
			sorted[i] = source[i];
		}
		
		while (count <= size) {
			if (isDebug) System.out.println("[디버그] count=" + count + ", size=" + size);
			
			for (int i = (size - 1); i >= 0; i--) {
				right = sorted[i];
				
				if (i != 0) {
					left = sorted[i-1];
					
					if (left > right) {
						temp = left;
						left = right;
						right = temp;
						
						sorted[i] = right;
						sorted[(i-1)] = left;
						
						if (isDebug) System.out.println("[디버그] sorted[" + i + "]=" + right + " 와 sorted[" + (i - 1) + "]=" + left + " (을)를 서로 바꿨습니다.");
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
		
		if (isDebug) System.out.println("\n[디버그] Alg_Start: " + start_algorithm + " / Alg_Stop: " + stop_algorithm + " / Alg_Time: " + (stop_algorithm - start_algorithm));
		
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
		
		if (isDebug) System.out.println("\n[디버그] Prg_Start: " + prc_start + " / Prg_Stop: " + prc_stop + " / Prg_Time: " + (prc_stop - prc_start));
		
		System.out.println("\n정렬 알고리즘 처리 시간: " + BubbleSort.getProcessTime() + " ms");
		System.out.println("프로그램 처리 시간: " + (prc_stop - prc_start) + " ms");
	}
}
