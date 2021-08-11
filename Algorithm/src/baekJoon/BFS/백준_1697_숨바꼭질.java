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

public class 백준_1697_숨바꼭질 {
	

	public static int N,K;
	public static int[] dist = {-1,1,2};
	public static int answer = Integer.MAX_VALUE;
	public static boolean[] visit;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_1697.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()) ;
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visit = new boolean[100001];
		
		if(N == K) {
			answer = 0;
		}else {
			bfs();
		}
		
		System.out.println(answer);
		
		
	}
	//스텍오버플로우 오
	private static void dfs(info param) {
		//visit[param.position] = true;
		
		for(int i = 0 ; i < 3 ; i ++) {
			int next = 0 ; 
			
			if(i != 2) {
				next = param.position + dist[i];
			}else {
				next = param.position * dist[i];
			}
			
			if(next == K) {
				answer = Math.min(param.second+1, answer);
			}else {
				if(next < 0 || next > 100000) continue;
				if(visit[next]) continue;
				visit[next] = true;
				dfs(new info(next, param.second+1));
			}
		}
		
	}

	private static void bfs() {
		Queue<info> q = new LinkedList<>();
		q.add(new info(N,0));
		visit[N] = true;
		
		while(!q.isEmpty()) {
			
			info now = q.poll();
			
			for(int i = 0 ; i < 3 ; i ++) {
				int next = 0;
				
				if(i != 2) {
					next = now.position + dist[i];
				}else {
					next = now.position * dist[i];
				}
				
				if(next == K) {
					answer = Math.min(now.second+1, answer);
				}else {
					if(next < 0 || next > 100000) continue;
					if(visit[next]) continue;
					visit[next] = true;
					q.add(new info(next,now.second+1));
				}
				
			}
		}
		
	}
	
	static class info{
		int position;
		int second;
		
		info(int p , int s){
			this.position = p;
			this.second = s;
					
		}
	}

}

