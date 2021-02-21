package baekJoon;

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

public class 백준_9095_123더하기_dp {
	
	public static int n, answer;
	public static int[] memoization;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_9095.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		//int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			  n = Integer.parseInt(br.readLine());
			  if(n == 1) {
				  System.out.println(1);
			  }else if(n == 2) {
				  System.out.println(2);
			  }else if(n == 3) {
				  System.out.println(4);
			  }else {
				  memoization = new int[n+1];
				  System.out.println(dp(n));
			  }
		}
	}

	private static int dp(int n) {
		memoization[1] = 1;
		memoization[2] = 2;
		memoization[3] = 4;
		for (int i = 4; i <= n; i++) {
			memoization[i] = memoization[i - 1] + memoization[i - 2] + memoization[i - 3];
		}
		return memoization[n];
	}

}

