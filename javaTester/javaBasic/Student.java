package javaBasic;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.testng.annotations.Test;

public class Student {
	
	int id;
	String name;
	int age;
	int score;
	
	public Student(int id, String name, int age, int score){
		this.id = id;
		this.name = name;
		this.age = age;
		this.score = score;	
	}
	
	public void displayed(){
		System.out.println("ID: " + id);
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Score: " + score);
	}

	public static void main(String[] args){
		Student[] students = new Student[5];
		students[0] = new Student(01, "Thanh Tuan", 24, 9);
		students[1] = new Student(02, "Tuan Dang", 25, 10);
		students[2] = new Student(03, "Thanh Nguyen", 20, 8);
		students[3] = new Student(04, "Thanh Tam", 23, 6);
		students[4] = new Student(05, "Thanh Duc", 26, 7);
		for (int i = 0; i < students.length; i++) {
			students[i].displayed();
		}
	}
}
