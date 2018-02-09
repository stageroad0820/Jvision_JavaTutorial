package jvision.ghowon;

import java.util.Scanner;

class PhoneInfo {
	String name, phone, birth;
	
	public PhoneInfo(String name, String phone, String birth) {
		this.name = name;
		this.phone = phone;
		this.birth = birth;
	}
	
	public PhoneInfo() {
		// Nothing
	}
	
	public String getName() {
		return name;
	}
	
	public void showPhoneInfo() {
		if (name == null || phone == null || birth == null) {
			System.err.println("출력할 데이터가 존재하지 않습니다.");
		}
		else {
			System.out.println("이름: " + name);
			System.out.println("전화번호: " + phone);
			System.out.println("생년월일: " + birth);
		}
	}
}

class PhoneBookManager {
	final int MAX = 100;
	private PhoneInfo[] infoStorage = new PhoneInfo[MAX];
	int count = 0;
	
	public void inputData() {
		System.out.println("\n데이터 입력을 시작합니다.");
		
		if(infoStorage[count] != null && count != MAX) {
			count++;
		}
		
		System.out.print("이름을 입력해 주세요: ");
		String name = Menu.getScanner().next();
		
		System.out.print("전화번호를 입력해 주세요: ");
		String phone = Menu.getScanner().next();
		
		System.out.print("생년월일을 입력해 주세요: ");
		String birth = Menu.getScanner().next();
		
		infoStorage[count] = new PhoneInfo(name, phone, birth);
		
		System.out.println("입력된 데이터는 다음과 같습니다. ");
		System.out.println("인덱스 번호: " + count);
		infoStorage[count].showPhoneInfo();
		
	}
	
	public void searchData() {
		System.out.println("검색할 이름을 입력하세요: ");
		String search = Menu.getScanner().next();
		
		int notFound = 0;
		
		for (int i = 0; i < infoStorage.length; i++) {
			if (infoStorage[i] != null && infoStorage[i].getName().contains(search)) {
				System.out.println("검색한 인덱스: " + i);
				infoStorage[i].showPhoneInfo();
			}
			else {
				notFound++;
			}
		}
		
		if (notFound == MAX) {
			System.out.println("일치하는 데이터를 찾을 수 없습니다.\n");
		}
		else {
			int found = MAX - notFound;
			
			System.out.println("일치하는 데이터를 " + found + " 개 찾아 출력하였습니다.\n");
		}
	}
	
	public void deleteData() {
		System.out.println("\n삭제할 이름을 입력하세요: ");
		String search = Menu.getScanner().next();
		
		int found = 0;
		
		for (int i = 0; i < infoStorage.length; i++) {
			if (infoStorage[i] != null && infoStorage[i].getName().contains(search)) {
				found++;
			}
		}
		
		if (found > 0) {
			do {
				System.out.println(search + " (이)가 포함된 이름을 한개 이상 찾았습니다. 모두 제거할까요?");
				System.out.println("1. 예 / 2. 아니오");
				System.out.print("입력: ");
				int select = Menu.getScanner().nextInt();
				
				switch(select) {
				case 1:
					System.out.println("삭제 중 입니다...");
					
					int length = infoStorage.length;
					
					for (int i = 0; i < length; i++) {
						if (infoStorage[i] != null && infoStorage[i].getName().contains(search)) {
							infoStorage[i] = infoStorage[i+1];
						}
					}
					
					System.out.println("삭제되었습니다.");
					break;
				case 2:
					System.out.print("삭제할 데이터 이름을 입력해 주세요: ");
					String selName = Menu.getScanner().next();
					
					for (int i = 0; i < infoStorage.length; i++) {
						if (infoStorage[i] != null && infoStorage[i].getName().contains(selName)) {
							for (int j = i; j < (infoStorage.length - 1); j++) {
								infoStorage[j] = infoStorage[j+1] ;
							}
							break;
						}
					}
					System.out.println("삭제 되었습니다.");
					break;
				default:
					System.err.println("잘못된 값을 입력하셨습니다. 다시 입력해 주세요.");
					continue;
				}
				break;
			} while (true);
		}
		else {
			System.out.println("일치하는 데이터를 찾을 수 없습니다.");
		}
	}
}

class Menu {
	private static Scanner sc = new Scanner(System.in);
	
	public static void showMenu() {
		System.out.println("\n원하는 메뉴를 선택하세요.");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 이름으로 검색");
		System.out.println("3. 이름으로 삭제");
		System.out.println("4. 프로그램 종료");
		System.out.print("선택: ");
	}
	
	public static Scanner getScanner() {
		return sc;
	}
}

public class roadPhone {
	public static void main(String[] args) {
		PhoneBookManager pbm = new PhoneBookManager();
		int select;
		
		while (true) {
			Menu.showMenu();
			select = Menu.getScanner().nextInt();
			
			switch(select) {
			case 1:
				pbm.inputData();
				break;
			case 2:
				pbm.searchData();
				break;
			case 3:
				pbm.deleteData();
				break;
			case 4:
				System.out.println("\n프로그램을 종료합니다.");
				return;
			default:
				System.err.println("\n잘못된 값을 입력하셨습니다. 다시 입력해 주세요.");
				break;
			}
		}
	}
}
