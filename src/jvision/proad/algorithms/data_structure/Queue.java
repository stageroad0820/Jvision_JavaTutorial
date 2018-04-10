package jvision.proad.algorithms.data_structure;

import java.util.ArrayList;
import java.util.Scanner;

public class Queue {
	static ArrayList<Integer> list = new ArrayList<>();
	
	public void enQueue(int element) {
		list.add(element);
		System.out.println("현재 Queue 에 " + element + "[index=" + (getSize() - 1) + "] 값이 enqueue 되었습니다.");
	}
	
	public int deQueue() {
		int deq = list.get(0);
		System.out.println("현재 Queue 에서 " + deq + "[index=0] 값이 dequeue 되었습니다.");
		
		list.remove(0);
		return deq;
	}
	
	public int getSize() {
		return list.size();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue alg = new Queue();
		
		do {
			System.out.println("Queue 알고리즘 테스트 프로그램입니다. 원하시는 메뉴를 선택하세요.");
			System.out.println("1. Enqueue / 2. Dequeue / 3. View / 4. Exit");
			System.out.println("==========================================================");
			System.out.print("입력: ");
			int menu = sc.nextInt();
			
			switch (menu) {
			case 1:
				System.out.print("Queue 에 추가할 숫자를 입력하세요: ");
				int temp = sc.nextInt();
				
				alg.enQueue(temp);
				continue;
			case 2:
				if (alg.getSize() == 0) {
					System.out.println("현재 Queue 에 등록된 값이 없습니다! Enqueue 를 1번 이상 실행 한 다음 다시 시도해 주세요.");
				}
				else {
					System.out.println("현재 Queue 에서 Dequeue 한 값은 다음과 같습니다: " + alg.deQueue());
				}
				continue;
			case 3:
				if (alg.getSize() == 0) {
					System.out.println("현재 Queue 에 등록된 값이 없습니다.");
				}
				else {
					System.out.println("현재 Queue 에 등록된 값은 다음과 같으며 오른쪽으로 갈 수록 index 값이 큽니다.");
					for (int i = 0; i < alg.getSize(); i++) {
						System.out.print(list.get(i) + ", ");
					}
					System.out.println("");
				}
				continue;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
				continue;
			}
			break;
		} while (true);
	}
}
