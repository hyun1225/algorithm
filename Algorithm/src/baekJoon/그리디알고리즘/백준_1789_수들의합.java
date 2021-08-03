package baekJoon.그리디알고리즘;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
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

public class 백준_1789_수들의합 {
	

	public static long S ;
	public static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_1789.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 
		S = Long.parseLong(br.readLine());
		
		long sum = 0;
		int n = 1;
		while(true) {
			sum += (n++);
			if(sum > S) {
				break;
			}
		}
		System.out.println(n-2);
		
		
	}

}

