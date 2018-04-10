package jvision.proad.algorithms.sorting;

public class BubbleSort {
	static int[] notSort;
	
	public BubbleSort(int size) {
		notSort = new int[size];
		
		for (int i = 0; i < size; i++) {
			int random = (int)(Math.random() * 100);
			
			notSort[i] = random;
		}
		
		System.out.println("배열 초기화 완료.");
	}
	
	public int[] sorting(int[] src) {
		int[] sorted = new int[src.length];
		int left, right, temp;
		int count = 1;
		int size = sorted.length;
		
		do {
			for (int i = 1; i < size; i++) {
				left = src[src.length - (i + 1)];
				right = src[src.length - i];
				
				if (left > right) {
					temp = right;
					right = left;
					left = temp;
					
					sorted[src.length - (i + 1)] = left;
					sorted[src.length - i] = right;
				}
				else {
					continue;
				}
			}
			
			count++;
		} while (count < size);
		
		return sorted;
	}
	
	public static void main(String[] args) {
		int size = 20;
		int arr[];
		
		BubbleSort alg = new BubbleSort(size);
		arr = alg.sorting(notSort);
		
		System.out.print("정렬 전: ");
		
		for (int i = 0; i < size; i++) {
			System.out.print(notSort[i] + ", ");
		}
		
		System.out.println("");
		
		System.out.print("정렬 후: ");
		
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + ", ");
		}
	}
}
