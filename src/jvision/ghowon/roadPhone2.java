package jvision.ghowon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class roadPhone2 {
	public static void main(String[] args) {
		PhoneBookManager2 pbm = new PhoneBookManager2();
		FileManager fm = new FileManager();
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("\n현재 디버그 모드 상태는 " + fm.isDebug() + " 입니다.");
			Menu2.showMenu();
			String sel = sc.next();
			
			if (sel.matches("^[1-4]$")) {
				int select = Integer.parseInt(sel);
				
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
					sc.close();
					return;
				default:
					System.out.println("\n잘못된 값을 입력하셨습니다. 다시 입력해 주세요.");
					continue;
				}
			}
			else {
				System.out.println("\n잘못된 값을 입력하셨습니다. 다시 입력해 주세요.");
				continue;
			}
		}
	}
}

class FileManager {
	String def_path = System.getenv("USERPROFILE") + "\\Documents\\Java\\PhoneBook\\";
	String extension = ".txt"; 
	
	boolean debug = false;
	
	String prefix = "[디버그/안내] ";
	String warning = "[디버그/주의] ";
	String error = "[디버그/오류] ";
	
	public FileManager() {
		// Nothing
	}
	
	public void createFile(String name) {
		File file = new File(def_path, name + extension);
		file.getParentFile().mkdirs();
		
		try {
			file.createNewFile();
			if (debug) System.out.println(prefix + "새로운 파일을 생성하였습니다. 파일 위치: " + file.getPath());
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println(error + "새로운 파일을 생성하지 못했습니다. 사유: " + e.getLocalizedMessage());
		}
	}
	
	public File getFile(String name) {
		File file = new File(def_path, name + extension);
		
		if (file.exists() && file.isDirectory()) {
			System.out.println("해당 파일은 존재하지 않는 파일이거나 디렉터리(폴더)인 것 같습니다. 파일을 불러오지 못했습니다.");
			return null;
		}
		else {
			if (debug) System.out.println(prefix + file.getName() + " 파일을 불러왔습니다.");
			return file;
		}
	}
	
	public void writeFile(File file, String key, String value) {
		try {
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bfw = new BufferedWriter(fw);
			
			bfw.write(key + ":" + value);
			bfw.newLine();
			
			bfw.flush();
			
			if (debug) System.out.println(prefix + file.getName() + " 파일을 작성하고, 작성에 사용한 BufferedWriter 출력 스트림을 닫았습니다. (FileManager/writeFile())");
			fw.close();
			bfw.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println(prefix + file.getName() + " 파일을 작성하지 못했습니다. [" + e.getMessage() + "/" + e.getCause() + "]");
		}
	}
	
	public String getInfo(File file, String info) {
		BufferedReader bfr;
		FileReader fr;
		
		if (file.exists()) {
			try {
				fr = new FileReader(file);
				bfr = new BufferedReader(fr);
				
				try {
					String temp;
					String line[] = new String[3];
					
					for (int i = 0; i < line.length; i++) {
						if ((temp = bfr.readLine()) != null) {
							line[i] = temp;
							if (debug) System.out.println(prefix + file.getName() + " 파일의 " + i + " 번째 줄을 읽었습니다. 내용: [" + temp + "]"); }
							
							String[] value = line[i].split(":");
							
							if (value[0].contains(info) || value[0].equals(info)) {
								if (debug) System.out.println(prefix + file.getName() + " 파일의 " + i + " 번째 줄에 있는 " + info + " 내용을 읽었습니다. 값: [" + value[1] + "]"); 
								fr.close();
								bfr.close();
								return value[1];
							}
							
							if (i == (line.length - 1)) {
								if (debug) System.out.println(prefix + " BufferedReader 입력 스트림을 닫았습니다. (FileManager/getInfo())");
								fr.close();
								bfr.close();
							}
						}
				} catch (IOException e) {
						e.printStackTrace();
					
						System.err.println(error + "BufferedReader 입력 스트림을 닫지 못했습니다. [" + e.getMessage() + "/" + e.getCause() + "]");
						return null;
				}
			} catch (IOException e) {
				e.printStackTrace();
				
				if (debug) System.err.println(error + file.getName() + " 파일의 내용을 불러오지 못했습니다. [" + e.getMessage() + "/" + e.getCause() + "]");
				return null;
			}
		}
		else {
			System.out.println("[오류] " + file.getName() + " 파일을 찾을 수 없습니다.");
			return null;
		}
		
		return null;
	}
	
