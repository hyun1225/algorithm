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

public class 백준_15649_N과M1 {
	

	public static int N,M;
	public static int[] number;
	public static int[] ans;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_15649.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		//Scanner sc = new Scanner(System.in);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		number = new int[N];
		visit = new boolean[N];
		ans = new int[M];
		for(int i = 0 ; i <N ; i ++) {
			number[i] = i+1;
		}
		
		permutation(0);
		System.out.println(sb);
	}

	private static void permutation(int cnt) {
		
		if(cnt == M) {
		//	ansPrint();
			//StringBuilder 사용시 System.out.print 으로 배열돌면서 출력하는것보다 1/10 단축
			for (int val : ans) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i = 0 ; i < N ; i ++) {
			if(!visit[i]) {
				visit[i] = true;
				ans[cnt] = number[i];
				permutation(cnt+1);
				visit[i] = false;
			}
		}
		
	}

	private static void ansPrint() {
		for(int i = 0 ; i < ans.length; i ++) {
			System.out.print(ans[i] + " ");
		}
		System.out.println();
	}

}

