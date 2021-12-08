package javaBasic;

import java.util.Scanner;

public class Topic_07_Condition_Statement_Exercise_Part_II {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//
//		int number = sc.nextInt();
//		
//		switch (number) {
//		case 1:
//			System.out.println("One");
//			break;
//		case 2:
//			System.out.println("Two");
//			break;
//		case 3:
//			System.out.println("Three");
//			break;
//		case 4:
//			System.out.println("Four");
//			break;
//		case 5:
//			System.out.println("Five");
//			break;
//		case 6:
//			System.out.println("Six");
//			break;
//		case 7:
//			System.out.println("Seven");
//			break;
//		case 8:
//			System.out.println("Eight");
//			break;
//		case 9:
//			System.out.println("Nine");
//			break;
//		case 10:
//			System.out.println("Ten");
//			break;
//		}
//	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//
//		int a = sc.nextInt();
//		int b = sc.nextInt();
//		String pheptinh = sc.next();
//
//		switch (pheptinh) {
//		case "+":
//			System.out.println(a + b);
//			break;
//		case "-":
//			System.out.println(a - b);
//			break;
//		case "*":
//			System.out.println(a * b);
//			break;
//		case "/":
//			System.out.println(a / b);
//			break;
//		}
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();

		switch (a) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("This month has 31 days");
			break;
		case 2:
			System.out.println("This month has 28 days");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("This month has 30 days");
		}
	}
}
