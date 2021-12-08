package javaBasic;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_10_Break_Continue {

	public void Exercise_01() {

		List<String> browsers = Arrays.asList("Chrome", "Firefox", "Safari", "IE", "Opera", "Edge");
		for (String browser : browsers) {
			if (browser == "IE") {
				continue;
			}
			System.out.println(browser);
		}
	}

	@Test
	public void Exercise_02() {

		Scanner sc = new Scanner(System.in);

		int number = sc.nextInt();

		switch (number) {
		case 1:
			System.out.println("JAN");
			break;
		case 2:
			System.out.println("FEB");
			break;
		case 3:
			System.out.println("MAR");
			break;
		case 4:
			System.out.println("APR");
			break;
		case 5:
			System.out.println("MAY");
			break;
		case 6:
			System.out.println("JUN");
			break;
		case 7:
			System.out.println("JUL");
			break;
		case 8:
			System.out.println("AUG");
			break;
		case 9:
			System.out.println("SEP");
			break;
		case 10:
			System.out.println("OCT");
			break;
		case 11:
			System.out.println("NOV");
			break;
		case 12:
			System.out.println("DEC");
			break;
		}
	}
}
