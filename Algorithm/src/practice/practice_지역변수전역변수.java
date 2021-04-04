package practice;

import java.util.Arrays;

public class practice_지역변수전역변수 {

	public static int[] arr;
	public static int k = 100;
	
	public static void main(String[] args) {
		int[] arr2 = new int[] {100,200,300};
		func(arr2);
		System.out.println(Arrays.toString(arr2));	
		int n = 10;
		func2(n);
		System.out.println(n);
		arr = new int[] {1,2,3};
		int[] arrr = new int[] {56};
		func3(arrr);
		System.out.println(Arrays.toString(arr));	
		System.out.println(Arrays.toString(arrr));	
		
		practice_123 abc = new practice_123();
		//int k = 1;
		abc.puyopuyoCheck(k);
		System.out.println(k);
		
	}

	private static void func3(int[] arrr) {
		int[] logical = new int[] {1000};
		arr = logical;
		arrr = logical;
	}

	private static void func2(int n) {
		// TODO Auto-generated method stub
		n = 1000+n;
	}

	private static void func(int[] arr2) {
		System.out.println("func함수실행");
		int[] arr3 = new int[] {1000,2000,3000};
		 arr2 = arr3;
	}

}
