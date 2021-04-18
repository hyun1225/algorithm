package baekJoon.그리디알고리즘;

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

public class 백준_13305_주유소 {
	
	public static int N;
	public static long answer=0;
	public static long[] distance, price;
	public static long min = Long.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_13305.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		distance = new long[N-1];
		price = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N-1 ; i ++) {
			distance[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i ++) {
			price[i] = Long.parseLong(st.nextToken());
		}
		
		
		for(int i = 0; i < N-1 ; i ++ ) {
			min = Math.min(min, price[i]);
			answer += min * distance[i];
		}
		
		System.out.println(answer);
		
	}

}

