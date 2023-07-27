package calculator;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		

		Scanner scanner = new Scanner(System.in);
		
		
		
		
		
		System.out.print("Enter first number: ");
		int x = scanner.nextInt();
		
		
		
		System.out.println("1) Addition");
		System.out.println("2) Subtraction");
		System.out.println("3) Multiplication");
		System.out.println("4) Division");
		System.out.println("5) Exit");
		System.out.print("Choose an operation: ");
		
		int choice = scanner.nextInt();
		
		System.out.print("Enter second number: ");
		int y = scanner.nextInt();
		
		
		
		switch(choice) {
		
		case 1:
			System.out.println("result is: " + (x+y));
			break;
		case 2:
			System.out.println("result is: " + (x-y));
			break;
		case 3:
			System.out.println("result is: " + (x*y));
			break;
		case 4:
			System.out.println("result is: " + (x/y));
			break;

		}
		
		
	}

}
