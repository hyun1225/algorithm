package baekJoon.브루트포스;

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

public class 백준_1065_한수_ver2 {
	
   public static int N, answer;
   

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input1065.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		//Scanner sc = new Scanner(System.in);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N  = Integer.parseInt(st.nextToken());
		
		//N = sc.nextInt();
		answer = 0;
		
		if(N < 100) {
			System.out.println(N);
			return;
		}
		
		answer = 99;
		int a,b,c = 0;
		
		for(int i = 111 ; i <= N; i ++) {
			a = i%10;
			b = (i/10)%10;
			c = i/100;
			
			if( (a-b) == (b-c) ) {
				answer ++;
			}
		}
		
		System.out.println(answer);
		return;
		
		
	}

}

