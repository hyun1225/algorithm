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

public class 백준_2798_블랙잭 {
	

	public static int N,M, max = Integer.MIN_VALUE;
	public static int[] nums, select;
	public static boolean[] visit;
	

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_2798.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		visit = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i ++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		newBlackJack(0,0,0);
		
		System.out.println(max);
		
	}


	private static void newBlackJack(int cnt, int start, int sum) {
		// TODO Auto-generated method stub
		if(cnt == 3) {
			max = Math.max(sum, max);
			return;
		}
		
		for(int i = start ; i < N ; i ++) {
			if(!visit[i] && ((cnt<2 && sum+nums[i] < M) || (cnt>=2 && sum+nums[i] <= M))) {
				visit[i] = true;
				newBlackJack(cnt+1, i+1 , sum+nums[i]);
				visit[i] = false;
			}
		}
	}

}

