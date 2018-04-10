package jvision.proad.algorithms.data_structure;

import java.util.ArrayList;
import java.util.Scanner;

public class Stack {
	static ArrayList<Integer> stack = new ArrayList<>();
	
	public void push(int element) {
		stack.add(element);
		System.out.println("Stack 에 " + element + " 값이 push 되었습니다.");
	}
	
	public int pop() {
		int pop = stack.get((getSize() - 1));
		System.out.println("Stack 에서 " + pop + " [index=" + (getSize() - 1) + "] 값이 pop 되었습니다.");
		
		stack.remove((getSize() - 1));
		
		return pop;
	}
	
	public int getSize() {
		return stack.size();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack alg = new Stack();
		
		do {
			System.out.println("Stack 알고리즘 테스트 프로그램 입니다. 원하시는 메뉴를 선택하세요.");
			System.out.println("1. Push / 2. Pop / 3. View / 4. Exit");
			System.out.println("==================================================================");
			System.out.print("입력: ");
			
			int menu = sc.nextInt();
			
			switch (menu) {
			case 1:
				System.out.print("Stack 에 push 할 숫자를 입력해 주세요: ");
				int temp = sc.nextInt();
				
				alg.push(temp);
				continue;
			case 2:
				if (alg.getSize() == 0) {
					System.out.println("현재 Stack 에 쌓여있는 값이 없습니다! Push 를 1번 이상 진행한 다음 다시 실행해 주세요.");
				}
				else {
					System.out.println("Stack 에서 Pop 한 값은 다음과 같습니다: " + alg.pop());
				}
				continue;
			case 3:
				if (alg.getSize() == 0) {
					System.out.println("현재 Stack 에 쌓여있는 값이 없습니다.");
				}
				else {
					System.out.println("현재 Stack 에 있는 값은 다음과 같으며 오른쪽으로 갈 수록 index 값이 큽니다.");
					
					for (int i = 0; i < alg.getSize(); i++) {
						System.out.print(stack.get(i) + ", ");
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
