package baekJoon;

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

public class 백준_1932_정수삼각형 {
	
	public static int[][] dp;
	public static int N ;
	public static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_1932.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N][N];
		StringTokenizer st;
		
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j <= i ; j ++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1 ; i < N; i ++) {
			for(int j = 0 ; j <= i; j++) {
				if(j == 0) {
					dp[i][j] = dp[i-1][j] + dp[i][j];
				}else if( j == i) {
					dp[i][j] = dp[i-1][j-1] + dp[i][j];
				}else {
					dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + dp[i][j];
				}
			}
		}
		
		for(int i = 0 ; i < N ; i ++) {
			max = Math.max(dp[N-1][i], max);
		}
		
		System.out.println(max);
		
	}

}

