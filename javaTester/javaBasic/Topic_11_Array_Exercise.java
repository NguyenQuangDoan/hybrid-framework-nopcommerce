package javaBasic;

public class Topic_11_Array_Exercise {
	int[] arr = {2 ,7 ,6 ,8 ,9, -5, -8, -4, 10, 5};

	public void Exercise_01_Find_Max_Number() {

		int x = 0;
		for(int i = 0; i < arr.length; i++){
			if(x < arr[i]){
				x = arr[i];
			} 
		}
		System.out.println(x);
	}

	public void Exercise_02_Total_First_And_Last_Number(){
		int sum = 0;
		sum = arr[0] + arr[arr.length - 1];
		System.out.println(sum);
	}
	
	public void Exercise_03_Find_Even_Number(){
		for(int i = 0; i < arr.length; i++){
			if(arr[i] % 2 == 0){
				System.out.println(arr[i]);
			}
		}
	}
	
	public void Exercise_04_Total_Odd_Number_Greater_Than_0(){
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (!(arr[i] % 2 == 0) && arr[i] > 0) {
				sum += arr[i];
			}
		}
		System.out.println(sum);
	}
	
	public void Exercise_05_Display_Greater_Than_0_And_Smaller_Than_10(){
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] >= 0 && arr[i] <= 10){
				System.out.println(arr[i]);
			}
		}
	}
	
	
	public void Exercise_06_Find_Total_And_Average(){
		int sum = 0;
		float avg = 0f;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println("gia tri tong " + sum);
		
		avg = sum / arr.length;
		System.out.println("gia tri trung binh " + avg);
	}
	
}
