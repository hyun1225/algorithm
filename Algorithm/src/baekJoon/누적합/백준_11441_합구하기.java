package baekJoon.누적합;

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

public class 백준_11441_합구하기 {
	

	public static int N,M;
	public static int[] nums;
	public static int[] sum;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_11441.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		sum = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i ++) {
			nums[i] = Integer.parseInt(st.nextToken());
			sum[i+1] = sum[i]+nums[i];
		}
		
		M = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < M ; i ++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(sum[b]-sum[a-1]).append("\n");
			//System.out.println(sum[b]-sum[a-1]);
		}
		
		System.out.println(sb);
		
		
	}

}

