package jvision.ghowon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class PhoneInfo2 {
	String name, phone, birth;
	
	public PhoneInfo2() {
		// Nothing
	}
	
	public PhoneInfo2(String name, String phoneNum, String birth) {
		this.name = name;
		this.phone = phoneNum;
		this.birth = birth;
	}
}

class FileManager {
	public FileManager() {
		// Nothing
	}
	
	public File createFile(String name, String extension) {
		File file = new File(System.getProperty("user.dir") + "\\PhoneBooks", name + extension);
		file.getParentFile().mkdirs();
		
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
			
			return null;
		}
		
		return file;
	}
	
	public File getFile(String name, String extension) {
		File file = new File(System.getProperty("user.dir") + "\\PhoneBooks", name + extension);
		
		if (file.exists() && !file.isDirectory()) {
			return file;
		}
		else {
			return null;
		}
	}
	
	public void writeFile(File file, String key, String value) {
		try {
			BufferedWriter bfw = new BufferedWriter(new FileWriter(file, true));
			
			bfw.write(key + ":" + value);
			bfw.newLine();
			bfw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getName(File file) {
		return gettingInfo(file, "name");
	}
	
	public String getPhone(File file) {
		return gettingInfo(file, "phone");
	}
	
	public String getBirth(File file) {
		return gettingInfo(file, "birth");
	}

	private String gettingInfo(File file, String info) {
		try {
			BufferedReader bfr = new BufferedReader(new FileReader(file));
			
			try {
				String temp;
				String line[] = new String[3];
				
				for (int i = 0; i < line.length; i++) {
					if ((temp = bfr.readLine()) != null) {
						line[i] = temp;
//						System.out.println("[Debug] Reading line " + (i + 1) + " : " + line[i]);
						
						String[] value = line[i].split(":");
//						System.out.println("[Debug] Split string: " + value);
						
						if (value[0].contains(info)) {
							return value[1];
						}
						
						if (i == (line.length - 1)) {
							bfr.close();
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void showPhoneInfo(File file) {
		System.out.println("==============================================");
		System.out.println("- 파일 이름: " + file.getName());
		System.out.println("- 이름: " + getName(file));
		System.out.println("- 전화번호: " + getPhone(file));
		System.out.println("- 생년월일: " + getBirth(file));
		System.out.println("==============================================\n");
	}
}

class PhoneBookManager2 {
	FileManager fm = new FileManager();
	Scanner sc = new Scanner(System.in);
	
	String extension = ".txt";
	
	public void inputData() {
		System.out.println("데이터 입력을 시작합니다.");
		
		System.out.println("[1/3] 이름을 입력해 주세요.");
		String name = sc.next();
		
		System.out.println("[2/3] 전화번호를 입력해 주세요. (- 포함 가능)");
		String phone = sc.next();
		
		System.out.println("[3/3] 생년월일을 입력해 주세요. (- 포함 가능)");
		String birth = sc.next();
		
		File file = fm.createFile(name, extension);
		
		if (file.exists()) {
			System.out.println("이미 있는 데이터 입니다. 아래를 참고해 주세요.");
			
			fm.showPhoneInfo(file);
		}
		else {
			fm.writeFile(file, "name", name);
			fm.writeFile(file, "phone", phone);
			fm.writeFile(file, "birth", birth);
			
			System.out.println("[안내] 완료 작업: 파일 무결성 검사");
			
			if (file.exists() && !file.isDirectory()) {
				System.out.println("[완료] 입력하신 정보는 아래와 같습니다.");
				System.out.println("- 이름: " + fm.getName(file));
				System.out.println("- 전화번호: " + fm.getPhone(file));
				System.out.println("- 생년월일: " + fm.getBirth(file) + "\n");
			}
			else {
				System.out.println("데이터 저장용 파일 생성에 실패하였습니다.");
			}
		}
	}
	
	public void searchData() {
		System.out.println("검색할 이름을 입력해 주세요.");
		String search = sc.next();
		
		ArrayList<File> list = new ArrayList<>();
		int found = 0;
		
		File dir = new File(System.getProperty("user.dir") + "\\PhoneBooks");
		
		if (!dir.exists() || !dir.isDirectory()) {
			System.out.println("'" + search + "' (을)를 찾을 수 없습니다. \n검색할 폴더가 생성되지 않았거나 해당 주소는 폴더를 가리키는 주소가 아닐 수 있습니다.");
			System.out.println("\n");
		}
		else {
			for (File file : dir.listFiles()) {
				if (file.getName().toLowerCase().contains(search)) {
					found++;
					list.add(file);
				}
			}
			
			if (found == 1) {
				File temp = list.get(0);
				
				fm.showPhoneInfo(temp);
			}
			else if (found > 1) {
				do {
					System.out.println("'" + search + "' (이)가 포함된 데이터를 한개 이상 발견하였습니다. 모두 표시할까요?");
					System.out.println("[ 1. 예 / 2. 아니오 ]");
					int select = sc.nextInt();
					
					switch(select) {
					case 1:
						for (File file : list) {
							fm.showPhoneInfo(file);
						}
						break;
					case 2:
						System.out.println("'" + search + "' (이)가 포함된 데이터들 입니다. 참고하세요.");
						
						for (int i = 0; i < found; i++) {
							System.out.println(list.get(i).getName());
						}
						
						System.out.println("\n'" + search + "' (이)가 포함된 정확한 이름을 입력해주시면 해당 정보가 출력됩니다.");
						search = sc.next();
						
						File temp = fm.getFile(search, extension);
						
						if (list.contains(temp)) {
							fm.showPhoneInfo(temp);
						}
						else {
							System.out.println("'" + search + "' (을)를 찾을 수 없습니다. 이름을 정확히 입력했는지 확인하신 뒤 다시 시도해 주세요.");
						}
						break;
					default:
						System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
						continue;
					}
					break;
				} while (true);
			}
			else {
				System.out.println("'" + search + "' (을)를 찾을 수 없습니다. 철자가 틀린 것이 없는지 확인하신 뒤 다시 시도해 주세요.");
			}
		}
	}
	
	public void deleteData() {
		System.out.println("삭제할 이름을 입력해 주세요.");
		String search = sc.next();
		
		ArrayList<File> list = new ArrayList<>();
		int found = 0;
		
		File dir = new File(System.getProperty("user.dir") + "\\PhoneBooks");
		
		if (!dir.exists() || !dir.isDirectory()) {
			System.out.println("'" + search + "' (을)를 찾을 수 없습니다. \n검색할 폴더가 생성되지 않았거나 해당 주소는 폴더를 가리키는 주소가 아닐 수 있습니다.");
			System.out.println("\n");
		}
		else {
			for (File file : dir.listFiles()) {
				if (file.getName().toLowerCase().contains(search.toLowerCase())) {
					found++;
					list.add(file);
				}
			}
			
			if (found == 1) {
				do {
					String name = fm.getName(list.get(0));
					System.out.println("데이터 " + name + " (을)를 제거합니다. 계속 하시겠습니까?");
					System.out.println("[ 1. 예 / 2. 아니오 ]");
					int select = sc.nextInt();
					
					File file = fm.getFile(name, extension);
					
					switch (select) {
					case 1:
						System.out.println("'" + name + "' (을)를 제거합니다. 잠시만 기다려 주세요...");
						
						if (file.delete()) {
							System.out.println("데이터가 성공적으로 제거되었습니다.");
						}
						else {
							System.out.println("데이터 삭제에 실패하였습니다. 해당 위치로 가서 파일을 직접 제거해 주세요.");
							System.out.println("파일 위치: " + file.getPath());
						}
						break;
					case 2:
						System.out.println("사용자가 데이터 삭제를 취소하였습니다.");
						break;
					default:
						System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.\n");
						continue;
					}
					break;
				} while (true);
			}
			else if (found > 1) {
				do {
					System.out.println("'" + search + "' (이)가 포함된 데이터를 여러개 발견하였습니다. 모두 삭제할까요?");
					System.out.println("[ 1. 예 / 2. 아니오 ]");
					int select = sc.nextInt();
					
					switch (select) {
					case 1:
						System.out.println("'" + search + "' (이)가 포함된 모든 데이터를 제거합니다. 잠시만 기다려 주세요...");
						
						int notDeleted = 0;
						
						for (File file : list) {
							if (file.delete()) {
								System.out.println("데이터가 성공적으로 제거되었습니다.");
							}
							else {
								notDeleted++;
							}
						}
						
						if (notDeleted != 0) {
							System.out.println(notDeleted + " 개의 데이터를 제외하고 모든 데이터가 삭제되었습니다. 나머지는 해당 위치로 이동하여 직접 삭제해 주세요.");
							System.out.println("파일 위치: " + dir.getPath());
						}
						else {
							System.out.println("모든 파일이 성공적으로 제거되었습니다.");
						}
						break;
					case 2:
						System.out.println("'" + search + "' (이)가 포함된 데이터들 입니다. 입력하실 때에는 대소문자를 구분해서 써주세요.");
						
						for (int i = 0; i < found; i++) {
							System.out.println(list.get(i).getName());
						}
						
						System.out.println("\n'" + search + "' (이)가 포함된 정확한 이름을 입력해주시면 해당 정보가 출력됩니다.");
						search = sc.next();
						
						File temp = fm.getFile(search, extension);
						
						if (temp.delete()) {
							System.out.println("데이터가 성공적으로 제거되었습니다.");
						}
						else {
							System.out.println("데이터 삭제에 실패하였습니다. 해당 위치로 가서 파일을 직접 제거해 주세요.");
							System.out.println("파일 위치: " + temp.getPath());
						}
						break;
					default:
						System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
						continue;
					}
					break;
					} while (true);
			}
			else {
				System.out.println("'" + search + "' (을)를 찾을 수 없습니다. 철자가 틀린 것이 없는지 확인하신 뒤 다시 시도해 주세요.");
			}
		}
	}
}

class Menu2 {
	public static void showMenu() {
		System.out.println("==============================================");
		System.out.println("원하는 메뉴를 선택하세요.");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 이름으로 검색");
		System.out.println("3. 이름으로 삭제");
		System.out.println("4. 프로그램 종료");
		System.out.print("선택: ");
	}
}

@SuppressWarnings("resource")
public class roadPhone2 {
	public static void main(String[] args) {
		PhoneBookManager2 pbm = new PhoneBookManager2();
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			Menu2.showMenu();
			
			int select = sc.nextInt();
			
			System.out.println("");
			
			switch (select) {
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
				
			}
		}
	}
}