	public void deleteFile(File file) {
		String name = file.getName();
		
		if (file.delete()) {
			System.out.println("[안내] " + name + " 파일이 정상적으로 삭제되었습니다.");
		}
		else {
			System.out.println("[오류] " + name + " 파일을 삭제하지 못했습니다. 다른 프로세스에서 해당 파일을 사용하고 있는 것 같습니다.");
		}
	}
	
	public void showPhoneInfo(File file) {
		System.out.println("=============================");
		System.out.println("- 파일 이름: " + file.getName());
		System.out.println("- 이름: " + getInfo(file, "name"));
		System.out.println("- 전화번호: " + getInfo(file, "phone"));
		System.out.println("- 생년월일: " + getInfo(file, "birth"));
		System.out.println("=============================\n");
	}
	
	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	public String getExtension() {
		return this.extension;
	}
	
	public boolean isDebug() {
		return debug;
	}
	
	public void setDirectory(String dir) {
		this.def_path = dir;
	}
	
	public String getDirectory() {
		return def_path;
	}
}

class PhoneBookManager2 {
	FileManager fm = new FileManager();
	Scanner sc;
	
	public void inputData() {
		sc = new Scanner(System.in);
		
		try {
			System.out.println("=============================");
			System.out.println("[안내] 데이터 입력을 시작합니다.");
			
			System.out.println("[1/3] 이름을 입력해 주세요.");
			String name = sc.next();
			
			System.out.println("[2/3] 전화번호를 입력해 주세요.");
			String phone = sc.next();
			
			System.out.println("[3/3] 생년월일을 입력해 주세요.");
			String birth = sc.next();
			
			fm.createFile(name);
			
			File file = fm.getFile(name);
			
			FileReader fr = new FileReader(file);
			BufferedReader bfr = new BufferedReader(fr);
			
			if (bfr.readLine() != null) {
				System.out.println("[안내] 이미 있는 데이터 입니다. 아래를 참고해 주세요.");
				
				fm.showPhoneInfo(file);
			}
			else {
				if (fm.isDebug()) System.out.println(fm.prefix + "파일 입력을 시작합니다.");
				
				fm.writeFile(file, "name", name);
				fm.writeFile(file, "phone", phone);
				fm.writeFile(file, "birth", birth);
				
				if (fm.isDebug()) System.out.println(fm.prefix + "파일 입력이 완료되었습니다. 파일 무결성 검사를 시작합니다.");
				
				if (file.exists() && !file.isDirectory()) {
					if (fm.isDebug()) System.out.println(fm.prefix + "파일 무결성 검사가 완료되었습니다.");
					
					System.out.println("[안내] 데이터가 생성되었습니다. 입력하신 데이터는 다음과 같습니다.");
					fm.showPhoneInfo(file);
				}
				else {
					System.out.println("[오류] 데이터 저장용 파일을 생성하지 못했습니다.");
				}
			}
			
			if (fm.isDebug()) System.out.println(fm.prefix + "BufferedReader 입력 스트림을 닫았습니다. (PhoneBookManager2/inputData())");
			fr.close();
			bfr.close();
		} catch (IOException e) {
			e.printStackTrace();
			
			if (fm.isDebug()) System.out.println(fm.error + "BufferedReader 입력 스트림을 시작하거나 닫지 못했습니다. [" + e.getMessage() + "/" + e.getCause() + "]");
		}
	}
	
