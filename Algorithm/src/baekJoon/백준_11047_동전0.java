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

public class 백준_11047_동전0 {
	
	public static int N,K ,ans;
	public static int[] coin;
	

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_11047.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		coin = new int[N];
		ans = 0 ; 
		for(int i = 0 ; i < N; i ++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = N-1 ; i >=0 ; i --) {
			if(K/coin[i] > 0) {
				ans += K/coin[i];
				K = K%coin[i];
			}
		}
		
		System.out.println(ans);
		
		
	}

}

