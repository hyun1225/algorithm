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

public class 백준_2458_키순서 {
	

	public static int N,M;
	static final int INF = 1000000000;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_2458.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		// T = sc.nextInt();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		boolean[][] dis = new boolean[N+1][N+1];
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			dis[a][b] = true;
		}
		for(int k = 1; k<=N; k++) {
			for(int i = 1; i <= N ; i ++) {
				for(int j =1; j<= N; j ++) {
					if(dis[i][k] && dis[k][j]) dis[i][j] = true;
				}
			}
		}
		
		int total = 0;
		for(int i = 1 ; i <=N ; i++) {
			int cnt = 0;
			for(int j =1 ;j<=N; j++) {
				if(i==j) continue;
				if(dis[i][j] || dis[j][i]) {
					cnt++;
				}
			}
			if(cnt == N-1) total++;
		}
		System.out.println(total);
		
		
	}

}