	public void searchData() {
		sc = new Scanner(System.in);
		
		System.out.println("=============================");
		System.out.println("[안내] 검색할 이름을 입력해 주세요.");
		String search = sc.next();
		
		ArrayList<File> list = new ArrayList<>();
		int found = 0;
		
		File dir = new File(fm.getDirectory());
		
		if (!dir.exists() || !dir.isDirectory()) {
			System.out.println("[안내] '" + search + "' (을)를 찾을 수 없습니다. 검색에 사용되는 폴더가 생성되지 않았거나 해당 주소는 폴더를 가리키는 것이 아닐 수 있습니다.\n");
		}
		else {
			for (File file : dir.listFiles()) {
				if (fm.isDebug()) System.out.println("파일 검색: " + file.getName().toLowerCase());
				
				if (file.getName().toLowerCase().contains(search.toLowerCase())) {
					if (fm.isDebug()) System.out.println("파일 추가 " + (found + 1) + " 번째: " + file.getName().toLowerCase());
					list.add(file);
					found++;
				}
			}
			
			if (fm.isDebug()) System.out.println("찾은 개수: " + found + " / 배열 크기: " + list.size());
			
			if (found == 1) {
				System.out.println("[안내] '" + search + "' (이)가 포함된 데이터를 찾았습니다. 아래의 내용을 확인해 주세요.");
				
				fm.showPhoneInfo(list.get(0));
			}
			else if (found > 1) {
				do {
					System.out.println("[안내] '" + search + "' (이)가 포함된 데이터를 여러개 찾았습니다. 모두 표시할까요?");
					System.out.println("[ 1. 예 / 2. 아니오 ] 숫자로 입력해 주세요.");
					String menu = sc.next();
					
					if (menu.matches("^[1-2]$$")) {
						if (menu.equals("1")) {
							System.out.println("[안내] '" + search + "' (이)가 포함된 모든 데이터를 표시합니다.");
							
							for (int i = 0; i < list.size(); i++) {
								fm.showPhoneInfo(list.get(i));
							}
							break;
						}
						else if (menu.equals("2")) {
							System.out.println("[안내] '" + search + "' (이)가 포함된 데이터는 다음과 같습니다. 정확한 이름을 입력해 주세요.");
							
							for (int i = 0; i < list.size(); i++) {
								System.out.println(list.get(i).getName());
							}
							
							search = sc.next();
							
							if (list.get(0).getName().toLowerCase().equals(search.toLowerCase() + fm.getExtension())) {
								System.out.println("[안내] " + list.get(0).getName() + " 의 정보를 표시합니다.");
								
								fm.showPhoneInfo(list.get(0));
								break;
							}
							else {
								System.out.println("[안내] 이름이 '" + search + "' 인 데이터를 찾을 수 없습니다. 이름을 정확히 입력했는지 확인하신 뒤 다시 시도해 주세요.");
								break;
							}
						}
						else {
							System.out.println("[안내] 잘못 입력하셨습니다. 다시 입력해 주세요.");
							continue;
						}
					}
					else {
						System.out.println("[안내] 잘못 입력하셨습니다. 다시 입력해 주세요.");
						continue;
					}
				} while (true);
			}
			else {
				System.out.println("[안내] '" + search + "' (이)가 포함된 데이터를 찾을 수 없습니다. 철자가 틀린 곳은 없는지 확인하신 뒤 다시 시도해 주세요.");
			}
		}
	}
	
