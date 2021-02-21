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

public class 백준_2458_키순서_dfs3 {
	
	static int N,M;
	static int[] gtCnt, ltCnt ;
	static ArrayList<Integer>[] adj;

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
		adj = new ArrayList[N+1];
		
		for(int i = 1; i <=N ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		gtCnt = new int[N+1];
		ltCnt = new int[N+1];
		
		int i , j;
		
		for(int m = 1; m <= M ; m++) {
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			
			adj[i].add(j);
		}
		
		int answer = 0;
		
		for(int k = 1; k <=N; k++) {
			dfs(k,k, new boolean[N+1]);
		}
		
		for(int k = 1 ; k <=N ; k++) {
			if(gtCnt[k] + ltCnt[k] == N-1) answer ++;
		}
		
		System.out.println(answer);
		
	}

	private static void dfs(int src, int cur, boolean[] visited) {
		visited[cur] = true;
		
		for(int i = 0 ; i < adj[cur].size(); i ++) {
			if(visited[adj[cur].get(i)]) continue;
			gtCnt[src]++;
			ltCnt[adj[cur].get(i)]++;
			dfs(src, adj[cur].get(i), visited);
		}
		
	}

}

