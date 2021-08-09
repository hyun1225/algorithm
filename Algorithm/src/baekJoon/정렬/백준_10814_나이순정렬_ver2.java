package baekJoon.정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

public class 백준_10814_나이순정렬_ver2 {
	

	static int N ;
	static StringBuilder[] sbArray;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_10814.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		sbArray = new StringBuilder[201];
		
		for(int i = 0 ; i < sbArray.length ; i ++) {
			sbArray[i] = new StringBuilder();
		}
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			sbArray[age].append(age+" "+name+"\n");
		}
		
		for(int i = 0 ; i < sbArray.length; i ++) {
			sb.append(sbArray[i]);
		}
		
		System.out.println(sb);
			
	}
}

