package baekJoon.그리디알고리즘;

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

public class 백준_1339_단어수학 {
	
	
	public static int N, answer = 0;
	public static String[] word;
	public static int[] alpha;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_1339.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		word = new String[N];
		alpha = new int[26];
		
		for(int i = 0 ; i < N ; i ++) {
			word[i] = br.readLine();
		}
		
		for(int i = 0 ; i < N ; i ++) {
			int temp = (int) Math.pow(10, word[i].length()-1);
			for(int j = 0 ; j < word[i].length() ; j ++) {
				int tmpAlpha = word[i].charAt(j)- 'A';
				alpha[tmpAlpha] += temp;
				temp /= 10;
			}
		}
		
		Arrays.sort(alpha);
		
		
		for(int i = alpha.length-1, nums = 9 ; i>=16 ; i--, nums--) {
			answer += alpha[i] * nums;
		}
		
		System.out.println(answer);
	}

}

