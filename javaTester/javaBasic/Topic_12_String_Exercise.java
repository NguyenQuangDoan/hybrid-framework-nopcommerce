package javaBasic;

import org.testng.annotations.Test;

public class Topic_12_String_Exercise {
	String courseName = "Automation Online Advance Course";

	public void TC_01_Split_Array() {
		char courseNameArr[] = courseName.toCharArray();
		int count = 0;
		for (char character : courseNameArr) {
			if (character <= 'Z' && character >= 'A') {
				count++;
			}
		}
		System.out.println(count);
	}

	
	public void TC_02() {
		String name = "Automation Testing 345 Tutorials Online 789";

		char nameArr[] = name.toCharArray();
		int countchara = 0;
		for (char character : nameArr) {
			if (character == 'a'){
				countchara++;
			}
		}
		System.out.println("số kí tự a: " + countchara);
		
		System.out.println(name.contains("Testing"));
		
		System.out.println(name.startsWith("Automation"));
		
		System.out.println(name.endsWith("Online"));
		
		System.out.println(name.indexOf("Tutorials"));
		
		System.out.println(name.replace("Online", "Offline"));
		
		int count = 0;
		for (char character : nameArr) {
			if (character <= '9' && character >= '0') {
				count++;
			}
		}
		System.out.println(count);
	}
	
	@Test
	public void TC_03(){
		String name = "Automation Testing 345 Tutorials Online 789";

		char nameArr[] = name.toCharArray();
		
		for (int i = nameArr.length - 1; i >= 0; i--) {
			System.out.print(nameArr[i]);
		}
	}
}
