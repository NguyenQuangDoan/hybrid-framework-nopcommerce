package javaOOP;

import java.util.Scanner;

public class Topic_01_Class_Object_Student {

	private int id;
	private String name;
	private float theoryPoint;
	private float practicePoint;
	static Scanner sc = new Scanner(System.in);

	private int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	private String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	private double getTheoryPoint() {
		return theoryPoint;
	}

	private void setTheoryPoint(float theoryPoint) {
		this.theoryPoint = theoryPoint;
	}

	private float getPracticePoint() {
		return practicePoint;
	}

	private void setPracticePoint(float practicePoint) {
		this.practicePoint = practicePoint;
	}

	private Float averagePoint() {
		return (this.theoryPoint + this.practicePoint * 2) / 3;
	}

	private void showStudentInfo() {
		System.out.println("*****************************");
		System.out.println("Student ID: " + getId());
		System.out.println("Student Name: " + getName());
		System.out.println("Student Theory Point: " + getTheoryPoint());
		System.out.println("Student Practice Point: " + getPracticePoint());
		System.out.println("Student Average Point: " + averagePoint());
		System.out.println("*****************************");
	}

	public static void main(String[] args) {
		Topic_01_Class_Object_Student firstStudent = new Topic_01_Class_Object_Student();
		System.out.println("Nhập MSSV: ");
		firstStudent.setId(sc.nextInt());
		System.out.println("Nhập Họ Tên Sinh Viên: ");
		firstStudent.setName(sc.next());
		System.out.println("Nhập điểm lý thuyết: ");
		firstStudent.setTheoryPoint(sc.nextFloat());
		System.out.println("Nhập điểm thực hành: ");
		firstStudent.setPracticePoint(sc.nextFloat());
		firstStudent.showStudentInfo();
	}
}
