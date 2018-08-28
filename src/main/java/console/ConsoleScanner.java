package console;

import java.util.Scanner;

public class ConsoleScanner {
	
	private Scanner scanner = new Scanner(System.in);
	
	public ConsoleScanner() {
	}
	
	public String readString(String msg) {
		System.out.println(msg);
		return scanner.nextLine();
	}
	
	public Integer readInt(String msg) {
		System.out.println(msg);
		return Integer.parseInt(scanner.nextLine());
	}
	
	public Double readDouble(String msg) {
		System.out.println(msg);
		return Double.parseDouble(scanner.nextLine());
	}

}