	public void deleteData() {
		sc = new Scanner(System.in);
		
		System.out.println("=============================");
		System.out.println("삭제할 이름을 입력해 주세요. 이름에 포함된 글자만 입력하면 검색해서 보여드립니다.");
		String search = sc.next();
		
		ArrayList<File> list = new ArrayList<>();
		int found = 0;
		
		File dir = new File(fm.getDirectory());
		
		if (!dir.exists() || !dir.isDirectory()) {
			System.out.println("[안내] '" + search + "' (을)를 찾을 수 없습니다. 검색에 사용되는 폴더가 생성되지 않았거나 해당 주소는 폴더를 가리키는 것이 아닐 수 있습니다.\n");
		}
		else {
			for (File file : dir.listFiles()) {
				if (fm.isDebug()) System.out.println("파일 검색: " + file.getName().toLowerCase());
				
				if (file.getName().toLowerCase().contains(search.toLowerCase())) {
					if (fm.isDebug()) { System.out.println("파일 추가 " + (found + 1) + "번째: " + file.getName().toLowerCase()); }
					list.add(file);
					found++;
				}
			}
			
			if (fm.isDebug()) System.out.println("찾은 개수: " + found + " / 배열 크기: " + list.size());
			
			if (found == 1) {
				do {
					System.out.println("[안내] '" + list.get(0).getName() + "' (을)를 삭제합니다. 삭제할까요?");
					System.out.println("[ 1. 예 / 2. 아니오] 숫자로 입력해 주세요.");
					String menu = sc.next();
					
					if (menu.matches("^[1-2]$")) {
						if (menu.equals("1")) {
							System.out.println("[안내] '" + list.get(0).getName() + "' 데이터를 제거합니다. 잠시만 기다려 주세요...");
							fm.deleteFile(list.get(0));
							break;
						}
						else if (menu.equals("2")) {
							System.out.println("[안내] '" + list.get(0).getName() + " 파일 제거를 사용자가 취소하였습니다.");
							break;
						}
						else {
							System.out.println("[안내] 잘못 입력하셨습니다. 다시 입력해 주세요.");
							continue;
						}
					}
					else {
						System.out.println("[안내] 잘못 입력하셨습니다. 다시 입력해 주세요.");
						continue;
					}
				} while (true);
			}
			
			else if (found > 1) {
				do {
					System.out.println("[안내] '" + search + "' (이)가 포함된 데이터를 여러개 찾았습니다. 모두 삭제할까요?");
					System.out.println("[ 1. 예 / 2. 아니오 ] 숫자로 입력해 주세요.");
					String menu = sc.next();
					
					if (menu.matches("^[1-2]$")) {
						if (menu.equals("1")) {
							System.out.println("[안내] '" + search + " (이)가 포함된 모든 데이터를 삭제합니다.");
							
							for (int i = 0; i < list.size(); i++) {
								fm.deleteFile(list.get(i));
							}
							
							break;
						}
						else if (menu.equals("2")) {
							System.out.println("[안내] '" + search + "' (이)가 포함된 데이터는 다음과 같습니다. 정확한 이름을 입력해 주세요.");
							
							for (int i = 0; i < list.size(); i++) {
								System.out.println(list.get(i).getName());
							}
							
							search = sc.next();
							
							File temp = fm.getFile(search);
							
							if (list.contains(temp)) {
								System.out.println("[안내] " + temp.getName() + " 파일을 삭제합니다.");
								
								fm.deleteFile(temp);
							}
							else {
								System.out.println("[안내] 이름이 '" + search + "' 인 데이터를 찾을 수 없습니다. 이름을 정확히 입력했는지 확인하신 뒤 다시 시도해 주세요.");
							}
							
							break;
						}
						else {
							System.out.println("[안내] 잘못 입력하셨습니다. 다시 입력해 주세요.");
							continue;
						}
					}
					else {
						System.out.println("[안내] 잘못 입력하셨습니다. 다시 입력해 주세요.");
						continue;
					}
				} while (true);
			}
			
			else {
				System.out.println("[안내] '" + search + "' (이)가 포함된 데이터를 찾을 수 없습니다. 철자가 틀린 곳은 없는지 확인하신 뒤 다시 시도해 주세요.");
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