package baekJoon.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
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

public class 백준_2458_키순서_bfs {
	
	static int N,M, adj[][] ;
	static int upCnt, downCnt;

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
		
		int i , j;
		for(int m = 1 ; m <=M ; m++) {
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			
			adj[i][j] = 1;
		}
		int answer = 0;
		
		for(int k =1; k<= N ; k++) {
			upCnt = 0;
			downCnt = 0;
			upBfs(k);
			downBfs(k);
			if(upCnt + downCnt == N-1) {
				answer++;
			}
		}
		
		System.out.println(answer);
		
		
	}
	
	// 자신보다 큰 수 카운트  
	private static void upBfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visit = new boolean[N+1];
		q.add(start);
		visit[start] = true;
		
		while(!q.isEmpty()) {
			int k = q.poll();
			for(int i = 1; i <= N ; i ++) {
				if(adj[k][i] == 1 && !visit[i]) {
					upCnt ++;
					q.add(i);
					visit[i] = true;
				}
			}
			
		}
		
	}
	
	//자신보다 작은 수 카운트 
	private static void downBfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visit = new boolean[N+1];
		q.add(start);
		visit[start] = true;
		
		while(!q.isEmpty()) {
			int k = q.poll();
			for(int i = 1; i <= N ; i ++) {
				if(adj[i][k] == 1 && !visit[i]) {
					downCnt ++;
					q.add(i);
					visit[i] = true;
				}
			}
			
		}
		
	}

}

