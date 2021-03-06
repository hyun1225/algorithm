package baekJoon;

import java.util.ArrayList;
import java.util.Arrays;
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

public class 백준_1157_단어공부 {
	

	public static String str;
	public static int[] alpha;
	public static int max = Integer.MIN_VALUE;
	public static int index=0;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_1157.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		alpha = new int[26];
		
		for(int i = 0 ; i < str.length(); i ++) {
			if(str.charAt(i)-'a' < 0) {
				alpha[str.charAt(i)-'A']++;
			}else {
				alpha[str.charAt(i)-'a']++;
			}
		}
		
		boolean flag = false;
		for(int i = 0 ; i < alpha.length; i++) {
			if(alpha[i] !=0 ) {
				if(max == alpha[i]) {
					flag = true;
				}else if(max < alpha[i]) {
					max = alpha[i];
					index = i;
					flag = false;
				}
			}
		}

		if(flag) {
			System.out.println("?");
		}else {
			System.out.println((char)(index+'A'));
		}
		
		
	}

}

