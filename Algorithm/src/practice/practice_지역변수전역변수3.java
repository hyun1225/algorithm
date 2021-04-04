package practice;

import java.util.Arrays;

public class practice_지역변수전역변수3 {

	public static int[] arr;
	
	public static void main(String[] args) {
		arr = new int[] {10};
		int[] arr2 = new int[] {1,2};
		func(arr2);
		System.out.println(Arrays.toString(arr));
	//	System.out.println(Arrays.toString(arr2));
	}

	private static void func(int[] arr2) {
		int[] logicalArr = new int[] {20,30,40,50,60};
		arr = logicalArr;
		//arr2 = logicalArr;// 얕은복사 
		//arr2[0] += 1000;
		//arr2 = logicalArr.clone();
		//arr2[0] += 1000;
		//logicalArr[0] += 1;
		//System.out.println(arr2[0]);
		//System.out.println(logicalArr[0]);
		//	System.out.println(arr2[0]);
		//	System.out.println(logicalArr[0]);
		//int[] copyArr = Arrays.copyOfRange(logicalArr, , );
		//System.out.println(Arrays.toString(copyArr));
	}

}
