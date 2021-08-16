package baekJoon.이분탐색;

import java.util.ArrayList;
import java.util.*;
//a = sc.nextInt();                           // int 변수 1개 입력받는 예제
//b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
//g = sc.nextByte();                          // char 변수 1개 입력받는 예제
//var = sc.next();                            // 문자열 1개 입력받는 예제
//AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
import java.io.*;
import java.util.Queue;
import java.util.Scanner;
import java.util.Scanner;

public class 백준_2805_나무자르기 {
	

	static int N,M;
	static int[] trees;
	static long max = 0;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_2805.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		trees = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i ++) {
			trees[i] = Integer.parseInt(st.nextToken());
			max = Math.max(trees[i], max);
		}
		
		long start = 0;
		long end = max;
		
		while(start <= end) {
			
			long sum = 0 ;
			long mid = (start+end) / 2 ;
			
			for(int i = 0 ; i < N ; i ++) {
				if(trees[i] > mid) {
					sum += trees[i] - mid;
				}
			}
			
			if(sum >= M) {
				start = mid + 1 ;
			}else {
				end = mid - 1 ;
			}
		}
		
		System.out.println(end);
		
		
	}

}

