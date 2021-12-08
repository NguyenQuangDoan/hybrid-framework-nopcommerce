package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_04_Operator_Exercise {

//	public static void main(String[] arg) {
//		Scanner input1 = new Scanner(System.in);
//		Scanner input2 = new Scanner(System.in);
//
//	    String name = input1.nextLine();
//	    int age = input2.nextInt();
//	    
//	    System.out.println("After 15 years, age of " + name + " will be " + age);
//	}

//	public static void main(String[] arg) {
//		Scanner input1 = new Scanner(System.in);
//		Scanner input2 = new Scanner(System.in);
//
//		int a = input1.nextInt();
//		int b = input2.nextInt();
//
//		a = a + b;
//		b = a - b;
//		a = a - b;
//
//		System.out.println("After swapping then a = " + a + ", b = " + b);
//	}

	public static void main(String[] arg) {
		Scanner input1 = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);

		int a = input1.nextInt();
		int b = input2.nextInt();

		if (a > b) {
			System.out.println("true");
		} else if (a < b) {
			System.out.println("false");
		} else {
			System.out.println("a = b");
		}

	}
}
