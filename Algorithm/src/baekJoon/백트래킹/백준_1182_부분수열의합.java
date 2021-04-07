package baekJoon.백트래킹;

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

public class 백준_1182_부분수열의합 {
	
	
	public static int[] arr;
	public static int N,S,answer=0;
	public static boolean[] visit;
	public static int[] tmp;
	


	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_1182.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= N; i++) {
			visit = new boolean[N];
			tmp = new int[i];
			permu(i,0,0);
		}
		
		System.out.println(answer);
		
	}
	        
	
	private static void permu(int length, int cnt, int start) {
		
		if(cnt == length) {
			check();
			return;
		}
		
		for(int i = start ; i < N; i ++) {
			if(!visit[i]) {
				visit[i] = true;
				tmp[cnt] = arr[i];
				permu(length, cnt+1, i+1);
				visit[i] = false;
			}
		}
		
	}
	
	
	

	 
	private static void check() {
		int sum=0;
		for(int i = 0 ; i < tmp.length; i++) {
			sum += tmp[i];
		}
		if(sum == S) answer++;
	}


}

