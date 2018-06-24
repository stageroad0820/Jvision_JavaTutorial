package jvision.proad.algorithms.sorting;

import java.util.Scanner;

/*
 * > 공부하는 로드: 선택 정렬 (Selection Sort)
 * 
 * > 작동 방식:
 * 1. 정렬할 배열의 모든 원소를 "선형 탐색" 하여 최솟값을 찾습니다.
 * 2. 검색된 최솟값을 배열의 맨 왼쪽의 원소와 교체합니다. 만약 최솟값이 맨 왼쪽에 있다면 아무 작업도 하지 않습니다.
 * 3. 왼쪽으로 옮겨진 원소는 정렬이 끝났다고 판단합니다.
 * (이때 맨 왼쪽을 의미하는 index=0 을 하나씩 올립니다.)
 * 4. 모든 원소가 정렬될 때 까지 위의 작업을 반복합니다.
 * 5. 모든 원소가 정렬되면 끝납니다.
 * 
 * > 평균 작동 시간: 프로그램 전체 ms / 정렬 처리 ms
 * 
 * [작동 방식 출처: 안드로이드 앱 "알고리즘 도감"]
 * [링크: https://play.google.com/store/apps/details?id=wiki.algorithm.algorithms]
 */

public class SelectionSort {
	static int[] arr;
	static boolean isDebug = true;
	static long process = 0L;
	
	public SelectionSort(int size) {
		if (isDebug) System.out.println("[디버그] 생성자 SelectionSort(int size) 호출.");
		
		arr = new int[size];
		
		for (int i = 0; i < size; i++) {
			int random = (int)((Math.random() * 100) + 1);
			
			arr[i] = random;
			
			for (int j = 0; j < i; j++) {
				if (arr[i] == arr[j]) {
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
		if (isDebug) System.out.println("[디버그] 메소드 sorting(int[] sorce) 시작.");
		
		int size = source.length;
		int[] sorted = new int[size];
		
		long alg_start = System.currentTimeMillis();
		
		for (int i = 0; i < size; i++) {
			sorted[i] = source[i];
		}
		
		int count = 0;
		int ind_point = 0, prev_point = 0;;
		int val_min = source[count];
		int val_point = 0;;
		
		do {
			for (int i = count; i < size; i++) {
				if (isDebug) System.out.println("[디버그] val_min = " + val_min + " (와)과 sorted[" + i + "] = " + sorted[i] + " 비교. 결과: " + (val_min > sorted[i]));
				
				if (val_min > sorted[i]) {
					val_point = val_min;
					prev_point = ind_point;
					ind_point = i;
					val_min = sorted[i];
					
					if (isDebug) System.out.println("[디버그] 교체 완료 >> val_min = " + val_min + ", count = " + count + ", val_point = " + val_point + ", ind_point = " + ind_point + ", prev_point = " + prev_point);
				}
			}
			
			sorted[count] = val_min;
			sorted[ind_point] = val_point;
			
			count++;
			
			ind_point = 0;
			prev_point = 0;
			
			if (count < 19) {
				val_min = source[count + 1];
			}
			else {
				val_min = source[count];
			}
			
			val_point = 0;
			
			if (isDebug) {
				System.out.println("[디버그] count = " + count + ", size = " + size);
				System.out.println("[디버그] ind_point = " + ind_point + ", prev_point = " + prev_point + ", val_min = " + val_min + ", val_point = " + val_point);
			}
		} while (count < size);
		
		long alg_stop = System.currentTimeMillis();
		long alg_time = (alg_stop - alg_start);
		
		SelectionSort.setProcessTime(alg_time);
		
		if (isDebug) System.out.println("[디버그] Alg_Start: " + alg_start + " / Alg_Stop: " + alg_stop + " / Alg_Time: " + alg_time + "ms");
		
		return sorted;
	}
	
	public static void onStart(int size) {
		SelectionSort alg = new SelectionSort(size);
		int[] sorted = alg.sorting(arr);
		
		System.out.print("\n정렬 전: ");
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		
		System.out.print("\n정렬 후: ");
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(sorted[i] + ", ");
		}
		
		System.out.println("");
	}
	
	private static void setProcessTime(long time) {
		SelectionSort.process = time;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("선택 정렬을 실행할 배열의 크기를 입력해 주세요.");
		int size = sc.nextInt();
		
		long prc_start = System.currentTimeMillis();
		
		SelectionSort.onStart(size);
		sc.close();
		
		long prc_stop = System.currentTimeMillis();
		long prc_time = (prc_stop - prc_start);
		
		if (isDebug) System.out.println("\n[디버그] Prc_Start: " + prc_start + " / Prc_Stop: " + prc_stop + " / Prc_Time: " + prc_time + "ms");
		
		System.out.println("\n정렬 알고리즘 시간: " + " ms");
		System.out.println("프로그램 처리 시간: " + prc_time + " ms");
	}
}
