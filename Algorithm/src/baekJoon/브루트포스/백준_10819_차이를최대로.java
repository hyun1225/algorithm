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

public class 백준_10819_차이를최대로 {
	

	public static int[] arr, tmp;
	public static int N ;
	public static int max = Integer.MIN_VALUE;
	public static boolean[] visit;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_10819.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		tmp = new int[N];
		visit = new boolean[N];
		
		for(int i = 0 ; i < N ; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		permutaion(0);
		System.out.println(max);
		
		
	}


	private static void permutaion(int count) {
		
		if(count == N) {
			calculation();
			return;
		}
		
		for(int i = 0 ; i < N ; i ++) {
			if(!visit[i]) {
				visit[i] = true;
				tmp[count] = arr[i];
				permutaion(count+1);
				visit[i] = false;
			}
		}
	}


	private static void calculation() {
		int sum = 0;
		for(int i = 0 ; i <= N-2 ; i++) {
			sum += Math.abs(tmp[i]-tmp[i+1]);
		}
		max = Math.max(sum, max);
	}

}

