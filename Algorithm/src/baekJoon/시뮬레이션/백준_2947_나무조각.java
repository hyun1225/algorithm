package baekJoon.시뮬레이션;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
//a = sc.nextInt();                           // int 변수 1개 입력받는 예제
//b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
//g = sc.nextByte();                          // char 변수 1개 입력받는 예제
//var = sc.next();                            // 문자열 1개 입력받는 예제
//AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_2947_나무조각 {
	

	public static int[] nums;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_2947.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		nums = new int[5];
		for(int i = 0 ; i < 5 ; i ++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		while(true) {
			for(int i = 0 ; i < 4 ; i ++) {
				if(nums[i]>nums[i+1]) {
					int tmp = nums[i];
					nums[i] = nums[i+1];
					nums[i+1] = tmp;
					print();
				}
			}
			if(check()) {
				break;
			}
		}
	}

	private static boolean check() {
		for(int i = 0 ; i<5 ;i ++) {
			if(nums[i] != i+1) return false;
		}
		return true;
	}

	private static void print() {
		for(int i = 0 ; i < 5 ; i ++) {
			System.out.print(nums[i]+" ");
		}
		System.out.println();
	}

}

