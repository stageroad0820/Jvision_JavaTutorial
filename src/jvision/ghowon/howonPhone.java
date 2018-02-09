package jvision.ghowon;

import java.util.Scanner;

class PhoneInfo1 {
	String name;
	String phoneNumber;
	String birth;

	public String getname() {
		return name;
	}

	public String getName() {
		return name;

	}

	public PhoneInfo1(String name, String num, String birth) {
		this.name = name;
		this.phoneNumber = num;
		this.birth = birth;
	}

	public void showPhoneInfo() {
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
		System.out.println("생년월일 : " + birth);
	}
}

class PhoneBookManager1 {
	final int MAX = 100;
	private PhoneInfo1[] infoStorage = new PhoneInfo1[MAX];
	int count;

	public void inputData() {
		System.out.print("이름 :");
		String name = Menu1.getSc().nextLine();
		System.out.print("전화번호 :");
		String phone = Menu1.getSc().nextLine();
		System.out.print("생년월일 : ");
		String birth = Menu1.getSc().nextLine();
		PhoneInfo info = new PhoneInfo(name, phone, birth);
		infoStorage[count++] = new PhoneInfo1(name, phone, birth);
		System.out.println("입력된 값은 다음과 같습니다.");

		info.showPhoneInfo();
	}

	public void searchData() {
		System.out.print("이름 : ");
		String name = Menu1.getSc().nextLine();
		System.out.printf("데이터 출력 (%s)", count);
		System.out.println();

		for (int i = 0; i < count; i++)
			if (name.contains(name))
				infoStorage[i].showPhoneInfo();
	}

	public void deleteData() {
		System.out.print("이름 : ");
		String name = Menu1.getSc().nextLine();
		int dataIdx = search(name);
		String temp = infoStorage[dataIdx].getName();

		for (int i = 0; i < MAX; i++) {
			if (temp.contains(name)) {

				for (int idx = dataIdx; idx < MAX; idx++)
					count--;

				System.out.printf("삭제한 데이터 목록(%s)", count);
				System.out.println();
				for (int j = 0; j < count; j++)
					if (name.contains(name))
						infoStorage[j].showPhoneInfo();
			} else {

			}
		}
	}

	public int search(String name) {
		for (int idx = 0; idx < count; idx++) {
			PhoneInfo1 countInfo = infoStorage[idx];
			if (name.compareTo(countInfo.name) == 0)
				return idx;
		}
		return 0;
	}
}

class Menu1 {
	private static Scanner sc = new Scanner(System.in);

	public static void showMenu() {
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 이름으로 검색");
		System.out.println("3. 이름으로 삭제");
		System.out.println("4. 프로그램 종료");
		System.out.print("선택 :");
	}

	public static Scanner getSc() {
		return sc;
	}

	public static void setSc(Scanner sc) {
		Menu1.sc = sc;
	}

}

public class howonPhone {

	public static void main(String[] args) {
		PhoneBookManager1 manager = new PhoneBookManager1();

		int choice;
		while (true) {
			Menu1.showMenu();
			choice = Menu1.getSc().nextInt();
			Menu1.getSc().nextLine();
			switch (choice) {
			case 1:
				manager.inputData();
				break;
			case 2:
				manager.searchData();
				break;
			case 3:
				manager.deleteData();
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}