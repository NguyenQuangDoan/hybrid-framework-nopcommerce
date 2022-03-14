package javaBasic;

import java.util.Scanner;

public class Topic_08_Loop_Statement_Exercise_For_For_Each {

//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//
//		int n = sc.nextInt();
//		for (int i = 1; i <= n; i++) {
//			System.out.print(i + " ");
//		}
//	}

//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//
//		int a = sc.nextInt();
//		int b = sc.nextInt();
//		
//		for (int i = a; i <= b; i++) {
//			System.out.print(i + " ");
//		}
//	}

//	public static void main(String[] args) {
//		for (int i = 1; i <= 10; i++) {
//			if(i % 2 == 0) {
//				System.out.print(i + " ");
//			}
//		}
//	}

//	public static void main(String[] args) {
//		int sum = 0;
//		Scanner sc = new Scanner(System.in);
//		int a = sc.nextInt();
//		int b = sc.nextInt();
//
//		for (int i = a; i <= b; ++i) {
//
//			sum += i;
//		}
//		System.out.println(sum);
//	}

//	public static void main(String[] args) {
//		int sum = 0;
//		Scanner sc = new Scanner(System.in);
//		
//		int n = sc.nextInt();
//		for (int i = 0; i <= n; i++) {
//			if (!(i % 2 == 0)) {
//				sum += i;
//			}
//		}
//		System.out.println(sum);
//	}
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		int a = sc.nextInt();
//		int b = sc.nextInt();
//		for (int i = a; i <= b; i++) {
//			if (i % 3 == 0) {
//				System.out.print(i + " ");
//			}
//		}
//
//	}

	public static void main(String[] args) {
		int sum = 1;
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			sum *= i;
		}
		System.out.println(sum);
	}
}
