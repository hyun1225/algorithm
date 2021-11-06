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

public class 백준_1707_이분그래프 {
	

	static int testCase,V,E;
	static ArrayList<Integer>[] graph;
	static int[] visit, checkVisit;
	static boolean flag;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_1707.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testCase = Integer.parseInt(br.readLine());
		StringTokenizer st ;
		
		for(int i = 0 ; i < testCase ; i ++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList[V+1];
			visit = new int[V+1];
			flag = true;
			
			for(int j = 0 ; j < V+1 ; j ++) {
				graph[j] = new ArrayList<>();
			}
			
			for(int j = 0 ; j < E ; j ++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph[a].add(b);
				graph[b].add(a);
			}
			
			for(int k = 1 ; k <= V ; k ++) {
				if(visit[k] == 0) {
					bfs(k);
				}
			}
			
			if(flag) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
			
			
		}
	}
	
	private static void bfs(int num) {
		Queue<Integer> q = new LinkedList<>();
		visit[num] = 1;
		
		q.add(num);
		
		while(!q.isEmpty()) {
			int sn = q.poll();
			
			for(int i = 0 ; i < graph[sn].size() ; i ++) {
				int m = graph[sn].get(i);
				
				if(visit[m] == 0) {
					visit[m] = 3 - visit[sn];
					q.add(m);
				}else {
					if(visit[sn] == visit[m]) {
						flag = false;
						return;
					}
				}
				
				
			}
		}
		
	}
}

