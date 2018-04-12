package jvision.proad.algorithms.sorting;

public class SelectionSort {
	static int[] arr;
	static boolean isDebug = false;
	
	public SelectionSort(int size) {
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
	}
	
	public static void onStart(int size) {
		
	}
	
	public static void main(String[] args) {
		
	}
}
