package javaBasic;

import java.util.Scanner;

public class Topic_06_Condition_Statement_Exercise_Part_I {

//	public static void main(String[] arg) {
//		Scanner input = new Scanner(System.in);
//
//		int n = input.nextInt();
//
//		if (n % 2 == 0) {
//			System.out.println("n là số chẵn");
//		} else {
//			System.out.println("n là số lẻ");
//		}
//	}

//	public static void main(String[] arg) {
//		Scanner input1 = new Scanner(System.in);
//		Scanner input2 = new Scanner(System.in);
//
//		int a = input1.nextInt();
//		int b = input2.nextInt();
//
//		if (a >= b) {
//			System.out.println("a lớn hơn hoặc bằng b");
//		} else {
//			System.out.println("a nhỏ hơn b");
//		}
//	}

//	public static void main(String[] arg) {
//		Scanner input1 = new Scanner(System.in);
//		Scanner input2 = new Scanner(System.in);
//
//		String user1 = input1.nextLine();
//		String user2 = input2.nextLine();
//
//		if (user1.equals(user2)) {
//			System.out.println("2 người là cùng tên");
//		} else {
//			System.out.println("2 người là khác tên");
//		}
//	}

//	public static void main(String[] arg) {
//		Scanner input1 = new Scanner(System.in);
//		Scanner input2 = new Scanner(System.in);
//		Scanner input3 = new Scanner(System.in);
//
//		int a = input1.nextInt();
//		int b = input2.nextInt();
//		int c = input2.nextInt();
//
//		if (a > b && a > c) {
//			System.out.println(a + " là số lớn nhất");
//		} else if (b > c){
//			System.out.println(b + " là số lớn nhất");
//		} else {
//			System.out.println(c + " là số lớn nhất");
//		}
//	}

//	public static void main(String[] arg) {
//		Scanner input1 = new Scanner(System.in);
//
//		int a = input1.nextInt();
//
//		if (10 < a && a < 100) {
//			System.out.println(a + " nằm trong khoảng [10;100]");
//		} else {
//			System.out.println(a + " không nằm trong khoảng [10;100]");
//		}
//	}

//	public static void main(String[] arg) {
//		Scanner input1 = new Scanner(System.in);
//
//		float a = input1.nextFloat();
//
//		if (0 < a && a < 5) {
//			System.out.println("Điểm D");
//		} else if (5 < a && a < 7.5) {
//			System.out.println("Điểm C");
//		} else if (7.5 < a && a < 8.5) {
//			System.out.println("Điểm B");
//		} else {
//			System.out.println("Điểm A");
//		}
//	}
	
	public static void main(String[] arg) {
		Scanner input1 = new Scanner(System.in);

		String a = input1.nextLine();

		if (a.equals("tháng 1")  || a.equals("tháng 3") || a.equals("tháng 5") || a.equals("tháng 7") || a.equals("tháng 8") || a.equals("tháng 10") || a.equals("tháng 12") ) {
			System.out.println("31 ngày");
		} else if (a.equals("tháng 2")) {
			System.out.println("28 ngày");
		} else {
			System.out.println("30 ngày");
		}
	}
}
