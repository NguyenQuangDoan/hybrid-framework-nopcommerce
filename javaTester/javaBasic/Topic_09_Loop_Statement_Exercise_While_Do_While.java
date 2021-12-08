package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_09_Loop_Statement_Exercise_While_Do_While {

	
	public void Exercise_01() {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		while(n <= 100){
			if(n % 2 == 0){
				System.out.println(n);
			}
			n++;
		}
	}
	

	public void Exercise_02() {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		while(a < b){
			if(a % 3 == 0 && a % 5 == 0){
				System.out.println(a);
			}
			a++;
		}
	}
	

	public void Exercise_03() {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int sum = 0;
		
		while(n > 0){
			if(n % 2 != 0){
				sum += n;
			}
			n--;
		}
		System.out.println(sum);
	}
	

	public void Exercise_04() {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		while(a < b){
			if(a % 3 == 0){
				System.out.println(a);
			}
			a++;
		}
	}
	
	
	public void Exercise_05() {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int sum = 1;
		
		while(n > 0){
			sum *= n;
			n--;
		}
		
		System.out.println(sum);
	}
	
	@Test
	public void Exercise_06() {
		int i = 0;
		int sum = 0;

		while(i <= 10){
			if(i % 2 == 0){
				sum += i;
			}
			i++;
		}
		System.out.println(sum);
	}
}
