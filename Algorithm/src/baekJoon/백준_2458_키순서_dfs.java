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

public class 백준_2458_키순서_dfs {
	
	static int N,M, adj[][] , reverse[][];
	static int cnt ;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_2458.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new int[N+1][N+1];
		reverse = new int[N+1][N+1];
		
		int i , j;
		
		for(int m = 1; m <= M ; m++) {
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			
			adj[i][j] = 1;
			reverse[j][i] = 1;
		}
		
		int answer = 0;
		
		for(int k = 1; k <=N; k++) {
			cnt = 0;
			dfs(k,adj, new boolean[N+1]);
			dfs(k,reverse, new boolean[N+1]);
			if(cnt == N-1) answer++;
		}
		System.out.println(answer);
		
		
	}

	private static void dfs(int k, int[][] adj, boolean[] visit) {
		visit[k] = true;
		
		for(int i =1 ; i <= N ; i++) {
			if(adj[k][i]==1 &&!visit[i]) {
				cnt ++;
				dfs(i,adj, visit);
			}
		}
		
	}

}

